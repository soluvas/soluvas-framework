package org.soluvas.commons.config;

import java.io.File;

import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.annotation.Bean;
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
	 * Tenant data directory, it's not a {@link Bean} so needs to be called via {@link TenantSelector} bean.
	 * @return
	 */
	File getDataDir();
	
	TenantRef tenantRef();
	
	
}
