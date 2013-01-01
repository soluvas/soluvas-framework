package org.soluvas.jaxrs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriInfo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubjectContext;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Function;
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
	 * @param resp TODO
	 * 
	 * @return
	 */
	public static Subject getSubject(@Nonnull final HttpServletRequest req,
			@Nonnull final HttpServletResponse resp) {
		final SecurityManager securityMgr = ThreadContext.getSecurityManager();
		if (securityMgr == null) {
			return TenantUtils.withService(FrameworkUtil.getBundle(JaxrsUtils.class).getBundleContext(),
					SecurityManager.class, null,
					new Function<SecurityManager, Subject>() {
				@Override @Nullable
				public Subject apply(@Nullable SecurityManager securityMgr) {
					final WebSubjectContext subjectContext = new DefaultWebSubjectContext();
					subjectContext.setServletRequest(req);
					subjectContext.setSecurityManager(securityMgr);
					final Subject subject = securityMgr.createSubject(subjectContext);
//					WebSubject subject = new WebSubject.Builder(securityMgr, req, resp).buildWebSubject();
					log.info("Session {}", subject.getSession().getId());
					return subject;
////					final Subject subject = new DefaultWebSubjectFactory().createSubject(subjectContext);
//					return subject;
//					ThreadContext.bind(securityMgr);
//					ThreadContext.bind(subject);
//					try {
//						final Subject subject = SecurityUtils.getSubject();
//						return subject;
//					} finally {
//						ThreadContext.unbindSubject();
//						ThreadContext.unbindSecurityManager();
//					}
				}
			});
		}
		final Subject subject = SecurityUtils.getSubject();
		return subject;
	}

	/**
	 * Get the security {@link Session} for currently logged in user.
	 * 
	 * <p>The {@link Subject} is fetched using {@link #getSubject(HttpServletRequest, HttpServletResponse)}.
	 * 
	 * <p>If no Session is available, the call will fail and throw {@link NullPointerException}.
	 * 
	 * @return
	 */
	public static Session requireSession(@Nonnull final HttpServletRequest req) {
		return Preconditions.checkNotNull(getSubject(req, null).getSession(false),
				"Cannot get security session");
	}

}
