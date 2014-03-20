package org.soluvas.security;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantBeanRepository;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * General-purpose {@link AccessControlManager} implementation, it's modular because it needs to
 * be configured with appropriate persistence-specific {@link RolePersonRepository} implementation.
 * @see AccessControlManager
 * @author ceefour
 */
public class AccessControlManagerImpl implements AccessControlManager {
	
	private static final Logger log = LoggerFactory
			.getLogger(AccessControlManagerImpl.class);
	private final TenantBeanRepository<? extends RolePersonRepository> rolePersonRepoBeanRepo;
	
	public AccessControlManagerImpl(TenantBeanRepository<? extends RolePersonRepository> rolePersonRepoBeanRepo) {
		super();
		this.rolePersonRepoBeanRepo = rolePersonRepoBeanRepo;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.AccessControlManager#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonTenantRoles(final String tenantId, String personId) {
		final RolePersonRepository rolePersonRepo = rolePersonRepoBeanRepo.get(tenantId);
		final Set<String> tenantRoleIds = ImmutableSet.copyOf(rolePersonRepo.getRight(personId));
		log.debug("{}'s {} has {} tenant roles: {}",
				tenantId, personId, tenantRoleIds.size(), Iterables.limit(tenantRoleIds, 10));
		return tenantRoleIds;
	}

	@Override
	public Set<String> getTenantRoleMembers(String tenantId, String roleId) {
		final RolePersonRepository rolePersonRepo = rolePersonRepoBeanRepo.get(tenantId);
		final Set<String> personIds = ImmutableSet.copyOf(rolePersonRepo.getLeft(roleId));
		log.debug("{}'s role {} has {} members: {}",
				tenantId, roleId, personIds.size(), Iterables.limit(personIds, 10));
		return personIds;
	}

	@Override
	public void replacePersonTenantRoles(String tenantId, String personId,
			Set<String> roleIds) {
		final RolePersonRepository rolePersonRepo = rolePersonRepoBeanRepo.get(tenantId);
		log.info("Replacing {}'s {} tenant roles with: {}", tenantId, personId, roleIds);
		rolePersonRepo.replaceLefts(personId, roleIds);
	}

	@Override
	public void replaceTenantRoleMembers(String tenantId, String roleId,
			Set<String> personIds) {
		final RolePersonRepository rolePersonRepo = rolePersonRepoBeanRepo.get(tenantId);
		log.info("Resetting {}'s tenant role {} members as: {}", tenantId, roleId, personIds);
		rolePersonRepo.replaceRights(roleId, personIds);
	}

}
