package org.soluvas.commons.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.soluvas.commons.CommonsException;

/**
 * @author mahendri
 *
 */
public class HashedPasswordUtils {

	private static final Random RANDOM = new Random();
	
	/**
	 * Generates 8-byte salt.
	 * @return
	 * @see HashedPasswordUtils#encodeSsha(String)
	 */
	public static byte[] generateSalt() {
		final byte[] bytes = new byte[8];
		RANDOM.nextBytes(bytes);
		return bytes;
	}

	/**
	 * Encodes <a href="http://tools.ietf.org/html/rfc2307">RFC 2307</a> SSHA password
	 * as byte array, using the provided salt.
	 * @param password
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @see HashedPasswordUtils#encodeSsha(String)
	 */
	public static byte[] calculateSsha(String password, byte[] salt) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.reset();
			digest.update(password.getBytes("UTF-8"));
			digest.update(salt);
			return digest.digest();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new CommonsException("Cannot calculate SSHA", e);
		}
	}

	/**
	 * Encodes <a href="http://tools.ietf.org/html/rfc2307">RFC 2307</a> formatted {SSHA} password
	 * with random 4-byte salt.
	 * <p>Example output: <code>{SSHA}RQMAqwP31zWvgLkxXRuymflnAQF........==</code>
	 * @param password
	 * @return
	 * @see generateSalt
	 */
	public static String encodeSsha(String password) {
		byte[] salt = generateSalt();
		byte[] digest;
		try {
			digest = calculateSsha(password, salt);
		} catch (Exception e) {
			throw new CommonsException(e, "Cannot calculate SHA using salt %s", salt);
		}
		byte[] digestAndSalt = new byte[digest.length + salt.length];
		System.arraycopy(digest, 0, digestAndSalt, 0, digest.length);
		System.arraycopy(salt, 0, digestAndSalt, digest.length, salt.length);
		return "{SSHA}" + Base64.encodeBase64String(digestAndSalt);
	}

}
