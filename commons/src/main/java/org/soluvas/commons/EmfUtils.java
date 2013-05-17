package org.soluvas.commons;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;

/**
 * @author rudi
 *
 */
public class EmfUtils {

	private static final Logger log = LoggerFactory.getLogger(EmfUtils.class);
	
	/**
	 * Synchronized so that access to global {@link EPackage} Registry is safe.
	 * @param pkg
	 * @return
	 */
	public static synchronized EPackage getEPackage(Class<? extends EPackage> pkg) {
		try {
			final Field eInstanceField = pkg.getDeclaredField("eINSTANCE");
			final EPackage ePackage = (EPackage) eInstanceField.get(pkg);
			return ePackage;
		} catch (Exception e) {
			throw new CommonsException(e, "Cannot get EPackage for %s",
					pkg.getName());
		}
	}

	/**
	 * Synchronized so that access to global {@link EFactory} Registry (is there any?) is safe.
	 * The EFactory will access EPackage anyway.
	 * @param eFactoryClass
	 * @return
	 */
	public static synchronized EFactory getEFactory(Class<? extends EFactory> eFactoryClass) {
		try {
			Field eInstanceField = eFactoryClass.getDeclaredField("eINSTANCE");
			EFactory eFactory = (EFactory) eInstanceField.get(eFactoryClass);
			Preconditions.checkNotNull(eFactory, "Cannot get EFactory for %s", eFactoryClass.getName());
			return eFactory;
		} catch (Exception e) {
			Throwables.propagate(e);
			return null;
		}
	}

	public static EClass getEClass(Class<? extends EPackage> ePackageClass, String eClassName) {
		final EPackage ePackage = getEPackage(ePackageClass);
//		EFactory eFactory = getEFactory(eFactoryClass);
//		final EPackage ePackage = eFactory.getEPackage();
//		Preconditions.checkNotNull(ePackage, "Cannot get EPackage for EFactory %s", eFactoryClass.getName());
		EClass eClass = (EClass) ePackage.getEClassifier(eClassName);
		return eClass;
	}

	/**
	 * Overlays another {@link EObject} on top of an existing {@link EObject}.
	 * @param current
	 * @param overlay
	 */
	public static void combineEObject(EObject current, EObject overlay) {
		for (EAttribute attr : overlay.eClass().getEAllAttributes()) {
			Object attrValue = overlay.eGet(attr);
			if (overlay.eIsSet(attr) && attrValue != null) {
				log.trace("Override {}.{} to {}", current.eClass().getName(), attr.getName(), attrValue);
				try {
					current.eSet(attr, attrValue);
				} catch (Exception e) {
					throw new CommonsException(String.format("Cannot override %s.%s to %s", 
							current.eClass().getName(), attr.getName(), attrValue), e);
				}
			}
		}
		for (EReference containment : overlay.eClass().getEAllContainments()) {
			EObject currentContainment = (EObject) current.eGet(containment);
			EObject overlayContainment = (EObject) overlay.eGet(containment);
			if (overlay.eIsSet(containment) && overlayContainment != null) {
				if (currentContainment != null) {
					combineEObject(currentContainment, overlayContainment);
				} else {
					// current doesn't have this containment, so directly set using a copied instance
					log.debug("Setting {}.{} to {}", current.eClass().getName(), containment.getName(), overlayContainment);
					current.eSet(containment, EcoreUtil.copy(overlayContainment));
				}
			}
		}
	}
	
}
