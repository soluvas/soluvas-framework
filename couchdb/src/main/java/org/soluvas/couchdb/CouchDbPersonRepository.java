package org.soluvas.couchdb;

import javax.annotation.Nullable;

import org.apache.http.conn.ClientConnectionManager;
import org.joda.time.DateTime;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.impl.PersonImpl;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.person.PersonRepository;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

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
	public Person findOneByEmail(@Nullable String email) {
		// FIXME: required by PersonAddCommand... and please add accountStatus filter 
		throw new UnsupportedOperationException();
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

}
