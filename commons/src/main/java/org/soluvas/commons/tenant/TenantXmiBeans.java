package org.soluvas.commons.tenant;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.soluvas.commons.VersioningMode;
import org.soluvas.commons.config.TenantSelector;

public interface TenantXmiBeans<T extends EObject> {

	public abstract VersioningMode getVersioningMode();

	public abstract long count();

	/**
	 * Return the original entity from XMI, without templating and expansion.
	 * It's not an owned {@link EObject}, so {@link EcoreUtil#copy(EObject)} is not necessary.
	 * 
	 * @param tenantId Usually tenantId.
	 * @return
	 * @throws IllegalArgumentException If {@code id} is not found.
	 */
	public abstract T getOriginal(String tenantId)
			throws IllegalArgumentException;

	/**
	 * Return the expanded entity, after templating and expansion.
	 * It's not an owned {@link EObject}, so {@link EcoreUtil#copy(EObject)} is not necessary.
	 * 
	 * @param tenantId Usually tenantId.
	 * @return
	 * @throws IllegalArgumentException If {@code id} is not found.
	 */
	public abstract T getExpanded(String tenantId)
			throws IllegalArgumentException;

	/**
	 * Get bean based on {@link TenantSelector#tenantRef()}.
	 * @return
	 */
	public abstract T getCurrentExpanded() throws IllegalArgumentException;

	/**
	 * Modifies the <b>unexpanded</b> entity, saves it to disk, then performs commit/sync based on {@link #getVersioningMode()}.
	 * @param tenantId
	 * @param entity You must formerly get it using {@link #getOriginal(String)}.
	 * @return Unexpanded entity.
	 * @see #getOriginal(String)
	 */
	public abstract T modify(String tenantId, T entity);

}