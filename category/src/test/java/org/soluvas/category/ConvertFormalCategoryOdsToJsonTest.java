package org.soluvas.category;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.measure.unit.Unit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.PropertyDefinitionRepositoryImpl;
import org.soluvas.data.PropertyKind;
import org.soluvas.json.JsonUtils;
import org.soluvas.json.LowerEnumSerializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * @author rudi
 *
 */
public class ConvertFormalCategoryOdsToJsonTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(ConvertFormalCategoryOdsToJsonTest.class);

	private static final int MAX_ROW = 5428;

	private final PropertyDefinitionRepository proDefRepo;
	
	public ConvertFormalCategoryOdsToJsonTest() throws JsonParseException, JsonMappingException, IOException {
		this.proDefRepo = new PropertyDefinitionRepositoryImpl();
		this.proDefRepo.init();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LowerEnumSerializer.LOWER = false;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void convert() throws Exception {
		final InputStream resourceAsStream = ConvertFormalCategoryOdsToJsonTest.class.getResourceAsStream("formal-category.ods");
		final SpreadsheetDocument spreadSheetDoc = SpreadsheetDocument.loadDocument(resourceAsStream);
		final Table sheet = spreadSheetDoc.getSheetByIndex(0);
		
		final List<FormalCategory> formalCategories = new ArrayList<>();
		final Map<String, Long> googleIdMap = new HashMap<>();
		
		for (int i = 1; i < MAX_ROW; i++) {
			//start to loop rows
			final Row row = sheet.getRowByIndex(i);
			
			final FormalCategory newFormalCat = new FormalCategory();
			final Builder<String> gooleBreadcrumbsBuilder = ImmutableList.builder();
			final com.google.common.collect.ImmutableSet.Builder<String> sameAsUrisBuilder = ImmutableSet.builder();
			final com.google.common.collect.ImmutableSet.Builder<PropertyDefinition> propertyOverrideb = ImmutableSet.builder();
			
			final long googleId = Long.valueOf(row.getCellByIndex(0).getStringValue());
			newFormalCat.setGoogleId(googleId);
			
			// breadcrumb: 1..7
			for (int j = 1; j <= 7; j++) {
				final Cell cell = row.getCellByIndex(j);
				if (!Strings.isNullOrEmpty(cell.getStringValue())) {
					gooleBreadcrumbsBuilder.add(cell.getStringValue());
				}
			}
			newFormalCat.setGoogleBreadcrumbs(gooleBreadcrumbsBuilder.build());
			log.info("{} {}", newFormalCat.getGoogleId(), newFormalCat.getGoogleBreadcrumbs());
			if (newFormalCat.getGoogleBreadcrumbs().size() >= 2) {
				final String parentBreadcrumb = newFormalCat.getGoogleBreadcrumbs().get(newFormalCat.getGoogleBreadcrumbs().size() - 2);
				final long parentGoogleId = Preconditions.checkNotNull(googleIdMap.get(parentBreadcrumb),
					"Cannot get parent named '%s'", parentBreadcrumb);
				newFormalCat.setParentGoogleId(parentGoogleId);
			}
			googleIdMap.put(Iterables.getLast(newFormalCat.getGoogleBreadcrumbs()), googleId);
			//name
			newFormalCat.setName(Iterables.getLast(newFormalCat.getGoogleBreadcrumbs()));
			//description
			newFormalCat.setDescription(Strings.emptyToNull(row.getCellByIndex(8).getStringValue()));
			//name_id + description_id
			final Map<String, String> translations = new HashMap<>();
			final String nameId = Strings.emptyToNull(row.getCellByIndex(9).getStringValue());
			if (nameId != null) {
				translations.put("name", nameId);
			}
			final String descriptionId = Strings.emptyToNull(row.getCellByIndex(10).getStringValue());
			if (descriptionId != null) {
				translations.put("description", descriptionId);
			}
			if (!translations.isEmpty()) {
				newFormalCat.getTranslations().put("id-ID", translations);
			}
			//primaryUri
			newFormalCat.setPrimaryUri(Strings.emptyToNull(row.getCellByIndex(11).getStringValue()));
			//sameAsUri1, sameAsUri2
			for (int j = 12; j <= 13; j++) {
				final String sameAsUri = Strings.emptyToNull(row.getCellByIndex(j).getStringValue());
				if (sameAsUri != null) {
					sameAsUrisBuilder.add(sameAsUri);
				}
			}
			for (int optIndex = 0; optIndex < 5; optIndex++) { // from column 14
				final String optId = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8)).getStringValue());
				if (optId != null) {
					
					final String optEnum = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 1).getStringValue());
					final String optQuantity = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 2).getStringValue());
					final String optUnit = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 3).getStringValue());
					final String optName_en = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 4).getStringValue());
					final String optDescription_en = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 5).getStringValue());
					final String optName_id = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 6).getStringValue());
					final String optDescription_id = Strings.emptyToNull(row.getCellByIndex(14 + (optIndex * 8) + 7).getStringValue());
					
					if (optEnum != null || optQuantity != null || optUnit != null || optName_en != null || optDescription_en != null || optName_id != null || optDescription_id != null) {
						final PropertyDefinition propertyOverride = new PropertyDefinition();
						propertyOverride.setId(optId);
						if (optEnum != null) {
							propertyOverride.setDefaultKind(PropertyKind.ENUMERATION);
							propertyOverride.setDefaultEnum(optEnum);
						}
						if (optQuantity != null || optUnit != null) {
							propertyOverride.setDefaultKind(PropertyKind.MEASUREMENT);
							propertyOverride.setDefaultQuantity(optQuantity);
							if (optUnit != null) {
								propertyOverride.setDefaultUnit(Unit.valueOf(optUnit));
							}
						}
						propertyOverride.setName(optName_en);
						propertyOverride.setDescription(optDescription_en);
						
						final String INDONESIAN = "id-ID";
						if (optName_id != null) {
							if (!propertyOverride.getTranslations().containsKey(INDONESIAN)) {
								propertyOverride.getTranslations().put(INDONESIAN, new HashMap<String, String>());
							}
							propertyOverride.getTranslations().get(INDONESIAN).put("name", optName_id);
						}
						if (optDescription_id != null) {
							if (!propertyOverride.getTranslations().containsKey(INDONESIAN)) {
								propertyOverride.getTranslations().put(INDONESIAN, new HashMap<String, String>());
							}
							propertyOverride.getTranslations().get(INDONESIAN).put("description", optDescription_id);
						}
						
						propertyOverrideb.add(propertyOverride);
					}
					
				}
			}
			
			// property: from column 54
			for (int j = 0; j < 10; j++) {
				final String property = Strings.emptyToNull(row.getCellByIndex(54 + j).getStringValue());
				if (!Strings.isNullOrEmpty(property)) {
					propertyOverrideb.add( Preconditions.checkNotNull(proDefRepo.findOneBase(property),
							"Soluvas Property Definition must not be null by id '%s'", property) );
				}
			}
			
			newFormalCat.setPropertyOverrides(propertyOverrideb.build());
			
			formalCategories.add(newFormalCat);
			
		}//end of loop rows
		
		final CategoryCatalog2 catalog = new CategoryCatalog2();
		catalog.getFormalCategories().addAll(formalCategories);
		
		final String parentDir = System.getProperty("user.home") + "/git/soluvas-framework/category/src/main/resources/org/soluvas/category/";
		final File jsonFile = new File(parentDir, "google.DataCatalog.jsonld");
		log.info("Writing {}", jsonFile);
		FileUtils.write(jsonFile, JsonUtils.asJson(catalog));
	}

}

