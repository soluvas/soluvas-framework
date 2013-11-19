package org.soluvas.jpa;

import java.io.Serializable;

import org.soluvas.commons.Identifiable;
import org.soluvas.data.repository.StatusAwareRepository;

/**
 * JPA-specific repository operations.
 * @param <T> TODO: should this extend an {@link Identifiable} of some sort?
 * @author ceefour
 */
public interface JpaRepository<T extends JpaEntity<ID>, ID extends Serializable> extends StatusAwareRepository<T, ID> {

}
