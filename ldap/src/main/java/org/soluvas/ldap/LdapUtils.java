package org.soluvas.ldap;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.exception.LdapURLEncodingException;
import org.apache.directory.shared.ldap.model.message.SearchScope;
import org.apache.directory.shared.ldap.model.url.LdapUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
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
	private static final Random random = new Random();

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
		
		log.debug("Creating LDAP server configuration to {} as {}", ldapUri, bindDn);
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
	 * Convert an LDAP {@link EntryCursor} to a {@link List},
	 * making sure the cursor is closed. Exceptions during close will be swallowed,
	 * but logged as WARN.
	 * 
	 * @param cursor
	 */
	public static List<Entry> asList(@Nonnull EntryCursor cursor) {
		try {
			List<Entry> entries = ImmutableList.copyOf(cursor);
			return entries;
		} finally {
			try {
				cursor.close();
			} catch (Exception e) {
				log.warn("Error closing LDAP cursor", e);
			}
		}
	}

	/**
	 * Transforms as {@link EntryCursor} to a {@link List} of T objects, then
	 * closes the connection.
	 * 
	 * @param cursor
	 * @param function
	 * @return
	 */
	public static <T> List<T> transform(@Nonnull EntryCursor cursor,
			Function<Entry, T> function) {
		try {
			return ImmutableList.copyOf(Iterables.transform(cursor, function));
		} finally {
			try {
				cursor.close();
			} catch (Exception e) {
				log.warn("Error closing LDAP cursor", e);
			}
		}
	}

	/**
	 * Transforms as {@link EntryCursor} to a {@link Set} of T objects, then
	 * closes the connection.
	 * 
	 * @param cursor
	 * @param function
	 * @return
	 */
	public static <T> Set<T> transformSet(@Nonnull EntryCursor cursor,
			Function<Entry, T> function) {
		try {
			Set<T> entries = ImmutableSet.copyOf(Iterables.transform(cursor,
					function));
			return entries;
		} finally {
			try {
				cursor.close();
			} catch (Exception e) {
				log.warn("Error closing LDAP cursor", e);
			}
		}
	}

	/**
	 * Get an {@link LdapConnection} from the {@link ObjectPool},
	 * executes the {@code function}, then returns the {@link LdapConnection} to the {@link ObjectPool}
	 * or calls {@link ObjectPool#invalidateObject(Object)} if there was an error. 
	 * @param ldapPool
	 * @param function
	 * @return
	 */
	public static <V> V withConnection(@Nonnull final ObjectPool<LdapConnection> ldapPool,
			@Nonnull final Function<LdapConnection, V> function) {
		final LdapConnection conn;
		try {
			conn = ldapPool.borrowObject();
		} catch (final Exception e) {
			throw new RuntimeException("Cannot get LDAP connection", e);
		}
		try {
			final V result = function.apply(conn);
			ldapPool.returnObject(conn);
			return result;
		} catch (final Exception e) {
			try {
				ldapPool.invalidateObject(conn);
			} catch (Exception e1) {
				log.warn("Cannot invalidate LDAP connection after " + e + " exception", e1);
			}
			throw new RuntimeException("Cannot perform LDAP operation", e);
		}
	}
	
	/**
	 * Generates 4-byte salt.
	 * @return
	 * @see #encodeSsha(String)
	 */
	public static byte[] generateSalt() {
		final byte[] bytes = new byte[4];
		random.nextBytes(bytes);
		return bytes;
	}
	
	/**
	 * Encodes RFC 2307 (http://tools.ietf.org/html/rfc2307) SSHA password
	 * as byte array, using the provided salt.
	 * @param password
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @see #encodeSsha(String)
	 */
	public static byte[] calculateSsha(String password, byte[] salt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.reset();
		digest.update(password.getBytes("UTF-8"));
		digest.update(salt);
		return digest.digest();
	}
	
	/**
	 * Encodes RFC 2307 (http://tools.ietf.org/html/rfc2307) formatted {SSHA} password
	 * with random salt.
	 * @param password
	 * @return
	 */
	public static String encodeSsha(String password) {
		byte[] salt = generateSalt();
		byte[] digest;
		try {
			digest = calculateSsha(password, salt);
		} catch (Exception e) {
			throw new RuntimeException("Cannot calculate SHA using salt " + salt, e);
		}
		byte[] digestAndSalt = new byte[digest.length + salt.length];
		System.arraycopy(digest, 0, digestAndSalt, 0, digest.length);
		System.arraycopy(salt, 0, digestAndSalt, digest.length, salt.length);
		return "{SSHA}" + Base64.encodeBase64String(digestAndSalt);
	}
	
	/**
	 * Delete an {@link Entry} and all its children.
	 * @param ldap
	 * @param dn
	 * @return Total number of deleted entries.
	 */
	public static long delete(@Nonnull final LdapConnection ldap, @Nonnull final String dn) {
		try {
			final List<Entry> children = LdapUtils.asList(ldap.search(dn, "(objectclass=*)", SearchScope.ONELEVEL));
			log.debug("Deleting {} and its {} children", dn, children.size());
			long deletedEntries = 0;
			for (Entry child : children) {
				deletedEntries += delete(ldap, child.getDn().getName());
			}
			ldap.delete(dn);
			deletedEntries++;
			log.info("Deleted {} including {} sub-entries", dn, deletedEntries);
			return deletedEntries;
		} catch (LdapException e) {
			throw new RuntimeException("Cannot delete " + dn, e);
		}
	}

}
