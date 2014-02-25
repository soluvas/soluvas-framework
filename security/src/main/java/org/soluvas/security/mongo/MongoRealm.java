package org.soluvas.security.mongo;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.SlugUtils;
import org.soluvas.mongo.MongoRepositoryException;
import org.soluvas.security.AccessControlManager;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.Rfc2307CredentialsMatcher;
import org.soluvas.security.RolePersonRepository;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;
import org.soluvas.security.impl.RealmUtils;

import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * A realm implementation that uses MongoDB repository.
 * 
 * @author ceefour
 */
public class MongoRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory.getLogger(MongoRealm.class);

	private final SecurityCatalog securityCatalog;
	/**
	 * @deprecated Use {@link RolePersonRepository} / {@link AccessControlManager} instead. 
	 */
	@Deprecated @Nullable
	private final SecurityRepository securityRepo;
	@Nullable
	private final RolePersonRepository rolePersonRepo;
	private final String personCollName = "person";
	private final DBCollection personColl;
	private MongoClient mongoClient;
	
	/**
	 * @param securityCatalog
	 * @param mongoUri
	 * @deprecated Use {@link #MongoRealm(String, SecurityCatalog, RolePersonRepository, String)}.
	 */
	@Deprecated
	public MongoRealm(SecurityCatalog securityCatalog, final String mongoUri) {
		super();
		this.securityCatalog = securityCatalog;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		log.info("Connecting to MongoDB realm database {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), personCollName);
		try {
			mongoClient = new MongoClient(realMongoUri);
			final DB db = mongoClient.getDB(realMongoUri.getDatabase());
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			personColl = db.getCollection(personCollName);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB realm database {}/{} as {} for {} repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					personCollName);
		}
		this.securityRepo = new MongoSecurityRepository(personColl);
		this.rolePersonRepo = null;
		setName("soluvas");
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	public MongoRealm(String name, SecurityCatalog securityCatalog, RolePersonRepository rolePersonRepo, final String mongoUri) {
		super();
		this.securityCatalog = securityCatalog;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		log.info("Connecting to MongoDB realm database {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), personCollName);
		try {
			mongoClient = new MongoClient(realMongoUri);
			final DB db = mongoClient.getDB(realMongoUri.getDatabase());
			if (realMongoUri.getUsername() != null)
				db.authenticate(realMongoUri.getUsername(),
						realMongoUri.getPassword());
			personColl = db.getCollection(personCollName);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB realm database {}/{} as {} for {} repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					personCollName);
		}
		this.securityRepo = null;
		this.rolePersonRepo = rolePersonRepo;
		setName(name);
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	@PreDestroy
	public void destroy() {
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			final PrincipalCollection principalCollection) {
		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (rolePersonRepo != null) {
			RealmUtils.modifyAuthInfo(info, principalCollection, rolePersonRepo, securityCatalog);
		} else {
			RealmUtils.modifyAuthInfo(info, principalCollection, securityRepo, securityCatalog);
		}
		return info;
	}

	/**
	 * Always returns a {@link SimpleAuthenticationInfo} based on the principal
	 * (username).
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		if (token instanceof UsernamePasswordToken) {
			// Principal can be either person ID, slug (username in user's perspective), or email
			final String tokenPrincipal = ((UsernamePasswordToken) token).getUsername();
			final String canonicalSlug = SlugUtils.canonicalize(tokenPrincipal);
			final String normalizedEmail = NameUtils.normalizeEmail(tokenPrincipal);
			final BasicDBObject query = new BasicDBObject("$or", new DBObject[] {
				new BasicDBObject("_id", tokenPrincipal),
				new BasicDBObject("canonicalSlug", canonicalSlug),
				new BasicDBObject("emails.email", normalizedEmail),
			});
			final ImmutableSet<String> expectedStatuses = ImmutableSet.of(
					AccountStatus.ACTIVE.name(), AccountStatus.VERIFIED.name());
			query.put("accountStatus", new BasicDBObject("$in", expectedStatuses));
			log.debug("findOne MongoDB {} using {}", personCollName, query);
			final DBObject found = personColl.findOne(query, new BasicDBObject("password", 1));
			log.debug("Matched for {} : {}", tokenPrincipal, found);
			if (found != null) {
				final String userPrincipal = (String) found.get("_id");
				final String userPassword = (String) found.get("password");
				return new SimpleAuthenticationInfo(userPrincipal, userPassword, getName());
			} else {
				log.info("Cannot find user '{}' in collection '{}' using: {}",
						tokenPrincipal, personCollName, query);
				throw new IncorrectCredentialsException("Cannot find user '" + tokenPrincipal + "' with status " + expectedStatuses);
			}
		} else if (token instanceof AutologinToken) {
			log.debug("AuthenticationInfo for {} is using AutologinToken", token.getPrincipal());
			final String personId = (String) token.getPrincipal();
			return new SimpleAuthenticationInfo(personId, null, getName());
		} else {
			throw new AuthenticationException("Unsupported AuthenticationToken: "
					+ token.getClass() + " using " + token.getPrincipal());
		}
	}

}
