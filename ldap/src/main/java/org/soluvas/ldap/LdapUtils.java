package org.soluvas.ldap;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

import javax.net.ssl.X509TrustManager;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.exception.LdapURLEncodingException;
import org.apache.directory.shared.ldap.model.message.ModifyRequestImpl;
import org.apache.directory.shared.ldap.model.message.ModifyResponse;
import org.apache.directory.shared.ldap.model.message.ResultCodeEnum;
import org.apache.directory.shared.ldap.model.url.LdapUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * Manages {@link Entry} objects inside a base DN entry.
 * @author ceefour
 */
public class LdapUtils {
	
	public static class ValueToString implements Function<Value<?>, String> {
		@Override
		public String apply(Value<?> input) {
			return input.getString();
		}
	}

	private transient static Logger log = LoggerFactory.getLogger(LdapUtils.class);

	/**
	 * Useful to be passed to {@link PoolableLdapConnectionFactory}.
	 * @param ldapUri e.g. ldap://localhost:10389
	 * @param bindDn e.g. uid=admin,ou=system
	 * @param bindPassword e.g. secret
	 * @return
	 */
	public static LdapConnectionConfig createTrustingConfig(String ldapUri, String bindDn, String bindPassword) {
		Preconditions.checkNotNull(ldapUri, "LDAP URI must not be empty");
		Preconditions.checkNotNull(bindDn, "Bind DN must not be empty");
		
		log.debug("Creating LDAP server configuration to {} as {}", new Object[] { ldapUri, bindDn });
		LdapUrl ldapUrlObj;
		try {
			ldapUrlObj = new LdapUrl(ldapUri);
		} catch (LdapURLEncodingException e) {
			throw new RuntimeException("Cannot parse LDAP URI " + ldapUri, e);
		}

		LdapConnectionConfig ldapConfig = new LdapConnectionConfig();
		ldapConfig.setLdapHost(ldapUrlObj.getHost());
		ldapConfig.setLdapPort(ldapUrlObj.getPort());
		ldapConfig.setUseSsl(LdapUrl.LDAPS_SCHEME.equalsIgnoreCase(ldapUrlObj.getScheme()));
		X509TrustManager alwaysTrustManager = new X509TrustManager() {
			@Override public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			
			@Override public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				log.warn("Trusting {} SERVER certificate {}", authType, chain);
			}
			
			@Override public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				log.warn("Trusting {} CLIENT certificate {}", authType, chain);
			}
		};
		ldapConfig.setTrustManagers(alwaysTrustManager);
		// name and credentials is used by PoolableLdapConnectionFactory
		ldapConfig.setName(bindDn);
		ldapConfig.setCredentials(bindPassword);
		
		return ldapConfig;
	}
	
	/**
	 * When updating {@link Person}, you should always exclude <tt>uid</tt> (the RDN) and <tt>userPassword</tt>
	 * attributes. 
	 * @param conn
	 * @param entry
	 * @param excludedAttributes
	 * @throws LdapException 
	 */
	public static void update(LdapConnection conn, Entry entry,
			boolean removeExtraAttributes, String... excludedAttributes) throws LdapException {
		Entry existing = conn.lookup(entry.getDn());
		ModifyRequestImpl req = createModifyRequest(entry, existing,
				removeExtraAttributes, excludedAttributes);
		if (!req.getModifications().isEmpty()) {
			log.info("Modify {}: {}", entry.getDn(), req);
			ModifyResponse response = conn.modify(req);
			if (response.getLdapResult().getResultCode() != ResultCodeEnum.SUCCESS) {
				log.error("Cannot modify entry " + entry.getDn() + ": " + response.getLdapResult().getResultCode() + " - " +
						response.getLdapResult().getDiagnosticMessage());
				throw new LdapException("Cannot modify entry " + entry.getDn() + ": " + response.getLdapResult().getResultCode() + " - " +
						response.getLdapResult().getDiagnosticMessage());
			}
		} else {
			log.info("Not modifying {} because there are no changes", entry.getDn());
		}
	}

	/**
	 * @param conn
	 * @param entry
	 * @param removeExtraAttributes
	 * @param excludedAttributes
	 * @return
	 * @throws LdapException
	 */
	protected static ModifyRequestImpl createModifyRequest(
			Entry entry, Entry existing, boolean removeExtraAttributes,
			String... excludedAttributes) throws LdapException {
		log.info("Updating entry {}, removeExtraAttributes: {}, excludedAttributes: {}", new Object[] {
				entry.getDn(), removeExtraAttributes, excludedAttributes });

		Set<String> excludedAttributeSet = ImmutableSet.copyOf(excludedAttributes);
		
		ModifyRequestImpl req = new ModifyRequestImpl();
		req.setName(entry.getDn());
		for (Attribute a : entry) {
			if ("objectClass".equalsIgnoreCase(a.getId()))
				continue;
			if (excludedAttributeSet.contains(a.getId()))
				continue;
			Set<String> newValues = ImmutableSet.copyOf(Iterables.transform(a, new ValueToString()));
			Set<String> oldValues = ImmutableSet.of();
			if (existing.containsAttribute(a.getId())) {
				oldValues = ImmutableSet.copyOf( Iterables.transform(existing.get(a.getId()), new ValueToString()) );
			}
			// make sure the new values are different, or ignore
			if (!oldValues.equals(newValues)) {
				log.debug("Replace {} in {}, {} => {}", new Object[] {
						a.getId(), entry.getDn(), oldValues, newValues });
				req.replace(a);
			}
		}
		if (removeExtraAttributes) {
			for (Attribute a : existing) {
				if ("objectClass".equalsIgnoreCase(a.getId()))
					continue;
				if (excludedAttributeSet.contains(a.getId()))
					continue;
				if (!entry.containsAttribute(a.getId())) {
					log.debug("Remove {} in {}", new Object[] {
							a.getId(), entry.getDn() });
					req.remove(a);
				}
			}
		}
		return req;
	}
	
	/**
	 * Convert an LDAP {@link EntryCursor} to a {@link List},
	 * making sure the cursor is closed. Exceptions during close will be swallowed,
	 * but logged as WARN.
	 * 
	 * @param cursor
	 */
	public static List<Entry> asList(EntryCursor cursor) {
		try {
			ImmutableList<Entry> entries = ImmutableList.copyOf((Iterable<Entry>)cursor);
			return entries;
		} finally {
			try {
				cursor.close();
			} catch (Exception e) {
				log.warn("Error closing LDAP cursor", e);
			}
		}
	}

	public static <V> V withConnection(LdapConnectionPool ldapPool, Function<LdapConnection, V> function) {
		try {
			LdapConnection conn = ldapPool.getConnection();
			try {
				return function.apply(conn);
			} finally {
				ldapPool.releaseConnection(conn);
			}
		} catch (Exception e) {
			log.error("LDAP operation error", e);
			Throwables.propagate(e);
			return null;
		}
	}
}
