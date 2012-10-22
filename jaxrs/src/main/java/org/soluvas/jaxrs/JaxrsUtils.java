package org.soluvas.jaxrs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ceefour
 */
public class JaxrsUtils {
	
	private static transient Logger log = LoggerFactory.getLogger(JaxrsUtils.class);
	
	/**
	 * Use {@code @Context UriInfo uriInfo} in JAX-RS.
	 * @return
	 */
	public static TenantRef getTenantInfo(UriInfo uriInfo) {
		final String pathInfo = uriInfo.getBaseUri().getPath();
		return getTenantInfo(pathInfo);
	}

	/**
	 * Use {@code @Context HttpServletRequest httpReq} in JAX-RS.
	 * @return
	 */
	public static TenantRef getTenantInfo(HttpServletRequest httpReq) {
		final String pathInfo = httpReq.getPathInfo();
		return getTenantInfo(pathInfo);
	}

	/**
	 * @param pathInfo
	 * @return
	 */
	public static TenantRef getTenantInfo(final String pathInfo) {
		Pattern apiPathPattern = Pattern.compile(".*\\/api\\/(.+)_([^_]+).*");
		Matcher apiPathMatcher = apiPathPattern.matcher(pathInfo);
		if (!apiPathMatcher.matches()) {
			log.warn("REST path {} does not conform to multitenant REST API pattern", pathInfo);
			return null;
		}
		TenantRef tenantRef = new TenantRef(apiPathMatcher.group(1), apiPathMatcher.group(2));
		log.debug("REST path {} is for {}", pathInfo, tenantRef);
		return tenantRef;
	}

}
