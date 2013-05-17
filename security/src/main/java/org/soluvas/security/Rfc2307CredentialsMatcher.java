package org.soluvas.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.util.HashedPasswordUtils;

import scala.actors.threadpool.Arrays;

/**
 * Match credentials based on <a href="http://tools.ietf.org/html/rfc2307">RFC 2307</a>.
 * Algorithms supported are:
 * <ol>
 * 	<li>SSHA (salted SHA1)</li>
 * </ol>
 * This does not connect to LDAP. Instead it uses LDAP-encoded userPassword
 * to provide flexible salt and hashing algorithm. 
 * @author mahendri
 */
public class Rfc2307CredentialsMatcher implements CredentialsMatcher {
	
	private static final Logger log = LoggerFactory
			.getLogger(Rfc2307CredentialsMatcher.class);
	private static final Pattern passwordPattern = Pattern.compile("\\{([^}]+)\\}(.+)");

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.credential.CredentialsMatcher#doCredentialsMatch(org.apache.shiro.authc.AuthenticationToken, org.apache.shiro.authc.AuthenticationInfo)
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		if (token instanceof AutologinToken) {
			log.debug("Auto-logging in {}", token.getPrincipal());
			return true;
		}
		if (token.getCredentials() == null) {
			log.warn("Rejecting null token credentials for {}", token.getPrincipal());
			return false;
		}
		if (info.getCredentials() == null) {
			log.warn("Rejecting null stored credentials for {}", info.getPrincipals());
			return false;
		}
		final String passwordToken = String.valueOf((char[]) token.getCredentials());
		final String userPassword = info.getCredentials().toString();
		final Matcher matcher = passwordPattern.matcher(userPassword);
		if (matcher.matches()) {
			final String algorithm = matcher.group(1);
			final String encodedBase64 = matcher.group(2);
			switch (algorithm) {
			case "SSHA":
				final byte[] encoded = Base64.decodeBase64(encodedBase64);
				log.trace("Decoded {} into {} bytes", encodedBase64, encoded.length);
				if (encoded.length < 21) {
					log.error("Encoded length must be at least 21 bytes, 20-byte password and at least 1-byte salt, for {}", info.getPrincipals());
					return false;
				}
				final byte[] digest = Arrays.copyOf(encoded, 20);
				final byte[] salt = Arrays.copyOfRange(encoded, 20, encoded.length);
				byte[] digestToken = HashedPasswordUtils.calculateSsha(passwordToken, salt);
				return Arrays.equals(digestToken, digest);
			default:
				log.error("Unknown password algorithm {} for {}", algorithm, info.getPrincipals());
				return false;
			}
		} else {
			log.error("Unknown password syntax for {}", info.getPrincipals());
			return false;
		}
	}

}
