package org.soluvas.category.shell;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.util.CategoryUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Show {@link Category}.
 * @author ceefour
 */
@Service @Lazy
@Command(scope="cat", name="cat", description="Show Category.")
public class CatCatCommand extends ExtCommandSupport {
	
	@Option(name="-i", description="Return the CategoryInfo form.")
	private transient boolean toInfo = false;
	
	@Argument(name="id", required=true, description="Category ID.")
	private String categoryId;
	
	private final CategoryCatalog categoryCatalog;
	
	@Inject
	public CatCatCommand(CategoryCatalog categoryCatalog) {
		super();
		this.categoryCatalog = categoryCatalog;
	}

	@Override
	protected Object doExecute() throws Exception {
		final List<Category> categoryList = CategoryUtils.flatten(ImmutableList.copyOf(EcoreUtil.copyAll(categoryCatalog.getCategories())));
		final Category cat = Iterables.find(categoryList, new Predicate<Category>() {
			@Override
			public boolean apply(@Nullable Category input) {
				return categoryId.equalsIgnoreCase( input.getId() );
			}
		}, null);
		
		Preconditions.checkNotNull(cat, "Cannot find Category must not be null");
		
		if (toInfo) {
			return cat.toInfo();
		} else {
			return cat;
		}
	}

}
