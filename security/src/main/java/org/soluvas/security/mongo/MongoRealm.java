package org.soluvas.security.mongo;

import java.util.Set;

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
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.SlugUtils;
import org.soluvas.mongo.MongoRepositoryException;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.Permission;
import org.soluvas.security.Rfc2307CredentialsMatcher;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
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
	private final SecurityRepository securityRepo;
	private final String personCollName = "person";
	private final DBCollection personColl;
	private MongoClient mongoClient;
	
	public MongoRealm(SecurityCatalog securityCatalog,
			final String mongoUri) {
		super();
		this.securityCatalog = securityCatalog;
		this.securityRepo = new MongoSecurityRepository();
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
		setName("soluvas");
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			final PrincipalCollection principalCollection) {
		final String userName = (String) principalCollection.getPrimaryPrincipal();
		final Set<String> personRoles = securityRepo.getPersonRoles(userName);

		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(personRoles);

		// TODO: permissions should be set somewhere else,
		// using EMF models

		log.trace("Processing security catalog for {} with {} roles, {} domains, {} actions, and {} permissions",
				userName, securityCatalog.getRoles().size(), securityCatalog
						.getDomains().size(), securityCatalog.getActions()
						.size(), securityCatalog.getPermissions().size());

		for (final Role role : securityCatalog.getRoles()) {
			switch (role.getAssignMode()) {
			case GUEST:
				log.trace("Assigning role {} to {} because assign mode {}",
						role.getName(), userName, role.getAssignMode());
				info.addRole(role.getName());
				break;
			case AUTHENTICATED:
				if (!principalCollection.isEmpty()) {
					log.trace(
							"Assigning role {} to {} because assign mode {} and principals={}",
							role.getName(), userName, role.getAssignMode(),
							principalCollection);
					info.addRole(role.getName());
				}
				break;
			case MANUAL:
				break;
			}
		}

		for (final Permission perm : securityCatalog.getPermissions()) {
			final Set<String> intersectingRoles = Sets.intersection(info.getRoles(),
					ImmutableSet.copyOf(perm.getRoles()));
			if (!intersectingRoles.isEmpty()) {
				log.trace("Assigning permission {} to {} due to role(s) {}",
						perm.toStringPermission(), userName, intersectingRoles);
				info.addStringPermission(perm.toStringPermission());
			}
		}

		// TODO: resource-level roles

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
			log.debug("findOne MongoDB {} using {}", personCollName, query);
			final DBObject found = personColl.findOne(query, new BasicDBObject("password", 1));
			log.debug("Matched for {} : {}", tokenPrincipal, found);
			if (found != null) {
				final String userPrincipal = (String) found.get("_id");
				final String userPassword = (String) found.get("password");
				return new SimpleAuthenticationInfo(userPrincipal, userPassword, getName());
			} else {
				throw new IncorrectCredentialsException("Cannot find user '" + tokenPrincipal + "'");
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
