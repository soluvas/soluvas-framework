package org.soluvas.commons;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @todo Support for propagating EMF Notify changes.
 * @author ceefour
 */
public class AggregatingSupplier<T extends EObject> implements Supplier<T> {

	private transient Logger log = LoggerFactory
			.getLogger(AggregatingSupplier.class);
	private final EClass eClass;
	/**
	 * Maps a supplier with the {@link EObject}s it contains.
	 * Note that these are <strong>copied</strong> objects, not original objects from suppliers.
	 */
	private final Multimap<Supplier<T>, EObject> map;
	private final T aggregate;
	private final EList<EReference> containments;

	@SuppressWarnings("unchecked")
	public AggregatingSupplier(EFactory eFactory, EClass eClass,
			List<Supplier<T>> suppliers) {
		super();
		this.eClass = eClass;
		this.map = Multimaps.synchronizedListMultimap(ArrayListMultimap.<Supplier<T>, EObject>create());
		aggregate = (T) eFactory.create(eClass);
		containments = aggregate.eClass().getEAllContainments();
		log.info("Initializing aggregating supplier for {} with {} suppliers", eClass, suppliers.size());
		for (Supplier<T> supplier : suppliers) {
			addSupplier(supplier);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addSupplier(Supplier<T> supplier) {
		log.debug("Adding supplier {} for {}", supplier, eClass.getName());
		int count = 0;
		T supplied = supplier.get();
		for (EReference containment : containments) {
			EList<EObject> suppliedContainment = (EList<EObject>) supplied
					.eGet(containment);
			log.debug("Aggregating {} {} from {} to {}.{}",
					suppliedContainment.size(), containment
							.getEReferenceType().getName(), supplier,
					eClass.getName(), containment.getName());
			EList<EObject> aggregateContainment = (EList<EObject>) aggregate
					.eGet(containment);
			final Collection<EObject> copied = EcoreUtil
					.copyAll(suppliedContainment);
			aggregateContainment.addAll(copied);
			map.putAll(supplier, copied);
			count += copied.size();
		}
		log.info("Added {} models from supplier {} for {}", count, supplier, eClass.getName());
	}

	public void removeSupplier(Supplier<T> supplier) {
		log.debug("Removing supplier {} for {}", supplier, eClass.getName());
		final Collection<EObject> models = ImmutableList.copyOf(map.get(supplier));
		for (EObject model : models) {
			EcoreUtil.remove(model);
		}
		map.removeAll(supplier);
		log.info("Removed {} models from supplier {} for {}", models.size(), supplier, eClass.getName());
	}

	@Override
	public T get() {
		return aggregate;
	}

}
