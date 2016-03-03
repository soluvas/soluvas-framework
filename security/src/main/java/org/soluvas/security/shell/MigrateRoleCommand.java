package org.soluvas.security.shell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.util.BatchFinder;
import org.soluvas.data.util.BatchProcessor;
import org.soluvas.data.util.RepositoryUtils;
import org.soluvas.security.Permission;
import org.soluvas.security.Role;
import org.soluvas.security.Role2;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.mongo.RolePersonRepository2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

/**
 * @author anisa
 *
 */
@Service @Scope("prototype")
@Command(scope="sec", name="migrateroles", description="Migrate Roles from XMI to MongoDB")
public class MigrateRoleCommand extends ExtCommandSupport {
	
	private static final Logger log = LoggerFactory.getLogger(MigrateRoleCommand.class);
	
	@Override
	protected Object doExecute() throws Exception {
		
		final SecurityCatalog secCatalog = getBean(SecurityCatalog.class);
		final RolePersonRepository2 rolePersonRepo = getBean(RolePersonRepository2.class);
		
		final List<Role> roles = ImmutableList.copyOf(EcoreUtil.copyAll(secCatalog.getRoles()));
		final List<Permission> permissions = ImmutableList.copyOf(EcoreUtil.copyAll(secCatalog.getPermissions()));
		
		final Map<String, List<Permission>> permissionMapByRole = new HashMap<>();
		for (final Role role : roles) {
			final List<Permission> permissionsByRole = permissions.stream().filter(new Predicate<Permission>() {
				@Override
				public boolean test(Permission t) {
					return t.getRoles().contains(role.getId());
				}
			}).collect(Collectors.toList());
			permissionMapByRole.put(role.getId(), permissionsByRole);
		}
		
		RepositoryUtils.runBatch("Migrate roles to mongoDB", new Sort("id"), new BatchFinder<Role>() {
			@Override
			public Page<Role> find(Pageable pageable) throws Exception {
				return new PageImpl<>(roles);
			}
		}, new BatchProcessor<Role>() {
			@Override
			public void process(Role roleXmi, long elementIndex, long elementOffset, long numberOfElements,
					long totalElements, long pageNumber, long totalPages, ProgressMonitor monitor) throws Exception {
			
				final Role2 role2 = new Role2();
				role2.setAssignMode(roleXmi.getAssignMode());
				role2.setCreationTime(roleXmi.getCreationTime());
				role2.setDescription(roleXmi.getDescription());
				role2.setId(roleXmi.getId());
				role2.setModificationTime(roleXmi.getModificationTime());
				role2.setName(roleXmi.getName());
				
				final Map<String, List<String>> permisssionMap = new HashMap<>();
				final List<Permission> permissionsGroupByRoleId = permissionMapByRole.get(roleXmi.getId());
				for (final Permission permission : permissionsGroupByRoleId) {
					permisssionMap.put(permission.getDomainPermission().get(0), permission.getActionPermission());
				}
				
				role2.setPermissions(permisssionMap);
				
				rolePersonRepo.addAll(ImmutableList.of(role2));
			}
		});
		
		return null;
	}

}
