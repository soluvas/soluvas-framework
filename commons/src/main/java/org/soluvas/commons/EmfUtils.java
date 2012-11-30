package org.soluvas.commons;

import java.lang.reflect.Field;

import javax.annotation.Nonnull;

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

	private static transient Logger log = LoggerFactory.getLogger(EmfUtils.class);
	
	public static EPackage getEPackage(Class<? extends EPackage> pkg) {
		try {
			Field eInstanceField = pkg.getDeclaredField("eINSTANCE");
			EPackage ePackage = (EPackage) eInstanceField.get(pkg);
			return ePackage;
		} catch (Exception e) {
			Throwables.propagate(e);
			return null;
		}
	}

	public static EFactory getEFactory(@Nonnull Class<? extends EFactory> eFactoryClass) {
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

	public static EClass getEClass(@Nonnull Class<? extends EPackage> ePackageClass, @Nonnull String eClassName) {
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
					throw new RuntimeException(String.format("Cannot override %s.%s to %s", 
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
