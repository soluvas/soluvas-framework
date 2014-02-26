package org.soluvas.commons.config;

import java.io.File;
import java.io.IOException;

import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Configuration;

/**
 * Implemented by tenant {@link Configuration} beans.
 * @see MultiTenantConfig
 * @see SingleTenantWebConfig
 * @todo Rename, because this cannot be implemented the same as {@link MultiTenantConfig}.
 * @author ceefour
 */
public interface TenantSelector {

	/**
	 * Tenant data directory, this is {@code request} scoped.
	 * @return
	 * @throws IOException 
	 */
	File dataDir() throws IOException;
	
	TenantRef tenantRef();
	
	
}
