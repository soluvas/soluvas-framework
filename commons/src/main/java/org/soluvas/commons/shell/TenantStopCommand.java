package org.soluvas.commons.shell;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/**
 * Stops tenant(s) using {@link TenantRepository#stop(java.util.Set)}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="stop", description="Stops tenant(s) using TenantRepository#stop(java.util.Set).")
public class TenantStopCommand extends ExtCommandSupport {
	
	/**
	 * Not required so it doesn't break apps that don't use {@link TenantRepository}. 
	 */
	@Autowired(required=false) @Nullable
	private TenantRepository<Object> tenantRepo;
	
	@Argument(name="tenantId ...", required=true, multiValued=true, description="Tenant ID(s)")
	private String[] tenantIds;
	
	@Override
	protected Void doExecute() throws Exception {
		Preconditions.checkNotNull(tenantRepo, "TenantRepository bean must present");
		tenantRepo.stop(ImmutableSet.copyOf(tenantIds));
		return null;
	}

}
