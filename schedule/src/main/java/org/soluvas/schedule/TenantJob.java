package org.soluvas.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.inject.Qualifier;

import org.quartz.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRef;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
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
	 * The bean name may have string replacements for "Repository" -> "Repo", "Manager" -> "Mgr".
	 * Both the short and long form may be used.
	 * @param requiredType
	 * @return
	 */
	protected <T> T getBean(Class<T> requiredType) {
		final List<String> mapBeanNames = new ArrayList<>();
		final String mapBeanName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, requiredType.getSimpleName()) + "Map";
		mapBeanNames.add(mapBeanName);
		if (mapBeanName.contains("Repository")) {
			mapBeanNames.add(mapBeanName.replace("Repository", "Repo"));
		}
		if (mapBeanName.contains("Manager")) {
			mapBeanNames.add(mapBeanName.replace("Manager", "Mgr"));
		}
		Map<String, T> mapBean = null;
		for (final String wantedName : mapBeanNames) {
			try {
				mapBean = appCtx.getBean(wantedName, Map.class);
				break;
			} catch (NoSuchBeanDefinitionException e) {
				// bean not found, try next
			}
		}
		if (mapBean == null) {
			throw new NoSuchElementException(String.format("Cannot find bean of type Map<String, %s> for tenant '%s' using names: %s",
					requiredType.getName(), tenantId, mapBeanNames));
		}

		final T bean = Preconditions.checkNotNull(mapBean.get(tenantId), "Cannot get %s bean for tenant '%s' from '%s', %s available tenants are: %s",
				requiredType.getName(), tenantId, mapBeanName, mapBean.size(), Iterables.limit(mapBean.keySet(), 10));
		return bean;
	}

}
