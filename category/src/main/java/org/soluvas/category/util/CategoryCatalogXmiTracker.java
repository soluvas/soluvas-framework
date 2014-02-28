package org.soluvas.category.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.CategoryException;
import org.soluvas.category.CategoryPackage;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.commons.SupplierXmiTracker;
import org.soluvas.commons.impl.XmiTrackerUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;

/**
 * Cannot use simple {@link SupplierXmiTracker} because need to calculate {@link Category#setSlugPath(String)}.
 * And potentially other complications (merging sub-categories?).
 * @author ceefour
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
	 * Used only for classpath, non-OSGi.
	 */
	private final Map<String, List<Category>> managedCategories = new HashMap<>();
	
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
	
	/**
	 * I guess this will never be called, and is not required anyway in non-OSGi environments.
	 */
	@PreDestroy
	public void destroy() {
		for (final Entry<String, List<Category>> entry : managedCategories.entrySet()) {
			removedBundle(entry.getValue(), entry.getKey());
		}
	}
	
	@Override
	public List<Category> addingBundle(final Bundle bundle, BundleEvent event) {
		// ------------------ Scan CategoryCatalogs ------------
		final List<URL> xmiFiles = XmiTrackerUtils.scan(bundle, suppliedClassSimpleName);
		return extractObjects(xmiFiles, bundle);
	}

	/**
	 * Scan using classpath.
	 * @todo Scanning multiple classpaths for resources is slow, so static or hybrid
	 * 		approach is preferable.
	 * @param dataDir If not {@code null}, will scan in filesystem too.
	 */
	public void scan(ClassLoader classLoader, @Nullable File dataDir) {
		final ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		// Due to JDK limitation, scanning of root won't work in webapp classpath,
		// at least the root folder must be specified before wildcard
		final List<String> locationPatterns = new ArrayList<>();
		locationPatterns.add("classpath*:org/**/*.CategoryCatalog.xmi");
		locationPatterns.add("classpath*:com/**/*.CategoryCatalog.xmi");
		locationPatterns.add("classpath*:id/**/*.CategoryCatalog.xmi");
		if (dataDir != null) {
			locationPatterns.add("file:" + dataDir + "/common/*.CategoryCatalog.xmi");
		}
		log.trace("Scanning {} for {}", classLoader, locationPatterns);
		try {
			final List<Resource> allResources = new ArrayList<>();
			for (String locationPattern : locationPatterns) {
				final Resource[] resources = resolver.getResources(locationPattern);
				allResources.addAll(ImmutableList.copyOf(resources));
			}
			log.info("Scanned {} returned {} resources: {}",
					locationPatterns, allResources.size(), allResources);
			final List<URL> xmiUrls = ImmutableList.copyOf(Lists.transform(
					allResources, new Function<Resource, URL>() {
				@Override @Nullable
				public URL apply(@Nullable Resource input) {
					try {
						return input.getURL();
					} catch (IOException e) {
						throw new CategoryException("Cannot get URL for " + input, e);
					}
				}
			}));
			for (URL xmiUrl : xmiUrls) {
				final List<Category> objs = extractObjects(ImmutableList.of(xmiUrl), null);
				managedCategories.put(xmiUrl.toString(), objs);
			}
		} catch (IOException e) {
			throw new CategoryException(e, "Cannot scan %s for %s",
					classLoader, locationPatterns);
		}
	}

	/**
	 * Scan using classpath.
	 * @todo Scanning multiple classpaths for resources is slow, so static or hybrid
	 * 		approach is preferable.
	 * @param dataDir If not {@code null}, will scan in filesystem too.
	 */
	@Deprecated
	public void scan(ClassLoader classLoader, @Nullable String dataDir) {
		scan(classLoader, dataDir != null ? new File(dataDir) : null);
	}
	
	private List<Category> extractObjects(final List<URL> xmiFiles,
			final Bundle bundle) {
		if (xmiFiles.isEmpty())
			return ImmutableList.of();

		// ------------------ CategoryCatalog XMI files ------------
		final List<CategoryCatalog> catalogs = ImmutableList.copyOf(Lists.transform(xmiFiles, new Function<URL, CategoryCatalog>() {
			@Override @Nullable
			public CategoryCatalog apply(@Nullable URL url) {
				log.debug("Getting CategoryCatalog XMI {} from {}", suppliedClassName, url);
				final CategoryCatalog categoryCatalog;
				if (bundle != null) {
					categoryCatalog = new StaticXmiLoader<CategoryCatalog>(xmiEPackage, url,
							bundle).get();
				} else {
					categoryCatalog = new StaticXmiLoader<CategoryCatalog>(xmiEPackage, url,
							ResourceType.CLASSPATH).get();
				}
				
				// Recursive expand as flat
				final List<Category> flatCategories = CategoryUtils.flatten(categoryCatalog.getCategories());
				for (final Category category : flatCategories) {
					log.debug("Realizing Category {} from {}", category.getName(), url);
					category.resolve(null);
				}
				
				log.debug("Loaded {} Categories ({} root) from CategorySchema {}",
						flatCategories.size(), categoryCatalog.getCategories().size(),
						url );
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
		log.info("Loaded {} root Categories from {}", categories.size(), xmiFiles);
		
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
			List<Category> objects) {
		removedBundle(objects, bundle.getSymbolicName() + " [" + bundle.getBundleId() + "]");
	}
	
	private void removedBundle(@Nonnull final List<Category> objects,
			String resourceContainer) {
		if (objects.isEmpty())
			return;
		
		log.debug("Removing {} EObjects provided by {}",
				objects.size(), resourceContainer);
		long removedCount = 0;
		for (final Category category : objects) {
			// Unresolve: not strictly necessary
			// Unregister from repo
			log.debug("Removing Category {} from {}", category.getName(),
					resourceContainer);
			synchronized (repo) {
				if (repo.getCategories().remove(category))
					removedCount++;
			}
		}
		log.info("Removed {} Categories from {}",
				removedCount, resourceContainer);
		
		// Notify StorySchemaCatalogXmiTracker
//			final TargetTypeRemoved removed = SchemaFactory.eINSTANCE.createTargetTypeRemoved();
//			removed.getTargetTypes().addAll(catalogs);
//			eventBus.post(removed);
	}

}
