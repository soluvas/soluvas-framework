package org.soluvas.commons;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Optional;

/**
 * Compares based on {@code positioner} attribute, if present.
 * @author ceefour
 */
public class PositionerComparator<T extends EObject> implements Comparator<T> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T o1, T o2) {
		Integer positioner1 = o1 != null && o1 instanceof Positionable
				? Optional.fromNullable(((Positionable) o1).getPositioner()).or(0) : 0;
		Integer positioner2 = o2 != null && o2 instanceof Positionable
				? Optional.fromNullable(((Positionable) o2).getPositioner()).or(0) : 0;
		return positioner1 - positioner2;
	}

}
