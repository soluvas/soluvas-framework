package org.soluvas.commons.shell; 

import java.util.Map;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.SysConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

/**
 * Show {@link SysConfig} for a tenant.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="config", description="Show SysConfig for a tenant.")
public class TenantConfigCommand extends ExtCommandSupport {
	
	@Argument(name="tenantId", required=true, description="Tenant ID, e.g. acme")
	private String tenantId;
	@Override
	protected Object doExecute() throws Exception {
		final Map<String, SysConfig> sysConfigMap = beanFactory.getBean("sysConfigMap", Map.class);
		final SysConfig sysConfig = Preconditions.checkNotNull(sysConfigMap.get(tenantId),
				"Cannot lookup SysConfig for tenant '%s', %s available SysConfigs are: %s",
				tenantId, sysConfigMap.size(), sysConfigMap.keySet());
		return sysConfig;
	}

}