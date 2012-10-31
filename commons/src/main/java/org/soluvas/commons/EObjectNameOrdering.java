package org.soluvas.commons;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
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
		final EStructuralFeature leftNameFeature = left.eClass().getEStructuralFeature(
				"name");
		final EStructuralFeature rightNameFeature = right.eClass()
				.getEStructuralFeature("name");
		Preconditions.checkNotNull(leftNameFeature,
				"EClass %s must have 'name' feature", left.eClass().getName());
		Preconditions.checkNotNull(rightNameFeature,
				"EClass %s must have 'name' feature", right.eClass().getName());
		String leftName = Optional.fromNullable(
				(String) left.eGet(leftNameFeature)).or("");
		String rightName = Optional.fromNullable(
				(String) right.eGet(rightNameFeature)).or("");
		return leftName.compareToIgnoreCase(rightName);
	};

}