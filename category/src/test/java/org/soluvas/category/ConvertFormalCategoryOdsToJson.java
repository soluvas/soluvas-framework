package org.soluvas.category;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;

/**
 * @author rudi
 *
 */
public class ConvertFormalCategoryOdsToJson {
	
private static final int MAX_COLUMN = 61;
//	private static final Logger log = LoggerFactory
//			.getLogger(ConvertFormalCategoryOdsToJson.class);

	private static final int MAX_ROW = 5428;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void convert() throws Exception {
		final InputStream resourceAsStream = ConvertFormalCategoryOdsToJson.class.getResourceAsStream("formal-category.ods");
		final SpreadsheetDocument spreadSheetDoc = SpreadsheetDocument.loadDocument(resourceAsStream);
		final Table sheet = spreadSheetDoc.getSheetByIndex(0);
		
		final List<FormalCategory> formalCategories = new ArrayList<>();
		final Map<String, Long> googleIdMap = new HashMap<>();
		
		for (int i = 0; i < MAX_ROW; i++) {
			//start to loop rows
			final Row row = sheet.getRowByIndex(i);
			
			final FormalCategory newFormalCat = new FormalCategory();
			final Builder<String> gooleBreadcrumbsBuilder = ImmutableList.builder();
			final com.google.common.collect.ImmutableSet.Builder<String> sameAsUrisBuilder = ImmutableSet.builder();
			final com.google.common.collect.ImmutableSet.Builder<String> optionsBuilder = ImmutableSet.builder();
			final Long googleId = Long.valueOf(row.getCellByIndex(0).getStringValue());
			/**
			 * The new option will be created if there are (mandatory):
			 * >> a string value option1(column 11);
			 * >> a string value option1Enum(column 12);
			 * >> a string value option1Name(column 15);
			 */
			@Nullable Option newOption = null;
			
			for (int j = 0; j < MAX_COLUMN; j++) {
				//start to loop columns
				final Cell cell = row.getCellByIndex(j);
				switch (j) {
				case 0:
					//googleId
					newFormalCat.setGoogleId(googleId);
					break;
				case 1:
					//googleBreadcrumb1
					gooleBreadcrumbsBuilder.add(cell.getStringValue());
					googleIdMap.put(cell.getStringValue(), googleId);
					break;
				case 2:
					//googleBreadcrumb2
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 3:
					//googleBreadcrumb3
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 4:
					//googleBreadcrumb4
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 5:
					//googleBreadcrumb5
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 6:
					//googleBreadcrumb6
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 7:
					//googleBreadcrumb7
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						gooleBreadcrumbsBuilder.add(cell.getStringValue());
						googleIdMap.put(cell.getStringValue(), googleId);
						final String parentBreadcrumb = row.getCellByIndex(j-1).getStringValue();
						newFormalCat.setParentGoogleId(googleIdMap.get(parentBreadcrumb));
					}
					break;
				case 8:
					//primaryUri
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						newFormalCat.setPrimaryUri(cell.getStringValue());
					}
					break;
				case 9:
					//sameAsUri1
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						sameAsUrisBuilder.add(cell.getStringValue());
					}
					break;
				case 10:
					//sameAsUri2
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						sameAsUrisBuilder.add(cell.getStringValue());
					}
					break;
				case 11:
					//option1	
					if (!Strings.isNullOrEmpty(cell.getStringValue())) {
						newOption = new Option();
						newOption.setId(cell.getStringValue());
					}
					break;
				case 12:
					//option1Enum	
					if (newOption != null) {
						Preconditions.checkState(!Strings.isNullOrEmpty(cell.getStringValue()),
								"OptionEnum must not be null or empty for newOption '%s'", newOption.getId());
						newOption.setKind(cell.getStringValue());
					}
					break;
				case 13:
					//option1Quantity
					break;
				case 14:
					//option1Unit	
					break;
				case 15:
					//option1Name	
					break;
				case 16:
					//option1Description	
					break;
				case 17:
					//option1Name_id	
					break;
				case 18:
					//option1Description_id	
					break;
				case 19:
					//option2	
					break;
				case 20:
					//option2Enum	
					break;
				case 21:
					//option2Quantity	
					break;
				case 22:
					//option2Unit	
					break;
				case 23:
					//option2Name	
					break;
				case 24:
					//option2Description	
					break;
				case 25:
					//option2Name_id	
					break;
				case 26:
					//option2Description_id	
					break;
				case 27:
					//option3	
					break;
				case 28:
					//option3Enum	
					break;
				case 29:
					//option3Quantity	
					break;
				case 30:
					//option3Unit	
					break;
				case 31:
					//option3Name	
					break;
				case 32:
					//option3Description	
					break;
				case 33:
					//option3Name_id	
					break;
				case 34:
					//option3Description_id	
					break;
				case 35:
					//option4	
					break;
				case 36:
					//option4Enum	
					break;
				case 37:
					//option4Quantity	
					break;
				case 38:
					//option4Unit	
					break;
				case 39:
					//option4Name	
					break;
				case 40:
					//option4Description	
					break;
				case 41:
					//option4Name_id	
					break;
				case 42:
					//option4Description_id	
					break;
				case 43:
					//option5	
					break;
				case 44:
					//option5Enum	
					break;
				case 45:
					//option5Quantity	
					break;
				case 46:
					//option5Unit	
					break;
				case 47:
					//option5Name	
					break;
				case 48:
					//option5Description	
					break;
				case 49:
					//option5Name_id	
					break;
				case 50:
					//option5Description_id	
					break;
				case 51:
					//property1	
					break;
				case 52:
					//property2	
					break;
				case 53:
					//property3	
					break;
				case 54:
					//property4	
					break;
				case 55:
					//property5	
					break;
				case 56:
					//property6	
					break;
				case 57:
					//property7	
					break;
				case 58:
					//property8	
					break;
				case 59:
					//property9	
					break;
				case 60:
					//property10
					break;
				}
				System.err.println(String.format("Row %s >>> Cell on column %s: %s", i, j, cell.getStringValue()));
			}//end of loop columns
			newFormalCat.setGoogleBreadcrumbs(gooleBreadcrumbsBuilder.build());
			formalCategories.add(newFormalCat);
		}//end of loop rows
		
		//TODO: write to a json-ld file.
		final CategoryCatalog2 catalog = new CategoryCatalog2();
	}

}

