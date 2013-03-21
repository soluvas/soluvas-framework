package org.soluvas.commons.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.soluvas.commons.WebAddress;

/**
 * @author agus
 */
public class AppUtils {
	
	/**
	 * Returns the absolute URI of {@literal logo_email.png}.
	 * This is practically "{webAddress.imagesUri}common/logo_email.png".
	 * Where {@literal common} is mounted by {tenantId}_common.
	 * 
	 * <p>This is useful for email and for JasperReports reporting.
	 * 
	 * <p>Note: Bippo.html.mustache simply uses: &lt;img src="{{webAddress.imagesUri}}/common/logo_email.png"...
	 * 
	 * @param appManifest
	 * @param webAddress
	 * @return
	 */
	public static String getEmailLogoUri(WebAddress webAddress) {
		return webAddress.getImagesUri() + "common/logo_email.png";
	}
	
	public static ExecutorService newCpuExecutor() {
		return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

}
