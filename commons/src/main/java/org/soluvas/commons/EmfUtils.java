package org.soluvas.commons;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rudi
 *
 */
public class EmfUtils {

	private static transient Logger log = LoggerFactory.getLogger(EmfUtils.class);
	
	/**
	 * Overlays another {@link EObject} on top of an existing {@link EObject}.
	 * @param current
	 * @param overlay
	 */
	public static void combineEObject(EObject current, EObject overlay) {
		for (EAttribute attr : overlay.eClass().getEAllAttributes()) {
			Object attrValue = overlay.eGet(attr);
			if (overlay.eIsSet(attr) && attrValue != null) {
				log.trace("Override {}.{} to {}", new Object[] { current.eClass().getName(), attr.getName(), attrValue });
				current.eSet(attr, attrValue);
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
					log.debug("Setting {}.{} to {}", new Object[] { current.eClass().getName(), containment.getName(), overlayContainment });
					current.eSet(containment, EcoreUtil.copy(overlayContainment));
				}
			}
		}
	}
	
}
