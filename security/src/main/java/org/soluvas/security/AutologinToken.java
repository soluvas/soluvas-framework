package org.soluvas.security;

import org.apache.shiro.authc.AuthenticationToken;

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
public class AutologinToken implements AuthenticationToken {
	
	private final Object principal;
	
	public AutologinToken(Object principal) {
		super();
		this.principal = principal;
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

}
