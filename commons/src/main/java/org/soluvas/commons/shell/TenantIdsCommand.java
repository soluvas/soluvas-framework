package org.soluvas.commons.shell; 

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * Lists tenant IDs using {@link TenantRepository}.
 *
 * @author ceefour
 * @see TenantLsCommand
 * @see TenantMapCommand
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="ids", description="Lists tenant IDs using TenantRepository.")
public class TenantIdsCommand extends ExtCommandSupport {
	
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	
	public TenantIdsCommand() {
		super(false);
	}
	
	@Override
	protected ImmutableSet<String> doExecute() throws Exception {
		Preconditions.checkNotNull(tenantRepo, "TenantRepository bean not found. Try using \"tenant:map -1\" instead.");
		final ImmutableMap<String, AppManifest> tenantMap = tenantRepo.findAll();
		return tenantMap.keySet();
	}

}