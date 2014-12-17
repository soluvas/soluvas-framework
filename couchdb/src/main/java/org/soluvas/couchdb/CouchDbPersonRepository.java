package org.soluvas.couchdb;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.ComplexKey;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.ektorp.support.DesignDocument;
import org.ektorp.support.DesignDocument.View;
import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.json.JsonUtils;

import scala.util.Failure;
import scala.util.Success;
import scala.util.Try;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
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
public class CouchDbPersonRepository extends CouchDbRepositoryBase<Person, AccountStatus>
		implements PersonRepository {
	
	/**
	 * Used by {@link org.soluvas.security.couchdb.CouchDbRolePersonRepository}. 
	 */
	public static final String VIEW_SECURITY_ROLE_IDS = "securityRoleIds";
	/**
	 * Used by {@link org.soluvas.security.couchdb.CouchDbRolePersonRepository}. 
	 */
	public static final String VIEW_SECURITY_ROLE_MEMBERS = "securityRoleMembers";

	public CouchDbPersonRepository(ClientConnectionManager connMgr, String couchDbUri, String dbName) {
		super(connMgr, Person.class, PersonImpl.class, 1L, couchDbUri, dbName,
				ImmutableList.<String>of(), ImmutableMap.<String, Integer>of(),
				DeleteMethod.DELETE, 
				"accountStatus",
				ImmutableSet.of(AccountStatus.ACTIVE, AccountStatus.VALIDATED, AccountStatus.VERIFIED),
				ImmutableSet.of(AccountStatus.INACTIVE),
				ImmutableSet.of(AccountStatus.DRAFT), ImmutableSet.of(AccountStatus.VOID) );
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
		addStatusMaskDesignView(design, "uid");
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
		addStatusMaskDesignView(design, "canonicalSlug", "slug");
		// TODO: View 'searchText' doesn't support accountStatus
		design.addView("searchText", new View(
				 "function(doc) { if (doc.type == 'Person' ) { "
			   + "emit(doc.uid, null);"
			   + "emit(doc.name, null);"
			   + "emit(doc.slug, null);"
			   + "emit(doc.canonicalSlug, null);"
		       + "doc.emails.forEach(function(e) { "
		       + "emit(e.email, null); "
		       + "}); "
		       + "} }"));
		// Used by CouchDbRolePersonRepository
		design.addView(VIEW_SECURITY_ROLE_IDS, new View(
				  "function(doc) {"
				+ "  if (doc.type == 'Person' )"
				+ "    doc.securityRoleIds.forEach(function(roleId) {"
				+ "      emit( doc.uid, roleId );"
				+ "    });"
				+ "}"));
		design.addView(VIEW_SECURITY_ROLE_MEMBERS, new View(
				  "function(doc) {"
				+ "  if (doc.type == 'Person' )"
				+ "    doc.securityRoleIds.forEach(function(roleId) {"
				+ "      emit( roleId, doc.uid );"
				+ "    });"
				+ "}"));
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
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		try {
			final Person found = lookupOne(statusMask, LookupKey.SLUG, upSlug);
			return Existence.of(found.getSlug(), found.getId());
		} catch (EntityLookupException e) {
			log.trace("existsBySlug {} '{}' returned {}", statusMask, upSlug, e);
			return Existence.<String>absent();
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.person.PersonRepository#findOneByFacebook(java.lang.Long, java.lang.String)
	 */
	@Override @Nullable
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

	@Override
	public Person findOneActive(String personId) {
		// FIXME: implement status=ACTIVE|VALIDATED|VERIFIED filter
		return findOne(personId);
	}

	/**
	 * Note: All emails in the CouchDB view must be lowercased.
	 * @param statusMask
	 * @param emails These will be lowercased.
	 * @return The returned keys will be normalized/lowercased emails. Hmm... should we use non-normalized keys?
	 * 		Like slug/canonicalSlug?
	 */
	public <S extends Person> Map<String, Try<S>> lookupAllByEmail(
			StatusMask statusMask, Collection<String> emails) {
		// normalize expected emails
		final Set<String> normalizedEmails = FluentIterable.from(emails).transform(new Function<String, String>() {
			@Override @Nullable
			public String apply(@Nullable String input) {
				return input.toLowerCase();
			}
		}).toSet();
		// filter by statusMask in Java, so we can give proper reason
		final List<ComplexKey> viewKeys = ImmutableList.copyOf(Collections2.transform(normalizedEmails, 
				new Function<String, ComplexKey>() {
			@Override @Nullable
			public ComplexKey apply(@Nullable String input) {
				return ComplexKey.of(StatusMask.RAW.getLiteral(), input);
			}
		}));
		final String viewName = "statusMask_email";
		final ViewQuery query = new ViewQuery().designDocId(getDesignDocId())
				.viewName(viewName).key(viewKeys).reduce(false).includeDocs(true);
		log.debug("Querying {} view {} for {} keys: {}", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10));
		final ViewResult fetcheds = dbConn.queryView(query);
//		final List<S> fetcheds = (List) dbConn.queryView(query, implClass);

		log.debug("Queried {} view {} for {} keys ({}) returned {} entities", 
				getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10), fetcheds.getSize() ); 

		final Map<String, Try<S>> resultMap = new HashMap<>();
		for (final Row row : fetcheds) {
			final String actualEmail = row.getKeyAsNode().get(1).asText();
			S person;
			try {
				person = (S) JsonUtils.mapper.treeToValue(row.getDocAsNode(), entityClass);
			} catch (JsonProcessingException e) {
				throw new RepositoryException(e, "Cannot deserialize document '%s' to %s: %s",
						row.getId(), entityClass.getName(), row.getDocAsNode());
			}
			switch (statusMask) {
			case RAW:
				resultMap.put(actualEmail, new Success<>(person));
			case ACTIVE_ONLY:
				if (activeStatuses.contains(person.getAccountStatus())) {
					resultMap.put(actualEmail, new Success<>(person));
				} else {
					resultMap.put(actualEmail, new Failure<S>(
							new EntityLookupException(Person.class, statusMask, LookupKey.EMAIL, actualEmail, this, Optional.fromNullable(person.getAccountStatus()))));
				}
			case INCLUDE_INACTIVE:
				if (Sets.union(activeStatuses, inactiveStatuses).contains(person.getAccountStatus())) {
					resultMap.put(actualEmail, new Success<>(person));
				} else {
					resultMap.put(actualEmail, new Failure<S>(
							new EntityLookupException(Person.class, statusMask, LookupKey.EMAIL, actualEmail, this, Optional.fromNullable(person.getAccountStatus()))));
				}
			case DRAFT_ONLY:
				if (ImmutableSet.of(AccountStatus.DRAFT).contains(person.getAccountStatus())) {
					resultMap.put(actualEmail, new Success<>(person));
				} else {
					resultMap.put(actualEmail, new Failure<S>(
							new EntityLookupException(Person.class, statusMask, LookupKey.EMAIL, actualEmail, this, Optional.fromNullable(person.getAccountStatus()))));
				}
			case VOID_ONLY:
				if (ImmutableSet.of(AccountStatus.VOID).contains(person.getAccountStatus())) {
					resultMap.put(actualEmail, new Success<>(person));
				} else {
					resultMap.put(actualEmail, new Failure<S>(
							new EntityLookupException(Person.class, statusMask, LookupKey.EMAIL, actualEmail, this, Optional.fromNullable(person.getAccountStatus()))));
				}
			}
		}
		
		// those actually not found
		final SetView<String> unfoundKeys = Sets.difference(ImmutableSet.copyOf(normalizedEmails), resultMap.keySet());
		for (final String unfoundKey : unfoundKeys) {
			resultMap.put(unfoundKey, new Failure<S>(new EntityLookupException(Person.class, statusMask, LookupKey.EMAIL, unfoundKey, this, Optional.<AccountStatus>absent())));
		}
		
		return resultMap;
	}
	
	@Override
	public <S extends Person, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		switch (lookupKey) {
		case ID:
			return lookupAllByIds(statusMask, (Collection) keys);
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
					.viewName(viewName).keys(viewKeys).reduce(false).includeDocs(true);
			log.debug("Querying {} view {} for {} keys: {}", 
					getDesignDocId(), viewName, viewKeys.size(), Iterables.limit(viewKeys, 10));
			final List<S> fetcheds = (List) dbConn.queryView(query, implClass);

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
					if (activeStatuses.contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case INCLUDE_INACTIVE:
					if (Sets.union(activeStatuses, inactiveStatuses).contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case DRAFT_ONLY:
					if (draftStatuses.contains(row.getAccountStatus())) {
						resultMap.put((K) row.getSlug(), new Success<>(row));
					} else if (!resultMap.containsKey(row.getSlug())) {
						resultMap.put((K) row.getSlug(), new Failure<S>(
								new EntityLookupException(Person.class, statusMask, lookupKey, row.getSlug(), this, Optional.fromNullable(row.getAccountStatus()))));
					}
					break;
				case VOID_ONLY:
					if (voidStatuses.contains(row.getAccountStatus())) {
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
		case EMAIL:
			return (Map) lookupAllByEmail(statusMask, (Collection<String>) keys);
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
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

	/**
	 * @param statusMask
	 * @param searchText
	 * @param pageable
	 * @return
	 * @todo View 'searchText' doesn't support accountStatus
	 */
	@Override
	public Page<Person> findBySearchText(StatusMask statusMask,
			final String searchText, Pageable pageable) {
		final ViewQuery viewQuery = new ViewQuery().designDocId(getDesignDocId()).viewName("searchText")
				.reduce(false).includeDocs(false);
		final ViewResult viewResult = dbConn.queryView(viewQuery);
		final Set<String> matchingGuids = FluentIterable.from(viewResult)
				.filter(new Predicate<Row>() {
					@Override
					public boolean apply(@Nullable Row input) {
						final String key = input.getKey();
						return StringUtils.containsIgnoreCase(key, searchText);
					}
				})
				.transform(new Function<Row, String>() {
					@Override @Nullable
					public String apply(@Nullable Row input) {
						return input.getId();
					}
				}).toSet();
		
		final Set<String> limitedGuids = FluentIterable.from(matchingGuids).skip((int) pageable.getOffset()).limit((int) pageable.getPageSize()).toSet();
		log.debug("Find {} by searchText '{}' returned {} matches out of {}, paging by {} offset {} contains {} entities: {}",
				entityClass.getSimpleName(), searchText, matchingGuids.size(), viewResult.getSize(), pageable.getPageSize(), pageable.getOffset(),
				limitedGuids.size(), limitedGuids);
		final ViewQuery guidsViewQuery = new ViewQuery().allDocs()
				.keys(limitedGuids).reduce(false).includeDocs(true);
		final List<Person> limiteds = (List) dbConn.queryView(guidsViewQuery, implClass);
		
		return new PageImpl<>(limiteds, pageable, matchingGuids.size());
	}

	@Override
	public long countBySearchText(StatusMask statusMask, final String searchText) {
		final ViewQuery viewQuery = new ViewQuery().designDocId(getDesignDocId()).viewName("searchText")
				.reduce(false).includeDocs(false);
		final ViewResult viewResult = dbConn.queryView(viewQuery);
		final Set<String> matchingGuids = FluentIterable.from(viewResult)
				.filter(new Predicate<Row>() {
					@Override
					public boolean apply(@Nullable Row input) {
						final String key = input.getKey();
						return StringUtils.containsIgnoreCase(key, searchText);
					}
				})
				.transform(new Function<Row, String>() {
					@Override @Nullable
					public String apply(@Nullable Row input) {
						return input.getId();
					}
				}).toSet();
		
		log.debug("Count {} by searchText '{}' returned {} matches out of {}",
				entityClass.getSimpleName(), searchText, matchingGuids.size(), viewResult.getSize());
		return matchingGuids.size();
	}

	@Override
	public long count(StatusMask statusMask) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	@Nullable
	public Person findOneByPhoneNumber(StatusMask statusMask, @Nullable String mobileNumber) {
		throw new UnsupportedOperationException("to be implemented");
	}

	/**
	 * @todo statusMask not yet supported
	 * @see org.soluvas.data.person.PersonRepository#findAll(org.soluvas.data.StatusMask, java.util.Collection)
	 */
	@Override
	public List<Person> findAll(StatusMask statusMask, Collection<String> ids) {
		return findAll(ids, new Sort("name"));
	}

	@Override
	public List<Person> findAllBySecRoleIds(StatusMask statusMask,
			Collection<String> secRoleIds) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person> findAll(StatusMask statusMask, Projection projection, Pageable pageable) {
		return null;
	}

	@Override
	public List<Person> findAllCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Page<Person> findAllByKeywordAndStatus(String searchText,
			Collection<AccountStatus> accountStatuses, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person> findAll(Collection<AccountStatus> accountStatuses,
			Pageable pageable) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public long countBySearchText(Collection<AccountStatus> accountStatus,
			String searchText) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public long countByStatuses(Collection<AccountStatus> accountStatuses) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public boolean existByCustomerRoleIds(StatusMask statusMask,
			Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNullCustomerRole(Collection<String> customerRoleIds) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getCustomerRoleByPersonId(String personId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long countAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> custoemrRoleIds,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Person> findAllByKeywordAndRoles(String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, Collection<String> securityRoles,
			Pageable pageable) {
		throw new UnsupportedOperationException();
	}

}
