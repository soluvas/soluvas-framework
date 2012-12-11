package org.soluvas.social;


/**
 * @author rully
 *
 */
public interface TargetFinder<T extends Target> {
	
	public T findOne(String id);

}
