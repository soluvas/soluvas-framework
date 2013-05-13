package org.soluvas.ldap;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.pool.ObjectPool;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.exception.LdapInvalidDnException;
import org.apache.directory.api.ldap.model.exception.LdapURLEncodingException;
import org.apache.directory.api.ldap.model.message.Response;
import org.apache.directory.api.ldap.model.message.SearchResultEntry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.url.LdapUrl;
import org.apache.directory.api.util.GeneralizedTime;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Optional;
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
		final LdapUrl ldapUrlObj;
		try {
			ldapUrlObj = new LdapUrl(ldapUri);
		} catch (LdapURLEncodingException e) {
			throw new LdapRepositoryException(e, "Cannot parse LDAP URI %s", ldapUri);
		}

		final LdapConnectionConfig ldapConfig = new LdapConnectionConfig();
		ldapConfig.setLdapHost(ldapUrlObj.getHost());
		final boolean secured = LdapUrl.LDAPS_SCHEME.equalsIgnoreCase(ldapUrlObj.getScheme());
		ldapConfig.setUseSsl(secured);
		if (ldapUrlObj.getPort() > 0)
			ldapConfig.setLdapPort(ldapUrlObj.getPort());
		else
			ldapConfig.setLdapPort(secured ? ldapConfig.getDefaultLdapsPort() : ldapConfig.getDefaultLdapPort());
		final X509TrustManager alwaysTrustManager = new X509TrustManager() {
			@Override public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			
			@Override public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				log.info("Trusting {} SERVER certificate {}", authType, chain);
			}
			
			@Override public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
				log.info("Trusting {} CLIENT certificate {}", authType, chain);
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
	public static List<Entry> asList(EntryCursor cursor) {
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
	 * Convert an LDAP {@link EntryCursor} to a {@link List},
	 * making sure the cursor is closed. Exceptions during close will be swallowed,
	 * but logged as WARN.
	 * 
	 * @param cursor
	 */
	public static List<Entry> asList(SearchCursor cursor) {
		try {
			final List<Entry> entries = ImmutableList.copyOf(Iterables.transform(cursor, new Function<Response, Entry>() {
				@Override @Nullable
				public Entry apply(@Nullable Response input) {
					return ((SearchResultEntry)input).getEntry();
				}
			}));
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
	public static <T> List<T> transform(EntryCursor cursor,
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
	public static <T> Set<T> transformSet(EntryCursor cursor,
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
	public static <V> V withConnection(final ObjectPool<LdapConnection> ldapPool,
			final Function<LdapConnection, V> function) {
		final LdapConnection conn;
		try {
			conn = ldapPool.borrowObject();
		} catch (final Exception e) {
			throw new LdapRepositoryException(e, "Cannot get LDAP connection");
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
			if (e instanceof LdapRepositoryException) {
				throw (LdapRepositoryException) e;
			} else {
				throw new LdapRepositoryException(e, "Cannot perform LDAP operation: %s", e);
			}
		}
	}
	
	/**
	 * Delete an {@link Entry} and all its children.
	 * @param ldap
	 * @param dn
	 * @return Total number of deleted entries.
	 */
	public static long deleteRecursively(final LdapConnection ldap, final String dn) {
		try {
			final List<Entry> children = LdapUtils.asList(ldap.search(dn, "(objectclass=*)", SearchScope.ONELEVEL));
			log.debug("Deleting {} and its {} children", dn, children.size());
			long deletedEntries = 0;
			for (Entry child : children) {
				deletedEntries += deleteRecursively(ldap, child.getDn().getName());
			}
			ldap.delete(dn);
			deletedEntries++;
			log.info("Deleted {} including {} sub-entries", dn, deletedEntries);
			return deletedEntries;
		} catch (LdapInvalidDnException e) {
			log.info("Not deleting non-existing DN " + dn, e);
			return 0;
		} catch (LdapException e) {
			throw new LdapRepositoryException(e, "Cannot delete %s recursively", dn);
		}
	}
	
	/**
	 * Tries to make input LDAP compliant phone number. If fails, then return absent.
	 * @param input
	 * @return
	 */
	public static Optional<String> enforcePhoneNumber(@Nullable String input) {
		if (input == null) {
			return Optional.absent();
		}
		final String trimmed = input.replaceAll("[^0-9\\+\\,\\-\\(\\) ]+", "").trim();
		final boolean containsNumber = input.matches(".*[0-9].*");
		return containsNumber ? Optional.of(trimmed) : Optional.<String>absent();
	}
	
	/**
	 * Returns LDAP generalized time. Note that LDAP generalized cannot
	 * handle dates former than year 1753, so it will throw {@link IllegalArgumentException} in that case.
	 * @param dateTime
	 * @return
	 * @throws IllegalArgumentException If invalid date or if year is before 1753.
	 */
	@Nullable
	public static String toGeneralizedTime(@Nullable DateTime dateTime) throws IllegalArgumentException {
		if (dateTime == null) {
			return null;
		}
		if (dateTime.getYear() < 1000) {
			throw new IllegalArgumentException("Cannot handle year " + dateTime.getYear() + " from " + dateTime + ". Minimum supported year is 1753.");
		}
		return new GeneralizedTime(dateTime.toGregorianCalendar()).toGeneralizedTime();
	}

}
