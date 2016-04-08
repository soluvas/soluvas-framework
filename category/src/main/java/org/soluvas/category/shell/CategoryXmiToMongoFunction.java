package org.soluvas.category.shell;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.FormalCategory;
import org.soluvas.commons.Translation;

import com.google.common.base.Function;

/**
 * @author rudi
 *
 */
public class CategoryXmiToMongoFunction implements Function<Category, Category2> {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryXmiToMongoFunction.class);
	
	private final FormalCategory formalCategory;
	
	public CategoryXmiToMongoFunction(FormalCategory formalCategory) {
		super();
		this.formalCategory = formalCategory;
	}
	
	@Override
	public Category2 apply(Category input) {
		final Category2 category2 = new Category2();
		category2.setColor( input.getColor() );
		category2.setCreationTime( input.getCreationTime() );
		category2.setDescription( input.getDescription() );
		category2.setGoogleFormalId( 
				input.getGoogleFormalId() != null ? input.getGoogleFormalId() : formalCategory.getGoogleId() );
		category2.setId( input.getId() );
		category2.setImageId( input.getImageId() );
		category2.setLanguage( input.getLanguage() );
		category2.setLevel( input.getLevel() );
		category2.setMetaDescription( input.getMetaDescription() );
		category2.setMetaKeywords( input.getMetaKeywords() );
		category2.setMetaTitle( input.getMetaTitle() );
		category2.setModificationTime( input.getModificationTime() );
		category2.setName( input.getName() );
		category2.setNsPrefix( input.getNsPrefix() );
//		log.debug("Category '{}' has parent '{}", input.getId(), input.getParentUName());
		if (input.getParentUName() != null) {
//			log.debug("Category '{}' has parent: {}", input.getId(), input.getParentUName());
			category2.setParentId( input.getParentUName().replace(input.getNsPrefix() + "_", ""));
		}
		category2.setPositioner( input.getPositioner() );
		category2.setPrimaryUri( input.getPrimaryUri() );
		category2.getSameAsUris().addAll( input.getSameAsUris() );
		category2.setSlug( input.getSlug() );
		category2.setSlugPath( input.getSlugPath() );
		category2.setStatus( input.getStatus() );
		category2.getTags().addAll( input.getTags() );
		if (input.getTranslations() != null && !input.getTranslations().isEmpty()) {
			final Map<String, Map<String, String>> newTranslation = new HashMap<>();
			for (final Entry<String, Translation> entry:  input.getTranslations().entrySet()) {
				newTranslation.put(entry.getKey(),
						entry.getValue().getMessages().entrySet().stream().collect(Collectors.toMap(msg -> msg.getKey(), msg -> msg.getValue())));
			}
			category2.setTranslations(newTranslation);
		}
		category2.getPropertyOverrides().addAll(formalCategory.getPropertyOverrides());
		
		return category2;
	}

}
