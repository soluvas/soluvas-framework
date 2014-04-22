package org.soluvas.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.annotation.Nullable;

import org.soluvas.commons.Identifiable;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.repository.StatusAwareRepository;

import scala.util.Try;

import com.google.common.eventbus.EventBus;

/**
 * JPA-specific repository operations.
 * <p>To use tenant-specific repository inside a tenant-independent code such as {@link EventBus} subscriber
 * or Quartz Job, see {@link CommandRequestAttributes#withTenant(String)}. 
 * @param <T> TODO: should this extend an {@link Identifiable} of some sort?
 * @author ceefour
 */
public interface JpaRepository<T extends JpaEntity<ID>, ID extends Serializable> extends StatusAwareRepository<T, ID> {

	public Existence<ID> existsById(StatusMask statusMask, ID id);
	public Map<ID, Existence<ID>> existsAllById(StatusMask statusMask, Collection<ID> ids);
	
	public <S extends T> S lookupOneById(StatusMask statusMask, @Nullable ID id) throws EntityLookupException;
	public <S extends T> Map<ID, Try<S>> lookupAllById(StatusMask statusMask, Collection<ID> ids);
	
}
