package org.soluvas.category.shell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.FormalCategory;
import org.soluvas.category.FormalCategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.Translation;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.CappedRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
@Service @Lazy
@Command(scope="cat", name="migrate", description="Migrate categories from xmi file to mongoDB.")
public class MigrateCategoryFromXmiToMongoDBCommand extends ExtCommandSupport {
	
	@Argument(index = 0, name = "formalcategoryid", required = true, description = "Formal category from Google.")
	private Long googleFormalId;

	@Override
	protected Object doExecute() throws Exception {
		final CategoryRepository xmiRepo = getBean(CategoryRepository.class);
		final MongoCategoryRepository mongoRepo = getBean(MongoCategoryRepository.class);
		final FormalCategoryRepository formalCategoryRepo = getBean(FormalCategoryRepository.class);
		
		final FormalCategory formalCategory = Preconditions.checkNotNull(formalCategoryRepo.findOne(googleFormalId),
				"Formal Category for '%s' must not be null", googleFormalId);
		
		final List<Category> categories = xmiRepo.findAllByStatus(ImmutableList.of(CategoryStatus.ACTIVE, CategoryStatus.VOID), new CappedRequest(500)).getContent();
		System.err.println(String.format("Migrate for %s categories", categories.size()));
		for (final Category category : categories) {
			final Category2 category2 = new CategoryXmiToMongo(formalCategory).apply(category);
			mongoRepo.add(category2);
		}
		System.err.println(String.format("Migrated for %s categories", categories.size()));
		
		return null;
	}
	
	private class CategoryXmiToMongo implements Function<Category, Category2> {
		
		private final FormalCategory formalCategory;

		public CategoryXmiToMongo(FormalCategory formalCategory) {
			this.formalCategory = formalCategory;
		}

		@Override
		public Category2 apply(Category input) {
			log.debug("Creating category2 from {}", input.getId());
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
			if (input.getParent() != null) {
				category2.setParentId( input.getParent().getId());
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

}
