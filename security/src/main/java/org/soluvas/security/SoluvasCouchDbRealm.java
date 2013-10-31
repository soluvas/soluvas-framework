package org.soluvas.security;

import java.net.MalformedURLException;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.ldap.AbstractLdapRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * A realm implementation that uses LDAP repository.
 * 
 * It does not extend {@link AbstractLdapRealm} (it uses Apache Directory API).
 * 
 * @author ceefour
 */
public class SoluvasCouchDbRealm extends AuthorizingRealm {

	private static final Logger log = LoggerFactory.getLogger(SoluvasCouchDbRealm.class);

	private final Supplier<SecurityCatalog> securityCatalogSupplier;
	private final SecurityRepository securityRepo;
	private final CouchDbConnector conn;

	private final HttpClient httpClient;
	
	/**
	 * 
	 * @param securityCatalogSupplier Why not generics? See https://issues.apache.org/jira/browse/ARIES-960 .
	 * 		Fortunately we no longer use Karaf.
	 * @param securityRepo
	 */
	@Deprecated
	public SoluvasCouchDbRealm(Supplier<SecurityCatalog> securityCatalogSupplier,
			final CouchDbConnector conn) {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = new CouchDbSecurityRepository();
		this.conn = conn;
		this.httpClient = null;
		setName("soluvas");
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	@Deprecated
	public SoluvasCouchDbRealm(Supplier<SecurityCatalog> securityCatalogSupplier,
			final String url, final String user, final String password, final String db) throws MalformedURLException {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = new CouchDbSecurityRepository();
		httpClient = new StdHttpClient.Builder()
			.url(url)
			.username(user)
			.password(password)				
			.build();
		final StdCouchDbInstance stdCouchDbInstance = new StdCouchDbInstance(httpClient);
		final StdCouchDbConnector cDbCon = new StdCouchDbConnector(db, stdCouchDbInstance);
		cDbCon.createDatabaseIfNotExists();
		this.conn = cDbCon;
		setName("soluvas");
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(AuthenticationToken.class);
	}
	
	@Deprecated
	public SoluvasCouchDbRealm(String name, Supplier<SecurityCatalog> securityCatalogSupplier,
			final String uri, final String db) throws MalformedURLException {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = new CouchDbSecurityRepository();
		httpClient = new StdHttpClient.Builder()
			.url(uri)
			.build();
		final StdCouchDbInstance stdCouchDbInstance = new StdCouchDbInstance(httpClient);
		final StdCouchDbConnector cDbCon = new StdCouchDbConnector(db, stdCouchDbInstance);
		cDbCon.createDatabaseIfNotExists();
		this.conn = cDbCon;
		setName(name);
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(HostAuthenticationToken.class);
	}
	
	public SoluvasCouchDbRealm(ClientConnectionManager connMgr, String name, Supplier<SecurityCatalog> securityCatalogSupplier,
			final String uri, final String db) throws MalformedURLException {
		super();
		this.securityCatalogSupplier = securityCatalogSupplier;
		this.securityRepo = new CouchDbSecurityRepository();
		this.httpClient = null;
		final HttpClient httpClient = new StdHttpClient.Builder()
			.url(uri)
			.connectionManager(connMgr)
			.build();
		final StdCouchDbInstance stdCouchDbInstance = new StdCouchDbInstance(httpClient);
		final StdCouchDbConnector cDbCon = new StdCouchDbConnector(db, stdCouchDbInstance);
		cDbCon.createDatabaseIfNotExists();
		this.conn = cDbCon;
		setName(name);
		setCredentialsMatcher(new Rfc2307CredentialsMatcher());
		setAuthenticationTokenClass(HostAuthenticationToken.class);
	}
	
	@PreDestroy
	public void destroy() {
		if (httpClient != null) {
			httpClient.shutdown();
		}
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			final PrincipalCollection principalCollection) {
		final String userName = (String) principalCollection.getPrimaryPrincipal();
		final Set<String> ldapRoles = securityRepo.getPersonRoles(userName);

		final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(ldapRoles);

		// TODO: permissions should be set somewhere else,
		// using EMF models

		final SecurityCatalog securityCatalog = securityCatalogSupplier.get();
		log.debug(
				"Processing security catalog for {} with {} roles, {} domains, {} actions, and {} permissions",
				userName, securityCatalog.getRoles().size(), securityCatalog
						.getDomains().size(), securityCatalog.getActions()
						.size(), securityCatalog.getPermissions().size());

		for (final Role role : securityCatalog.getRoles()) {
			switch (role.getAssignMode()) {
			case GUEST:
				log.debug("Assigning role {} to {} because assign mode {}",
						role.getName(), userName, role.getAssignMode());
				info.addRole(role.getName());
				break;
			case AUTHENTICATED:
				if (!principalCollection.isEmpty()) {
					log.debug(
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
				log.debug("Assigning permission {} to {} due to role(s) {}",
						perm.toStringPermission(), userName, intersectingRoles);
				info.addStringPermission(perm.toStringPermission());
			}
		}

		// TODO: resource-level roles

		return info;
	}

	/**
	 * Checks if the {@link HostAuthenticationToken#getHost()} matches {@link #getName()},
	 * then returns a {@link SimpleAuthenticationInfo} based on the principal
	 * (username).
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		try {
			final String host = token instanceof HostAuthenticationToken ? ((HostAuthenticationToken) token).getHost() : null;
			if (!getName().equals(host)) {
				throw new UnknownAccountException("Host mismatch, expected '" + getName() + "', token requests '" + host + "'");
			}
			
			if (token instanceof UsernamePasswordToken) {
				// Key can be either person ID or email
				final String tokenKey = ((UsernamePasswordToken) token).getUsername();
				final ViewQuery query = new ViewQuery()
					.designDocId("_design/Person")
			        .viewName("password")
			        .key(tokenKey);
				
				final ViewResult matched = conn.queryView(query);
				if (!matched.isEmpty()) {
					final Row firstRow = matched.iterator().next();
					final JsonNode node = firstRow.getValueAsNode();
					final String personId = node.get("uid").asText();
					final String userPassword = node.get("password").asText();
					log.info("Matched {} user(s) for principal {} realm {}, personId={}", 
							matched.getSize(), tokenKey, getName(), personId);
					return new SimpleAuthenticationInfo(personId, userPassword, null, getName());
				} else {
					log.debug("No matching user for principal {} realm {}", tokenKey, getName());
					return new SimpleAuthenticationInfo();
				}			
			} else if (token instanceof AutologinToken) {
				log.debug("AuthenticationInfo for {} is using AutologinToken", token.getPrincipal());
				final String personId = (String) token.getPrincipal();
				return new SimpleAuthenticationInfo(personId, null, getName());
			} else {
				throw new UnsupportedTokenException("Unsupported AuthenticationToken: "
						+ token.getClass() + " using " + token.getPrincipal());
			}
		} catch (RuntimeException e) {
			// Un-swallow non-AuthenticationException exceptions
			Throwables.propagateIfInstanceOf(e, AuthenticationException.class);
			log.error("Error authenticating against CouchDB realm '" + getName() + "': " + e, e);
			throw e;
		}
	}
}
