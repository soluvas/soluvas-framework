package org.soluvas.category.util;

import java.net.URL;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.CategoryPackage;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.commons.impl.XmiTrackerUtils;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * @author ceefour
 *
 */
public class CategoryCatalogXmiTracker implements BundleTrackerCustomizer<List<Category>> {
	
	private static Logger log = LoggerFactory
			.getLogger(CategoryCatalogXmiTracker.class);
	private static final String suppliedClassSimpleName = CategoryCatalog.class.getSimpleName();
	private static final String suppliedClassName = CategoryCatalog.class.getName();
	private static final CategoryPackage xmiEPackage = CategoryPackage.eINSTANCE;
	private final CategoryCatalog repo;
	private final EventBus eventBus;
	
	/**
	 * @param repo Access to this repo from this class is guaranteed to be synchronized,
	 * 		but other consumers may not do that. So it's recommended that this class
	 * 		is the exclusive consumer of this repo.
	 */
	public CategoryCatalogXmiTracker(@Nonnull final CategoryCatalog repo,
			@Nonnull final EventBus eventBus) {
		super();
		this.repo = repo;
		this.eventBus = eventBus;
	}
	
	protected List<String> getNameSegments(Category category) {
		return category.getParent() != null
				? ImmutableList.copyOf(Iterables.concat(getNameSegments(category.getParent()), ImmutableList.of(category.getName())))
				: ImmutableList.<String>of(category.getName());
	}

	protected List<String> getSlugSegments(Category category) {
		return category.getParent() != null
				? ImmutableList.copyOf(Iterables.concat(getSlugSegments(category.getParent()), ImmutableList.of(category.getSlug())))
				: ImmutableList.<String>of(category.getSlug());
	}

	protected int getLevel(Category category) {
		return category.getParent() != null
				? getLevel(category.getParent()) + 1
				: 1;
	}

	@Override
	public List<Category> addingBundle(final Bundle bundle, BundleEvent event) {
		final String path = bundle.getSymbolicName().replace('.', '/');
		
		// ------------------ Scan CategoryCatalogs ------------
		final List<URL> xmiFiles = XmiTrackerUtils.scan(bundle, suppliedClassSimpleName);
		if (xmiFiles.isEmpty())
			return ImmutableList.of();

		// ------------------ CategoryCatalog XMI files ------------
		final List<CategoryCatalog> catalogs = ImmutableList.copyOf(Lists.transform(xmiFiles, new Function<URL, CategoryCatalog>() {
			@Override @Nullable
			public CategoryCatalog apply(@Nullable URL url) {
				log.debug("Getting CategoryCatalog XMI {} from {} in {} [{}]", suppliedClassName, url,
						bundle.getSymbolicName(), bundle.getBundleId() );
				final XmiObjectLoader<CategoryCatalog> loader = new XmiObjectLoader<CategoryCatalog>(xmiEPackage, url,
						bundle);
				final CategoryCatalog categoryCatalog = loader.get();
				
				// Recursive expand as flat
				final List<Category> flatCategories = CategoryUtils.flatten(categoryCatalog.getCategories());
				
				for (final Category category : flatCategories) {
					log.debug("Realizing Category {} from {}", category.getName(), url);
					category.setCatalogName(categoryCatalog.getName());
					if (category.getId() == null) {
						category.setId( (category.getParent() != null ? category.getParent().getId() + "_" : "") + SlugUtils.generateId(category.getName()) );
					}
					if (category.getSlug() == null) {
						category.setSlug(SlugUtils.generateSegment(category.getName()));
					}
					category.setCatalogName(categoryCatalog.getName());
					category.setSlugPath(Joiner.on('/').join(getSlugSegments(category)));
					category.setCategoryCount((long) category.getCategories().size());
					category.setLevel(getLevel(category));
					for (final Category child : category.getCategories()) {
						child.setParent(category);
					}
				}
				
				log.debug("Loaded {} Categories ({} root) from CategorySchema {} in {} [{}]",
						flatCategories.size(), categoryCatalog.getCategories().size(),
						url, bundle.getSymbolicName(), bundle.getBundleId() );
				return categoryCatalog;
			}
		}));
		
		// -------------- Concatenate root categories ------------
		final List<Category> categories = ImmutableList.copyOf(Iterables.concat(
				Lists.transform(catalogs, new Function<CategoryCatalog, List<Category>>() {
			@Override @Nullable
			public List<Category> apply(@Nullable final CategoryCatalog input) {
				return input.getCategories();
			}
		})));
		log.info("Loaded {} root Categories from {} [{}]",
				categories.size(), bundle.getSymbolicName(), bundle.getBundleId());
		
		// Add these objects to repo
		// TODO: support catalogs which "inject" into existing categories, but need resolution algorithm
		synchronized (repo) {
			repo.getCategories().addAll(categories);
		}

		// Notify StorySchemaCatalogXmiTracker
//		final TargetTypeAdded added = SchemaFactory.eINSTANCE.createTargetTypeAdded();
//		added.getTargetTypes().addAll(targetTypes);
//		eventBus.post(added);
		
		final List<Category> objects = categories;
		return objects;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			List<Category> objects) {
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			@Nonnull final List<Category> objects) {
		if (objects.isEmpty())
			return;
		
		log.debug("Removing {} EObjects provided by {} [{}]",
				objects.size(), bundle.getSymbolicName(), bundle.getBundleId());
		long removedCount = 0;
		for (final Category category : objects) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			log.debug("Removing Category {} from {} [{}]", category.getName(),
					bundle.getSymbolicName(), bundle.getBundleId());
			synchronized (repo) {
				if (repo.getCategories().remove(category))
					removedCount++;
			}
		}
		log.info("Removed {} Categories from {} [{}]",
				removedCount, bundle.getSymbolicName(), bundle.getBundleId());
		
		// Notify StorySchemaCatalogXmiTracker
//			final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
//			removed.getTargetTypes().addAll(catalogs);
//			eventBus.post(removed);
	}

}
