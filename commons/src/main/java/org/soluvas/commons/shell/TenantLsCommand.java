package org.soluvas.commons.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * Lists tenant {@link AppManifest}s and {@link TenantState}s using {@link TenantRepository}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="ls", description="Lists tenant AppManifests and states using TenantRepository.")
public class TenantLsCommand extends ExtCommandSupport {
	
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	
	@Override
	protected Void doExecute() throws Exception {
		Preconditions.checkNotNull(tenantRepo, "TenantRepository bean not found");
		final ImmutableMap<String, AppManifest> tenantMap = tenantRepo.findAll();
		final ImmutableMap<String, TenantState> states = tenantRepo.getStates();
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-20s|%-10s|%-25s|%-30s|%-20s|%-3s|@",
				"№", "ID", "Title", "State", "Domain", "Email", "Time Zone", "$"));
		int i = 0;
		for (final Entry<String, AppManifest> entry : tenantMap.entrySet()) {
			final AppManifest tenant = entry.getValue();
			final TenantState state = states.get(entry.getKey());
			System.out.println(ansi().render("@|bold,black %3d||@%-15s@|bold,black ||@%-20s@|bold,black ||@%-10s@|bold,black ||@%-25s@|bold,black ||@%-30s@|bold,black ||@%-20s@|bold,black ||@%-3s",
				++i, entry.getKey(), tenant.getTitle(), state,
				tenant.getDomain(), tenant.getGeneralEmail(), tenant.getDefaultTimeZoneId(), tenant.getDefaultCurrencyCode()));
		}
		System.out.println(ansi().render("@|bold %d|@ tenants", i));
		return null;
	}

}