package org.soluvas.data.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.RelationshipType;

import com.google.common.base.Optional;

/**
 * A {@link Neo4jIdRelationRepository} where both the left and right IDs
 * are {@link String}s.
 * @author ceefour
 */
public class Neo4jStringIdRelationRepository extends
		Neo4jIdRelationRepository<String, String> {

	/**
	 * @param graphDb
	 * @param relationshipType
	 * @param leftKind
	 * @param rightKind
	 * @param leftIdxName
	 * @param rightIdxName
	 */
	public Neo4jStringIdRelationRepository(GraphDatabaseService graphDb,
			RelationshipType relationshipType, String leftKind,
			String rightKind, String leftIdxName, String rightIdxName) {
		super(graphDb, relationshipType, leftKind, rightKind, leftIdxName, rightIdxName);
	}

	@Override
	protected int compareLeft(String o1, String o2) {
		return Optional.fromNullable(o1).or("").compareToIgnoreCase(Optional.fromNullable(o2).or(""));
	}

	@Override
	protected int compareRight(String o1, String o2) {
		return Optional.fromNullable(o1).or("").compareToIgnoreCase(Optional.fromNullable(o2).or(""));
	}

}
