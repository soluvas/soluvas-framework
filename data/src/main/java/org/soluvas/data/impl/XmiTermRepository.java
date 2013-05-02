package org.soluvas.data.impl;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DataPackage;
import org.soluvas.data.KindPredicate;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;


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
	private final Logger log;
	/**
	 * {@link Term}s in working memory.
	 */
	private final DataCatalog catalog;
	/**
	 * Changeable XMI files, key is term's nsPrefix which is the same as {@link TenantRef#getTenantId()} (e.g. tuneeca). 
	 */
	private final Map<String, File> xmiFiles;
	
	public XmiTermRepository(String kindNsPrefix, String kindName, List<URL> xmiResources, 
			Map<String, File> xmiFiles) {
		super();
		log = LoggerFactory.getLogger(XmiTermRepository.class.getName() + "/" + kindNsPrefix + ":" + kindName);
		this.xmiFiles = xmiFiles;
		final KindPredicate predicate = new KindPredicate(kindNsPrefix, kindName);
		catalog = DataFactory.eINSTANCE.createDataCatalog();
		for (final URL resource : xmiResources) {
			final DataCatalog loaded = (DataCatalog) new XmiObjectLoader<>(DataPackage.eINSTANCE, resource, ResourceType.CLASSPATH).get();
			final Collection<Term> matchingTerms = Collections2.filter(loaded.getTerms(), predicate);
			log.debug("Loaded {} {}:{} terms from resource {}", matchingTerms.size(), kindNsPrefix, kindName, resource);
			catalog.getTerms().addAll(matchingTerms);
		}
		for (final File file : xmiFiles.values()) {
			final DataCatalog loaded = (DataCatalog) new XmiObjectLoader<>(DataPackage.eINSTANCE, file.getPath()).get();
			final Collection<Term> matchingTerms = Collections2.filter(loaded.getTerms(), predicate);
			log.debug("Loaded {} {}:{} terms from file {}", matchingTerms.size(), kindNsPrefix, kindName, file);
			catalog.getTerms().addAll(matchingTerms);
		}
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
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Term> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
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
	public List<Term> findAll(final Collection<String> ids) {
		return ImmutableList.copyOf(Collections2.filter(
				catalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				if (input.getNsPrefix() != null && input.getName() != null) {
					return ids.contains(input.getNsPrefix() + "_" + input.getName());
				} else {
					return false;
				}
			}
		}));
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
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
		return new PageImpl<>(ImmutableList.copyOf(limitedUNames), pageable, catalog.getTerms().size());
	}

	@Override
	public Page<Term> findAll(Pageable pageable) {
		final Iterable<Term> limited = doFindAll(pageable);
		return new PageImpl<>(ImmutableList.copyOf(limited), pageable, catalog.getTerms().size());
	}

}
