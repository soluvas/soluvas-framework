package org.soluvas.category.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryCatalog;
import org.soluvas.category.CategoryFactory;
import org.soluvas.category.CategoryPackage;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.commons.EcoreCopyFunction;
import org.soluvas.commons.QNameFunction;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.DataException;
import org.soluvas.data.DataPackage;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.eventbus.EventBus;

/**
 * {@link PagingAndSortingRepository} that operates on {@link Category}s (identified by UName)
 * inside one or more:
 * <ul>
 * 	<li>{@link CategoryCatalog} XMI classpath resources. These terms are <b>not</b> editable.</li>
 * 	<li>{@link CategoryCatalog} XMI files. These terms are editable.</li>
 * </ul>
 * <p>Note: When a change is made, for proper operation the system must:
 * <ol>
 * 	<li>Reload the global {@link CategoryCatalog} instance from (modified) XMI files</li>
 * 	<li>Commit the modified XMI files to Git, then (optionally) pull Git repo and push the Git repo</li>
 * </ol>
 * @author ceefour
 */
public class XmiCategoryRepository 
		extends PagingAndSortingRepositoryBase<Category, String>
		implements CategoryRepository {
	protected static final Logger log = LoggerFactory.getLogger(XmiCategoryRepository.class);
	/**
	 * {@link Category}s in working memory.
	 */
	private CategoryCatalog catalog;
	/**
	 * Changeable XMI files, key is term's nsPrefix which is the same as {@link TenantRef#getTenantId()} (e.g. tuneeca). 
	 */
	private final Map<String, File> xmiFiles;
	/**
	 * Changeable CategoryCatalog, key is term's nsPrefix which is the same as {@link TenantRef#getTenantId()} (e.g. tuneeca). 
	 */
	private final Map<String, CategoryCatalog> xmiCatalogs = new HashMap<>();
	private final List<URL> xmiResources;
	private final EventBus eventBus;
	
	public XmiCategoryRepository(List<URL> xmiResources, 
			Map<String, File> xmiFiles, EventBus eventBus) {
		super();
		this.xmiResources = xmiResources;
		this.xmiFiles = xmiFiles;
		this.eventBus = eventBus;
		reload();
	}
	
	protected synchronized void reload() {
		final CategoryCatalog catalog = CategoryFactory.eINSTANCE.createCategoryCatalog();
		for (final URL resource : xmiResources) {
			final CategoryCatalog loaded = (CategoryCatalog) new StaticXmiLoader<>(CategoryPackage.eINSTANCE, resource, ResourceType.CLASSPATH).get();
			final Collection<Category> matchingCategorys = loaded.getCategories();
			log.debug("Loaded {} categorys from resource {}", matchingCategorys.size(), resource);
			catalog.getCategories().addAll(EcoreUtil.copyAll(matchingCategorys));
		}
		for (final Entry<String, File> entry : xmiFiles.entrySet()) {
			final File file = entry.getValue();
			final String nsPrefix = entry.getKey();
			final CategoryCatalog loaded = (CategoryCatalog) new StaticXmiLoader<>(CategoryPackage.eINSTANCE, file.getPath()).get();
			xmiCatalogs.put(nsPrefix, loaded);
			final Collection<Category> matchingCategorys = loaded.getCategories();
			log.debug("Loaded {} categorys for {} from file {}", 
					matchingCategorys.size(), nsPrefix, file);
			catalog.getCategories().addAll(EcoreUtil.copyAll(matchingCategorys));
		}
		this.catalog = catalog;
		log.info("Loaded {} categorys from {} resources and {} files: {} {}", 
				catalog.getCategories().size(), xmiResources.size(), xmiFiles.size(),
				xmiResources, xmiFiles);
	}

	@Override
	public long count() {
		return catalog.getCategories().size();
	}

	@Override @Nullable
	protected String getId(Category entity) {
		return entity.getNsPrefix() + "_" + entity.getId();
	}

	@Override
	public <S extends Category> Collection<S> add(Collection<S> entities) {
		log.debug("Adding {} terms: {}", entities.size(), Iterables.limit(entities, 10));
		// check duplicate UName(s)
		final Collection<String> uNamesToAdd = Collections2.transform(entities, new QNameFunction());
		final Set<String> existingUNames = exists(uNamesToAdd);
		if (!existingUNames.isEmpty()) {
			throw new IllegalArgumentException("Duplicate Category UName(s): " + existingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<S> addedCategorys = new ArrayList<>();
		for (final S entity : entities) {
			final CategoryCatalog xmiCatalog = xmiCatalogs.get(entity.getNsPrefix());
			if (xmiCatalog == null) {
				throw new IllegalArgumentException("NsPrefix " + entity.getNsPrefix() + " is read-only.");
			}
			
			final S added = EcoreUtil.copy(entity);
			xmiCatalog.getCategories().add(added);
			addedCategorys.add(added);
			changedNsPrefixes.add(entity.getNsPrefix());
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Added %d terms: %s", entities.size(), uNamesToAdd));
		log.info("Added {} terms: {}", entities.size(), Iterables.limit(entities, 10));
		return addedCategorys;
	}

	@Override
	public <S extends Category> Collection<S> modify(Map<String, S> entities) {
		log.debug("Modifying {} terms: {}", entities.size(), Iterables.limit(entities.keySet(), 10));
		// check existence
		final Set<String> existingUNames = exists(entities.keySet());
		if (existingUNames.size() != entities.keySet().size()) {
			final SetView<String> missingUNames = Sets.difference(entities.keySet(), existingUNames);
			throw new IllegalArgumentException("Category UName(s) do not exist: " + missingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<S> addedCategorys = new ArrayList<>();
		for (final Entry<String, S> entry : entities.entrySet()) {
			final S entity = entry.getValue();
			final CategoryCatalog xmiCatalog = xmiCatalogs.get(entity.getNsPrefix());
			if (xmiCatalog == null) {
				throw new IllegalArgumentException("NsPrefix " + entity.getNsPrefix() + " is read-only.");
			}
			
			final Category toRemove = Iterables.find(xmiCatalog.getCategories(), new Predicate<Category>() {
				@Override
				public boolean apply(@Nullable Category input) {
					return entry.getKey().equals(input.getNsPrefix() + "_" + input.getName());
				}
			});
			xmiCatalog.getCategories().remove(toRemove);
			final S modified = EcoreUtil.copy(entity);
			
			xmiCatalog.getCategories().add(modified);
			addedCategorys.add(modified);
			changedNsPrefixes.add(entity.getNsPrefix());
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Modified %d terms: %s", entities.size(), entities.keySet()));
		log.info("Modified {} terms: {}", entities.size(), Iterables.limit(entities.keySet(), 10));
		return addedCategorys;
	}

	private void updateCatalogFiles(final Set<String> changedNsPrefixes) {
		final ResourceSet rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rset.getPackageRegistry().put(DataPackage.eNS_URI, DataPackage.eINSTANCE);		
		for (final String nsPrefix : changedNsPrefixes) {
			final CategoryCatalog xmiCatalog = xmiCatalogs.get(nsPrefix);
			final File file = Preconditions.checkNotNull(xmiFiles.get(nsPrefix),
					"Cannot find %s in xmiFiles", nsPrefix);
			final Resource res = rset.createResource(URI.createFileURI(file.getPath()));
			res.getContents().add(EcoreUtil.copy(xmiCatalog));
			try {
				res.save(ImmutableMap.of(XMIResource.OPTION_LINE_WIDTH, 80,
						XMIResource.OPTION_DECLARE_XML, true,
						XMIResource.OPTION_ENCODING, "UTF-8"));
				res.unload();
			} catch (IOException e) {
				throw new DataException(e, "Cannot save %s XMI file %s", nsPrefix, file);
			}
		}
	}

	@Override
	public Set<String> exists(final Collection<String> ids) {
		return ImmutableSet.copyOf(Collections2.transform(Collections2.filter(
				catalog.getCategories(), new Predicate<Category>() {
			@Override
			public boolean apply(@Nullable Category input) {
				if (input.getNsPrefix() != null && input.getName() != null) {
					return ids.contains(input.getNsPrefix() + "_" + input.getName());
				} else {
					return false;
				}
			}
		}), new QNameFunction()));
	}

	@Override
	public List<Category> findAll(final Collection<String> ids) {
		final Collection<Category> filtered = Collections2.filter(
				catalog.getCategories(), new Predicate<Category>() {
			@Override
			public boolean apply(@Nullable Category input) {
				if (input.getNsPrefix() != null && input.getName() != null) {
					return ids.contains(input.getNsPrefix() + "_" + input.getName());
				} else {
					return false;
				}
			}
		});
		return ImmutableList.copyOf(Collections2.transform(filtered, new EcoreCopyFunction<Category>()));
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		log.debug("Deleting {} terms: {}", ids.size(), Iterables.limit(ids, 10));
		// check existence
		final Set<String> existingUNames = exists(ids);
		if (existingUNames.size() != ids.size()) {
			final SetView<String> missingUNames = Sets.difference(ImmutableSet.copyOf(ids), existingUNames);
			throw new IllegalArgumentException("Category UName(s) do not exist: " + missingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<String> deletedCategorys = new ArrayList<>();
		final Pattern uNamePattern = Pattern.compile("([^_]+)\\_.+");
		for (final String id : ids) {
			final Matcher matcher = uNamePattern.matcher(id);
			Preconditions.checkArgument(matcher.matches(), "Cannot get nsPrefix for %s", id);
			final String nsPrefix = matcher.group(1);
			final CategoryCatalog xmiCatalog = xmiCatalogs.get(nsPrefix);
			if (xmiCatalog == null) {
				throw new IllegalArgumentException("NsPrefix " + nsPrefix + " is read-only.");
			}
			
			final Category toRemove = Iterables.find(xmiCatalog.getCategories(), new Predicate<Category>() {
				@Override
				public boolean apply(@Nullable Category input) {
					return id.equals(input.getNsPrefix() + "_" + input.getName());
				}
			});
			xmiCatalog.getCategories().remove(toRemove);
			deletedCategorys.add(id);
			
			changedNsPrefixes.add(nsPrefix);
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Deleted %d terms: %s", ids.size(), ids));
		log.info("Deleted {} terms: {}", ids, Iterables.limit(ids, 10));
		return deletedCategorys.size();
	}
	
	protected Iterable<Category> doFindAll(Predicate<Category> filter, Pageable pageable) {
		final Sort sort = Optional.fromNullable(pageable.getSort()).or(new Sort("positioner"));
		log.debug("Find categorys sorted by {}", sort.iterator().next().getProperty());
		final Collection<Category> filtered;
		if (filter != null) {
			filtered = Collections2.filter(catalog.getCategories(), filter);
		} else {
			filtered = catalog.getCategories();
		}
		final Ordering<Category> ordering = new Ordering<Category>() {
			@Override
			public int compare(@Nullable Category left, @Nullable Category right) {
				final Order order = Iterables.getFirst(sort, null);
				if (order != null) {
					try {
						final Object leftProp = Optional.fromNullable(PropertyUtils.getProperty(left, order.getProperty())).or("");
						final Object rightProp = Optional.fromNullable(PropertyUtils.getProperty(right, order.getProperty())).or("");
						final int sorted;
						if (leftProp instanceof Comparable<?> && !(leftProp instanceof String)) {
							sorted = ((Comparable<Object>) leftProp).compareTo(rightProp);
						} else {
							sorted = ((String) leftProp).compareToIgnoreCase( (String) rightProp );
						}
						return order.isAscending() ? sorted : -sorted;
					} catch (IllegalAccessException | InvocationTargetException
							| NoSuchMethodException e) {
						log.warn("Cannot access bean property " + order, e);
						return 0;
					}
				} else {
					return 0;
				}
			}
		};
		final List<Category> sorted = ordering.immutableSortedCopy(filtered);
		final Iterable<Category> limited = Iterables.limit(Iterables.skip(sorted,
				(int) pageable.getOffset()), (int) pageable.getPageSize());
		return limited;
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final Iterable<Category> limited = doFindAll(null, pageable);
		final Iterable<String> limitedUNames = Iterables.transform(limited, new QNameFunction());
		return new PageImpl<>(ImmutableList.copyOf(limitedUNames),
				pageable, catalog.getCategories().size());
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		final Iterable<Category> limited = doFindAll(null, pageable);
		return new PageImpl<>(ImmutableList.copyOf(Iterables.transform(limited, new EcoreCopyFunction<Category>())),
				pageable, catalog.getCategories().size());
	}
	
	@Override
	public Page<Category> findAllByStatus(final Collection<CategoryStatus> statuses, Pageable pageable) {
		final Predicate<Category> filter = new Predicate<Category>() {
			@Override
			public boolean apply(@Nullable Category input) {
				return statuses.contains(input.getStatus());
			}
		};
		final Iterable<Category> limited = doFindAll(filter, pageable);
		return new PageImpl<>(ImmutableList.copyOf(Iterables.transform(limited, new EcoreCopyFunction<Category>())),
				pageable, catalog.getCategories().size());
	}
	
	/**
	 * Override in subclass to perform custom action after XMI files are
	 * modified, e.g. commit then pull-push.
	 * @param nsPrefixes
	 * @param message TODO
	 */
	protected void catalogFilesChanged(final Set<String> nsPrefixes, String message) {
//		eventBus.post(new CategoryChanged(null));
	}

}
