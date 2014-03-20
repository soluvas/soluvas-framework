package org.soluvas.commons.config;

import org.springframework.context.annotation.Configuration;

/**
 * Simply implement this interface in your app's main {@link Configuration} bean.
 * @author ceefour
 */
public interface SoluvasApplication {
	
	/**
	 * Short app name, all lowercase, no symbols.
	 * @return
	 */
	String getId();

}
