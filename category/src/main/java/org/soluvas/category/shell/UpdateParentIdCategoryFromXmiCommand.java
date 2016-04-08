package org.soluvas.category.shell;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.CappedRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author rudi
 *
 */
@Service @Lazy
@Command(scope="cat", name="updateparentid", description="Update parent id for categories in mongoDB using xmi.")
public class UpdateParentIdCategoryFromXmiCommand extends ExtCommandSupport {
	
	@Override
	protected Object doExecute() throws Exception {
		final CategoryRepository xmiRepo = getBean(CategoryRepository.class);
		final MongoCategoryRepository mongoRepo = getBean(MongoCategoryRepository.class);
		
		final List<Category> xmiCategories = xmiRepo.findAll(new CappedRequest(500)).getContent();
		final List<Category2> mongoCategories = mongoRepo.findAll(new CappedRequest(500)).getContent();
		
		System.err.println(String.format("Updating %s categories", mongoCategories.size()));
		int updated = 0;
		for (final Category2 mongoCategory : mongoCategories) {
			final Optional<Category> optXmiCategory = xmiCategories.stream().filter(new Predicate<Category>() {
				@Override
				public boolean test(Category t) {
					return t.getId().equals(mongoCategory.getId());
				}
			}).findFirst();
			if (!optXmiCategory.isPresent()) {
				continue;
			}
			final Category xmiCategory = optXmiCategory.get();
			if (xmiCategory.getParentUName() == null) {
				continue;
			}
			mongoCategory.setParentId(xmiCategory.getParentUName().replace(xmiCategory.getNsPrefix() + "_", ""));
			mongoRepo.modify(mongoCategory.getId(), mongoCategory);
			updated++;
		}
		System.err.println(String.format("Updated for %s categories", updated));
		
		return null;
	}
	
}
