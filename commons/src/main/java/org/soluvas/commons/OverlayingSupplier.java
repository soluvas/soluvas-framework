package org.soluvas.commons;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;

/**
 * Overlay contents of {@link EObject} {@link Supplier}s.
 * EObject which has larger weight will "sink", thus overriding the EObject before.
 * @todo Support for propagating EMF Notify changes.
 * @author ceefour
 */
public class OverlayingSupplier<T extends EObject> implements Supplier<T>, DelegatingSupplier<T> {

	private transient Logger log = LoggerFactory
			.getLogger(OverlayingSupplier.class);
	private final EClass eClass;
	/**
	 * Maps a supplier with the {@link EObject}s it contains.
	 * Note that these are <strong>copied</strong> objects, not original objects from suppliers.
	 */
	private T overlaid;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final SortedMap<T, Supplier<T>> sources = Maps.synchronizedNavigableMap(Maps.newTreeMap(new WeightComparator()));

	public OverlayingSupplier(EFactory eFactory, EClass eClass,
			List<Supplier<T>> suppliers) {
		super();
		this.eClass = eClass;
		log.info("Initializing overlaying supplier for {} with {} suppliers", eClass.getName(), suppliers.size());
		for (Supplier<T> supplier : suppliers) {
			addSupplier(supplier);
		}
	}
	
	protected void reoverlay() {
		overlaid = null;
		log.debug("Overlaying {} sources for {}", sources.size(), eClass.getName());
		for (T obj : sources.keySet()) {
			if (overlaid == null) {
				overlaid = obj;
			} else {
				EmfUtils.combineEObject(overlaid, obj);
			}
		}
	}
	
	@Override
	public void addSupplier(Supplier<T> supplier) {
		log.debug("Adding supplier {} for {}", supplier, eClass.getName());
		sources.put(supplier.get(), supplier);
		reoverlay();
		log.info("Added supplier {} for {}, now {} suppliers", supplier, eClass.getName(), sources.size());
	}

	@Override
	public void removeSupplier(Supplier<T> supplier) {
		log.debug("Removing supplier {} for {}", supplier, eClass.getName());
		Iterator<Entry<T, Supplier<T>>> iterator = sources.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<T, Supplier<T>> entry = iterator.next();
			if (entry.getValue().equals(supplier)) {
				iterator.remove();
				break;
			}
		}
		reoverlay();
		log.info("Removed supplier {} for {}, now {} suppliers", supplier, eClass.getName(), sources.size());
	}

	@Override
	public T get() {
		Preconditions.checkNotNull(overlaid, "No suppliers provided for %s", eClass.getName());
		return overlaid;
	}

}
