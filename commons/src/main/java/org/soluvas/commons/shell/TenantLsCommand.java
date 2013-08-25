package org.soluvas.commons.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.AppManifest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Lists tenant {@link AppManifest}s.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="ls", description="Lists tenant AppManifests.")
public class TenantLsCommand extends ExtCommandSupport {
	
	@Override
	protected Object doExecute() throws Exception {
		final Map<String, AppManifest> tenantMap = beanFactory.getBean("tenantMap", Map.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-20s|%-20s|%-25s|%-20s|%-3s|@",
				"№", "ID", "Title", "Domain", "Email", "Time Zone", "$"));
		int i = 0;
		for (final Entry<String, AppManifest> entry : tenantMap.entrySet()) {
			AppManifest tenant = entry.getValue();
			System.out.println(ansi().render("@|bold,black %3d||@%-15s@|bold,black ||@%-20s@|bold,black ||@%-20s@|bold,black ||@%-25s@|bold,black ||@%-20s@|bold,black ||@%-3s",
				++i, entry.getKey(), tenant.getTitle(), tenant.getDomain(), tenant.getGeneralEmail(), tenant.getDefaultTimeZoneId(), tenant.getDefaultCurrencyCode()));
		}
		System.out.println(ansi().render("@|bold %d|@ tenants", i));
		return null;
	}

}