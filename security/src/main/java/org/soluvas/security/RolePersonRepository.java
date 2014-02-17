package org.soluvas.security;

import org.soluvas.commons.Person;
import org.soluvas.data.repository.AssocRepository;

/**
 * Assigns {@link Role}s to {@link Person}s.
 * @author ceefour
 */
public interface RolePersonRepository extends AssocRepository<String, String> {

}
