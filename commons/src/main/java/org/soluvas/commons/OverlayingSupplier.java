package org.soluvas.commons;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Overlay contents of {@link EObject} {@link Supplier}s.
 * EObject which has larger weight will "sink", thus overriding the EObject before.
 * @todo Support for propagating EMF Notify changes.
 * @author ceefour
 */
public class OverlayingSupplier<T extends EObject> implements Supplier<T>, DelegatingSupplier<T> {

	private static final Logger log = LoggerFactory
			.getLogger(OverlayingSupplier.class);
	private final EClass eClass;
	/**
	 * Maps a supplier with the {@link EObject}s it contains.
	 * Note that these are <strong>copied</strong> objects, not original objects from suppliers.
	 */
	private T overlaid;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final SortedMap<T, Supplier<T>> sources = Maps.synchronizedNavigableMap(Maps.newTreeMap(new PositionerComparator()));

	public OverlayingSupplier(EFactory eFactory, EClass eClass,
			List<Supplier<T>> suppliers) {
		super();
		this.eClass = eClass;
		log.info("Initializing overlaying supplier for {} with {} suppliers", eClass.getName(), suppliers.size());
		for (Supplier<T> supplier : suppliers) {
			addSupplier(supplier);
		}
	}
	
	public OverlayingSupplier(EPackage ePackage, String eClassName, List<Supplier<T>> suppliers) {
		this(ePackage.getEFactoryInstance(), (EClass) ePackage.getEClassifier(eClassName), suppliers);
	}
	
	@Override
	@PreDestroy
	public void destroy() {
		removeSuppliers(ImmutableList.copyOf(sources.values()));
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
		doRemoveSuppliers(ImmutableList.of(supplier));
		reoverlay();
		log.info("Removed supplier {} for {}, now {} suppliers", supplier, eClass.getName(), sources.size());
	}

	protected void removeSuppliers(Collection<Supplier<T>> removedSuppliers) {
		log.debug("Removing suppliers {} for {}", removedSuppliers, eClass.getName());
		doRemoveSuppliers(removedSuppliers);
		log.info("Removed suppliers {} for {}, now {} suppliers", removedSuppliers, eClass.getName(), sources.size());
	}

	protected void doRemoveSuppliers(Collection<Supplier<T>> removedSuppliers) {
		int removedCount = 0;
		Iterator<Entry<T, Supplier<T>>> iterator = sources.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<T, Supplier<T>> entry = iterator.next();
			if (removedSuppliers.contains( entry.getValue() )) {
				iterator.remove();
				removedCount++;
			}
			if (removedCount >= removedSuppliers.size())
				break;
		}
		reoverlay();
	}

	@Override
	public T get() {
		Preconditions.checkNotNull(overlaid, "No suppliers provided for %s", eClass.getName());
		return overlaid;
	}

}
