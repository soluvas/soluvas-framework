package org.soluvas.data.domain;

import java.io.Serializable;

import org.neo4j.graphdb.Relationship;
import org.soluvas.data.repository.EdgeRepository;

/**
 * Used by {@link EdgeRepository}.
 * This can represent a Like/Follow {@link Relationship}, or a Wink node. 
 * @author ceefour
 */
public interface Edge<L, R> extends Serializable {
	
	/**
	 * Get the left vertex.
	 * @return
	 */
	public abstract L getLeft();
	
	/**
	 * Get the right vertex.
	 * @return
	 */
	public abstract R getRight();

}
