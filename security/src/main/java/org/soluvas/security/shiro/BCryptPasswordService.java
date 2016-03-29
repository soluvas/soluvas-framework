package org.soluvas.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashingPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Hash;
import org.mindrot.jbcrypt.BCrypt;
import org.soluvas.security.SecurityException;

/**
 * Inspired by <a href="https://coderwall.com/p/ohycpq/using-bcrypt-with-shiro">Coderwall: Using BCrypt with Shiro</a>. Please vote for <a href="https://issues.apache.org/jira/browse/SHIRO-290">SHIRO-290</a>.
 *
 * <p>Requires:</p>
 *
 * <pre>{@code
 *     <dependency>
 *         <groupId>de.svenkubiak</groupId>
 *         <artifactId>jBCrypt</artifactId>
 *         <version>0.4.1</version>
 *     </dependency>
 * }</pre>
 *
 * <p>Usage:</p>
 *
 * <pre>{@code
 * @Bean
 * public JdbcRealm jdbcRealm() {
 *     final JdbcRealm jdbcRealm = new JdbcRealm();
 *     jdbcRealm.setDataSource(dataSource);
 *     // jdbcRealm.setAuthenticationQuery(Person2.SHIRO_AUTHENTICATION_QUERY);
 *     final PasswordMatcher passwordMatcher = new PasswordMatcher();
 *     passwordMatcher.setPasswordService(new BCryptPasswordService());
 *     jdbcRealm.setCredentialsMatcher(passwordMatcher);
 *     return jdbcRealm;
 * }
 * }</pre>
 */
public class BCryptPasswordService implements PasswordService {

    @Override
    public String encryptPassword(Object plaintextPassword) throws IllegalArgumentException {
        final String str;
        if (plaintextPassword instanceof char[]) {
            str = new String((char[]) plaintextPassword);
        } else if (plaintextPassword instanceof String) {
            str = (String) plaintextPassword;
        } else {
            throw new SecurityException("Unsupported password type: " + plaintextPassword.getClass().getName());
        }
        return BCrypt.hashpw(str, BCrypt.gensalt());
    }

    @Override
    public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {
        return BCrypt.checkpw(new String((char[]) submittedPlaintext), encrypted);
    }
}
