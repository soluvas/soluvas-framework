package org.soluvas.mongo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsPackage;
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
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.person.PersonRepository;

import scala.util.Try;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * MongoDB powered {@link Person} repository.
 * @author ceefour
 */
public class MongoPersonRepository extends MongoRepositoryBase<Person> implements
		PersonRepository {
	
	public MongoPersonRepository(String mongoUri) {
		super(Person.class, PersonImpl.class, PersonImpl.CURRENT_SCHEMA_VERSION, mongoUri, "person",
				ImmutableList.of("canonicalSlug"), ImmutableMap.of(
						"name", 1, // for sorting in list
						"creationTime", -1,
						"modificationTime", -1));
	}

	@Override
	protected void beforeSave(Person entity) {
		super.beforeSave(entity);
		entity.setCanonicalSlug(SlugUtils.canonicalize(entity.getSlug()));
	}
	
	@Override @Nullable
	public Person findOneBySlug(StatusMask statusMask, String upSlug) {
		return findOneByQuery(new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug)));
	}

	@Override
	public Existence<String> existsBySlug(StatusMask statusMask, String upSlug) {
		final DBObject dbo = findDBObjectByQuery(new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug)),
				new BasicDBObject("slug", 1));
		if (dbo != null) {
			return Existence.of((String) dbo.get("slug"), (String) dbo.get("_id"));
		} else {
			return Existence.<String>absent();
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
		if (email == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("emails", new BasicDBObject("$elemMatch", new BasicDBObject("email", email.toLowerCase().trim())));
		return findOneByQuery(query);
	}
	
	@Override @Nullable
	public Person findOneByPhoneNumber(@Nullable String phoneNumber) {
		if (phoneNumber == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject();
		final BasicDBObject qMobileNumber = new BasicDBObject("mobileNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		final BasicDBObject qPhoneNumber = new BasicDBObject("phoneNumbers", new BasicDBObject("$elemMatch", new BasicDBObject("phoneNumber", phoneNumber)));
		query.put("$or", new BasicDBObject[] {qMobileNumber, qPhoneNumber});
		return findOneByQuery(query);
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

	@SuppressWarnings("null")
	@Override
	public Page<Person> findBySearchText(StatusMask statusMask, @Nullable String searchText, Pageable pageable) {
		final BasicDBObject query = getQueryBySearchText(searchText);
		augmentQueryForStatusMask(query, statusMask);
		
		final Sort mySort;
		if (pageable.getSort() != null) {
			mySort = pageable.getSort().and(new Sort(Direction.DESC, "modificationTime"));
		} else {
			mySort = new Sort(Direction.DESC, "modificationTime");
		}
		
		final PageRequest myPageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), mySort);
		
		return findAllByQuery(query, myPageable);
	}
	
	private BasicDBObject getQueryBySearchText(String searchText) {
		final Pattern regex = Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE);
		final BasicDBObject nameQuery = new BasicDBObject("name", regex);
		final BasicDBObject idQuery = new BasicDBObject("id", regex);
		final BasicDBObject emailQuery = new BasicDBObject("email", regex);
		final BasicDBObject emailsQuery = new BasicDBObject("emails", new BasicDBObject("$elemMatch", emailQuery));
		final BasicDBObject phoneNumberQuery = new BasicDBObject("phoneNumber", regex);
		final BasicDBObject mobileNumbersQuery = new BasicDBObject("mobileNumbers", new BasicDBObject("$elemMatch", phoneNumberQuery));
		final BasicDBObject query = new BasicDBObject("$or", ImmutableList.of(nameQuery, idQuery , emailsQuery, mobileNumbersQuery));
		log.debug("Query is {}", query);
		return query;
	}

	@Override
	public long countBySearchText(StatusMask statusMask, String searchText) {
		final BasicDBObject query = getQueryBySearchText(searchText);
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
			query.put("accountStatus", AccountStatus.ACTIVE.name());
			break;
		case INCLUDE_INACTIVE:
			query.put("accountStatus", new BasicDBObject("$in", 
					ImmutableSet.of(AccountStatus.ACTIVE.name(), AccountStatus.INACTIVE.name())));
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
		throw new UnsupportedOperationException("to be implemented");
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

}
