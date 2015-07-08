package org.soluvas.category.shell;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.Translation;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;

/**
 * @author rudi
 *
 */
@Service @Lazy
@Command(scope="cat", name="migrate", description="Migrate categories from xmi file to mongoDB.")
public class MigrateFromXmiToMongoDBCommand extends ExtCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final CategoryRepository xmiRepo = getBean(CategoryRepository.class);
		final MongoCategoryRepository mongoRepo = getBean(MongoCategoryRepository.class);
		
		final List<Category> categories = xmiRepo.findAll();
		for (final Category category : categories) {
			final Category2 category2 = new CategoryXmiToMongo().apply(category);
			mongoRepo.add(category2);
		}
		
		return null;
	}
	
	private class CategoryXmiToMongo implements Function<Category, Category2> {
		
		@Override
		public Category2 apply(Category input) {
			final Category2 category2 = new Category2();
			category2.getCategories().addAll( EcoreUtil.copyAll(input.getCategories()).stream().map(c -> new CategoryXmiToMongo().apply(c)).collect(Collectors.toList()) );
			category2.setCategoryCount(input.getCategoryCount());
			category2.setColor( input.getColor() );
			category2.setCreationTime( input.getCreationTime() );
			category2.setDescription( input.getDescription() );
			category2.setGoogleFormalId( input.getGoogleFormalId() );
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
			category2.setParent( new CategoryXmiToMongo().apply( input.getParent() ) );
			category2.setParentUName( input.getParentUName() );
			category2.setPositioner( input.getPositioner() );
			category2.setPrimaryUri( input.getPrimaryUri() );
			category2.getSameAsUris().addAll( input.getSameAsUris() );
			category2.setSlug( input.getSlug() );
			category2.setSlugPath( input.getSlugPath() );
			category2.setStatus( input.getStatus() );
			category2.getTags().addAll( input.getTags() );
			for (final Entry<String, Translation> entry:  input.getTranslations().entrySet()) {
				category2.getTranslations().put(entry.getKey(),
						entry.getValue().getMessages().entrySet().stream().collect(Collectors.toMap(msg -> msg.getKey(), msg -> msg.getValue())));
			}
//			category2.getTranslations().putAll( input.getTranslations().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> (Map<String, String>) e.getValue().getMessages())) );
			
			return category2;
		}
		
	}

}
