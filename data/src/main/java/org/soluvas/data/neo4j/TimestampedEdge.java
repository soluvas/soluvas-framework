package org.soluvas.data.neo4j;

import org.joda.time.DateTime;
import org.neo4j.cypher.internal.symbols.RelationshipType;
import org.soluvas.data.domain.Edge;

/**
 * A basic {@link Edge} with {@code creationTime} and {@code modificationTime}.
 * @todo Should we put {@link RelationshipType}, leftKind, rightKind, leftId, rightId ?
 * @author ceefour
 */
public class TimestampedEdge<L, R> implements Edge<L, R> {
	
	private static final long serialVersionUID = 1L;
	private final L left;
	private final R right;
	private final DateTime creationTime;
	private final DateTime modificationTime;
	
	/**
	 * @param left
	 * @param right
	 * @param creationTime
	 * @param modificationTime
	 */
	public TimestampedEdge(L left, R right, DateTime creationTime,
			DateTime modificationTime) {
		super();
		this.left = left;
		this.right = right;
		this.creationTime = creationTime;
		this.modificationTime = modificationTime;
	}
	
	/**
	 * @return the left
	 */
	@Override
	public L getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	@Override
	public R getRight() {
		return right;
	}

	/**
	 * @return the creationTime
	 */
	public DateTime getCreationTime() {
		return creationTime;
	}

	/**
	 * @return the modificationTime
	 */
	public DateTime getModificationTime() {
		return modificationTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimestampedEdge ["
				+ (left != null ? "left=" + left + ", " : "")
				+ (right != null ? "right=" + right + ", " : "")
				+ (creationTime != null ? "creationTime=" + creationTime + ", "
						: "")
				+ (modificationTime != null ? "modificationTime="
						+ modificationTime : "") + "]";
	}

}
