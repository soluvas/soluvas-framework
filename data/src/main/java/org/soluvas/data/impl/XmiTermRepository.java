package org.soluvas.data.impl;

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

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataException;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.KindPredicate;
import org.soluvas.data.Term;
import org.soluvas.data.TermChanged;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
import org.soluvas.data.repository.XmiRepositoryBase;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.google.common.eventbus.EventBus;

/**
 * {@link PagingAndSortingRepository} that operates on {@link Term}s (identified by UName)
 * inside one or more:
 * <ul>
 * 	<li>{@link DataCatalog} XMI classpath resources. These terms are <b>not</b> editable.</li>
 * 	<li>{@link DataCatalog} XMI files. These terms are editable.</li>
 * </ul>
 * <p>Note: When a change is made, for proper operation the system must:
 * <ol>
 * 	<li>Reload the global {@link DataCatalog} instance from (modified) XMI files</li>
 * 	<li>Commit the modified XMI files to Git, then (optionally) pull Git repo and push the Git repo</li>
 * </ol>
 * @author ceefour
 */
public class XmiTermRepository 
		extends PagingAndSortingRepositoryBase<Term, String>
		implements TermRepository {
	protected final Logger log;
	/**
	 * {@link Term}s in working memory.
	 */
	private DataCatalog catalog;
	/**
	 * Changeable XMI files, key is term's nsPrefix which is the same as {@link TenantRef#getTenantId()} (e.g. tuneeca). 
	 */
	private final Map<String, File> xmiFiles;
	/**
	 * Changeable DataCatalog, key is term's nsPrefix which is the same as {@link TenantRef#getTenantId()} (e.g. tuneeca). 
	 */
	private final Map<String, DataCatalog> xmiCatalogs = new HashMap<>();
	private final String kindNsPrefix;
	private final String kindName;
	private final List<URL> xmiResources;
	private final EventBus eventBus;
	
	/**
	 * @param kindNsPrefix
	 * @param kindName
	 * @param xmiResources
	 * @param xmiFiles These may point to non-existing filepaths (which will be skipped during read, and
	 * 		created during write), but the parent directory <b>must</b> be valid.
	 * @param eventBus
	 */
	public XmiTermRepository(String kindNsPrefix, String kindName, List<URL> xmiResources, 
			Map<String, File> xmiFiles, EventBus eventBus) {
		super();
		log = LoggerFactory.getLogger(getClass().getName() + "/" + kindNsPrefix + ":" + kindName);
		this.kindNsPrefix = kindNsPrefix;
		this.kindName = kindName;
		this.xmiResources = xmiResources;
		this.xmiFiles = xmiFiles;
		this.eventBus = eventBus;
		reload();
	}
	
	protected synchronized void reload() {
		final DataCatalog catalog = DataFactory.eINSTANCE.createDataCatalog();
		final KindPredicate predicate = new KindPredicate(kindNsPrefix, kindName);
		for (final URL resource : xmiResources) {
			final DataCatalog loaded = (DataCatalog) new StaticXmiLoader<>(DataPackage.eINSTANCE, resource, ResourceType.CLASSPATH).get();
			final Collection<Term> matchingTerms = Collections2.filter(loaded.getTerms(), predicate);
			log.debug("Loaded {} {}:{} terms from resource {}", matchingTerms.size(), kindNsPrefix, kindName, resource);
			catalog.getTerms().addAll(EcoreUtil.copyAll(matchingTerms));
		}
		for (final Entry<String, File> entry : xmiFiles.entrySet()) {
			final File file = entry.getValue();
			final String nsPrefix = entry.getKey();
			if (file.exists()) {
				final DataCatalog loaded = (DataCatalog) new StaticXmiLoader<>(DataPackage.eINSTANCE, file.getPath()).get();
				xmiCatalogs.put(nsPrefix, loaded);
				final Collection<Term> matchingTerms = Collections2.filter(loaded.getTerms(), predicate);
				log.debug("Loaded {} {}:{} terms for {} from file {}", 
						matchingTerms.size(), kindNsPrefix, kindName, nsPrefix, file);
				catalog.getTerms().addAll(EcoreUtil.copyAll(matchingTerms));
			} else {
				final DataCatalog initial = DataFactory.eINSTANCE.createDataCatalog();
				log.debug("Using empty {}:{} terms for {} because missing DataCatalog file {}", 
						kindNsPrefix, kindName, nsPrefix, file);
				xmiCatalogs.put(nsPrefix, initial);
			}
		}
		this.catalog = catalog;
		log.info("Loaded {} {}:{} terms from {} resources and {} files: {} {}", 
				catalog.getTerms().size(), kindNsPrefix, kindName, xmiResources.size(), xmiFiles.size(),
				xmiResources, xmiFiles);
	}

	@Override
	public long count() {
		return catalog.getTerms().size();
	}

	@Override @Nullable
	protected String getId(Term entity) {
		return entity.getQName();
	}

	@Override
	public <S extends Term> Collection<S> add(Collection<S> entities) {
		log.debug("Adding {} terms: {}", entities.size(), Iterables.limit(entities, 10));
		// check duplicate UName(s)
		final Collection<String> uNamesToAdd = Collections2.transform(entities, new QNameFunction());
		final Set<String> existingUNames = exists(uNamesToAdd);
		if (!existingUNames.isEmpty()) {
			throw new IllegalArgumentException("Duplicate Term UName(s): " + existingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<S> addedTerms = new ArrayList<>();
		for (final S entity : entities) {
			final DataCatalog xmiCatalog = xmiCatalogs.get(entity.getNsPrefix());
			if (xmiCatalog == null) {
				throw new IllegalArgumentException(String.format("NsPrefix '%s' is read-only. %s editable nsPrefix(es) are: %s",
						entity.getNsPrefix(), xmiCatalogs.size(), xmiCatalogs.keySet()));
			}
			
			final S added = EcoreUtil.copy(entity);
			xmiCatalog.getTerms().add(added);
			addedTerms.add(added);
			changedNsPrefixes.add(entity.getNsPrefix());
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Added %d terms: %s", entities.size(), uNamesToAdd));
		log.info("Added {} terms: {}", entities.size(), Iterables.limit(entities, 10));
		return addedTerms;
	}

	@Override
	public <S extends Term> Collection<S> modify(Map<String, S> entities) {
		log.debug("Modifying {} terms: {}", entities.size(), Iterables.limit(entities.keySet(), 10));
		// check existence
		final Set<String> existingUNames = exists(entities.keySet());
		if (existingUNames.size() != entities.keySet().size()) {
			final SetView<String> missingUNames = Sets.difference(entities.keySet(), existingUNames);
			throw new IllegalArgumentException("Term UName(s) do not exist: " + missingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<S> addedTerms = new ArrayList<>();
		for (final Entry<String, S> entry : entities.entrySet()) {
			final S entity = entry.getValue();
			final DataCatalog xmiCatalog = xmiCatalogs.get(entity.getNsPrefix());
			if (xmiCatalog == null) {
				throw new IllegalArgumentException(String.format("NsPrefix '%s' is read-only. %s editable nsPrefix(es) are: %s",
						entity.getNsPrefix(), xmiCatalogs.size(), xmiCatalogs.keySet()));
			}
			
			final Term toRemove = Iterables.find(xmiCatalog.getTerms(), new Predicate<Term>() {
				@Override
				public boolean apply(@Nullable Term input) {
					return entry.getKey().equals(input.getQName());
				}
			});
			xmiCatalog.getTerms().remove(toRemove);
			final S modified = EcoreUtil.copy(entity);
			
			xmiCatalog.getTerms().add(modified);
			addedTerms.add(modified);
			changedNsPrefixes.add(entity.getNsPrefix());
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Modified %d terms: %s", entities.size(), entities.keySet()));
		log.info("Modified {} terms: {}", entities.size(), Iterables.limit(entities.keySet(), 10));
		return addedTerms;
	}

	private void updateCatalogFiles(final Set<String> changedNsPrefixes) {
		final ResourceSet rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rset.getPackageRegistry().put(DataPackage.eNS_URI, DataPackage.eINSTANCE);		
		for (final String nsPrefix : changedNsPrefixes) {
			final DataCatalog xmiCatalog = xmiCatalogs.get(nsPrefix);
			final File file = Preconditions.checkNotNull(xmiFiles.get(nsPrefix),
					"Cannot find %s in xmiFiles", nsPrefix);
			final Resource res = rset.createResource(URI.createFileURI(file.getPath()));
			res.getContents().add(EcoreUtil.copy(xmiCatalog));
			try {
				res.save(XmiRepositoryBase.SAVE_OPTIONS);
				res.unload();
			} catch (IOException e) {
				throw new DataException(e, "Cannot save %s XMI file %s", nsPrefix, file);
			}
		}
	}

	@Override
	public Set<String> exists(final Collection<String> ids) {
		return ImmutableSet.copyOf(Collections2.transform(Collections2.filter(
				catalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				if (input.getNsPrefix() != null && input.getName() != null) {
					return ids.contains(input.getNsPrefix() + "_" + input.getName());
				} else {
					return false;
				}
			}
		}), new QNameFunction()));
	}

	@Override
	public List<Term> findAll(final Collection<String> ids, Sort sort) {
		// TODO: support sort
		final Collection<Term> filtered = Collections2.filter(
				catalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				if (input.getNsPrefix() != null && input.getName() != null) {
					return ids.contains(input.getNsPrefix() + "_" + input.getName());
				} else {
					return false;
				}
			}
		});
		return ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(filtered)));
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		log.debug("Deleting {} terms: {}", ids.size(), Iterables.limit(ids, 10));
		// check existence
		final Set<String> existingUNames = exists(ids);
		if (existingUNames.size() != ids.size()) {
			final SetView<String> missingUNames = Sets.difference(ImmutableSet.copyOf(ids), existingUNames);
			throw new IllegalArgumentException("Term UName(s) do not exist: " + missingUNames);
		}
		// add
		final Set<String> changedNsPrefixes = new HashSet<>();
		final List<String> deletedTerms = new ArrayList<>();
		final Pattern uNamePattern = Pattern.compile("([^_]+)\\_.+");
		for (final String id : ids) {
			final Matcher matcher = uNamePattern.matcher(id);
			Preconditions.checkArgument(matcher.matches(), "Cannot get nsPrefix for %s", id);
			final String nsPrefix = matcher.group(1);
			final DataCatalog xmiCatalog = xmiCatalogs.get(nsPrefix);
			if (xmiCatalog == null) {
				throw new IllegalArgumentException(String.format("NsPrefix '%s' is read-only. %s editable nsPrefix(es) are: %s",
						nsPrefix, xmiCatalogs.size(), xmiCatalogs.keySet()));
			}
			
			final Term toRemove = Iterables.find(xmiCatalog.getTerms(), new Predicate<Term>() {
				@Override
				public boolean apply(@Nullable Term input) {
					return id.equals(input.getQName());
				}
			});
			xmiCatalog.getTerms().remove(toRemove);
			deletedTerms.add(id);
			
			changedNsPrefixes.add(nsPrefix);
		}
		updateCatalogFiles(changedNsPrefixes);
		reload();
		catalogFilesChanged(changedNsPrefixes, String.format("Deleted %d terms: %s", ids.size(), ids));
		log.info("Deleted {} terms: {}", ids, Iterables.limit(ids, 10));
		return deletedTerms.size();
	}
	
	protected Iterable<Term> doFindAll(Pageable pageable) {
		final Sort sort = Optional.fromNullable(pageable.getSort()).or(new Sort("name"));
		final Ordering<Term> ordering = new Ordering<Term>() {
			@Override
			public int compare(@Nullable Term left, @Nullable Term right) {
				final Order order = Iterables.getFirst(sort, null);
				if (order != null) {
					try {
						final int sorted = Optional.fromNullable(BeanUtils.getSimpleProperty(left, order.getProperty())).or("")
								.compareToIgnoreCase( Optional.fromNullable(BeanUtils.getSimpleProperty(right, order.getProperty())).or("") );
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
		final List<Term> sorted = ordering.immutableSortedCopy(catalog.getTerms());
		final Iterable<Term> limited = Iterables.limit(Iterables.skip(sorted,
				(int) pageable.getOffset()), (int) pageable.getPageSize());
		return limited;
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final Iterable<Term> limited = doFindAll(pageable);
		final Iterable<String> limitedUNames = Iterables.transform(limited, new QNameFunction());
		return new PageImpl<>(ImmutableList.copyOf(limitedUNames),
				pageable, catalog.getTerms().size());
	}

	@Override
	public Page<Term> findAll(Pageable pageable) {
		final Iterable<Term> limited = doFindAll(pageable);
		// must use EcoreUtil.copyAll, since transform with EcoreCopyFunction will make the object disappear if it has a parent!
		return new PageImpl<>(ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(limited))),
				pageable, catalog.getTerms().size());
	}
	
	/**
	 * Override in subclass to perform custom action after XMI files are
	 * modified, e.g. commit then pull-push.
	 * @param nsPrefixes
	 * @param message TODO
	 */
	protected void catalogFilesChanged(final Set<String> nsPrefixes, String message) {
		eventBus.post(new TermChanged(null, kindNsPrefix, kindName));
	}

}
