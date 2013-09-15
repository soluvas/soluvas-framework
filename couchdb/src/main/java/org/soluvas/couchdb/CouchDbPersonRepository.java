package org.soluvas.couchdb;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.ComplexKey;
import org.ektorp.DbAccessException;
import org.ektorp.ViewQuery;
import org.ektorp.support.DesignDocument;
import org.ektorp.support.DesignDocument.View;
import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.person.PersonRepository;

import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * CouchDB implementation of {@link PersonRepository}.
 * @author ceefour
 */
public class CouchDbPersonRepository extends CouchDbRepositoryBase<Person>
		implements PersonRepository {
	
	public CouchDbPersonRepository(ClientConnectionManager connMgr, String couchDbUri, String dbName) {
		super(connMgr, Person.class, PersonImpl.class, 1L, couchDbUri, dbName, "person",
				ImmutableList.<String>of(), ImmutableMap.<String, Integer>of());
	}
	
	@Override
	protected void beforeSave(Person entity) {
		super.beforeSave(entity);
		entity.setModificationTime(new DateTime());
		entity.setCanonicalSlug(SlugUtils.canonicalize(entity.getSlug()));
	}
	
	@Override
	protected void updateDesignDocument(DesignDocument design) {
		super.updateDesignDocument(design);
		design.addView("password", new View(
				"function(doc) { if (doc.type == 'Person' && doc.accountStatus.match(/^(active|validated|verified)$/) != null) { "
				+ "emit(doc.uid, {uid: doc.uid, password: doc.password} ); "
				+ "doc.emails.forEach(function(e) { "
				+ "emit(e.email, {uid: doc.uid, password: doc.password}); "
				+ "}); "
				+ "} }"));
		addStatusMaskDesignView(design, "accountStatus", 
				ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED),
				ImmutableSet.of(AccountStatus.INACTIVE),
				ImmutableSet.of(AccountStatus.DRAFT),
				ImmutableSet.of(AccountStatus.VOID),
				"uid");
		design.addView("statusMask_email", new View(
				 "function(doc) { if (doc.type == 'Person' ) { "
		       + "doc.emails.forEach(function(e) { "
		       + "emit(['raw', e.email], null); "
		       + "if (doc.accountStatus.match(/^(active|validated|verified)$/) != null) emit(['active_only', e.email], null); "
		       + "if (doc.accountStatus.match(/^(active|validated|verified|inactive)$/) != null) emit(['include_inactive', e.email], null); "
		       + "if (doc.accountStatus == 'draft') emit(['draft_only', e.email], null); "
		       + "if (doc.accountStatus.match(/^(void)$/) != null) emit(['void_only', e.email], null); "
		       + "}); "
		       + "} }"));
		addStatusMaskDesignView(design, "accountStatus", 
				ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED),
				ImmutableSet.of(AccountStatus.INACTIVE),
				ImmutableSet.of(AccountStatus.DRAFT),
				ImmutableSet.of(AccountStatus.VOID),
				"canonicalSlug", "slug");
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.data.SlugLookup#findOneBySlug(java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneBySlug(StatusMask statusMask, String upSlug) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.SlugLookup#existsBySlug(java.lang.String)
	 */
	@Override
	public String existsBySlug(StatusMask statusMask, String upSlug) {
		try {
			return lookupOne(statusMask, LookupKey.SLUG, upSlug).getSlug();
		} catch (EntityLookupException e) {
			log.trace("existsBySlug {} '{}' returned {}", statusMask, upSlug, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByFacebook(java.lang.Long, java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneByFacebook(@Nullable Long facebookId,
			@Nullable String facebookUsername) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByEmail(java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneByEmail(StatusMask statusMask, @Nullable String email) {
		try {
			final Person found = lookupOne(statusMask, LookupKey.EMAIL, email);
			return found;
		} catch (EntityLookupException e) {
			log.debug("lookupOne {} {} {} returned {}", statusMask, LookupKey.EMAIL, email, e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByMobileNumber(java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneByMobileNumber(@Nullable String mobileNumber) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByTwitter(java.lang.Long, java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneByTwitter(@Nullable Long twitterId,
			@Nullable String twitterScreenName) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByClientAccessToken(java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneByClientAccessToken(@Nullable String clientAccessToken) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findBySearchText(java.lang.String, org.soluvas.data.domain.Pageable)
	 */
	@Override
	public Page<Person> findBySearchText(String searchText, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#countBySearchText(java.lang.String)
	 */
	@Override
	public long countBySearchText(String searchText) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Person findOneActive(String personId) {
		// FIXME: implement status=ACTIVE|VALIDATED|VERIFIED filter
		return findOne(personId);
	}

	@Override
	public <S extends Person, K extends Serializable> S lookupOne(
			StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		switch (lookupKey) {
		case EMAIL:
		{
			// filter by statusMask in Java, so we can give proper reason
			final Object[] viewKey = new Object[] { StatusMask.RAW.getLiteral(), key };
			final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
					.viewName("statusMask_email").key(viewKey).includeDocs(true);
			log.debug("Querying {} view {} for key {}", 
					getDesignDocId(), "statusMask_email", viewKey);
			List<S> fetcheds;
			try {
				fetcheds = (List) dbConn.queryView(query, implClass);
			} catch (DbAccessException e) {
				if (e.getMessage().contains("update_seq")) {
					log.debug("Returning empty list for DbAccessException " + e, e);
					fetcheds = ImmutableList.of();
				} else {
					throw e;
				}
			}

			log.debug("Queried {} view {} for key {} returned {} entities: {}", 
					getDesignDocId(), "statusMask_email", viewKey, fetcheds.size(), 
					Iterables.limit(Lists.transform(fetcheds, new org.soluvas.commons.IdFunction()), 10));
			if (fetcheds.isEmpty()) {
				throw new EntityLookupException(Person.class, statusMask, lookupKey, key, this, Optional.<AccountStatus>absent());
			} else {
				final S fetched = fetcheds.iterator().next();
				switch (statusMask) {
				case RAW:
					return fetched;
				case ACTIVE_ONLY:
					if (ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED).contains(fetched.getAccountStatus())) {
						return fetched;
					} else {
						throw new EntityLookupException(Person.class, statusMask, lookupKey, key, this, Optional.fromNullable(fetched.getAccountStatus()));
					}
				case INCLUDE_INACTIVE:
					if (ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED, AccountStatus.INACTIVE).contains(fetched.getAccountStatus())) {
						return fetched;
					} else {
						throw new EntityLookupException(Person.class, statusMask, lookupKey, key, this, Optional.fromNullable(fetched.getAccountStatus()));
					}
				case DRAFT_ONLY:
					if (ImmutableSet.of(AccountStatus.DRAFT).contains(fetched.getAccountStatus())) {
						return fetched;
					} else {
						throw new EntityLookupException(Person.class, statusMask, lookupKey, key, this, Optional.fromNullable(fetched.getAccountStatus()));
					}
				case VOID_ONLY:
					if (ImmutableSet.of(AccountStatus.VOID).contains(fetched.getAccountStatus())) {
						return fetched;
					} else {
						throw new EntityLookupException(Person.class, statusMask, lookupKey, key, this, Optional.fromNullable(fetched.getAccountStatus()));
					}
				}
			}
		}
		case SLUG:
			return this.<S, K>lookupAll(statusMask, lookupKey, ImmutableSet.of(key)).get(key).get();
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override
	public <S extends Person, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		switch (lookupKey) {
		case SLUG: {
			// filter by statusMask in Java, so we can give proper reason
			final List<ComplexKey> viewKeys = ImmutableList.copyOf(Collections2.transform(keys, 
					new Function<K, ComplexKey>() {
				@Override @Nullable
				public ComplexKey apply(@Nullable K input) {
					return ComplexKey.of(StatusMask.RAW.getLiteral(), SlugUtils.canonicalize((String) input));
				}
			}));
//			final Object[] viewKey = new Object[] { StatusMask.RAW.getLiteral(), key };
			final String viewName = "statusMask_canonicalSlug";
			final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
					.viewName(viewName).keys(viewKeys).includeDocs(true);
			log.debug("Querying {} view {} for {} keys: {}", 
					getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10));
			List<S> fetcheds;
			try {
				fetcheds = (List) dbConn.queryView(query, implClass);
			} catch (DbAccessException e) {
				if (e.getMessage().contains("update_seq")) {
					log.debug("Returning empty list for DbAccessException " + e, e);
					fetcheds = ImmutableList.of();
				} else {
					throw e;
				}
			}

			log.debug("Queried {} view {} for {} keys ({}) returned {} entities: {}", 
					getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10), fetcheds.size(), 
					Iterables.limit(Lists.transform(fetcheds, new org.soluvas.commons.IdFunction()), 10));
			
			final Map<K, Try<S>> resultMap = new HashMap<>();
			for (final S row : fetcheds) {
				switch (statusMask) {
				case RAW:
					resultMap.put((K) row.getSlug(), new Success<>(row));
					break;
				case ACTIVE_ONLY:
					if (ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED).contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case INCLUDE_INACTIVE:
					if (ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED, AccountStatus.INACTIVE).contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case DRAFT_ONLY:
					if (ImmutableSet.of(AccountStatus.DRAFT).contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case VOID_ONLY:
					if (ImmutableSet.of(AccountStatus.VOID).contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				}
			}
			
			// those actually not found
			final SetView<K> unfoundKeys = Sets.difference(ImmutableSet.copyOf(keys), resultMap.keySet());
			for (final K unfoundKey : unfoundKeys) {
				resultMap.put(unfoundKey, new Failure<S>(new EntityLookupException(Person.class, statusMask, lookupKey, unfoundKey, this, Optional.<AccountStatus>absent())));
			}
			
			return resultMap;
		}
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

	@Override
	public <K extends Serializable> Map<K, Try<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
	}

	@Override
	public <K extends Serializable> K checkExists(StatusMask statusMask,
			LookupKey lookupKey, K key) throws EntityLookupException {
		throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
	}

	@Override
	public TrashResult trash(Person entity) {
		return trashAll(ImmutableSet.of(entity)).get(entity.getId()).get();
	}

	@Override
	public TrashResult trashById(String id) {
		return trashAllByIds(ImmutableSet.of(id)).get(id).get();
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<Person> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrash(Person entity) {
		return untrashAll(ImmutableSet.of(entity)).get(entity.getId()).get();
	}

	@Override
	public UntrashResult untrashById(String id) {
		return untrashAllByIds(ImmutableSet.of(id)).get(id).get();
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(
			Collection<Person> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(
			Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

}
