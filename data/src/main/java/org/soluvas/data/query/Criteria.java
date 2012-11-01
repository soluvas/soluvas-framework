package org.soluvas.data.query;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @todo Evaluate or consider merging with: jOOQ (knows JDO Typesafe), Querydsl (supported by Spring),
 * Spring Data JPA Specification (who use it?), JPA Criteria (bad), JDO Typesafe (inspired by Querydsl), SDO.
 * I think Querydsl is best. As jOOQ is too SQL-specific. 
 * @author rudi
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
