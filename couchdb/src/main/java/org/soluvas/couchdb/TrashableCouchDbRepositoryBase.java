package org.soluvas.couchdb;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.ComplexKey;
import org.ektorp.ViewQuery;
import org.soluvas.commons.Identifiable;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.repository.Trashable;

import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * {@link CouchDbRepositoryBase} which supports {@link Trashable}.
 * @author ceefour
 */
public abstract class TrashableCouchDbRepositoryBase<T extends Identifiable, E extends Enum<E>> extends
		CouchDbRepositoryBase<T, E> implements Trashable<T, String> {

	/**
	 * @param connMgr
	 * @param intfClass
	 * @param implClass
	 * @param currentSchemaVersion
	 * @param couchDbUri
	 * @param dbName
	 * @param deleteMethod TODO
	 * @param uniqueFields
	 * @param indexedFields
	 * @param statusProperty
	 * @param activeStatuses
	 * @param inactiveStatuses
	 * @param draftStatuses
	 * @param voidStatuses
	 */
	public TrashableCouchDbRepositoryBase(ClientConnectionManager connMgr,
			Class<T> intfClass, Class<? extends T> implClass,
			long currentSchemaVersion, String couchDbUri, String dbName,
			org.soluvas.couchdb.CouchDbRepositoryBase.DeleteMethod deleteMethod, List<String> uniqueFields,
			Map<String, Integer> indexedFields, String statusProperty,
			Set<E> activeStatuses, Set<E> inactiveStatuses, Set<E> draftStatuses, Set<E> voidStatuses) {
		super(connMgr, intfClass, implClass, currentSchemaVersion, couchDbUri,
				dbName, uniqueFields, indexedFields, deleteMethod,
				statusProperty, activeStatuses, inactiveStatuses, draftStatuses, voidStatuses);
	}

	/**
	 * @param connMgr
	 * @param intfClass
	 * @param implClass
	 * @param currentSchemaVersion
	 * @param couchDbUri
	 * @param dbName
	 * @param deleteMethod TODO
	 * @param uniqueFields
	 * @param indexedFields
	 */
	public TrashableCouchDbRepositoryBase(ClientConnectionManager connMgr,
			Class<T> intfClass, Class<? extends T> implClass,
			long currentSchemaVersion, String couchDbUri, String dbName,
			org.soluvas.couchdb.CouchDbRepositoryBase.DeleteMethod deleteMethod, List<String> uniqueFields, Map<String, Integer> indexedFields) {
		super(connMgr, intfClass, implClass, currentSchemaVersion, couchDbUri,
				dbName, deleteMethod, uniqueFields, indexedFields);
	}
	
	/**
	 * Please implement in subclass, returns the entity's {@code status} attribute.
	 * @param object
	 * @return
	 */
	protected abstract E getStatus(T object);
	/**
	 * Please implement in subclass, sets the entity's {@code status} attribute.
	 * @param object
	 */
	protected abstract void setStatus(T object, E status);
	/**
	 * Please implement in subclass, gets what the entity's {@code status} should be
	 * if {@link #untrash(Identifiable)}-ed. Must not be one of the {@code voidStatuses}.
	 * @param fetched
	 * @return
	 */
	protected abstract E getRestoredStatus(T fetched);
	
	@Override
	public final TrashResult trash(T checklist) {
		final Map<String, Try<TrashResult>> manyTrash = trashAll(ImmutableList.of(checklist));
		return manyTrash.get(checklist.getId()).get();
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<T> checklists) {
		final List<String> checklistIds = ImmutableList.copyOf(Collections2.transform(checklists, new org.soluvas.commons.IdFunction()));
		return trashAllByIds(checklistIds);
	}

	@Override
	public TrashResult trashById(String id) {
		return trashAllByIds(ImmutableSet.of(id)).get(id).get();
	}
	
	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		log.debug("Trashing {} {} documents: {}", ids.size(), collName, ids);
		final List<ComplexKey> viewKeys = ImmutableList.copyOf(Collections2.transform(ids, 
				new Function<String, ComplexKey>() {
			@Override @Nullable
			public ComplexKey apply(@Nullable String input) {
				return ComplexKey.of(StatusMask.RAW.getLiteral(), input);
			}
		}));
//		final Object[] viewKey = new Object[] { StatusMask.RAW.getLiteral(), key };
		final String viewName = "statusMask_uid";
		final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
				.viewName(viewName).keys(viewKeys).includeDocs(true);
		log.debug("Querying {} view {} for {} keys to trash: {}", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10));
		final List<T> fetcheds = (List) dbConn.queryView(query, implClass);
		log.debug("Queried {} view {} for {} keys to trash ({}) returned {} entities: {}", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10), fetcheds.size(), 
				Iterables.limit(Lists.transform(fetcheds, new org.soluvas.commons.IdFunction()), 10));
		
		final Set<String> trasheds = new HashSet<>();
		long errorCount = 0;
		long alreadyCount = 0;
		final Map<String, Try<TrashResult>> resultMap = new HashMap<>();
		for (final T fetched : fetcheds) {
			if (!voidStatuses.contains(getStatus(fetched))) {
				try {
					final E voidStatus = voidStatuses.iterator().next();
					log.trace("Trashing '{}' from {} to {} status", fetched.getId(), getStatus(fetched), voidStatus);
					setStatus(fetched, voidStatus);
					dbConn.update(fetched);
					resultMap.put(fetched.getId(), new Success<>(TrashResult.TRASHED));
					trasheds.add(fetched.getId());
				} catch (Exception e) {
					log.info(String.format("Cannot trash '%s' out of %d %s documents: %s",
							fetched.getId(), ids.size(), collName, e), e);
					final CouchDbRepositoryException exception = new CouchDbRepositoryException(e,
							"Cannot trash '%s' out of %d %s documents: %s", 
							fetched.getId(), ids.size(), collName, e);
					resultMap.put(fetched.getId(), new Failure<TrashResult>(exception));
					errorCount++;
				}
			} else {
				log.trace("Trashing '{}' but already trashed", fetched.getId());
				resultMap.put(fetched.getId(), new Success<>(TrashResult.ALREADY_TRASHED));
				alreadyCount++;
			}
		}
		// not found
		final Set<String> unfounds = Sets.difference(ImmutableSet.copyOf(ids), resultMap.keySet());
		if (!unfounds.isEmpty()) {
			log.debug("Cannot find {} entities to trash: {}", unfounds.size(), unfounds);
			for (final String unfound : unfounds) {
				resultMap.put(unfound, new Success<>(TrashResult.NOT_FOUND));
			}
		}
		
		log.info("Trashed {} out of {} {} documents ({} already trashed, {} errors, {} not found): {}",
				trasheds.size(), ids.size(), collName, alreadyCount, errorCount, unfounds.size());
		return resultMap;
	}

	@Override
	public UntrashResult untrash(T entity) {
		return untrashAll(ImmutableSet.of(entity)).get(entity.getId()).get();
	}

	@Override
	public UntrashResult untrashById(String id) {
		return untrashAllByIds(ImmutableSet.of(id)).get(id).get();
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(
			Collection<T> entities) {
		final List<String> checklistIds = ImmutableList.copyOf(Collections2.transform(entities, new org.soluvas.commons.IdFunction()));
		return untrashAllByIds(checklistIds);
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(
			Collection<String> ids) {
		log.debug("Untrashing {} {} documents: {}", ids.size(), collName, ids);
		final List<ComplexKey> viewKeys = ImmutableList.copyOf(Collections2.transform(ids, 
				new Function<String, ComplexKey>() {
			@Override @Nullable
			public ComplexKey apply(@Nullable String input) {
				return ComplexKey.of(StatusMask.RAW.getLiteral(), input);
			}
		}));
//		final Object[] viewKey = new Object[] { StatusMask.RAW.getLiteral(), key };
		final String viewName = "statusMask_uid";
		final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
				.viewName(viewName).keys(viewKeys).includeDocs(true);
		log.debug("Querying {} view {} for {} keys to untrash: {}", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10));
		final List<T> fetcheds = (List) dbConn.queryView(query, implClass);
		log.debug("Queried {} view {} for {} keys to untrash ({}) returned {} entities: {}", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10), fetcheds.size(), 
				Iterables.limit(Lists.transform(fetcheds, new org.soluvas.commons.IdFunction()), 10));
		
		final Set<String> untrasheds = new HashSet<>();
		long errorCount = 0;
		long alreadyCount = 0;
		final Map<String, Try<UntrashResult>> resultMap = new HashMap<>();
		for (final T fetched : fetcheds) {
			if (voidStatuses.contains(getStatus(fetched))) {
				try {
					final E restoredStatus = getRestoredStatus(fetched);
					Preconditions.checkState(!voidStatuses.contains(restoredStatus),
							"Subclass' getRestoredStatus '%s' returned illegal status '%s' which is contained in void statuses: %s",
							getId(fetched), restoredStatus, voidStatuses);
					log.trace("Untrashing '{}' from {} to {} status", 
							fetched.getId(), getStatus(fetched), restoredStatus);
					setStatus(fetched, restoredStatus);
					dbConn.update(fetched);
					resultMap.put(fetched.getId(), new Success<>(UntrashResult.UNTRASHED));
					untrasheds.add(fetched.getId());
				} catch (Exception e) {
					log.info(String.format("Cannot untrash '%s' out of %d %s documents: %s",
							fetched.getId(), ids.size(), collName, e), e);
					final CouchDbRepositoryException exception = new CouchDbRepositoryException(e,
							"Cannot untrash '%s' out of %d %s documents: %s", 
							fetched.getId(), ids.size(), collName, e);
					resultMap.put(fetched.getId(), new Failure<UntrashResult>(exception));
					errorCount++;
				}
			} else {
				log.trace("Trashing '{}' but already untrashed", fetched.getId());
				resultMap.put(fetched.getId(), new Success<>(UntrashResult.ALREADY_UNTRASHED));
				alreadyCount++;
			}
		}
		// not found
		final Set<String> unfounds = Sets.difference(ImmutableSet.copyOf(ids), resultMap.keySet());
		if (!unfounds.isEmpty()) {
			log.debug("Cannot find {} entities to untrash: {}", unfounds.size(), unfounds);
			for (final String unfound : unfounds) {
				resultMap.put(unfound, new Success<>(UntrashResult.NOT_FOUND));
			}
		}
		
		log.info("Untrashed {} out of {} {} documents ({} already untrashed, {} errors, {} not found): {}",
				untrasheds.size(), ids.size(), collName, alreadyCount, errorCount, unfounds.size());
		return resultMap;
	}

}
