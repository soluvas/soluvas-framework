package org.soluvas.security.util;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameFunction;
import org.soluvas.security.SecurityCatalog;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author rudi
 *
 */
public class SecurityHelper {
	
	private static final Logger log = LoggerFactory
			.getLogger(SecurityHelper.class);
	
	/**
	 * Checks if a {@link Subject} has any "real" role, i.e. excluding {@code guest} and {@code authenticated}.
	 * @param securityCatalog
	 * @param subject
	 * @return
	 */
	public static boolean hasAnyRealRole(SecurityCatalog securityCatalog, Subject subject) {
		final ImmutableSet<String> allRoleNames = ImmutableSet.copyOf(Lists.transform(securityCatalog.getRoles(), new NameFunction()));
		final ImmutableSet<String> excludedRoleNames = ImmutableSet.of("guest", "authenticated");
		final List<String> realRoleNames = ImmutableList.copyOf(Sets.difference(allRoleNames, excludedRoleNames));
		final boolean[] ownedRoles = subject.hasRoles(realRoleNames);
		log.trace("(Real) Role Names  have {} records: {} owned: {}", realRoleNames.size(), realRoleNames, ownedRoles);
		boolean hasAnyRealRole = ArrayUtils.contains(ownedRoles, true);
		return hasAnyRealRole;
	}

}
