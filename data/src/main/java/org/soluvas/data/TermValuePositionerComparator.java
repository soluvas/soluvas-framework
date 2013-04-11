package org.soluvas.data;

import java.util.Comparator;

import javax.annotation.Nullable;

/**
 * Compares a {@link TermValue} and another {@link TermValue} based on
 * {@link Term#getPositioner()}.
 * @author haidar
 */
public class TermValuePositionerComparator implements
		Comparator<TermValue> {
	private final TermManager termMgr;
	
	public TermValuePositionerComparator(TermManager termMgr) {
		super();
		this.termMgr = termMgr;
	}

	@Override
	public int compare(@Nullable TermValue left,
			@Nullable TermValue right) {
		Term leftTerm = termMgr.findTerm(left.getValue());
		Term rightTerm = termMgr.findTerm(right.getValue());
		if (leftTerm != null && leftTerm.getPositioner() != null && rightTerm != null && rightTerm.getPositioner() != null) {
			return leftTerm.getPositioner() - rightTerm.getPositioner(); 
		} else {
			return 0;
		}
	}
}