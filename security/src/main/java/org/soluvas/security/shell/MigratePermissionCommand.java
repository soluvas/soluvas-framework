package org.soluvas.security.shell;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.json.JsonUtils;
import org.soluvas.security.ActionPermission;
import org.soluvas.security.Domain;
import org.soluvas.security.DomainPermission2;
import org.soluvas.security.DomainPermissionCatalog;
import org.soluvas.security.Permission;
import org.soluvas.security.SecurityCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

/**
 * @author anisa
 *
 */
@Service @Scope("prototype")
@Command(scope="sec", name="migratepermissions", description="Migrate Permissions from XMI to Jsonld")
public class MigratePermissionCommand extends ExtCommandSupport {
	
	private static final Logger log = LoggerFactory.getLogger(MigratePermissionCommand.class);

	@Override
	protected Object doExecute() throws Exception {
		//* proses migrate permission 
		
		final SecurityCatalog secCatalog = getBean(SecurityCatalog.class);
		
		final List<Domain> domains = ImmutableList.copyOf(EcoreUtil.copyAll(secCatalog.getDomains()));
		final List<Permission> permissions = ImmutableList.copyOf(EcoreUtil.copyAll(secCatalog.getPermissions()));
		
		final Map<String, Set<String>> actionPermissionsByDomain = new HashMap<>();
		for (final Domain domain : domains) {
			final List<Permission> permissionsByDomain = permissions.stream().filter(new Predicate<Permission>() {
				@Override
				public boolean test(Permission t) {
					return t.getDomainPermission().contains(domain.getName());
				}
			}).collect(Collectors.toList());
			
			final Set<String> actionPermissionList = new HashSet<>();
			for (final Permission permission : permissionsByDomain) {
				actionPermissionList.addAll(permission.getActionPermission());
			}
			
			actionPermissionsByDomain.put(domain.getName(), actionPermissionList);
		}
		
		final List<DomainPermission2> domainPermissionList = new ArrayList<>();
		for (final Domain domain : domains) {
//			log.info("Domain '{}' has {} actionPermissions: {}",
//					entry.getKey(), entry.getValue().size(), entry.getValue());
			
			final DomainPermission2 dp = new DomainPermission2();
			
			final Set<String> actions = actionPermissionsByDomain.get(domain.getName());
			
			final List<ActionPermission> actionPermissions = new ArrayList<>();
			for (final String actionPermissionValue : actions) {
				final ActionPermission ap = new ActionPermission();
				ap.setDescription(actionPermissionValue);
				ap.setId(actionPermissionValue);
				ap.setName(actionPermissionValue);
				
				actionPermissions.add(ap);
			}
//			final List<ActionPermission> actionPermissions = actions.stream().map(new Function<String, ActionPermission>() {
//				@Override
//				public ActionPermission apply(String t) {
//					final ActionPermission ap = new ActionPermission();
//					ap.setDescription(t);
//					ap.setId(t);
//					ap.setName(t);
//					return ap;
//				}
//			}).collect(Collectors.toList());
			dp.setActionPermission(actionPermissions);
			
			dp.setDescription(domain.getDescription());
			dp.setId(domain.getName());
			dp.setName(domain.getName());
			
			domainPermissionList.add(dp);
		}

		final DomainPermissionCatalog domainPermissionCatalog = new DomainPermissionCatalog();
		domainPermissionCatalog.getDomainPermissions().addAll(domainPermissionList);
		
		final String parentDir = System.getProperty("user.home") + "/git/soluvas-framework/security/src/main/resources/org/soluvas/security";
		final File jsonFile = new File(parentDir, "soluvas.DomainPermissionCatalog.jsonld");
		log.info("Writing {}", jsonFile);
		FileUtils.write(jsonFile, JsonUtils.asJson(domainPermissionCatalog));
		
		return null;
	}

}
