package org.soluvas.commons.shell;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

/**
 * Sets up a new tenant using {@link TenantRepository#add(String, org.soluvas.commons.AppManifest, Object, String)}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="add", description="Sets up a new tenant using TenantRepository#add.")
public class TenantAddCommand extends ExtCommandSupport {
	
	/**
	 * Not required so it doesn't break apps that don't use {@link TenantRepository}. 
	 */
	@Autowired(required=false) @Nullable
	private TenantRepository<Object> tenantRepo;
	
	@Argument(name="tenantId", required=true, description="Tenant ID.")
	private String tenantId;
	@Option(name="-t", aliases="--title", description="Title (default: capitalized tenantId).")
	private String title;
	@Option(name="-e", aliases="--email", description="General email.")
	private String email;
	
	@Override
	protected AppManifest doExecute() throws Exception {
		Preconditions.checkNotNull(tenantRepo, "TenantRepository bean must present");
		final AppManifest appManifest = tenantRepo.newBlank();
		if (title != null) {
			appManifest.setTitle(title);
		} else {
			appManifest.setTitle(StringUtils.capitalize(tenantId));
		}
		if (email != null) {
			appManifest.setGeneralEmail(email);
		}
		final Object provisionData = tenantRepo.newProvisionData();
		final AppManifest addedAppManifest = tenantRepo.add(tenantId, appManifest, provisionData, null);
		return addedAppManifest;
	}

}
