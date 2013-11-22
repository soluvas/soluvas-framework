package org.soluvas.security;

import org.soluvas.data.repository.CrudRepository;

/**
 * Repository of {@link Role} entities. Refactored from {@link SecurityRepository}.
 * @author rudi
 */
public interface RoleRepository extends CrudRepository<Role, String> {

}
