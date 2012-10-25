package org.soluvas.ldap;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.pool.ObjectPool;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;
import org.apache.directory.shared.ldap.model.cursor.EntryCursor;
import org.apache.directory.shared.ldap.model.entry.Attribute;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.entry.Value;
import org.apache.directory.shared.ldap.model.exception.LdapException;
import org.apache.directory.shared.ldap.model.exception.LdapURLEncodingException;
import org.apache.directory.shared.ldap.model.message.ModifyRequest;
import org.apache.directory.shared.ldap.model.message.ModifyRequestImpl;
import org.apache.directory.shared.ldap.model.message.ModifyResponse;
import org.apache.directory.shared.ldap.model.message.ResultCodeEnum;
import org.apache.directory.shared.ldap.model.schema.AttributeType;
import org.apache.directory.shared.ldap.model.schema.SchemaManager;
import org.apache.directory.shared.ldap.model.url.LdapUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NotNullPredicate;

import com.google.common.base.Function;
import com.google.common.base.Optional;
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
	 * @throws LdapException 
	 */
	public static void update(@Nonnull LdapConnection conn, @Nonnull Entry entry,
			SchemaManager schemaManager, @Nonnull Set<String> affectedAttributes) throws LdapException {
		Entry existing = conn.lookup(entry.getDn());
		ModifyRequest req = createModifyRequest(entry, existing, schemaManager, affectedAttributes);
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
	protected static ModifyRequest createModifyRequest(
			@Nonnull Entry entry, @Nonnull Entry existing,
			final SchemaManager schemaMgr, Set<String> affectedAttributes) throws LdapException {
		Preconditions.checkArgument(entry.isSchemaAware(), "Cannot modify entry %s, updated entry is not schema aware. Please call conn.loadSchema();", entry.getDn());
		Preconditions.checkArgument(existing.isSchemaAware(), "Cannot modify entry %s, existing entry is not schema aware. Please call conn.loadSchema();", existing.getDn());
		
		final Set<AttributeType> affectedAttributeTypes = ImmutableSet.copyOf(Iterables.transform(affectedAttributes, new Function<String, AttributeType>() {
			@Override @Nullable
			public AttributeType apply(@Nullable String input) {
				AttributeType attributeType = schemaMgr.getAttributeType(input);
				Preconditions.checkNotNull(attributeType, "Cannot get AttributeType %s from SchemaManager %s", input, schemaMgr);
				return attributeType;
			}
		}));
		log.info("Updating entry {}, affectedAttributes: {}", new Object[] {
				entry.getDn(), affectedAttributes });

		ModifyRequest req = new ModifyRequestImpl();
		req.setName(entry.getDn());
		for (Attribute updatedAttr : entry) {
			final AttributeType updatedAttrType = Optional.fromNullable(updatedAttr.getAttributeType())
					.or(schemaMgr.getAttributeType(updatedAttr.getId()));
			Preconditions.checkNotNull(updatedAttrType, "AttributeType of %s cannot be null", updatedAttr);
			if ("objectClass".equalsIgnoreCase(updatedAttrType.getName()))
				continue;
			if (!affectedAttributeTypes.contains(updatedAttrType))
				continue;
			Set<String> newValues = ImmutableSet.copyOf(Iterables.filter(Iterables.transform(updatedAttr, new ValueToString()),
					new NotNullPredicate<String>()));
			Set<String> oldValues = ImmutableSet.of();
			// get old value from either AttributeType (if present) or ID
			Attribute existingAttr = existing.get(updatedAttrType.getName());
			if (existingAttr == null) {
				log.debug("Replace new {} in {}: {}",
						updatedAttrType.getName(), entry.getDn(), updatedAttr.get() );
				req.replace(updatedAttr);
			} else {
				// make sure the new values are different, or ignore
				
				if (existingAttr.get().getNormValue() instanceof byte[]) {
					if (!Arrays.equals((byte[])existingAttr.get().getNormValue(), (byte[]) updatedAttr.get().getNormValue())) {
						log.debug("Replace {} in {}, {} => {}",
								updatedAttrType.getName(), entry.getDn(), existingAttr.get().getNormValue(), updatedAttr.get().getNormValue() );
						req.replace(updatedAttr);
					}
				} else if (!existingAttr.get().getNormValue().equals(updatedAttr.get().getNormValue())) {
					log.debug("Replace {} in {}, {} => {}",
							updatedAttrType.getName(), entry.getDn(), existingAttr.get().getNormValue(), updatedAttr.get().getNormValue() );
					req.replace(updatedAttr);
				}
			}
//			final Attribute theAttributeinExisting = existing.get(updatedAttrType);
//			if (existing.containsAttribute(updatedAttrType)) {
//				oldValues = ImmutableSet.copyOf( Iterables.transform(existing.get(updatedAttrType), new ValueToString()) );
//			} else if (existing.containsAttribute(updatedAttr.getId())) {
//				oldValues = ImmutableSet.copyOf( Iterables.transform(existing.get(updatedAttr.getId()), new ValueToString()) );
//			}
//			// make sure the new values are different, or ignore
//			if (!oldValues.equals(newValues)) {
//				log.debug("Replace {} in {}, {} => {}",
//						updatedAttr.getId(), entry.getDn(), oldValues, newValues );
//				req.replace(updatedAttr);
//			}
		}
		
		final Set<AttributeType> updatedAttrTypes = ImmutableSet.copyOf(Iterables.transform(entry, new Function<Attribute, AttributeType>() {
			@Override @Nullable
			public AttributeType apply(@Nullable Attribute attr) {
				return Optional.fromNullable(attr.getAttributeType())
						.or(schemaMgr.getAttributeType(attr.getId()));
			}
		}));
		
		for (Attribute existingAttr : existing) {
			final AttributeType existingAttrType = Optional.fromNullable(existingAttr.getAttributeType())
					.or(Optional.fromNullable(schemaMgr.getAttributeType(existingAttr.getId()))).orNull();
			if (existingAttrType == null) {
				log.warn("Skipping existing attribute {} from entry {} because not known by SchemaManager {}",
						existingAttr.getId(), existing.getDn(), schemaMgr);
				continue;
			}
			if ("objectClass".equalsIgnoreCase(existingAttrType.getName()))
				continue;
			if (!affectedAttributeTypes.contains(existingAttrType))
				continue;
			// remove if AttributeType (looked up first) not found in updated entry
			if (!updatedAttrTypes.contains(existingAttrType)) {
				log.debug("Remove {} in {}",
						existingAttr.getId(), entry.getDn() );
				req.remove(existingAttr);
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
	public static List<Entry> asList(@Nonnull EntryCursor cursor) {
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

	public static <V> V withConnection(ObjectPool<LdapConnection> ldapPool, Function<LdapConnection, V> function) {
		try {
			LdapConnection conn = ldapPool.borrowObject();
			try {
				return function.apply(conn);
			} finally {
				ldapPool.returnObject(conn);
			}
		} catch (Exception e) {
			log.error("LDAP operation error", e);
			Throwables.propagate(e);
			return null;
		}
	}
	
	/**
	 * Generates 4-byte salt.
	 * @return
	 * @see #encodeSsha(String)
	 */
	public static byte[] generateSalt() {
		byte[] bytes = new byte[4];
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
		MessageDigest digest = MessageDigest.getInstance("SHA");
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
	
}
