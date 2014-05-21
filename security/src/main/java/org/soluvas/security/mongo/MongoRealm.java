package org.soluvas.security.mongo;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
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
import org.soluvas.mongo.MongoUtils;
import org.soluvas.security.AccessControlManager;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.Rfc2307CredentialsMatcher;
import org.soluvas.security.RolePersonRepository;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;
import org.soluvas.security.impl.RealmUtils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;

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

	private final List<String> dbHosts;

	private final String dbName;

	private final String dbUser;
	
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
		dbHosts = realMongoUri.getHosts();
		dbName = realMongoUri.getDatabase();
		dbUser = realMongoUri.getUsername();
		log.info("Connecting to MongoDB realm database {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), personCollName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primary());
			personColl = db.getCollection(personCollName);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB realm database %s/%s as %s for %s repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					personCollName);
		}
		this.securityRepo = new MongoSecurityRepository(personColl);
		this.rolePersonRepo = null;
		setName("soluvas");
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	/**
	 * @param securityCatalog
	 * @param mongoUri
	 * @deprecated Use {@link #MongoRealm(String, SecurityCatalog, RolePersonRepository, String)}.
	 */
	@Deprecated
	public MongoRealm(String name, SecurityCatalog securityCatalog, final String mongoUri) {
		super();
		this.securityCatalog = securityCatalog;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		dbHosts = realMongoUri.getHosts();
		dbName = realMongoUri.getDatabase();
		dbUser = realMongoUri.getUsername();
		log.info("Connecting to MongoDB realm database {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), personCollName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primary());
			personColl = db.getCollection(personCollName);
		} catch (Exception e) {
			throw new MongoRepositoryException(e, "Cannot connect to MongoDB realm database {}/{} as {} for {} repository",
					realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(),
					personCollName);
		}
		this.securityRepo = new MongoSecurityRepository(personColl);
		this.rolePersonRepo = null;
		setName(name);
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	public MongoRealm(String name, SecurityCatalog securityCatalog, RolePersonRepository rolePersonRepo, final String mongoUri) {
		super();
		this.securityCatalog = securityCatalog;
		// WARNING: mongoUri may contain password!
		final MongoClientURI realMongoUri = new MongoClientURI(mongoUri);
		dbHosts = realMongoUri.getHosts();
		dbName = realMongoUri.getDatabase();
		dbUser = realMongoUri.getUsername();
		log.info("Connecting to MongoDB realm database {}/{} as {}, person collection={}",
				realMongoUri.getHosts(), realMongoUri.getDatabase(), realMongoUri.getUsername(), personCollName);
		try {
			final DB db = MongoUtils.getDb(realMongoUri, ReadPreference.primary());
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
		final String host = token instanceof HostAuthenticationToken ? ((HostAuthenticationToken) token).getHost() : null;
		if (!getName().equals(host)) {
			log.debug("[{}] Host mismatch, expected '{}', token requests '{}'."
					+ " If you use multiple realms, one realm should match the host while others mismatch."
					+ " If all mismatch, you have a misconfiguration.", getName(), getName(), host);
			throw new UnknownAccountException("[" + getName() + "] Host mismatch, expected '" + getName() + "', token requests '" + host + "'."
					+ " If you use multiple realms, one realm should match the host while others mismatch."
					+ " If all mismatch, you have a misconfiguration.");
		}
		
		if (token instanceof UsernamePasswordToken) {
			// Principal can be either person ID, slug (username in user's perspective), or email
			final String tokenPrincipal = ((UsernamePasswordToken) token).getUsername();
			final String canonicalSlug = SlugUtils.canonicalize(tokenPrincipal);
			final String normalizedEmail = NameUtils.normalizeEmail(tokenPrincipal);
			// This requires 3 compound indexes in MongoRepositoryBase
			final BasicDBObject query = new BasicDBObject("$or", new DBObject[] {
				new BasicDBObject("_id", tokenPrincipal),
				new BasicDBObject("canonicalSlug", canonicalSlug),
				new BasicDBObject("emails.email", normalizedEmail),
			});
//			query.put("accountStatus", new BasicDBObject("$in", expectedStatuses));
			log.debug("[{}] findOne MongoDB using {} in {}@{}/{} collection {}",
					getName(), query, dbUser, dbHosts, dbName, personCollName);
			final DBObject found = personColl.findOne(query, new BasicDBObject(ImmutableMap.of(
					"password", true, "accountStatus", true)));
			log.debug("[{}] findOne result for person '{}' with password: {}", getName(), tokenPrincipal, found);
			final AccountStatus accountStatus = AccountStatus.valueOf((String) found.get("accountStatus"));
			if (found != null) {
				final ImmutableSet<AccountStatus> expectedStatuses = ImmutableSet.of(
						AccountStatus.ACTIVE, AccountStatus.VERIFIED);
				if (expectedStatuses.contains(accountStatus)) {
					final String userPrincipal = (String) found.get("_id");
					final String userPassword = (String) found.get("password");
					return new SimpleAuthenticationInfo(userPrincipal, userPassword, getName());
				} else {
					log.info("[{}] User '{}' cannot log in because status is {}, expected {}",
							getName(), tokenPrincipal, accountStatus, expectedStatuses);
					switch (accountStatus) {
					case DRAFT:
					case VALIDATED:
						throw new DisabledAccountException("User '" + tokenPrincipal + "' cannot log in because status is " + accountStatus);
					case INACTIVE:
					case VOID:
						throw new LockedAccountException("User '" + tokenPrincipal + "' cannot log in because status is " + accountStatus);
					default:
						throw new DisabledAccountException("User '" + tokenPrincipal + "' cannot log in because unknown status: " + accountStatus);
					}
				}
			} else {
				log.info("[{}] Cannot find user '{}' in collection '{}' using: {}",
						getName(), tokenPrincipal, personCollName, query);
				throw new UnknownAccountException("[" + getName() + "] Cannot find user '" + tokenPrincipal + "'");
			}
		} else if (token instanceof AutologinToken) {
			log.debug("[{}] AuthenticationInfo for {} is using AutologinToken", getName(), token.getPrincipal());
			final String personId = (String) token.getPrincipal();
			return new SimpleAuthenticationInfo(personId, null, getName());
		} else {
			throw new AuthenticationException("[" + getName() + "] Unsupported AuthenticationToken: "
					+ token.getClass() + " using " + token.getPrincipal());
		}
	}

}
