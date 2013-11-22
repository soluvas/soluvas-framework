package org.soluvas.security.mongo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityRepository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * MongoDB {@link SecurityRepository} implementation.
 * @todo Implement
 * @author ceefour
 */
public class MongoSecurityRepository implements SecurityRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(MongoSecurityRepository.class);
	
	private final DBCollection personColl;
	
	public MongoSecurityRepository(final DBCollection personColl) {
		super();
		this.personColl = personColl;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getRoleRepository()
	 */
	@Override
	public CrudRepository<Role, String> getRoleRepository() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonRoles(String personId) {
		final BasicDBObject personObj = (BasicDBObject) personColl.findOne(new BasicDBObject("_id", personId));
		final List<Object> secRoleIdObjList = (personObj.get("securityRoleIds") != null ? (List<Object>)  personObj.get("securityRoleIds") : null);
		final Set<String> roleSet = new HashSet<>();
		if (secRoleIdObjList != null) {
			for (final Object roleObj : secRoleIdObjList) {
				roleSet.add((String) roleObj);
			}
		}
		log.debug("FIXME: GANTI KE TRACE| PersonID {} has roles: {}", personObj.get("_id"), roleSet);
		return roleSet;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getRoleMembers(java.lang.String)
	 */
	@Override
	public Set<String> getRoleMembers(String role) {
		final DBCursor personIdCur = personColl.find(new BasicDBObject("securityRoleIds", role));
		final Set<String> personIdSet = new HashSet<>();
		for (final DBObject personObj : personIdCur) {
			personIdSet.add((String) personObj.get("_id"));
		}
		log.debug("FIXME: GANTI KE TRACE| Role owned by {} people: {}", role, personIdSet.size(), personIdSet);
		return personIdSet;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#replacePersonRoles(java.lang.String, java.util.Set)
	 */
	@Override
	public void replacePersonRoles(String personId,
			Set<String> roles) {
		final BasicDBObject personObj = (BasicDBObject) personColl.findOne(new BasicDBObject("_id", personId));
		final List<Object> secRoleIdObjList = (personObj.get("securityRoleIds") != null ? (List<Object>)  personObj.get("securityRoleIds") : null);
		if (secRoleIdObjList != null) {
			log.debug("FIXME: GANTI KE TRACE| PersonID has {} old roles that will be removed: {}", secRoleIdObjList.size(), secRoleIdObjList);
			personObj.removeField("securityRoleIds");
		}
		personObj.append("securityRoleIds", roles);
		log.debug("FIXME: GANTI KE TRACE| PersonID has {} new roles that will be removed: {}", roles, personObj.get("securityRoleIds"));
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#replaceRoleMembers(java.lang.String, java.util.Set)
	 */
	@Override
	public void replaceRoleMembers(String role,
			Set<String> personIds) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#addRole(java.lang.String, java.lang.String, java.util.Set)
	 */
	@Override
	@Deprecated
	public void addRole(String name, @Nullable String description,
			@Nullable Set<String> personIds) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#ensureRoles(java.util.Collection)
	 */
	@Override
	public void ensureRoles(Collection<Role> roles) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getDomainBase()
	 */
	@Override
	@Deprecated
	public String getDomainBase() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getBindConfig()
	 */
	@Override
	@Deprecated
	public LdapConnectionConfig getBindConfig() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.SecurityRepository#getUsersRdn()
	 */
	@Override
	@Deprecated
	public String getUsersRdn() {
		throw new UnsupportedOperationException();
	}

}
