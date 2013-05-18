package com.aksimata.person;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.mongo.MongoRepositoryBase;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
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
	public Person findOneBySlug(String upSlug) {
		return findOneByQuery(new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug)));
	}

	@Override
	public String existsBySlug(String upSlug) {
		final DBObject dbo = findDBObjectByQuery(new BasicDBObject("canonicalSlug", SlugUtils.canonicalize(upSlug)),
				new BasicDBObject("slug", 1));
		return (String) (dbo != null ? dbo.get("slug") : null);
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
	public Person findOneByEmail(@Nullable String email) {
		if (email == null) {
			return null;
		}
		final BasicDBObject query = new BasicDBObject("emails.email", email.toLowerCase().trim());
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
	
}
