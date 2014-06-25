package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.UUID;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.tenant.ProvisionData;
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
	private TenantRepository<ProvisionData> tenantRepo;
	
	@Argument(name="tenantId", required=true, description="Tenant ID.")
	private String tenantId;
	@Option(name="-t", aliases="--title", description="Title (default: capitalized tenantId).")
	private String title;
	@Option(name="--summary", description="Summary (default: same as title). It's used for HomePage's title.")
	private String summary;
	@Option(name="--description", description="Description (default: same as summary).")
	private String description;
	@Option(name="-e", aliases="--email", description="General email.")
	private String email;
	@Option(name="--style", description="Default Mall style.")
	private String defaultStyle;
	@Option(name="--admin", description="Admin person ID.")
	private final String adminPersonId = "admin";
	@Option(name="--adminpass", description="Admin password (default: autogenerated).")
	private String adminPassword;
	@Option(name="--adminemail", description="Admin email (default: same as general email).")
	private String adminEmail;
	
	public TenantAddCommand() {
		super(false);
	}
	
	@Override
	protected AppManifest doExecute() throws Exception {
		Preconditions.checkNotNull(tenantRepo, "TenantRepository bean must present");
		final AppManifest appManifest = tenantRepo.newBlank();
		if (title != null) {
			appManifest.setTitle(title);
		} else {
			appManifest.setTitle(StringUtils.capitalize(tenantId));
		}
		appManifest.setSummary( summary != null ? summary : appManifest.getTitle() );
		appManifest.setDescription( description != null ? description : appManifest.getSummary() );
		if (email != null) {
			appManifest.setGeneralEmail(email);
		} else {
			appManifest.setGeneralEmail(System.getProperty("user.name") + "@" + MultiTenantConfig.getFqdn());
		}
		if (defaultStyle != null) {
			appManifest.setDefaultStyle(defaultStyle);
		}
		
		final ProvisionData provisionData = tenantRepo.newProvisionData();
		provisionData.setAdminPersonId(adminPersonId);
		provisionData.setAdminPassword( adminPassword != null ? adminPassword : UUID.randomUUID().toString().substring(0, 8) );
		provisionData.setAdminEmail( adminEmail != null ? adminEmail : appManifest.getGeneralEmail() );
		
		final AppManifest addedAppManifest = tenantRepo.add(tenantId, appManifest, provisionData, null);
		System.out.println(ansi().render("Admin person ID:  @|bold %s|@", provisionData.getAdminPersonId()));
		System.out.println(ansi().render("Admin email:      @|bold %s|@", provisionData.getAdminEmail()));
		System.out.println(ansi().render("Admin password:   @|bold %s|@", provisionData.getAdminPassword()));
		return addedAppManifest;
	}

}
