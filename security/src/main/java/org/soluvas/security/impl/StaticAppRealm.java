package org.soluvas.security.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.AutologinToken;

/**
 * Simple realm that recognizes only {@link HostAuthenticationToken#getHost()} {@code ""},
 * principal of {@code sysadmin}, and role of {@code app_sysadmin}.
 * @author ceefour
 */
public class StaticAppRealm extends AuthenticatingRealm {

	private static final Logger log = LoggerFactory
			.getLogger(StaticAppRealm.class);
	private static final String HOST = "";
	
	private final String sysadminPassword;

	public StaticAppRealm(String sysadminPassword) {
		super();
		setName("APP");
		this.sysadminPassword = sysadminPassword;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		final String host = token instanceof HostAuthenticationToken ? ((HostAuthenticationToken) token).getHost() : null;
		if (!HOST.equals(host)) {
			log.debug("[{}] Host mismatch, expected '{}', token requests '{}'."
					+ " If you use multiple realms, one realm should match the host while others mismatch."
					+ " If all mismatch, you have a misconfiguration.", getName(), HOST, host);
			throw new UnknownAccountException("[" + getName() + "] Host mismatch, expected '" + HOST + "', token requests '" + host + "'."
					+ " If you use multiple realms, one realm should match the host while others mismatch."
					+ " If all mismatch, you have a misconfiguration.");
		}
		
		if (token instanceof UsernamePasswordToken) {
			// Principal can be either person ID, slug (username in user's perspective), or email
			final String tokenPrincipal = ((UsernamePasswordToken) token).getUsername();
			if ("sysadmin".equals(tokenPrincipal)) {
				return new SimpleAuthenticationInfo(token.getPrincipal(), sysadminPassword, HOST);
			} else {
				throw new UnknownAccountException("User '" + tokenPrincipal + "' not found");
			}
		} else if (token instanceof AutologinToken) {
			log.debug("[{}] AuthenticationInfo for {} is using AutologinToken", getName(), token.getPrincipal());
			final String tokenPrincipal = ((UsernamePasswordToken) token).getUsername();
			if ("sysadmin".equals(tokenPrincipal)) {
				return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), HOST);
			} else {
				throw new UnknownAccountException("User '" + tokenPrincipal + "' not found");
			}
		} else {
			throw new AuthenticationException("[" + getName() + "] Unsupported AuthenticationToken: "
					+ token.getClass() + " using " + token.getPrincipal());
		}
	}

}
