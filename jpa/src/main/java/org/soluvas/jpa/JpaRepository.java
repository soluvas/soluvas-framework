package org.soluvas.jpa;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.repository.StatusAwareRepository;


/**
 * JPA-specific repository operations.
 * @param <T> TODO: should this extend an {@link Identifiable} of some sort?
 * @author ceefour
 */
public interface JpaRepository<T> extends StatusAwareRepository<T, String> {

}
