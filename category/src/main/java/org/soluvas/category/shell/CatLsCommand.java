package org.soluvas.category.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.ServiceReference;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.util.CategoryUtils;
import org.soluvas.commons.NameUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * List registered {@link Category}s.
 * @author ceefour
 */
@Command(scope="cat", name="ls", description="List registered Categories.")
public class CatLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<CategoryCatalog> categoryCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(CategoryCatalog.class),
				"Cannot get %s service reference", CategoryCatalog.class.getName());
		final CategoryCatalog categoryCatalog = Preconditions.checkNotNull(getService(CategoryCatalog.class, categoryCatalogRef),
				"Cannot get %s service", CategoryCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-25s|%-18s|%-15s|%1s|%-10s|%-20s|%-20s|@",
				"№", "ID", "Name", "Slug", "L", "Catalog", "Description", "Bundle"));
		int i = 0;
		final EList<Category> nestedCategories = categoryCatalog.getCategories();
		final List<Category> flatCategories = CategoryUtils.flatten(nestedCategories);
		for (final Category category : flatCategories) {
			final String bundleAnsi = NameUtils.shortenBundleAnsi(category.getBundle(), 20);
			final String descriptionAnsi = NameUtils.shortenAnsi(category.getDescription(), 20);
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-25s|@@|bold,black ||@%-18s@|bold,black ||@%-15s@|bold,black ||@%-1d@|bold,black ||@%-10s@|bold,black ||@" + descriptionAnsi + "@|bold,black ||@" + bundleAnsi,
				++i, category.getId(), Strings.repeat("·", category.getLevel() - 1) + category.getName(),
				category.getSlug(), category.getLevel(), category.getCatalogName() ));
		}
		System.out.println(ansi().render("@|bold %d|@ categories", i));
		return null;
	}

}
