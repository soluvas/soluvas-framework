package org.soluvas.schedule;

import java.util.Map;

import javax.inject.Qualifier;

import org.quartz.Job;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.context.ApplicationContext;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;

/**
 * Base class for tenant-aware Quartz {@link Job},
 * with built-in support for {@link #tenantId}, {@link #appManifest}, {@link #appCtx}, and {@link #getBean(Class)}.
 * @author ceefour
 */
public abstract class TenantJob implements Job {
	
	protected String tenantId;
	protected AppManifest appManifest;
	protected ApplicationContext appCtx;
	
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	/**
	 * @param appManifest the appManifest to set
	 */
	public void setAppManifest(AppManifest appManifest) {
		this.appManifest = appManifest;
	}
	
	/**
	 * @param appCtx the appCtx to set
	 */
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
	}

	/**
	 * Return the tenant-scoped bean of type {@code T}, without {@link Qualifier} support.
	 * First it looks up the bean named {@code requiredType + "Map"} which must be a {@link Map}{@literal <String, T>},
	 * then it looks up the key based on {@link TenantRef#getTenantId()} and returns that object. 
	 * @param requiredType
	 * @return
	 */
	protected <T> T getBean(Class<T> requiredType) {
		final String mapBeanName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, requiredType.getSimpleName()) + "Map";
		final Map<String, T> mapBean = appCtx.getBean(mapBeanName, Map.class);
		final T bean = Preconditions.checkNotNull(mapBean.get(tenantId), "Cannot get %s bean for tenant '%s' from '%s', %s available tenants are: %s",
				requiredType.getName(), tenantId, mapBeanName, mapBean.size(), Iterables.limit(mapBean.keySet(), 10));
		return bean;
	}

}
