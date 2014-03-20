package org.soluvas.security.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.Permission;
import org.soluvas.security.PersonAction;
import org.soluvas.security.PersonPermission;
import org.soluvas.security.Role;
import org.soluvas.security.RolePersonRepository;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.SecurityRepository;
import org.soluvas.security.couchdb.CouchDbRealm;
import org.soluvas.security.mongo.MongoRealm;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * Static helper methods for {@link AuthorizingRealm} implementations.
 * @author ceefour
 * @see CouchDbRealm
 * @see MongoRealm
 */
public class RealmUtils {
	
	private static final Logger log = LoggerFactory.getLogger(RealmUtils.class);
	
	/**
	 * Modifies the given {@link SimpleAuthorizationInfo} using {@link SecurityRepository}.
	 * @param authzInfo
	 * @param principalCollection
	 * @param securityRepo
	 * @param securityCatalog
	 * @deprecated Use the {@link RolePersonRepository}-based implementation.
	 */
	@Deprecated
	public static void modifyAuthInfo(SimpleAuthorizationInfo authzInfo, final PrincipalCollection principalCollection, SecurityRepository securityRepo,
			SecurityCatalog securityCatalog) {
		final String personId = (String) principalCollection.getPrimaryPrincipal();
		// Database-based roles for the current principal(s) are retrieved using RolePersonRepository
		final Set<String> personRoleIds = securityRepo.getPersonRoles(personId);
		modifyAuthInfo(authzInfo, principalCollection, personRoleIds, securityCatalog);
	}

	/**
	 * Modifies the given {@link SimpleAuthorizationInfo} using {@link RolePersonRepository}.
	 * @param authzInfo
	 * @param principalCollection
	 * @param rolePersonRepo
	 * @param securityCatalog
	 */
	public static void modifyAuthInfo(SimpleAuthorizationInfo authzInfo, final PrincipalCollection principalCollection, RolePersonRepository rolePersonRepo,
			SecurityCatalog securityCatalog) {
		final String personId = (String) principalCollection.getPrimaryPrincipal();
		// Database-based roles for the current principal(s) are retrieved using RolePersonRepository
		final List<String> personRoleIds = rolePersonRepo.getRight(personId);
		modifyAuthInfo(authzInfo, principalCollection, personRoleIds, securityCatalog);
	}

	/**
	 * Modifies the given {@link SimpleAuthorizationInfo} using provided {@code personRoleIds}.
	 * Used by {@link #modifyAuthInfo(SimpleAuthorizationInfo, PrincipalCollection, RolePersonRepository, SecurityCatalog)},
	 * but you can also use this directly if you don't have a {@link RolePersonRepository}.
	 * @param authzInfo
	 * @param principalCollection
	 * @param securityRepo
	 * @param securityCatalog
	 */
	public static void modifyAuthInfo(SimpleAuthorizationInfo authzInfo, final PrincipalCollection principalCollection, Collection<String> personRoleIds,
			SecurityCatalog securityCatalog) {
		final String personId = (String) principalCollection.getPrimaryPrincipal();
		
		// Database-based roles for the current principal(s) are usually retrieved using RolePersonRepository
		log.trace("Assigning {} stored roles to person '{}': {}",
				personRoleIds.size(), personId, Iterables.limit(personRoleIds, 10));
		authzInfo.addRoles(personRoleIds);

		// (Static) Permissions for each Role are set in SecurityCatalog.xmi files, using EMF models.
		log.trace("Processing security catalog for person '{}' with {} roles, {} domains, {} actions, and {} permissions",
				personId, securityCatalog.getRoles().size(), securityCatalog.getDomains().size(), 
				securityCatalog.getActions().size(), 
				securityCatalog.getPermissions().size());
		for (final Role role : securityCatalog.getRoles()) {
			switch (role.getAssignMode()) {
			case GUEST:
				log.trace("Assigning role {}-{} to person '{}' because assign mode {}",
						role.getId(), role.getName(), personId, role.getAssignMode());
				authzInfo.addRole(role.getId());
				break;
			case AUTHENTICATED:
				if (!principalCollection.isEmpty()) {
					log.trace(
							"Assigning role {}-{} to person '{}' because assign mode {} and principals={}",
							role.getId(), role.getName(), personId, role.getAssignMode(),
							principalCollection);
					authzInfo.addRole(role.getId());
				}
				break;
			case MANUAL:
				break;
			}
		}
		for (final Permission perm : securityCatalog.getPermissions()) {
			final Set<String> intersectingRoles = Sets.intersection(authzInfo.getRoles(),
					ImmutableSet.copyOf(perm.getRoles()));
			if (!intersectingRoles.isEmpty()) {
				log.trace("Assigning permission {} to person '{}' due to role(s) {}",
						perm.toStringPermission(), personId, intersectingRoles);
				authzInfo.addStringPermission(perm.toStringPermission());
			}
		}

		// dynamic/resource-level roles
		// add PersonPermission for VIEW & MODIFY (but not VIEW_ADMINISTRATIVE, MODIFY_ADMINISTRATIVE)
		authzInfo.addObjectPermission(
				new PersonPermission(ImmutableSet.of(PersonAction.VIEW, PersonAction.MODIFY), principalCollection));
	}

}
