package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Optional;
import com.google.common.collect.Ordering;

/**
 * Orders any {@link EObject} based on <tt>name</tt> attribute (must exist).
 * 
 * @author ceefour
 */
public class EObjectNameOrdering extends Ordering<EObject> {

	@Override
	public int compare(EObject left, EObject right) {
		if (left == null || right == null)
			return 0;
		String leftName = Optional.fromNullable(
				(String) left.eGet(left.eClass().getEStructuralFeature(
						"name"))).or("");
		String rightName = Optional.fromNullable(
				(String) right.eGet(right.eClass().getEStructuralFeature(
						"name"))).or("");
		return leftName.compareToIgnoreCase(rightName);
	};

}