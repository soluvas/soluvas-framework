package org.soluvas.ldap;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.X509TrustManager;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.exception.LdapURLEncodingException;
import org.apache.directory.shared.ldap.model.message.ModifyRequestImpl;
import org.apache.directory.shared.ldap.model.url.LdapUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Manages {@link Entry} objects inside a base DN entry.
 * @author ceefour
 */
public class LdapUtils {
	
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
	 * When updating {@link PersonWithLong}, you should always exclude <tt>uid</tt> (the RDN) and <tt>userPassword</tt>
	 * attributes. 
	 * @param conn
	 * @param entry
	 * @param excludedAttributes
	 * @throws LdapException 
	 */
	public static void update(LdapConnection conn, Entry entry,
			boolean removeExtraAttributes, String... excludedAttributes) throws LdapException {
		log.info("Updating entry {}, removeExtraAttributes: {}, excludedAttributes: {}", new Object[] {
				entry.getDn(), removeExtraAttributes, excludedAttributes });
		Entry existing = conn.lookup(entry.getDn());

		ImmutableSet<String> excludedAttributeSet = ImmutableSet.copyOf(excludedAttributes);
		
		ModifyRequestImpl req = new ModifyRequestImpl();
		req.setName(entry.getDn());
		for (Attribute a : entry) {
			if ("objectClass".equalsIgnoreCase(a.getId()))
				continue;
			if (excludedAttributeSet.contains(a.getId()))
				continue;
			ImmutableSet<Value<?>> newValues = ImmutableSet.copyOf(a);
			if (existing.containsAttribute(a.getId())) {
				// make sure the new values are different, or ignore
				ImmutableSet<Value<?>> oldValues = ImmutableSet.copyOf( existing.get(a.getId()) );
				if (oldValues.equals(newValues))
					continue;
			}
			log.debug("Replace {} in {} with {}", new Object[] {
					a.getId(), entry.getDn(), newValues });
			req.replace(a);
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
		if (!req.getModifications().isEmpty()) {
			log.info("Modify {}: {}", entry.getDn(), req);
			conn.modify(req);
		} else {
			log.info("Not modifying {} because there are no changes", entry.getDn());
		}
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

}
