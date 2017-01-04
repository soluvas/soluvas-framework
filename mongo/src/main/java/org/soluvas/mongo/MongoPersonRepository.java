package org.soluvas.mongo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.EnumNameFunction;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
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
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import scala.util.Try;

/**
 * MongoDB powered {@link Person} repository.
 * @author ceefour
 */
public class MongoPersonRepository extends MongoRepositoryBase<Person> implements
		PersonRepository {
	
	private final String tenantId;
	@Nullable
	private final CacheManager cacheMgr;

	public MongoPersonRepository(String tenantId, @Nullable CacheManager cacheMgr, String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Person.class, PersonImpl.class, PersonImpl.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL, "person",
				ImmutableList.of("canonicalSlug"), migrationEnabled, autoExplainSlow,
				Index.asc("name"), // for sorting in list
				Index.desc("creationTime"),
				Index.desc("modificationTime"),
				Index.asc("securityRoleIds"),
				Index.asc("customerRole"),
				Index.asc("memberRole"),
				Index.asc("managerRole"),
				Index.asc("facebookId"),
				// used by MongoRealm#doGetAuthenticationInfo()
				Index.compound("_id", Direction.ASC, "accountStatus", Direction.ASC),
				Index.compound("canonicalSlug", Direction.ASC, "accountStatus", Direction.ASC),
				Index.compound("emails.email", Direction.ASC, "accountStatus", Direction.ASC)
			);
		this.tenantId = tenantId;
		this.cacheMgr = cacheMgr;
	}

	@Override
	protected void beforeSave(Person entity, ModificationTimePolicy mtimePolicy) {
		super.beforeSave(entity, mtimePolicy);
		entity.setCanonicalSlug(SlugUtils.canonicalize(entity.getSlug()));
	}
	
	@Override @Nullable
	public Person findOneBySlug(StatusMask statusMask, String upSlug) {
		String canonicalize = SlugUtils.canonicalize(upSlug);
		return findOneByQuery(new BasicDBObject("canonicalSlug", canonicalize));
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		final BasicDBObject query = new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug));
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbo = findDBObjectByQuery(query,
				new BasicDBObject("slug", true));
		if (dbo != null) {
			final String actualSlug = (String) dbo.get("slug");
			if (actualSlug.equals(upSlug)) {
				return Existence.of(actualSlug, (String) dbo.get("_id"));
			} else {
				return Existence.mismatch(actualSlug, (String) dbo.get("_id"));
			}
		} else {
			return Existence.<String>absent();
		}
	}
	
	@Override
	public Existence<String> existsBySlugCacheable(StatusMask statusMask,
			String upSlug) {
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
	public Person findOneByFacebook(@Nullable Long facebookId,
			@Nullable String facebookUsername) {
		if (facebookId == null && facebookUsername == null) {
			return null;
		}
		final List<DBObject> orCriteria = new ArrayList<>();
		if (facebookId != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_ID.getName(), 
					facebookId));
		}
		if (facebookUsername != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.FACEBOOK_IDENTITY__FACEBOOK_USERNAME.getName(), 
					facebookUsername));
		}
		final BasicDBObject query = new BasicDBObject("$or", orCriteria);
		return findOneByQuery(query);
	}

	@Override @Nullable
	public Person findOneByEmail(StatusMask statusMask, @Nullable String email) {
		if (Strings.isNullOrEmpty(email))  {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}
	
	@Override @Nullable
	public Person findOneByEmail(AccountStatus status, String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty");
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
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
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("_id", true), "getIdByEmail", statusMask, email);
		if (dbObject == null) {
			return Optional.absent();
		} else {
			return Optional.of(String.valueOf(dbObject.get("_id")));
		}
	}
	
	@Override @Nullable
	public Person findOneById(StatusMask statusMask, @Nullable String id) {
		if (Strings.isNullOrEmpty(id))  {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("_id", id);
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}
	
	@Override @Nullable
	public Person findOneByMobileOrPhoneNumber(StatusMask statusMask, @Nullable String phoneNumber) {
		if (phoneNumber == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject qMobileNumber = new BasicDBObject("mobileNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		final BasicDBObject qPhoneNumber = new BasicDBObject("phoneNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		query.put("$or", new BasicDBObject[] {qMobileNumber, qPhoneNumber});
		augmentQueryForStatusMask(query, statusMask);
		return findOneByQuery(query);
	}
	
	@Override
	public boolean isExistsByMobileOrPhoneNumber(StatusMask statusMask, String phoneNumber) {
		final Optional<String> optExists = getIdByMobileOrPhoneNumber(statusMask, phoneNumber);
		return optExists.isPresent();
	}
	
	@Override
	public Optional<String> getIdByMobileOrPhoneNumber(StatusMask statusMask,
			String phoneNumber) {
		Preconditions.checkState(!Strings.isNullOrEmpty(phoneNumber), "Phone number must not be null or empty");
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject qMobileNumber = new BasicDBObject("mobileNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		final BasicDBObject qPhoneNumber = new BasicDBObject("phoneNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		query.put("$or", new BasicDBObject[] {qMobileNumber, qPhoneNumber});
		augmentQueryForStatusMask(query, statusMask);
		final DBObject dbObject = findOnePrimary(query, new BasicDBObject("_id", true), "getIdByPhoneNumber", statusMask, phoneNumber);
		if (dbObject == null) {
			return Optional.absent();
		} else {
			return Optional.of(String.valueOf(dbObject.get("_id")));
		}
	}

	@Override @Nullable
	public Person findOneByTwitter(@Nullable Long twitterId,
			@Nullable String twitterScreenName) {
		if (twitterId == null && twitterScreenName == null) {
			return null;
		}
		final List<DBObject> orCriteria = new ArrayList<>();
		if (twitterId != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_ID.getName(), 
					twitterId));
		}
		if (twitterScreenName != null) {
			orCriteria.add(new BasicDBObject(CommonsPackage.Literals.TWITTER_IDENTITY__TWITTER_SCREEN_NAME.getName(), 
					twitterScreenName));
		}
		final BasicDBObject query = new BasicDBObject("$or", orCriteria);
		return findOneByQuery(query);
	}

	@Override @Nullable
	public Person findOneByClientAccessToken(@Nullable String clientAccessToken) {
		if (clientAccessToken == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("clientAccessToken", clientAccessToken);
		return findOneByQuery(query);
	}

	@Override
	public Page<Person> findBySearchText(StatusMask statusMask, @Nullable String searchText, Pageable pageable) {
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
		final BasicDBObject mobileNumbersQuery = new BasicDBObject("mobileNumbers", new BasicDBObject("$elemMatch", phoneNumberQuery));
		final BasicDBObject phoneNumbersQuery = new BasicDBObject("phoneNumbers", new BasicDBObject("$elemMatch", phoneNumberQuery));
		
		final BasicDBObject query = new BasicDBObject("$or", ImmutableList.of(nameQuery, idQuery , emailsQuery, mobileNumbersQuery, phoneNumbersQuery));
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
	public Page<Person> findAll(StatusMask statusMask, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		final Page<Person> page = findAllByQuery(query, pageable);
		return page;
	}

	@Override
	public Page<Person> findAll(StatusMask statusMask, Projection projection, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		final long total = count(statusMask);
		final ImmutableList<Person> people = findSecondary(query, getProjectionDBObject(projection),
				MongoUtils.getSort(pageable.getSort()),
				pageable.getOffset(), pageable.getPageSize(),
				"findAll", statusMask, projection);
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
			query.put("accountStatus", new BasicDBObject("$in", 
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.VERIFIED.name(),
							AccountStatus.INACTIVE.name())));
			break;
		case VOID_ONLY:
			query.put("accountStatus", AccountStatus.VOID.name());
			break;
		default:
			throw new IllegalArgumentException("Unrecognized StatusMask: " + statusMask);	
		}
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
	public <S extends Person, K extends Serializable> Map<K, Try<S>> lookupAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Map<K, Existence<K>> checkExistsAll(
			StatusMask statusMask, LookupKey lookupKey, Collection<K> keys) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public <K extends Serializable> Existence<K> checkExists(StatusMask statusMask,
			LookupKey lookupKey, K key) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trash(Person entity) {
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public TrashResult trashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
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
		throw new UnsupportedOperationException("to be implemented");
	}

	@Override
	public UntrashResult untrashById(String id) {
		throw new UnsupportedOperationException("to be implemented");
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

	@Override
	public List<Person> findAll(StatusMask statusMask, Collection<String> ids) {
		final BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$in", ids));
		augmentQueryForStatusMask(query, statusMask);
		return findAllByQuery(query, new CappedRequest(500)).getContent();
	}
	
	@Override
	public Page<Person> findAll(StatusMask statusMask, Collection<String> ids, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject("_id", new BasicDBObject("$in", ids));
		augmentQueryForStatusMask(query, statusMask);
		return findAllByQuery(query, pageable);
	}

	@Override
	public List<Person> findAllBySecRoleIds(StatusMask statusMask, Collection<String> secRoleIds) {
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
		final Person person = findOneByQuery(query);
		return person != null;
	}

	@Override
	public List<Person> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds) {
		final BasicDBObject query = new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds));
		augmentQueryForStatusMask(query, statusMask);
		
		return findAllByQuery(query, new CappedRequest(500)).getContent();
	}
	
	@Override
	public Page<Person> findAllByCustomerRoleIds(StatusMask statusMask, Collection<String> customerRoleIds, Pageable pageable) {
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
	public Page<Person> findAllByKeywordAndStatus(
			String keyword,
			Collection<AccountStatus> accountStatuses, 
			Pageable pageable) {
		final BasicDBObject query = getQueryByKeyword(keyword);
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in", FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
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
	 * @param keyword (ID, name, emails and phone numbers)
	 * @param accountStatuses
	 * @param customerRole
	 * @param securityRoleIds
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Person> findAllByKeywordAndRoles(
			String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, 
			Collection<String> securityRoleIds,
			Pageable pageable) {
		
		BasicDBObject query;
		if (keyword != null) {
			query = getQueryByKeyword(keyword);
		} else {
			query = new BasicDBObject();
		}
		
		if (accountStatuses != null && !accountStatuses.isEmpty()){
			query.put("accountStatus", new BasicDBObject("$in", 
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}
		
		if (customerRole != null) { 
			query.put("customerRole", customerRole.getId()); 
		}
		
		if (securityRoleIds != null && !securityRoleIds.isEmpty()) {
			query.put("securityRoleIds", 
					new BasicDBObject("$in", securityRoleIds));
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
	 * @param keyword (ID, name, emails and phone numbers)
	 * @param accountStatuses
	 * @param customerRole
	 * @param securityRoleIds
	 * @return
	 */
	@Override
	public long countAllByKeywordAndRoles(
			String keyword,
			Collection<AccountStatus> accountStatuses,
			CustomerRole customerRole, 
			Collection<String> securityRoleIds) {
		
		BasicDBObject query;
		if (keyword != null) {
			query = getQueryByKeyword(keyword);
		} else {
			query = new BasicDBObject();
		}
		
		if (accountStatuses != null && !accountStatuses.isEmpty()){
			query.put("accountStatus", new BasicDBObject("$in", 
					FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}
		
		if (customerRole != null) { 
			query.put("customerRole", customerRole.getId()); 
		}
		
		if (securityRoleIds != null && !securityRoleIds.isEmpty()) {
			query.put("securityRoleIds", 
					new BasicDBObject("$in", securityRoleIds));
		}
		
		return countByQuery(query);
	}
	
//	private BasicDBObject findAllByKeywordAndRoles() {
//		return null;
//	}

	@Override
	public Page<Person> findAll(Collection<AccountStatus> accountStatuses,
			Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in", FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
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
	public long countBySearchText(Collection<AccountStatus> accountStatuses,
			String searchText) {
		final BasicDBObject query = getQueryByKeyword(searchText);
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in", FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
		}
		
		final long count = countByQuery(query);
		log.debug("Got {} people by SearchText query: {}", count, query);
		return count;
	}

	@Override
	public long countByStatuses(Collection<AccountStatus> accountStatuses) {
		final BasicDBObject query = new BasicDBObject();
		if (!accountStatuses.isEmpty()) {
			query.put("accountStatus", new BasicDBObject("$in", FluentIterable.from(accountStatuses).transform(new EnumNameFunction()).toList()));
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
		primary.update(
				new BasicDBObject("customerRole", new BasicDBObject("$in", customerRoleIds)),
				new BasicDBObject("$set", new BasicDBObject("customerRole", null)),
				false, true);
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
		return findSecondary(query, new BasicDBObject(ImmutableMap.of("slug", true, "_id", false)),
				null, 0, 0, new CursorFunction<ImmutableSet<String>>() {
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
		return findSecondary(query, new BasicDBObject(ImmutableMap.of("slug", true, "_id", false)),
				sort, pageable.getOffset(), pageable.getPageSize(), new CursorFunction<ImmutableSet<String>>() {
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
	@Nullable public Person getZendeskUserId(String email) {
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		query.put("zendeskIntegration", true);
		query.put("zendeskUserId", new BasicDBObject("$exists", true));
		query.put("customerRole", new BasicDBObject("$exists", true));
		
		final BasicDBObject fields = new BasicDBObject("zendeskUserId", true);
		fields.put("customerRole", 1);
		
		final DBObject dbObject = findOnePrimary(query, fields, "getZendeskUserId", email);
		if (dbObject != null) {
			if (dbObject.get("zendeskUserId") != null && !"null".equals(dbObject.get("zendeskUserId"))) {
				final Person person = CommonsFactory.eINSTANCE.createPerson();
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
	public Page<Person> findAllByEmailExists(StatusMask statusMask, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		augmentQueryForStatusMask(query, statusMask);
		query.put("emails", new BasicDBObject("$exists", true));
		final Page<Person> page = findAllByQuery(query, pageable);
		return page;
	}

	@Override
	public Page<Person> findAllByEmailExists(DateTime starTime, DateTime endTime, StatusMask statusMask,
			Pageable pageable) {
		final BasicDBObject query = getQueryByCreationTime(starTime.toLocalDate(), endTime.toLocalDate());
		augmentQueryForStatusMask(query, statusMask);
		query.put("emails", new BasicDBObject("$exists", true));
		final Page<Person> page = findAllByQuery(query, pageable);
		return page;
	}
	
	private BasicDBObject getQueryByCreationTime(@Nullable LocalDate startDate,
			@Nullable LocalDate endDate) {
		final BasicDBObject query = new BasicDBObject();
		if (startDate != null || endDate != null) {
			final BasicDBObject creationTimeQuery = new BasicDBObject();
			if (startDate != null) {
				creationTimeQuery.put("$gte",
						startDate.toDateTimeAtStartOfDay(timeZone).toDate());
			}
			if (endDate != null) {
				creationTimeQuery.put("$lt", endDate.plusDays(1)
						.toDateTimeAtStartOfDay(timeZone).toDate());
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
		
		final List<DBObject> dbObjects = findSecondaryAsDBObjects(query, fields, sort, 0, 0, "findAllIdsByCustomerRoleId", statusMask, customerRoleId);
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
		
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		
		final long count = countByQuery(query);
		return count > 0;
	}
	
	@Override
	public boolean existsByEmailAndStatus(String email, AccountStatus status) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty for existsByEmailAndStatus");
		Preconditions.checkState(status != null, "Status must not be null for existsByEmailAndStatus");
		
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		query.put("accountStatus", status.name());
		
		final long count = countByQuery(query);
		return count > 0;
	}
	
	/**
	 * Karena satu email bisa dimiliki oleh beberapa person dengan beragam status nya..
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public ImmutableList<AccountStatus> getStatusesByEmail(String email) {
		Preconditions.checkState(!Strings.isNullOrEmpty(email), "Email must not be null or empty for getStatusesByEmail");
		
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		
		final BasicDBObject fields = new BasicDBObject();
		fields.put("accountStatus", true);
		
		
		final List<DBObject> dbObjectList = findSecondaryAsDBObjects(query, fields, null, 0, 0, "getStatusesByEmail", email);
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


//	@Override
//	public Existence<String> existsBySlugEx(StatusMask statusMask, String slug) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
