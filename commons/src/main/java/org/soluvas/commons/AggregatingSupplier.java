package org.soluvas.commons;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * Aggregate (not federate) contents from {@link EObject} {@link Supplier}s.
 * 
 * {@link Positionable#getPositioner()} is honored if provided.
 * 
 * Usage:
 * <pre>{@literal
 * 	<reference id="securityPackage" interface="org.soluvas.security.SecurityPackage" />
 * 	<bean id="aggregatingSecurityCatalogSupplier" class="org.soluvas.commons.AggregatingSupplier"
 * 		destroy-method="destroy" depends-on="securityPackage">
 * 		<argument ref="securityPackage" />
 * 		<argument value="SecurityCatalog" />
 * 		<argument>
 * 			<list />
 * 		</argument>
 * 	</bean>
 * 	<service ref="aggregatingSecurityCatalogSupplier" auto-export="interfaces">
 * 		<service-properties>
 * 			<entry key="clientId" value="${clientId}" />
 * 			<entry key="tenantEnv" value="${tenantEnv}" />
 * 			<entry key="tenantId" value="${tenantId}" />
 * 			<entry key="suppliedClass" value="org.soluvas.security.SecurityCatalog" />
 * 			<entry key="layer" value="application" />
 * 		</service-properties>
 * 	</service>
 * 	
 * 	<bean id="securityCatalogSupplierTracker" class="org.soluvas.commons.SupplierTracker">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument ref="aggregatingSecurityCatalogSupplier" />
 * 	</bean>
 * 	<bean class="org.osgi.util.tracker.ServiceTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument>
 * 			<bean class="org.osgi.framework.FrameworkUtil" factory-method="createFilter">
 * 				<argument value="(&amp;(objectClass=com.google.common.base.Supplier)(suppliedClass=org.soluvas.security.SecurityCatalog)(tenantId=berbatik)(layer=module))" />
 * 			</bean>
 * 		</argument>
 * 		<argument ref="securityCatalogSupplierTracker" />
 * 	</bean>
 * 	
 * 	<bean id="securityCatalogXmiTracker" class="org.soluvas.commons.XmiTracker">
 * 		<argument value="org.soluvas.security.SecurityPackage" />
 * 		<argument value="org.soluvas.security.SecurityCatalog" />
 * 		<argument value="${tenantId}" />
 * 		<argument value="${tenantEnv}" />
 * 	</bean>
 * 	<bean class="org.osgi.util.tracker.BundleTracker" init-method="open" destroy-method="close">
 * 		<argument ref="blueprintBundleContext" />
 * 		<argument value="32" />
 * 		<argument ref="securityCatalogXmiTracker" />
 * 	</bean>
 * }</pre>
 * 
 * @todo Support for propagating EMF Notify changes.
 * @author ceefour
 */
public class AggregatingSupplier<T extends EObject> implements Supplier<T>, DelegatingSupplier<T> {

	private static final Logger log = LoggerFactory
			.getLogger(AggregatingSupplier.class);
	private final EClass eClass;
	/**
	 * Maps a supplier with the {@link EObject}s it contains.
	 * Note that these are <strong>copied</strong> objects, not original objects from suppliers.
	 */
	private final Multimap<Supplier<T>, EObject> map;
	/**
	 * The created EObject that will hold all contents.
	 */
	private final T aggregate;
	/**
	 * Containment {@link EReference}s that will be used to find what things
	 * to aggregate.
	 */
	private final List<EReference> containments;

	@SuppressWarnings("unchecked")
	public AggregatingSupplier(EFactory eFactory, EClass eClass, List<Supplier<T>> suppliers) {
		super();
		this.eClass = eClass;
		this.map = Multimaps.synchronizedListMultimap(ArrayListMultimap.<Supplier<T>, EObject>create());
		aggregate = (T) eFactory.create(eClass);
		containments = aggregate.eClass().getEAllContainments();
		log.info("Initializing aggregating supplier for {} with {} suppliers", eClass, suppliers.size());
		for (final Supplier<T> supplier : suppliers) {
			addSupplier(supplier);
		}
	}
	
	public AggregatingSupplier(EPackage ePackage, String eClassName, List<Supplier<T>> suppliers) {
		this(ePackage.getEFactoryInstance(), (EClass) ePackage.getEClassifier(eClassName), suppliers);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.commons.DelegatingSupplier#addSupplier(com.google.common.base.Supplier)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public synchronized void addSupplier(Supplier<T> supplier) {
		log.debug("Adding supplier {} for {}", supplier, eClass.getName());
		long count = 0;
		final T supplied = supplier.get();
		for (final EReference containment : containments) {
			final EList<EObject> suppliedContainment = (EList<EObject>) supplied
					.eGet(containment);
			log.debug("Aggregating {} {} from {} to {}.{}",
					suppliedContainment.size(), containment
							.getEReferenceType().getName(), supplier,
					eClass.getName(), containment.getName());
			final EList<EObject> aggregateContainment = (EList<EObject>) aggregate
					.eGet(containment);
			final Collection<EObject> copiedChildren = EcoreUtil
					.copyAll(suppliedContainment);
			for (final EObject copiedChild : copiedChildren) {
				// find the proper sorted position for this new child
				final int childPositioner = copiedChild instanceof Positionable ? Optional.fromNullable(((Positionable) copiedChild).getPositioner()).or(0) : 0;
				int newIndex = Iterables.indexOf(aggregateContainment, new Predicate<EObject>() {
					@Override
					public boolean apply(@Nullable EObject input) {
						final int existingPositioner = input instanceof Positionable ? Optional.fromNullable(((Positionable) input).getPositioner()).or(0) : 0;
						return existingPositioner > childPositioner;
					}
				});
				log.trace("Adding {}[{}] at {} of {}", copiedChild.eClass().getName(),
						copiedChild instanceof Positionable ? childPositioner : "NA",
							newIndex, aggregateContainment.size());
				if (newIndex >= 0) {
					aggregateContainment.add(newIndex, copiedChild);
				} else {
					aggregateContainment.add(copiedChild);
				}
			}
			map.putAll(supplier, copiedChildren);
			count += copiedChildren.size();
		}
		log.info("Added {} models from supplier {} for {}", count, supplier, eClass.getName());
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.DelegatingSupplier#removeSupplier(com.google.common.base.Supplier)
	 */
	@Override
	public synchronized void removeSupplier(Supplier<T> supplier) {
		log.debug("Removing supplier {} ({}) for {}", supplier, supplier.getClass().getName(), eClass.getName());
		final int removedModelCount = doRemoveSupplier(supplier);
		log.info("Removed {} models from supplier {} ({}) for {}", 
				removedModelCount, supplier, supplier.getClass().getName(), eClass.getName());
	}

	protected int doRemoveSupplier(Supplier<T> supplier) {
		final Collection<EObject> models = ImmutableList.copyOf(map.get(supplier));
		for (final EObject model : models) {
			EcoreUtil.remove(model);
		}
		map.removeAll(supplier);
		return models.size();
	}

	protected void removeSuppliers(Collection<Supplier<T>> removedSuppliers) {
		log.debug("Removing suppliers {} for {}", removedSuppliers, eClass.getName());
		int removedModelCount = 0;
		for (Supplier<T> supplier : removedSuppliers) {
			removedModelCount += doRemoveSupplier(supplier);
		}
		log.info("Removed {} models from suppliers {} for {}", removedModelCount, removedSuppliers, eClass.getName());
	}

	@Override
	public T get() {
		return aggregate;
	}

	@Override @PreDestroy
	public void destroy() {
		removeSuppliers(ImmutableList.copyOf(map.keys()));
	}

}
