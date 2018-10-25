package org.soluvas.mongo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Email2;
import org.soluvas.commons.EnumNameFunction;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Organization2;
import org.soluvas.commons.PersonInfo2;
import org.soluvas.commons.PhoneNumber2;
import org.soluvas.commons.PostalAddress2;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.TrashResult;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.person.PersonRepository;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import scala.util.Try;

/**
 * MongoDB powered {@link Person2} repository.
 * 
 * @author ceefour
 */
public class MongoPersonRepository extends MongoRepositoryBase<Person2> implements PersonRepository {

	private final String tenantId;
	@Nullable
	private final CacheManager cacheMgr;

	public MongoPersonRepository(String tenantId, @Nullable CacheManager cacheMgr, String mongoUri,
			boolean migrationEnabled, boolean autoExplainSlow) {
		super(Person2.class, Person2.class, Person2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL, "person",
				ImmutableList.of("canonicalSlug"), migrationEnabled, autoExplainSlow, Index.asc("name"), // for
																											// sorting
																											// in
																											// list
				Index.desc("creationTime"), Index.desc("modificationTime"), Index.asc("securityRoleIds"),
				Index.asc("customerRole"), Index.asc("memberRole"), Index.asc("managerRole"), Index.asc("facebookId"),
				// used by MongoRealm#doGetAuthenticationInfo()
				Index.compound("_id", Direction.ASC, "accountStatus", Direction.ASC),
				Index.compound("canonicalSlug", Direction.ASC, "accountStatus", Direction.ASC),
				Index.compound("emails.email", Direction.ASC, "accountStatus", Direction.ASC));
		this.tenantId = tenantId;
		this.cacheMgr = cacheMgr;
		
		upgradeEntityFrom1To2();
	}

	private void upgradeEntityFrom1To2() {
		final DBObject query = new BasicDBObject();
		query.put("schemaVersion", PersonImpl.CURRENT_SCHEMA_VERSION);
//		query.put("schemaVersion", Person2.CURRENT_SCHEMA_VERSION);
		final DBCursor cursor = primary.find(query);
		log.debug("Updating for {} row(s)", cursor.size());
		for (final DBObject dbObject : cursor) {
			 dbObject.put("schemaVersion", Person2.CURRENT_SCHEMA_VERSION);
//			 dbObject.put("schemaVersion", PersonImpl.CURRENT_SCHEMA_VERSION);
			if (dbObject.containsField("emails")) {
				final BasicDBList objListEmails = (BasicDBList) dbObject.get("emails");
				for (final Object object : objListEmails) {
					final DBObject objEmail = (DBObject) object;
					objEmail.put("className", Email2.class.getName());
				}
			}
			if (dbObject.containsField("mobileNumbers") && dbObject.get("mobileNumbers") !=null) {
				final BasicDBList objListMobileNumbers = (BasicDBList) dbObject.get("mobileNumbers");
					for (final Object object : objListMobileNumbers) {
						final DBObject objMN = (DBObject) object;
						objMN.put("className", PhoneNumber2.class.getName());
					}
			}
			if (dbObject.containsField("addresses")) {
				final BasicDBList objListAddresses = (BasicDBList) dbObject.get("addresses");
				for (final Object object : objListAddresses) {
					final DBObject objEmail = (DBObject) object;
					objEmail.put("className", PostalAddress2.class.getName());
				}
			}
			if (dbObject.containsField("phoneNumbers")) {
				final BasicDBList objListPhoneNums = (BasicDBList) dbObject.get("phoneNumbers");
				for (final Object object : objListPhoneNums) {
					final DBObject objPN = (DBObject) object;
					objPN.put("className", PhoneNumber2.class.getName());
				}
			}
			if (dbObject.containsField("organizations")) {
				final BasicDBList objListorganizations = (BasicDBList) dbObject.get("organizations");
				for (final Object object : objListorganizations) {
					final DBObject objOrganizations = (DBObject) object;
					objOrganizations.put("className", Organization2.class.getName());
				}
			}
			primary.save(dbObject);
		} // end of looping
	}

	@Override
	protected void beforeSave(Person2 entity, ModificationTimePolicy mtimePolicy) {
		super.beforeSave(entity, mtimePolicy);
		entity.setCanonicalSlug(SlugUtils.canonicalize(entity.getSlug()));
	}

