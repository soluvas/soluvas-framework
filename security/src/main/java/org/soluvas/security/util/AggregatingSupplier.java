package org.soluvas.security.util;

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

/**
 * @author ceefour
 */
public class AggregatingSupplier<T extends EObject> implements Supplier<T> {

	private transient Logger log = LoggerFactory
			.getLogger(AggregatingSupplier.class);
	private final EFactory eFactory;
	private final EClass eClass;
	private final List<Supplier<T>> suppliers;

	public AggregatingSupplier(EFactory eFactory, EClass eClass,
			List<Supplier<T>> suppliers) {
		super();
		this.eFactory = eFactory;
		this.eClass = eClass;
		this.suppliers = suppliers;
		log.info("Initializing aggregating supplier for {} with {} suppliers", eClass, suppliers.size());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		T aggregate = (T) eFactory.create(eClass);
		EList<EReference> containments = aggregate.eClass()
				.getEAllContainments();
		for (Supplier<T> supplier : suppliers) {
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
				aggregateContainment.addAll(EcoreUtil
						.copyAll(suppliedContainment));
			}
		}
		return aggregate;
	}
	

}
