package org.soluvas.category.shell;

import java.util.List;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.FormalCategory;
import org.soluvas.category.FormalCategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.CappedRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

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
		
		final List<Category> categories = xmiRepo.findAll(new CappedRequest(500)).getContent();
		System.err.println(String.format("Migrate for %s categories", categories.size()));
		for (final Category category : categories) {
			final Category2 category2 = new CategoryXmiToMongoFunction(formalCategory).apply(category);
			mongoRepo.add(category2);
		}
		System.err.println(String.format("Migrated for %s categories", categories.size()));
		
		return null;
	}
	
}
