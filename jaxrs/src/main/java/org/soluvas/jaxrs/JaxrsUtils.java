package org.soluvas.jaxrs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;

import com.google.common.base.Preconditions;

/**
 * @author ceefour
 */
public class JaxrsUtils {
	
	private static transient Logger log = LoggerFactory.getLogger(JaxrsUtils.class);
	
	/**
	 * Use {@code @Context UriInfo uriInfo} in JAX-RS.
	 * @return
	 */
	public static TenantRef getTenant(@Nonnull final UriInfo uriInfo) {
		final String pathInfo = uriInfo.getBaseUri().getPath();
		return getTenant(pathInfo);
	}

	/**
	 * Use {@code @Context HttpServletRequest httpReq} in JAX-RS.
	 * @return
	 */
	public static TenantRef getTenant(@Nonnull final HttpServletRequest httpReq) {
		final String pathInfo = httpReq.getPathInfo();
		return getTenant(pathInfo);
	}

	/**
	 * @param pathInfo
	 * @return
	 */
	public static TenantRef getTenant(@Nonnull final String pathInfo) {
		final Pattern apiPathPattern = Pattern.compile(".*\\/api\\/(.+)_([^_/]+).*");
		final Matcher apiPathMatcher = apiPathPattern.matcher(pathInfo);
		if (!apiPathMatcher.matches()) {
			log.warn("REST path {} does not conform to multitenant REST API pattern", pathInfo);
			return null;
		}
		final TenantRef tenantRef = new TenantRef(null, apiPathMatcher.group(1),
				apiPathMatcher.group(2));
		log.trace("REST path {} is for {}", pathInfo, tenantRef);
		return tenantRef;
	}
	
	/**
	 * Get the security {@link Subject} (currently logged in user). The access token
	 * is fetched from either of: (in order of importance)
	 * 
	 * <ol>
	 * <li>the current request's {@literal accessToken} Form parameter</li>
	 * <li>the current request's {@literal accessToken} Query parameter</li>
	 * <li>the current request's {@literal accessToken} cookie</li>
	 * </ol>
	 *
	 * <p>See https://shiro.apache.org/session-management.html
	 * 
	 * @return
	 */
	public static Subject getSubject(@Nonnull final HttpServletRequest req) {
		final Subject subject = SecurityUtils.getSubject();
		return subject;
	}

	/**
	 * Get the security {@link Session} for currently logged in user.
	 * 
	 * <p>The {@link Subject} is fetched using {@link #getSubject(HttpServletRequest)}.
	 * 
	 * <p>If no Session is available, the call will fail and throw {@link NullPointerException}.
	 * 
	 * @return
	 */
	public static Session requireSession(@Nonnull final HttpServletRequest req) {
		return Preconditions.checkNotNull(getSubject(req).getSession(false),
				"Cannot get security session");
	}

}
