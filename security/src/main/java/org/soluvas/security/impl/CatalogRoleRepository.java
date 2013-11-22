package org.soluvas.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.IdPredicate;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Order;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
import org.soluvas.security.Role;
import org.soluvas.security.RoleRepository;
import org.soluvas.security.SecurityCatalog;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * Read-only {@link RoleRepository} that only provides {@link Role}s from
 * (XMI) {@link SecurityCatalog}.
 * @author rudi
 */
public class CatalogRoleRepository extends PagingAndSortingRepositoryBase<Role, String>
	implements RoleRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(CatalogRoleRepository.class);
	private final SecurityCatalog securityCatalog;
	
	public CatalogRoleRepository(SecurityCatalog securityCatalog) {
		super();
		this.securityCatalog = securityCatalog;
	}

	@Override
	public long count() {
		return securityCatalog.getRoles().size();
	}

	@Override @Nullable
	protected String getId(Role entity) {
		return entity.getId();
	}

	@Override
	public <S extends Role> Collection<S> add(Collection<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Role> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(Collection<String> ids) {
		return FluentIterable.from(securityCatalog.getRoles()).filter(new IdPredicate<>(ids))
				.transform(new org.soluvas.commons.IdFunction()).toSet();
	}

	protected Iterable<Role> doFindAll(Predicate<Role> filter, Pageable pageable) {
		final Sort sort = Optional.fromNullable(pageable.getSort()).or(new Sort("id"));
		final Collection<Role> filtered;
		if (filter != null) {
			filtered = Collections2.filter(securityCatalog.getRoles(), filter);
		} else {
			filtered = securityCatalog.getRoles();
		}
		final Ordering<Role> ordering = new Ordering<Role>() {
			@Override
			public int compare(@Nullable Role left, @Nullable Role right) {
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
		log.debug("Find roles sorted by {} returned {} entities (before paging)", 
				sort.iterator().next().getProperty(), filtered.size());
		final List<Role> sorted = ordering.immutableSortedCopy(filtered);
		final Iterable<Role> limited = Iterables.limit(Iterables.skip(sorted,
				(int) pageable.getOffset()), (int) pageable.getPageSize());
		return limited;
	}

	@Override
	public List<Role> findAll(Collection<String> ids, Sort sort) {
		// TODO: support sort
		final Collection<Role> filtered = Collections2.filter(
				securityCatalog.getRoles(), new IdPredicate(ids));
		// must use EcoreUtil.copyAll, since transform with EcoreCopyFunction will make the object disappear if it has a parent!
		return ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(filtered)));
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		final Iterable<Role> limited = doFindAll(null, pageable);
		final Iterable<String> limitedIds = Iterables.transform(limited, new IdFunction());
		return new PageImpl<>(ImmutableList.copyOf(limitedIds),
				pageable, count());
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		final Iterable<Role> limited = doFindAll(null, pageable);
		// must use EcoreUtil.copyAll, since transform with EcoreCopyFunction will make the object disappear if it has a parent!
		return new PageImpl<>(ImmutableList.copyOf(EcoreUtil.copyAll(ImmutableList.copyOf(limited))),
				pageable, count());
	}

}
