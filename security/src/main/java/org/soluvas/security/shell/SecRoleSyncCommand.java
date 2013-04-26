 package org.soluvas.security.shell; 

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.AssignMode;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Synchronize {@link Role}s from the {@link SecurityCatalog} dictionary to the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope = "sec", name = "rolesync", description = "Synchronize Roles from the SecurityCatalog to the SecurityRepository.")
public class SecRoleSyncCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleSyncCommand.class);
	private final SecurityCatalog securityCatalog;
	private final SecurityRepository securityRepo;

	@Inject
	public SecRoleSyncCommand(SecurityCatalog securityCatalog,
			SecurityRepository securityRepo) {
		super();
		this.securityCatalog = securityCatalog;
		this.securityRepo = securityRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		final EList<Role> catalogRoles = securityCatalog.getRoles();
		final List<Role> manualRoles = ImmutableList.copyOf(Iterables.filter(catalogRoles, new Predicate<Role>() {
			@Override
			public boolean apply(@Nullable Role input) {
				return input.getAssignMode() == AssignMode.MANUAL;
			}
		}));
		System.out.format("Ensuring %d manual roles (total %d roles)...",
				manualRoles.size(), catalogRoles.size());
		securityRepo.ensureRoles(manualRoles);
		System.out.format(" OK\n");
		return null;
	}

}