 package org.soluvas.security.shell; 

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.security.AssignMode;
import org.soluvas.security.Role;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;


/**
 * Synchronize {@link Role}s from the {@link SecurityCatalog} dictionary to the {@link SecurityRepository}.
 * 
 * @author ceefour
 */
@Command(scope = "sec", name = "roleadd", description = "Synchronize Roles from the SecurityCatalog to the SecurityRepository.")
public class SecRoleSyncCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRoleSyncCommand.class);

	private final ServiceLookup svcLookup;

	public SecRoleSyncCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		SecurityCatalog securityCatalog = svcLookup.getSupplied(SecurityCatalog.class, session);
		ServiceReference<SecurityRepository> securityRepoRef = svcLookup.getService(SecurityRepository.class, session, null, null);
		SecurityRepository securityRepo = bundleContext.getService(securityRepoRef);
		try {
			final EList<Role> catalogRoles = securityCatalog.getRoles();
			List<Role> manualRoles = ImmutableList.copyOf(Iterables.filter(catalogRoles, new Predicate<Role>() {
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
		} finally {
			bundleContext.ungetService(securityRepoRef);
		}
	}

}