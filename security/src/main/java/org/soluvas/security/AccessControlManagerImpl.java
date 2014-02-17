package org.soluvas.security;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * @author ceefour
 *
 */
public class AccessControlManagerImpl implements AccessControlManager {
	
	private static final Logger log = LoggerFactory
			.getLogger(AccessControlManagerImpl.class);
	private final ImmutableMap<String, RolePersonRepository> rolePersonRepoMap;
	
	public AccessControlManagerImpl(ImmutableMap<String, RolePersonRepository> rolePersonRepoMap) {
		super();
		this.rolePersonRepoMap = rolePersonRepoMap;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.security.AccessControlManager#getPersonRoles(java.lang.String)
	 */
	@Override
	public Set<String> getPersonTenantRoles(final String tenantId, String personId) {
		final RolePersonRepository rolePersonRepo = Preconditions.checkNotNull(rolePersonRepoMap.get(tenantId),
				"Cannot get RolePersonRepository for tenant '%s'. %s available repos are: %s",
				tenantId, rolePersonRepoMap.size(), Iterables.limit(rolePersonRepoMap.keySet(), 10));
		final Set<String> tenantRoleIds = ImmutableSet.copyOf(rolePersonRepo.getRight(personId));
		log.debug("{}'s {} has {} tenant roles: {}",
				tenantId, personId, tenantRoleIds.size(), Iterables.limit(tenantRoleIds, 10));
		return tenantRoleIds;
	}

	@Override
	public Set<String> getTenantRoleMembers(String tenantId, String roleId) {
		final RolePersonRepository rolePersonRepo = Preconditions.checkNotNull(rolePersonRepoMap.get(tenantId),
				"Cannot get RolePersonRepository for tenant '%s'. %s available repos are: %s",
				tenantId, rolePersonRepoMap.size(), Iterables.limit(rolePersonRepoMap.keySet(), 10));
		final Set<String> personIds = ImmutableSet.copyOf(rolePersonRepo.getLeft(roleId));
		log.debug("{}'s role {} has {} members: {}",
				tenantId, roleId, personIds.size(), Iterables.limit(personIds, 10));
		return personIds;
	}

}
