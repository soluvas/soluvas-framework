package org.soluvas.couchdb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.http.conn.ClientConnectionManager;
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
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.person.PersonRepository;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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
		design.addView("statusMask_uid", new View(
				"function(doc) { if (doc.type == 'Person' ) { emit(['raw', doc.uid], null); if (doc.accountStatus.match(/^(active|validated|verified)$/) != null) emit(['active_only', doc.uid], null); if (doc.accountStatus.match(/^(active|validated|verified|inactive)$/) != null) emit(['include_inactive', doc.uid], null); if (doc.accountStatus == 'draft') emit(['draft_only', doc.uid], null); if (doc.accountStatus.match(/^(void)$/) != null) emit(['void_only', doc.uid], null); } }"));
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
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.SlugLookup#findOneBySlug(java.lang.String)
	 */
	@Override
	@Nullable
	public Person findOneBySlug(String upSlug) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.SlugLookup#existsBySlug(java.lang.String)
	 */
	@Override
	public String existsBySlug(String upSlug) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
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
	public Person findOneByEmail(@Nullable String email, StatusMask statusMask) {
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
		default:
			throw new UnsupportedOperationException("Unsupported lookupKey: " + lookupKey);
		}
	}

}
