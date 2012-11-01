package org.soluvas.data.query;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class Criteria implements Serializable {
	
	private List<Criterion<?>> criterions = ImmutableList.of();

	public Criteria() {
		super();
	}
	
	public Criteria(Criterion<?> criterion) {
		super();
		this.criterions = ImmutableList.<Criterion<?>>of(criterion);
	}
	
	public Criteria(List<Criterion<?>> criterions) {
		super();
		this.criterions = criterions;
	}

	/**
	 * @return the criterions
	 */
	public List<Criterion<?>> getCriterions() {
		return criterions;
	}

	/**
	 * @param criterions the criterions to set
	 */
	public void setCriterions(List<Criterion<?>> criterions) {
		this.criterions = criterions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Criteria [criterions=%s]", criterions);
	}
	
}
