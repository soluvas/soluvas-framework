package org.soluvas.security;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * {@link AuthenticationToken} that is always trusted. For example, when logging in
 * via external authentication provider, such as Facebook, Twitter, Google, and Yahoo.
 * 
 * <p>Used by SoluvasRealm to simply provide the given principal as LDAP personId/uid.
 * 
 * <p>Used by LdapBindCredentialsMatcher to skip password checking if an {@link AutologinToken}
 * is given.
 * 
 * @author haidar
 */
@SuppressWarnings("serial")
public class AutologinToken implements HostAuthenticationToken {
	
	private final Object principal;
	private final String host;
	
	public AutologinToken(Object principal) {
		super();
		this.principal = principal;
		this.host = null;
	}

	public AutologinToken(Object principal, String host) {
		super();
		this.principal = principal;
		this.host = host;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.AuthenticationToken#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		return principal;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.authc.AuthenticationToken#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public String getHost() {
		return host;
	}

}
