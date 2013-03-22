package org.soluvas.commons.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.soluvas.commons.WebAddress;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author agus
 */
public class AppUtils {
	
	/**
	 * Returns the absolute URI of {@literal logo_email.png}.
	 * This is practically "{webAddress.imagesUri}tenant_common/logo_email.png".
	 * Where {@literal common} is mounted by {tenantId}_common.
	 * 
	 * <p>This is useful for email and for JasperReports reporting.
	 * 
	 * <p>Note: Bippo.html.mustache simply uses: &lt;img src="{{webAddress.imagesUri}}/tenant_common/logo_email.png"...
	 * 
	 * @param appManifest
	 * @param webAddress
	 * @return
	 */
	public static String getEmailLogoUri(WebAddress webAddress) {
		return webAddress.getImagesUri() + "tenant_common/logo_email.png";
	}
	
	public static ExecutorService newCpuExecutor() {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("CPU-%02d").build();
		return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), threadFactory);
	}

	public static ExecutorService newNetworkExecutor() {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Net-%02d").build();
		return Executors.newFixedThreadPool(32, threadFactory);
	}

}
