package org.soluvas.commons.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.soluvas.commons.SysConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Lists tenant {@link SysConfig}s.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="tenant", name="configls", description="Lists tenant SysConfigs.")
public class TenantConfigLsCommand extends ExtCommandSupport {
	
	@Override
	protected Object doExecute() throws Exception {
		final Map<String, SysConfig> sysConfigMap = beanFactory.getBean("sysConfigMap", Map.class);
		if (sysConfigMap.isEmpty()) {
			System.err.println("No tenant SysConfigs found");
			return null;
		}
		System.out.print(ansi().render("@|negative_on %3s|%-15s|@", "№", "Tenant ID"));
		final SysConfig first = sysConfigMap.values().iterator().next();
		final List<EAttribute> attrs = new ArrayList<>();
		for (EAttribute attr : first.eClass().getEAttributes()) {
			attrs.add(attr);
			System.out.print(ansi().render("@|negative_on |%-25s|@",
					attr.getName()));
		}
		System.out.println();
		
		int i = 0;
		for (final Entry<String, SysConfig> entry : sysConfigMap.entrySet()) {
			SysConfig sysConfig = entry.getValue();
			System.out.print(ansi().render("@|bold,black %3d||@%-15s", ++i, entry.getKey()));
			for (EAttribute attr : attrs) {
				System.out.print(ansi().render("@|bold,black ||@%-25s", sysConfig.eGet(attr)));
			}
			System.out.println();
		}
		System.out.println(ansi().render("@|bold %d|@ tenant SysConfigs", i));
		return null;
	}

}