	@Override
	@Nullable
	public Person2 findOneBySlug(StatusMask statusMask, String upSlug) {
		String canonicalize = SlugUtils.canonicalize(upSlug);
		return findOneByQuery(new BasicDBObject("canonicalSlug", canonicalize));
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		final BasicDBObject query = new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug));
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbo = findDBObjectByQuery(query, new BasicDBObject("slug", true));
		if (dbo != null) {
			final String actualSlug = (String) dbo.get("slug");
			if (actualSlug.equals(upSlug)) {
				return Existence.of(actualSlug, (String) dbo.get("_id"));
			} else {
				return Existence.mismatch(actualSlug, (String) dbo.get("_id"));
			}
		} else {
			return Existence.<String> absent();
		}
	}

	@Override
	public Existence<String> existsBySlugCacheable(StatusMask statusMask, String upSlug) {
		if (cacheMgr != null) {
			final Cache slugsCache = cacheMgr.getCache("slugs");
			final String key = String.format("person:%s:%s", tenantId, upSlug);
			@Nullable
			Existence existence = slugsCache.get(key, Existence.class);
			log.debug("cache: key '{}' with existence {}", key, existence);
			if (existence == null) {
				existence = existsBySlug(statusMask, upSlug);
				if (existence.isPresent()) {
					slugsCache.put(key, existence);
				}
			}
			return existence;
		} else {
			return existsBySlug(statusMask, upSlug);
		}
	}

	@Override
	public Person2 findOneByFacebook(@Nullable Long facebookId, @Nullable String facebookUsername) {
		if (facebookId == null && facebookUsername == null) {
			return null;
		}
		final List<DBObject> orCriteria = new ArrayList<>();
		if (facebookId != null) {
			orCriteria.add(
					new BasicDBObject(CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_ID.getName(), facebookId));
		}
		if (facebookUsername != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_USERNAME.getName(),
					facebookUsername));
		}
		final BasicDBObject query = new BasicDBObject("$or", orCriteria);
		log.debug("Try to find one by facebook id '{}' or userName '{}: {}", facebookId, facebookUsername, query);
		return findOneByQuery(query);
	}

	@Override
	@Nullable
	public Person2 findOneByEmail(StatusMask statusMask, @Nullable String email) {
		if (Strings.isNullOrEmpty(email)) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}

	@Override
	@Nullable
	public Person2 findOneByEmail(AccountStatus status, String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty");
		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		query.put("accountStatus", status.name());
		return findOneByQuery(query);
	}

	@Override
	public boolean isExistsByEmail(StatusMask statusMask, String email) {
		final Optional<String> optExists = getIdByEmail(statusMask, email);
		return optExists.isPresent();
	}

	@Override
	public Optional<String> getIdByEmail(StatusMask statusMask, String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty");
		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("_id", true), "getIdByEmail", statusMask,
				email);
		if (dbObject == null) {
			return Optional.absent();
		} else {
			return Optional.of(String.valueOf(dbObject.get("_id")));
		}
	}

	@Override
	@Nullable
	public Person2 findOneById(StatusMask statusMask, @Nullable String id) {
		if (Strings.isNullOrEmpty(id)) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("_id", id);
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}

	@Override
	@Nullable
	public Person2 findOneByMobileOrPhoneNumber(StatusMask statusMask, @Nullable String phoneNumber) {
		if (phoneNumber == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject qMobileNumber = new BasicDBObject("mobileNumbers",
				new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		final BasicDBObject qPhoneNumber = new BasicDBObject("phoneNumbers",
				new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		query.put("$or", new BasicDBObject[] { qMobileNumber, qPhoneNumber });
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}

	@Override
	public boolean isMobilePhoneNumberAlreadyRegistered(StatusMask statusMask, String phoneNumber) {
		final Optional<String> optExists = getIdByMobileOrPhoneNumber(statusMask, phoneNumber);
		return optExists.isPresent();
	}

	@Override
	public Optional<String> getIdByMobileOrPhoneNumber(StatusMask statusMask, String phoneNumber) {
//		Preconditions.checkState(!Strings.isNullOrEmpty(phoneNumber), "Phone number must not be null or empty");
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject qMobileNumber = new BasicDBObject("mobileNumbers",
				new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		final BasicDBObject qPhoneNumber = new BasicDBObject("phoneNumbers",
				new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		query.put("$or", new BasicDBObject[] { qMobileNumber, qPhoneNumber });
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("_id", true), "getIdByPhoneNumber",
				statusMask, phoneNumber);
		if (dbObject == null) {
			return Optional.absent();
		} else {
			return Optional.of(String.valueOf(dbObject.get("_id")));
		}
	}

	@Override
	@Nullable
	public Person2 findOneByTwitter(@Nullable Long twitterId, @Nullable String twitterScreenName) {
		if (twitterId == null && twitterScreenName == null) {
			return null;
		}
		final List<DBObject> orCriteria = new ArrayList<>();
		if (twitterId != null) {
			orCriteria
					.add(new BasicDBObject(CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_ID.getName(), twitterId));
		}
		if (twitterScreenName != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_SCREEN_NAME.getName(),
					twitterScreenName));
		}
		final BasicDBObject query = new BasicDBObject("$or", orCriteria);
		return findOneByQuery(query);
	}

	@Override
	@Nullable
	public Person2 findOneByClientAccessToken(@Nullable String clientAccessToken) {
		if (clientAccessToken == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("clientAccessToken", clientAccessToken);
		return findOneByQuery(query);
	}

	@Override
	public Page<Person2> findBySearchText(StatusMask statusMask, @Nullable String searchText, Pageable pageable) {
		final BasicDBObject queryBySearchText = getQueryByKeyword(searchText);
		augmentQueryForStatusMask(queryBySearchText, statusMask);
		final Sort mySort;
		if (pageable.getSort() != null) {
			mySort = pageable.getSort().and(new Sort(Direction.DESC, "modificationTime"));
		} else {
			mySort = new Sort(Direction.DESC, "modificationTime");
		}

		final PageRequest myPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), mySort);

		return findAllByQuery(queryBySearchText, myPageable);
	}

	private BasicDBObject getQueryByKeyword(String searchText) {
		final Pattern regex = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);

		final BasicDBObject nameQuery = new BasicDBObject("name", regex);
		final BasicDBObject idQuery = new BasicDBObject("_id", regex);

		final BasicDBObject emailQuery = new BasicDBObject("email", regex);
		final BasicDBObject emailsQuery = new BasicDBObject("emails", new BasicDBObject("$elemMatch", emailQuery));

		final BasicDBObject phoneNumberQuery = new BasicDBObject("phoneNumber", regex);
		final BasicDBObject mobileNumbersQuery = new BasicDBObject("mobileNumbers",
				new BasicDBObject("$elemMatch", phoneNumberQuery));
		final BasicDBObject phoneNumbersQuery = new BasicDBObject("phoneNumbers",
				new BasicDBObject("$elemMatch", phoneNumberQuery));

		final BasicDBObject query = new BasicDBObject("$or",
				ImmutableList.of(nameQuery, idQuery, emailsQuery, mobileNumbersQuery, phoneNumbersQuery));
		log.debug("Query is {}", query);
		return query;
	}

	@Override
	public long countBySearchText(StatusMask statusMask, String searchText) {
		final BasicDBObject query = getQueryByKeyword(searchText);
		augmentQueryForStatusMask(query, statusMask);

		final long count = countByQuery(query);
		log.debug("Got {} people by query: {}", count, query);
		return count;
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		final Page<Person2> page = findAllByQuery(query, pageable);
		return page;
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Projection projection, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		final long total = count(statusMask);
		final ImmutableList<Person2> people = findSecondary(query, getProjectionDBObject(projection),
				MongoUtils.getSort(pageable.getSort()), pageable.getOffset(), pageable.getPageSize(), "findAll",
				statusMask, projection);
		return new PageImpl<>(people, pageable, total);
	}

	@Override
	public long count(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		final long count = countByQuery(query);
		log.debug("Got {} record(s) by query: {}", count, query);
		return count;
	}

	protected void augmentQueryForStatusMask(BasicDBObject query, StatusMask statusMask) {
		Preconditions.checkArgument(!query.containsField("accountStatus"),
				"Query to be augmented using StatusMask must not already have a 'status' criteria.");
		switch (statusMask) {
		case RAW:
			break;
		case ACTIVE_ONLY:
			query.put("accountStatus", new BasicDBObject("$in",
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.VERIFIED.name())));
			break;
		case INCLUDE_INACTIVE:
			query.put("accountStatus", new BasicDBObject("$in", ImmutableSet.of(AccountStatus.ACTIVE.name(),
					AccountStatus.VERIFIED.name(), AccountStatus.INACTIVE.name())));
			break;
		case VOID_ONLY:
			query.put("accountStatus", AccountStatus.VOID.name());
			break;
		default:
			throw new IllegalArgumentException("Unrecognized StatusMask: " + statusMask);
		}
	}

	@Override
	public Person2 findOneActive(String personId) {
		// FIXME: implement status=ACTIVE|VALIDATED|VERIFIED filter
		return findOne(personId);
	}

	@Override
	public <S extends Person2, K extends Serializable> S lookupOne(StatusMask statusMask, LookupKey lookupKey, K key)
			throws EntityLookupException {
		final String attribute;
		switch (lookupKey) {
		case ID:
			attribute = "_id";
			break;
		case SLUG:
			attribute = "canonicalSlug";
			break;
		case EMAIL:
			attribute = "emails.email";
			break;
		case FACEBOOK_ID:
			attribute = "facebookId";
			break;
		case FACEBOOK_USERNAME:
			attribute = "facebookUsername";
			break;
		case GUID:
			attribute = "guid";
			break;
		case MOBILE_NUMBER:
			attribute = "mobileNumbers.phoneNumber";
			break;
		case TWITTER_ID:
			attribute = "twitterId";
			break;
		case TWITTER_SCREENNAME:
			attribute = "twitterScreenName";
			break;
		default:
			throw new RuntimeException("Unrecognized for lookupKey " + lookupKey);
		}
		final BasicDBObject query = new BasicDBObject(attribute, key);
		augmentQueryForStatusMask(query, statusMask);
		return (S) findOneByQuery(query);
	}

	@Override
	public <S extends Person2, K extends Serializable> Map<K, Try<S>> lookupAll(StatusMask statusMask,
			LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(StatusMask statusMask, LookupKey lookupKey,
			Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask, LookupKey lookupKey, K key) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trash(Person2 entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAll(Collection<Person2> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<TrashResult>> trashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrash(Person2 entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAll(Collection<Person2> entities) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public Map<String, Try<UntrashResult>> untrashAllByIds(Collection<String> ids) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public List<Person2> findAll(StatusMask statusMask, Collection<String> ids) {
		final BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$in", ids));
		augmentQueryForStatusMask(query, statusMask);
		return findAllByQuery(query, new CappedRequest(500)).getContent();
	}

	@Override
	public Page<Person2> findAll(StatusMask statusMask, Collection<String> ids, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$in", ids));
		augmentQueryForStatusMask(query, statusMask);
		return findAllByQuery(query, pageable);
	}

	@Override
	public List<Person2> findAllBySecRoleIds(StatusMask statusMask, Collection<String> secRoleIds) {
		final BasicDBObject query = new BasicDBObject();
		query.put("securityRoleIds", new BasicDBObject("$in", secRoleIds));
		augmentQueryForStatusMask(query, statusMask);
		log.debug("Find All by secRoleIds + status: {}", query);
		return findAllByQuery(query, new CappedRequest(500)).getContent();
	}

	@Override
	public boolean hasMatchWithSecRoleIds(String personId, Collection<String> secRoleIds) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", personId);
		query.put("securityRoleIds", new BasicDBObject("$in", secRoleIds));
		final Person2 person = findOneByQuery(query);
		return person != null;
	}

	@Override
	public List<Person2> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds) {
		final BasicDBObject query = new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds));
		augmentQueryForStatusMask(query, statusMask);

		return findAllByQuery(query, new CappedRequest(500)).getContent();
	}

	@Override
	public Page<Person2> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds,
			Pageable pageable) {
		final BasicDBObject query = new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds));
		augmentQueryForStatusMask(query, statusMask);

		return findAllByQuery(query, pageable);
	}

	@Override
	public long countAllByCustomerRolesIds(StatusMask statusMask, Collection<String> customerRoleIds) {
		log.debug("customerRoleIds {}", customerRoleIds);
		final BasicDBObject query = new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds));
		augmentQueryForStatusMask(query, statusMask);

		return countByQuery(query);
	}

	@Override
	public Page<Person2> findAllByKeywordAndStatus(String keyword, Collection<AccountStatus> accountStatuses,
			Pageable pageable) {
		final BasicDBObject query = getQueryByKeyword(keyword);
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}

		final Sort mySort;
		if (pageable.getSort() != null) {
			mySort = pageable.getSort().and(new Sort(Direction.DESC, "modificationTime"));
		} else {
			mySort = new Sort(Direction.DESC, "modificationTime");
		}

		final PageRequest myPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), mySort);

		return findAllByQuery(query, myPageable);
	}

	/**
	 * 
	 * @param keyword
	 *            (ID, name, emails and phone numbers)
	 * @param accountStatuses
	 * @param customerRole
	 * @param securityRoleIds
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Person2> findAllByKeywordAndRoles(String keyword, Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds, Pageable pageable) {

		BasicDBObject query;
		if (keyword != null) {
			query = getQueryByKeyword(keyword);
		} else {
			query = new BasicDBObject();
		}

		if (accountStatuses != null && !accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}

		if (customerRole != null) {
			query.put("customerRole", customerRole.getId());
		}

		if (securityRoleIds != null && !securityRoleIds.isEmpty()) {
			query.put("securityRoleIds", new BasicDBObject("$in", securityRoleIds));
		}

		final Sort mySort;
		if (pageable.getSort() != null) {
			mySort = pageable.getSort().and(new Sort(Direction.DESC, "modificationTime"));
		} else {
			mySort = new Sort(Direction.DESC, "modificationTime");
		}

		final PageRequest myPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), mySort);

		log.debug("Query findAllByKeywordAndRoles {}", query);

		return findAllByQuery(query, myPageable);
	}

	/**
	 * 
	 * @param pageable
	 * @param keyword
	 *            (ID, name, emails and phone numbers)
	 * @param accountStatuses
	 * @param customerRole
	 * @param securityRoleIds
	 * @return
	 */
	@Override
	public long countAllByKeywordAndRoles(String keyword, Collection<AccountStatus> accountStatuses,
			CustomerRole2 customerRole, Collection<String> securityRoleIds) {

		BasicDBObject query;
		if (keyword != null) {
			query = getQueryByKeyword(keyword);
		} else {
			query = new BasicDBObject();
		}

		if (accountStatuses != null && !accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}

		if (customerRole != null) {
			query.put("customerRole", customerRole.getId());
		}

		if (securityRoleIds != null && !securityRoleIds.isEmpty()) {
			query.put("securityRoleIds", new BasicDBObject("$in", securityRoleIds));
		}

		return countByQuery(query);
	}

	// private BasicDBObject findAllByKeywordAndRoles() {
	// return null;
	// }

	@Override
	public Page<Person2> findAll(Collection<AccountStatus> accountStatuses, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}

		final Sort mySort;
		if (pageable.getSort() != null) {
			mySort = pageable.getSort().and(new Sort(Direction.DESC, "modificationTime"));
		} else {
			mySort = new Sort(Direction.DESC, "modificationTime");
		}

		final PageRequest myPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), mySort);

		return findAllByQuery(query, myPageable);
	}

	@Override
	public long countBySearchText(Collection<AccountStatus> accountStatuses, String searchText) {
		final BasicDBObject query = getQueryByKeyword(searchText);
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}

		final long count = countByQuery(query);
		log.debug("Got {} people by SearchText query: {}", count, query);
		return count;
	}

	@Override
	public long countByStatuses(Collection<AccountStatus> accountStatuses) {
		final BasicDBObject query = new BasicDBObject();
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in",
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}
		final long count = countByQuery(query);
		log.debug("Got {} record(s) by Statuses query: {}", count, query);
		return count;
	}

	@Override
	public long countByFacebook() {
		final BasicDBObject query = new BasicDBObject();
		query.put("facebookId", new BasicDBObject("$exists", true));
		final long count = countByQuery(query);
		log.debug("Got {} record(s) by Facebook query: {}", count, query);
		return count;
	}

	@Override
	public boolean existByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds) {
		final BasicDBObject query = new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds));
		augmentQueryForStatusMask(query, statusMask);
		final DBCursor cursor = primary.find(query, new BasicDBObject("_id", true));
		return cursor.count() > 0;
	}

	@Override
	public void setNullCustomerRole(Collection<String> customerRoleIds) {
		primary.update(new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds)),
				new BasicDBObject("$set", new BasicDBObject("customerRole", null)), false, true);
	}

	@Override
	public String getCustomerRoleByPersonId(String personId) {
		final BasicDBObject query = new BasicDBObject("_id", personId);
		final BasicDBObject field = new BasicDBObject("customerRole", true);
		final DBObject object = findOnePrimary(query, field, "findCustomerRoleByPersonId", personId);
		if (object != null) {
			final String customerRole = (String) object.get("customerRole");
			log.debug("Person {}'s customerRole is {}", personId, customerRole);
			return customerRole;
		} else {
			return null;
		}
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		return findSecondary(query, new BasicDBObject(ImmutableMap.of("slug", true, "_id", false)), null, 0, 0,
				new CursorFunction<ImmutableSet<String>>() {
					@Override
					public ImmutableSet<String> apply(DBCursor cursor) throws Exception {
						return FluentIterable.from(cursor).transform(new Function<DBObject, String>() {
							@Override
							public String apply(DBObject input) {
								return (String) input.get("slug");
							}
						}).toSet();
					}
				}, "findAllSlugsByStatus", statusMask);
	}

	@Override
	public ImmutableSet<String> findAllSlugsByStatus(StatusMask statusMask, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject sort = MongoUtils.getSort(pageable.getSort());
		augmentQueryForStatusMask(query, statusMask);
		return findSecondary(query, new BasicDBObject(ImmutableMap.of("slug", true, "_id", false)), sort,
				pageable.getOffset(), pageable.getPageSize(), new CursorFunction<ImmutableSet<String>>() {
					@Override
					public ImmutableSet<String> apply(DBCursor cursor) throws Exception {
						return FluentIterable.from(cursor).transform(new Function<DBObject, String>() {
							@Override
							public String apply(DBObject input) {
								return (String) input.get("slug");
							}
						}).toSet();
					}
				}, "findAllSlugsByStatus", statusMask);
	}

	@Override
	@Nullable
	public Person2 getZendeskUserId(String email) {
		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		query.put("zendeskIntegration", true);
		query.put("zendeskUserId", new BasicDBObject("$exists", true));
		query.put("customerRole", new BasicDBObject("$exists", true));

		final BasicDBObject fields = new BasicDBObject("zendeskUserId", true);
		fields.put("customerRole", 1);

		final DBObject dbObject = findOnePrimary(query, fields, "getZendeskUserId", email);
		if (dbObject != null) {
			if (dbObject.get("zendeskUserId") != null && !"null".equals(dbObject.get("zendeskUserId"))) {
				final Person2 person = new Person2();
				person.setId(dbObject.get("zendeskUserId").toString());
				person.setZendeskUserId(Long.valueOf(dbObject.get("zendeskUserId").toString()));
				person.setCustomerRole(dbObject.get("customerRole").toString());
				return person;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Long getZendeskUserIdByPersonId(String personId) {
		Preconditions.checkState(!Strings.isNullOrEmpty(personId),
				"Person ID for finding zendesk user id must not be null or empty.");
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", personId);
		query.put("zendeskIntegration", true);
		query.put("customerRole", new BasicDBObject("$exists", true));

		final BasicDBObject fields = new BasicDBObject("zendeskUserId", true);

		final DBObject dbObject = findOnePrimary(query, fields, "getZendeskUserIdByPersonId", personId);
		log.debug("Found zendesk user dbObject by personId '{}': {}", personId, dbObject);
		if (dbObject != null) {
			if (dbObject.get("zendeskUserId") != null && !"null".equals(dbObject.get("zendeskUserId"))) {
				return Long.valueOf(dbObject.get("zendeskUserId").toString());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Page<Person2> findAllByEmailExists(StatusMask statusMask, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		query.put("emails", new BasicDBObject("$exists", true));
		final Page<Person2> page = findAllByQuery(query, pageable);
		return page;
	}

	@Override
	public Page<Person2> findAllByEmailExists(DateTime starTime, DateTime endTime, StatusMask statusMask,
			Pageable pageable) {
		final BasicDBObject query = getQueryByCreationTime(starTime.toLocalDate(), endTime.toLocalDate());
		augmentQueryForStatusMask(query, statusMask);
		query.put("emails", new BasicDBObject("$exists", true));
		final Page<Person2> page = findAllByQuery(query, pageable);
		return page;
	}

	private BasicDBObject getQueryByCreationTime(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
		final BasicDBObject query = new BasicDBObject();
		if (startDate != null || endDate != null) {
			final BasicDBObject creationTimeQuery = new BasicDBObject();
			if (startDate != null) {
				creationTimeQuery.put("$gte", startDate.toDateTimeAtStartOfDay(timeZone).toDate());
			}
			if (endDate != null) {
				creationTimeQuery.put("$lt", endDate.plusDays(1).toDateTimeAtStartOfDay(timeZone).toDate());
			}
			query.put("creationTime", creationTimeQuery);
		}
		return query;
	}

	@Override
	public List<String> findAllIdsByCustomerRoleId(StatusMask statusMask, String customerRoleId) {
		final BasicDBObject query = new BasicDBObject("customerRole", customerRoleId);
		augmentQueryForStatusMask(query, statusMask);

		final BasicDBObject fields = new BasicDBObject("_id", true);

		final BasicDBObject sort = new BasicDBObject("_id", 1);

		final List<DBObject> dbObjects = findSecondaryAsDBObjects(query, fields, sort, 0, 0,
				"findAllIdsByCustomerRoleId", statusMask, customerRoleId);
		final List<String> ids = dbObjects.stream().map(new java.util.function.Function<DBObject, String>() {
			@Override
			public String apply(DBObject t) {
				return t.get("_id").toString();
			}
		}).collect(Collectors.toList());
		return ids;
	}

	@Override
	public Optional<String> getCustomerRole(@Nonnull String personId) {
		String customerRole = getCustomerRoleByPersonId(personId);
		return Optional.fromNullable(customerRole);
	}

	@Override
	public boolean existsByEmail(String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty for existsByEmail");

		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));

		final long count = countByQuery(query);
		return count > 0;
	}

	@Override
	public boolean existsByEmailAndStatus(String email, AccountStatus status) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email),
				"Email must not be null or empty for existsByEmailAndStatus");
		Preconditions.checkState(status != null, "Status must not be null for existsByEmailAndStatus");

		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		query.put("accountStatus", status.name());

		final long count = countByQuery(query);
		return count > 0;
	}

	/**
	 * Karena satu email bisa dimiliki oleh beberapa person dengan beragam
	 * status nya..
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public ImmutableList<AccountStatus> getStatusesByEmail(String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email),
				"Email must not be null or empty for getStatusesByEmail");

		final BasicDBObject query = new BasicDBObject("emails",
				new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));

		final BasicDBObject fields = new BasicDBObject();
		fields.put("accountStatus", true);

		final List<DBObject> dbObjectList = findSecondaryAsDBObjects(query, fields, null, 0, 0, "getStatusesByEmail",
				email);
		if (dbObjectList != null && !dbObjectList.isEmpty()) {
			final ImmutableList.Builder<AccountStatus> bList = ImmutableList.builder();
			for (final DBObject dbObject : dbObjectList) {
				bList.add(AccountStatus.valueOf(String.valueOf(dbObject.get("accountStatus"))));
			}
			return bList.build();
		} else {
			return ImmutableList.of();
		}
	}
	
	public String findJneAreaCode(String district, String city, String province, String country) {
		BasicDBObject basicDb = new BasicDBObject();
		
		BasicDBObject elemDbo = new BasicDBObject();
		elemDbo.put("district", district);
		elemDbo.put("city", city);
		elemDbo.put("province", province);
		elemDbo.put("country", country);
		basicDb.put("addresses", new BasicDBObject("$elemMatch", elemDbo));
		
		Page<Person2> address = findAllByQuery(basicDb, new PageOffsetRequest(0, 100));
		return null;
	}

	@Override
	public double getPerformanceValue(String id) {
		final BasicDBObject query = new BasicDBObject("_id", id);
		final BasicDBObject fields = new BasicDBObject("performanceValue", true);
		final DBObject dbObject = findOneSecondary(query, fields, "getPerformanceValue", id);
		if (dbObject != null) {
			if (dbObject.containsField("performanceValue")) {
				return Double.valueOf( String.valueOf(dbObject.get("performanceValue")) );
			}
			return 0;
		}
		return 0;
	}

	@Override
	public boolean updatePerformanceValues(Map<String, Double> upPerformanceMap) {
		final BulkWriteOperation bulk = primary.initializeUnorderedBulkOperation();
		
		upPerformanceMap.entrySet().forEach(new Consumer<Entry<String, Double>>() {
			@Override
			public void accept(Entry<String, Double> entry) {
				final Double performanceValue = entry.getValue();
				final String id = entry.getKey();
				
				final DBObject query = new BasicDBObject();
				query.put("_id", id);
				
				final DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("performanceValue", performanceValue));

				bulk.find(query).updateOne(update);
			}
		});
		
		final BulkWriteResult writeResult = bulk.execute();
		
		if (upPerformanceMap.size() != writeResult.getMatchedCount()) {
			log.error("Expected {} matched, but got {}. inserted={}, modified={} of {}, upserted={}",
					upPerformanceMap.size(), writeResult.getMatchedCount(), writeResult.getInsertedCount(), writeResult.getModifiedCount(), writeResult.getMatchedCount(), writeResult.getUpserts().size());
			return false;
		} else {
			log.info("Succeeded updating {} qtys (actual modified={}). Input: {}",
					writeResult.getMatchedCount(), writeResult.getModifiedCount(), upPerformanceMap);
			return true;
		}
	}
	
	@Override
	public Page<Person2> findAllWhereCustomerRoleValidThruNotNull(StatusMask statusMask, Pageable pageable) {
		BasicDBObject query = new BasicDBObject("customerRoleValidThru", new BasicDBObject("$exists", true));
		augmentQueryForStatusMask(query, statusMask);
		return findAllByQuery(query, pageable);
	}
 

	@SuppressWarnings("deprecation")
	@Override
	public void removeFcmToken(String userId, String oldFirebaseCloudMessagingToken) {
		final BasicDBObject query = new BasicDBObject("_id", userId);
		final BasicDBObject update = new BasicDBObject("$pull", new BasicDBObject("firebaseCloudMessagingTokens", oldFirebaseCloudMessagingToken));
		final WriteResult result = primary.update(query, update);
		log.debug("Update person by removing firebase cloud messaging token '{}' for personId '{}': {}",
				oldFirebaseCloudMessagingToken, userId, result);
	}

	@Override
	public boolean addPrimaryEmail(String id, String primaryEmail) {
		final DBObject query = new BasicDBObject("_id", id);
		final DBObject objPrimaryEmail = new BasicDBObject(ImmutableMap.of("email", primaryEmail, "primary", true));
		final BasicDBList emails = new BasicDBList();
		emails.add(objPrimaryEmail);
		
		final WriteResult update = primary.update(query, new BasicDBObject("$set", ImmutableMap.of("emails", emails)));
		log.debug("Added primary email '{}' to '{}': {}", primaryEmail, id, update);
		return update.getN() == 1;
	}
	
	@Override
	public boolean addPrimaryMobileNumber(String id, String mobileNumber) {
		final DBObject query = new BasicDBObject("_id", id);
		final DBObject objPrimaryMobileNumber = new BasicDBObject(ImmutableMap.of("phoneNumber", mobileNumber, "primary", true));
		final BasicDBList mobileNumbers = new BasicDBList();
		mobileNumbers.add(objPrimaryMobileNumber);
		
		final WriteResult update = primary.update(query, new BasicDBObject("$set", ImmutableMap.of("mobileNumbers", mobileNumbers)));
		log.debug("Added primary mobileNumber '{}' to '{}': {}", mobileNumber, id, update);
		return update.getN() == 1;
	}

	@Override @Nullable
	public PersonInfo2 findOneAsInfo(String id) {
		final BasicDBObject query = new BasicDBObject("_id", id);
		
		final HashMap<String, Boolean> map = new HashMap<>();
		map.put("_id", true);
		map.put("slug", true);
		map.put("name", true);
		map.put("photoId", true);
		map.put("gender", true);
		map.put("emails", true);
		map.put("mobileNumbers", true);
		map.put("customerRole", true);
		final BasicDBObject fields = new BasicDBObject(map);
		
		final DBObject dbObj = findOneSecondary(query, fields, "findOneAsInfo", id);
		if (dbObj == null) {
			return null;
		}
		
		final PersonInfo2 personInfo = new PersonInfo2();
		if (dbObj.containsField("_id")) {
			personInfo.setId(String.valueOf(dbObj.get("_id")));
		}
		if (dbObj.containsField("slug")) {
			personInfo.setSlug(String.valueOf(dbObj.get("slug")));
		}
		if (dbObj.containsField("name")) {
			personInfo.setName(String.valueOf(dbObj.get("name")));
		}
		if (dbObj.containsField("photoId")) {
			personInfo.setPhotoId(String.valueOf(dbObj.get("photoId")));
		}
		if (dbObj.containsField("gender")) {
			personInfo.setGender(Gender.valueOf(String.valueOf(dbObj.get("gender"))));
		}
		if (dbObj.containsField("emails")) {
			final BasicDBList objEmails = (BasicDBList) dbObj.get("emails");
			final java.util.Optional<Object> optPrimaryEmail = objEmails.stream().filter(new Predicate<Object>() {
				@Override
				public boolean test(Object t) {
					final DBObject objEmail = (DBObject) t;
					if (objEmail.containsField("email") && objEmail.containsField("primary")) {
						return Boolean.valueOf(String.valueOf(objEmail.get("primary")));
					}
					return false;
				}
			}).findFirst();
			if (optPrimaryEmail.isPresent()) {
				final DBObject objPrimaryEmail = (DBObject) optPrimaryEmail.get();
				personInfo.setEmail(String.valueOf(objPrimaryEmail.get("email")));
			} else {
				final DBObject objFirstEmail = (DBObject) objEmails.get(0);
				personInfo.setEmail(String.valueOf(objFirstEmail.get("email")));
			}
		}
		if (dbObj.containsField("mobileNumbers")) {
			final BasicDBList objMobileNumbers = (BasicDBList) dbObj.get("mobileNumbers");
			final java.util.Optional<Object> optPrimaryMobileNumber = objMobileNumbers.stream().filter(new Predicate<Object>() {
				@Override
				public boolean test(Object t) {
					final DBObject objEmail = (DBObject) t;
					if (objEmail.containsField("phoneNumber") && objEmail.containsField("primary")) {
						return Boolean.valueOf(String.valueOf(objEmail.get("primary")));
					}
					return false;
				}
			}).findFirst();
			if (optPrimaryMobileNumber.isPresent()) {
				final DBObject objPrimaryMobileNumber = (DBObject) optPrimaryMobileNumber.get();
				personInfo.setMobileNumber(String.valueOf(objPrimaryMobileNumber.get("phoneNumber")));
			} else {
				final DBObject objFirstMobileNumber = (DBObject) objMobileNumbers.get(0);
				personInfo.setMobileNumber(String.valueOf(objFirstMobileNumber.get("phoneNumber")));
			}
		}
		if (dbObj.containsField("customerRole")) {
			personInfo.setRole(String.valueOf(dbObj.get("customerRole")));
		}
		
		return personInfo;
	}

	@Override
	public ImmutableList<PostalAddress2> getAddresses(String id) {
		final BasicDBObject query = new BasicDBObject("_id", id);
		
		final BasicDBObject fields = new BasicDBObject("addresses", 1);
		
		final DBObject dbObj = findOneSecondary(query, fields, "getAddresses", id);
		if (dbObj == null) {
			return ImmutableList.of();
		}
		final ImmutableList.Builder<PostalAddress2> bList = ImmutableList.builder();
		if (dbObj.containsField("addresses")) {
			final BasicDBList objAddresses = (BasicDBList) dbObj.get("addresses");
			objAddresses.forEach(new Consumer<Object>() {
				@Override
				public void accept(Object t) {
					final DBObject objAddress = (DBObject) t;
					
					final PostalAddress2 address = new PostalAddress2();
					if (objAddress.containsField("city")) {
						address.setCity(String.valueOf(objAddress.get("city")));
					}
					if (objAddress.containsField("country")) {
						address.setCountry(String.valueOf(objAddress.get("country")));
					}
					if (objAddress.containsField("countryCode")) {
						address.setCountryCode(String.valueOf(objAddress.get("countryCode")));
					}
					if (objAddress.containsField("description")) {
						address.setDescription(String.valueOf(objAddress.get("description")));
					}
					if (objAddress.containsField("district")) {
						address.setDistrict(String.valueOf(objAddress.get("district")));
					}
					if (objAddress.containsField("emails")) {
						final BasicDBList objEmails = (BasicDBList) objAddress.get("emails");
						address.setEmails(objEmails.stream().map(new java.util.function.Function<Object, String>() {
							@Override
							public String apply(Object t) {
								return String.valueOf(t);
							}
						}).collect(Collectors.toList()));
					}
					if (objAddress.containsField("homePhones")) {
						final BasicDBList objHomePhones = (BasicDBList) objAddress.get("homePhones");
						address.setHomePhones(objHomePhones.stream().map(new java.util.function.Function<Object, String>() {
							@Override
							public String apply(Object t) {
								return String.valueOf(t);
							}
						}).collect(Collectors.toList()));
					}
					if (objAddress.containsField("id")) {
						address.setId(UUID.fromString(String.valueOf(objAddress.get("id"))));
					}
					if (objAddress.containsField("jneAreaCode")) {
						address.setJneAreaCode(String.valueOf(objAddress.get("jneAreaCode")));
					}
					if (objAddress.containsField("mobiles")) {
						final BasicDBList objMobiles = (BasicDBList) objAddress.get("mobiles");
						address.setMobiles(objMobiles.stream().map(new java.util.function.Function<Object, String>() {
							@Override
							public String apply(Object t) {
								return String.valueOf(t);
							}
						}).collect(Collectors.toList()));
					}
					if (objAddress.containsField("name")) {
						address.setName(String.valueOf(objAddress.get("name")));
					}
					if (objAddress.containsField("organization")) {
						address.setOrganization(String.valueOf(objAddress.get("organization")));
					}
					if (objAddress.containsField("phones")) {
						final BasicDBList objPhones = (BasicDBList) objAddress.get("phones");
						address.setPhones(objPhones.stream().map(new java.util.function.Function<Object, String>() {
							@Override
							public String apply(Object t) {
								return String.valueOf(t);
							}
						}).collect(Collectors.toList()));
					}
					if (objAddress.containsField("postalCode")) {
						address.setPostalCode(String.valueOf(objAddress.get("postalCode")));
					}
					if (objAddress.containsField("primary")) {
						address.setPrimary(Boolean.valueOf(String.valueOf(objAddress.get("primary"))));
					}
					if (objAddress.containsField("primaryBilling")) {
						address.setPrimaryBilling(Boolean.valueOf(String.valueOf(objAddress.get("primaryBilling"))));
					}
					if (objAddress.containsField("primaryEmail")) {
						address.setPrimaryEmail(String.valueOf(objAddress.get("primaryEmail")));
					}
					if (objAddress.containsField("primaryHomePhone")) {
						address.setPrimaryHomePhone(String.valueOf(objAddress.get("primaryHomePhone")));
					}
					if (objAddress.containsField("primaryMobile")) {
						address.setPrimaryMobile(String.valueOf(objAddress.get("primaryMobile")));
					}
					if (objAddress.containsField("primaryPhone")) {
						address.setPrimaryPhone(String.valueOf(objAddress.get("primaryPhone")));
					}
					if (objAddress.containsField("primaryShipping")) {
						address.setPrimaryShipping(Boolean.valueOf(String.valueOf(objAddress.get("primaryShipping"))));
					}
					if (objAddress.containsField("primaryWorkPhone")) {
						address.setPrimaryWorkPhone(String.valueOf(objAddress.get("primaryWorkPhone")));
					}
					if (objAddress.containsField("province")) {
						address.setProvince(String.valueOf(objAddress.get("province")));
					}
					if (objAddress.containsField("street")) {
						address.setStreet(String.valueOf(objAddress.get("street")));
					}
					if (objAddress.containsField("validationTime")) {
						address.setValidationTime(new DateTime(objAddress.get("validationTime")));
					}
					if (objAddress.containsField("validationTime_zone")) {
						address.setValidationTime_zone(DateTimeZone.forID(String.valueOf(objAddress.get("validationTime_zone"))));
					}
					if (objAddress.containsField("workPhones")) {
						final BasicDBList objWorkPhones = (BasicDBList) objAddress.get("workPhones");
						address.setWorkPhones(objWorkPhones.stream().map(new java.util.function.Function<Object, String>() {
							@Override
							public String apply(Object t) {
								return String.valueOf(t);
							}
						}).collect(Collectors.toList()));
					}
					bList.add(address);
				}
			});
		}
		
		return bList.build();
	}

	/**
	 * db.person.update({_id: 'ingga_bia_putri', 'addresses.id': '104d04ca-50a5-4611-8fa6-9e33c8656581'}, {$set: {'addresses.$.street': 'ubah jalan'}});
	 */
	@Override
	public void setJneAreaCode(String id, UUID addressId, String areaCode) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", id);
		query.put("addresses.id", addressId.toString());
		
		final BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("addresses.$.jneAreaCode", areaCode));
		
		final WriteResult result = primary.update(query, update);
		log.debug("Result update JNE area code for person '{}' - address '{}' - jneCode '{}': {}",
				id, addressId, areaCode, result);
	}

	@Override
	public void addAddress(String id, PostalAddress2 address) {
		Preconditions.checkState(address.getId() != null,
				"For adding new address, id must not be null!");
		
		final DBObject objAddress = new BasicDBObject();
		objAddress.put("id", address.getId().toString());
		
		if (!Strings.isNullOrEmpty(address.getName())) {
			objAddress.put("name", address.getName()); 
		}
		if (!Strings.isNullOrEmpty(address.getStreet())) {
			objAddress.put("street", address.getStreet()); 
		}
		if (!Strings.isNullOrEmpty(address.getCity())){
			objAddress.put("city", address.getCity()); 
		}
		if (!Strings.isNullOrEmpty(address.getPostalCode())){
			objAddress.put("postalCode", address.getPostalCode()); 
		}
		if (!Strings.isNullOrEmpty(address.getProvince())){
			objAddress.put("province", address.getProvince()); 
		}
		if (!Strings.isNullOrEmpty(address.getCountry())){
			objAddress.put("country", address.getCountry()); 
		}
		if (!Strings.isNullOrEmpty(address.getCountryCode())){
			objAddress.put("countryCode", address.getCountryCode()); 
		}
		if (!Strings.isNullOrEmpty(address.getPrimaryMobile())){
			objAddress.put("primaryMobile", address.getPrimaryMobile()); 
		}
		if (!Strings.isNullOrEmpty(address.getPrimaryEmail())){
			objAddress.put("primaryEmail", address.getPrimaryEmail()); 
		}
		objAddress.put("primary", Optional.fromNullable(address.isPrimary()).or(false)); 
		objAddress.put("primaryBilling", Optional.fromNullable(address.isPrimaryBilling()).or(false));
		objAddress.put("primaryShipping", Optional.fromNullable(address.isPrimaryShipping()).or(false));
		if (!Strings.isNullOrEmpty(address.getDistrict())){
			objAddress.put("district", address.getDistrict());
		}
		
		final BasicDBObject query = new BasicDBObject("_id", id);
		
		final BasicDBObject update = new BasicDBObject("$push", new BasicDBObject("addresses", objAddress));
		final WriteResult result = primary.update(query, update);
		log.debug("Added new address '{}' for personId '{}': {}", address.getId(), id, result);
	}

	@Override
	public PostalAddress2 getBillingAddress(String id) {
		final ImmutableList<PostalAddress2> addresses = getAddresses(id);
		if (addresses.isEmpty()) {
			return null;
		}
		
		return addresses.stream().filter(new Predicate<PostalAddress2>() {
			@Override
			public boolean test(PostalAddress2 t) {
				return t.isPrimaryBilling();
			}
		}).findFirst().orElse(addresses.get(0));
	}

	@Override
	public void modifyAddress(String personId, PostalAddress2 postalAddress) {
		final BasicDBObject query = new BasicDBObject();
		query.put("_id", personId);
		query.put("addresses.id", postalAddress.getId().toString());
		
		final BasicDBObject update = new BasicDBObject();
		final Map<String, Object> map = new HashMap<>();
		if (!Strings.isNullOrEmpty(postalAddress.getName())){
			map.put("addresses.$.name", postalAddress.getName()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getStreet())){
			map.put("addresses.$.street", postalAddress.getStreet()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getCity())){
			map.put("addresses.$.city", postalAddress.getCity()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getPostalCode())){
			map.put("addresses.$.postalCode", postalAddress.getPostalCode()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getProvince())){
			map.put("addresses.$.province", postalAddress.getProvince()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getCountry())){
			map.put("addresses.$.country", postalAddress.getCountry()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getCountryCode())){
			map.put("addresses.$.countryCode", postalAddress.getCountryCode()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getPrimaryMobile())){
			map.put("addresses.$.primaryMobile", postalAddress.getPrimaryMobile()); 
		}
		if (!Strings.isNullOrEmpty(postalAddress.getPrimaryEmail())){
			map.put("addresses.$.primaryEmail", postalAddress.getPrimaryEmail()); 
		}
		map.put("addresses.$.primary", Optional.fromNullable(postalAddress.isPrimary()).or(false)); 
		map.put("addresses.$.primaryBilling", Optional.fromNullable(postalAddress.isPrimaryBilling()).or(false));
		map.put("addresses.$.primaryShipping", Optional.fromNullable(postalAddress.isPrimaryShipping()).or(false));
		if (!Strings.isNullOrEmpty(postalAddress.getDistrict())){
			map.put("addresses.$.district", postalAddress.getDistrict());
		}
		update.put("$set", map);
		
//		log.debug("Updating person's address by query '{}': {}", query, update);
		
		final WriteResult result = primary.update(query, update);
		log.debug("Update address for personId '{}': {}", personId, postalAddress);
	}
	
	@Override
	public ImmutableSet<String> getFcmTokens(String id) {
		final DBObject query = new BasicDBObject(ImmutableMap.of("_id", id, "firebaseCloudMessagingTokens", new BasicDBObject("$exists", true)));
		final BasicDBObject fields = new BasicDBObject("firebaseCloudMessagingTokens", true);
		final List<DBObject> dbObjects = findSecondaryAsDBObjects(query, fields, null, 0, 0, "getFcmTokens", id);
		
//		log.debug("Got dbObjects by query '{}' and fields '{}': {}",
//				query, fields , dbObjects);
		
		final ImmutableSet.Builder<String> bSet = ImmutableSet.builder();
		
		if (!dbObjects.isEmpty()) {
			dbObjects.forEach(new Consumer<DBObject>() {
				@Override
				public void accept(DBObject objDoc) {
					final BasicDBList objTokens = (BasicDBList) objDoc.get("firebaseCloudMessagingTokens");
					objTokens.forEach(new Consumer<Object>() {
						@Override
						public void accept(Object token) {
							bSet.add(String.valueOf(token));
						}
					});
				}
			});
		}
		
		final ImmutableSet<String> result = bSet.build();
		log.debug("Got fcm tokens for person '{}': {}", id, result);
		return result;
	}

	@Override
	public PostalAddress2 getShippingAddress(String id) {
		final ImmutableList<PostalAddress2> addresses = getAddresses(id);
		if (addresses.isEmpty()) {
			return null;
		}
		
		return addresses.stream().filter(new Predicate<PostalAddress2>() {
			@Override
			public boolean test(PostalAddress2 t) {
				return t.isPrimaryShipping();
			}
		}).findFirst().orElse(addresses.get(0));
	}

	@Override	
	public void setAddressToResellerStartUp(String personId, UUID addressId, String startUpId, Date regDate) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", personId);
		query.put("addresses.id", addressId.toString());
		
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.put("addresses.$.startupReseller", Boolean.TRUE);
		setQuery.put("addresses.$.startupResellerId", startUpId);
		setQuery.put("addresses.$.startupResellerRegistartion", regDate);
		BasicDBObject update = new BasicDBObject("$set", setQuery);
		
		WriteResult result = primary.update(query, update);
		log.debug("Result update address to reseller startup for person '{}' - address '{}' - startup ID '{}': reg date {}",
				personId, addressId, startUpId, regDate);
	}
	
	// @Override
	// public Existence<String> existsBySlugEx(StatusMask statusMask, String
	// slug) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
