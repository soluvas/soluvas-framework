package org.soluvas.security.impl;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.MultiTenantWebConfig;
import org.soluvas.commons.tenant.TenantRef;

/**
 * @author ceefour
 * @todo FIXME: We misused the {@link HostAuthenticationToken#getHost()}! It's used for the client's IP address, <b>not</b> the server's name!
 * 		I think a better idea is to prefix the username with tenantId (i.e. {@link AuthenticatingFilter} should find the tenantId before passing the token), 
 * 		e.g. "tuneeca:hendy" or "tuneeca:ceefour666@gmail.com"
 * 		or "tuneeca.com:hendy". Or just create a {@link HostAuthenticationToken} subclass.
 */
public class MultitenantBasicHttpAuthenticationFilter extends BasicHttpAuthenticationFilter {
	
	private final MultiTenantConfig tenantConfig;
	
	public MultitenantBasicHttpAuthenticationFilter(
			MultiTenantConfig tenantConfig) {
		super();
		this.tenantConfig = tenantConfig;
	}

	/**
	 * @todo FIXME: We misused the {@link HostAuthenticationToken#getHost()}! It's used for the client's IP address, <b>not</b> the server's name!
	 * @see org.apache.shiro.web.filter.authc.AuthenticatingFilter#getHost(javax.servlet.ServletRequest)
	 */
	@Override
	protected String getHost(ServletRequest request) {
		final TenantRef tenantRef = MultiTenantWebConfig.getTenantRefMultiHost(
				(HttpServletRequest) request, tenantConfig.getTenantEnv(), tenantConfig.tenantMap(), 
				tenantConfig.getOpenDomain(), tenantConfig.getManageDomain());
		return tenantRef.getTenantId(); //request.getServerName();
	}

}
