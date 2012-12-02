package org.soluvas.data.neo4j;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.index.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.DataException;
import org.soluvas.data.EntityShadow;
import org.soluvas.data.repository.AssocRepositoryBase;
import org.soluvas.data.repository.IdAssocRepository;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;

/**
 * Used by {@link Neo4jRelationRepository} for ID-based operations.
 * using Neo4j graph database.
 * @author ceefour
 */
public abstract class Neo4jIdRelationRepository<LID  extends Serializable, RID extends Serializable> extends AssocRepositoryBase<LID, RID>
	implements IdAssocRepository<LID, RID> {

	/**
	 * ID property as it appears on a Neo4j {@link Node}. 
	 */
	private static final String idProperty = "_rowId";

	private static Logger log = LoggerFactory.getLogger(Neo4jIdRelationRepository.class);

//	private final GraphDatabaseService graphDb;
	private final RelationshipType relationshipType;
	private final LID leftKind;
	private final RID rightKind;
	private final String leftIdxName;
	private final String rightIdxName;
	private final ExecutionEngine executionEngine;
	private final Index<Node> leftIdx;
	private final Index<Node> rightIdx;
	
	protected abstract int compareLeft(LID o1, LID o2);
	protected abstract int compareRight(RID o1, RID o2);
	
	/**
	 * @param graphDb
	 * @param prefix Sets the prefix in multitenant environments, e.g. <tt>berbatik_dev</tt>.
	 */
	public Neo4jIdRelationRepository(@Nonnull final GraphDatabaseService graphDb,
			@Nonnull final RelationshipType relationshipType,
			@Nonnull final LID leftKind, @Nonnull final RID rightKind,
			@Nonnull final String leftIdxName, @Nonnull final String rightIdxName) {
		super();
		log.info("Initializing Neo4j {} Repository with left={} right={} using {}",
				relationshipType, leftIdxName, rightIdxName, graphDb);
//		this.graphDb = graphDb;
		this.relationshipType = relationshipType;
		this.leftKind = leftKind;
		this.rightKind = rightKind;
		this.leftIdxName = leftIdxName;
		this.rightIdxName = rightIdxName;
		leftIdx = Neo4jUtils.ensureIndex(graphDb, leftIdxName);
		rightIdx = Neo4jUtils.ensureIndex(graphDb, rightIdxName);
		executionEngine = new ExecutionEngine(graphDb);
	}
	
	@SuppressWarnings("unchecked")
	@Override @Nonnull
	public NavigableMap<RID, Long> getLeftCounts() {
		final String query = "START right = node:" + rightIdxName + "('*:*') " +
				"MATCH left -[rel:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN right." + idProperty + " AS rightId, COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		ImmutableSortedMap.Builder<RID, Long> builder = ImmutableSortedMap.orderedBy(new Comparator<RID>() {
			@Override
			public int compare(RID o1, RID o2) {
				return compareRight(o1, o2);
			}
		});
		for (final Map<String, Object> row : rows) {
			final RID rightId = (RID) row.get("rightId");
			final Long relCount = (Long)row.get("relCount");
			builder.put(rightId, relCount);
		}
		final NavigableMap<RID, Long> result = builder.build();
		log.info("getLeftCounts {} returned {} rights: {} - {}", 
				relationshipType, result.size(), query, params);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override @Nonnull
	public NavigableMap<LID, Long> getRightCounts() {
		final String query = "START left = node:" + leftIdxName + "('*:*') " +
				"MATCH left -[:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left." + idProperty + " AS leftId, COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		ImmutableSortedMap.Builder<LID, Long> builder = ImmutableSortedMap.orderedBy(new Comparator<LID>() {
			@Override
			public int compare(LID o1, LID o2) {
				return compareLeft(o1, o2);
			}
		});
		for (final Map<String, Object> row : rows) {
			final LID leftId = (LID) row.get("leftId");
			final Long relCount = (Long) row.get("relCount");
			builder.put(leftId, relCount);
		}
		final NavigableMap<LID, Long> result = builder.build();
		log.info("getRightCounts {} returned {} lefts: {} - {}", 
				relationshipType, result.size(), query, params);
		return result;
	}
	
	/**
	 * Check whether a {@link Node} likes another {@link Node}.
	 * @param left
	 * @param right
	 */
	public Relationship getRelationship(@Nonnull final Node left, @Nonnull final Node right) {
		Preconditions.checkNotNull(left, "left node cannot be null");
		Preconditions.checkNotNull(right, "right node cannot be null");
		
		final String query = "START left = node({leftNodeId}), right = node({rightNodeId}) " +
				"MATCH left -[rel:" + relationshipType.name() + "]-> right " +
				"RETURN rel";
		final long leftNodeId = left.getId();
		final long rightNodeId = right.getId();
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftNodeId", leftNodeId, "rightNodeId", rightNodeId);
		final ExecutionResult rows = executionEngine.execute(query, params);
		log.trace("getRelationship {} #{} -{}-> {} #{} returned {}: {} - {}",
				leftKind, leftNodeId, relationshipType, rightKind, rightNodeId, rows, query, params);
		final Map<String, Object> row = Iterables.getFirst(rows, null);
		if (row != null) {
			return (Relationship) row.get("rel");
		} else {
			return null;
		}
	}
	
	/**
	 * Check whether a {@link Node} likes another {@link Node}.
	 * @param liking
	 * @param liked
	 */
	public Relationship getRelationship(@Nonnull final LID leftId, @Nonnull final RID rightId) {
		Preconditions.checkNotNull(leftId, "leftId cannot be null");
		Preconditions.checkNotNull(rightId, "rightId cannot be null");
		
		final String query = "START left=node:" + leftIdxName + "(_rowId={leftId}), " +
				"right = node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[rel:" + relationshipType.name() + "]-> right " +
				"RETURN rel";
		final Map<String, Object> params = ImmutableMap.<String, Object>of("leftId", leftId, "rightId", rightId);
		final ExecutionResult rows = executionEngine.execute(query, params);
		log.trace("getRelationship {} {} -{}-> {} {} returned {}: {} - {}",
				leftKind, leftId, relationshipType, rightKind, rightId, rows, query, params);
		final Map<String, Object> row = Iterables.getFirst(rows, null);
		if (row != null) {
			return (Relationship) row.get("rel");
		} else {
			return null;
		}
	}
	
	@Override
	public long countRights(LID leftId) {
		final String query = "START left=node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[rel:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftId", leftId, "leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		final long count = (Long) Iterators.getOnlyElement(rows.columnAs("relCount"), 0L);
		log.info("{} countRights {} {} returned {} {}(s): {} - {}",
				relationshipType, leftKind, leftId, count, rightKind, query, params);
		return count;
	}
	
	@Override
	public long countLefts(RID rightId) {
		final String query = "START right = node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[rel:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"rightId", rightId, "leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		final long count = (Long) Iterators.getOnlyElement(rows.columnAs("relCount"), 0L);
		log.info("{} countRights {} {} returned {} {}(s): {} - {}",
				relationshipType, rightKind, rightId, count, leftKind, query, params);
		return count;
	}
	
	/**
	 * Only works if the leftId and rightId already exists in the graph database.
	 * If any of the IDs don't already exist, will throw {@link DataException}.
	 * The proper way to put a relation is by using the {@link EntityShadow}-supporting repository
	 * implementation.
	 * @see org.soluvas.data.repository.AssocRepository#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean put(LID leftId, RID rightId) {
		final Node leftNode 	= Neo4jUtils.getOnlyElement(leftIdx.get(idProperty, leftId), null);
		if (leftNode == null)
			throw new DataException("Cannot find " + leftKind + " node in index " + leftIdxName + " with ID " + leftId);
		final Node rightNode 	= Neo4jUtils.getOnlyElement(rightIdx.get(idProperty, rightId), null);
		if (rightNode == null)
			throw new DataException("Cannot find " + rightKind + " node in index " + rightIdxName + " with ID " + rightId);
		Relationship rel = getRelationship(leftNode, rightNode);
		if (rel == null) {
			try {
				rel = leftNode.createRelationshipTo(rightNode, relationshipType);
				log.info("Added relationship {}: {} {} -{}-> {} {}", rel,
						leftKind, leftId, relationshipType, rightKind, rightId );
				return true;
			} catch (Exception e) {
				throw new DataException(String.format("Cannot add relationship: %s %s -%s-> %s %s",
						leftKind, leftId, relationshipType, rightKind, rightId), e); 
			}
		} else {
			log.info("Relationship {} already exists: {} {} -{}-> {} {}", rel,
						leftKind, leftId, relationshipType, rightKind, rightId );
			return false;
		}
	}

	@Override
	public boolean delete(LID leftId, RID rightId) {
		final Relationship rel = getRelationship(leftId, rightId);
		if (rel != null) {
			log.info("Delete relationship {} {} -{}-> {} {}: {}",
					leftKind, leftId, relationshipType, rightKind, rightId, rel);
			rel.delete();
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Nonnull
	public Multimap<LID, RID> findAll() {
		return findAllLimit(null);
	}

	@SuppressWarnings("unchecked")
	@Nonnull
	public Multimap<LID, RID> findAllLimit(@Nullable Long limit) {
		final String query = "START left=node:" + leftIdxName + "('*:*') " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left." + idProperty + " AS leftId, right." + idProperty + " AS rightId" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final ImmutableMultimap.Builder<LID, RID> resultBuilder = ImmutableMultimap.builder();
		for (final Map<String, Object> row : rows) {
			final LID left = (LID) row.get("leftId");
			final RID right = (RID) row.get("rightId");
			resultBuilder.put(left, right);
		}
		final Multimap<LID, RID> result = resultBuilder.build();
		log.info("findAll {} -{}-> {} limit {} returned {} relationships: {} - {}",
				leftKind, relationshipType, rightKind, limit, result.size(), query, params);
		return result;
	}

	@Override @Nonnull
	public Collection<RID> getLeft(LID left) {
		return getLeftLimit(left, null);
	}
	
	public Collection<RID> getLeftLimit(LID leftId, Long limit) {
		final String query = "START left=node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN right." + idProperty + " AS rightId" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("leftId", leftId);
		paramsBuilder.put("leftKind", rightKind);
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final List<RID> matchingRightIds = ImmutableList.copyOf(rows.<RID>columnAs("rightId"));
		log.info("getLeft {} {} limit {} returned {} {} rights: {} - {}",
				leftKind, leftId, limit, matchingRightIds.size(), rightKind, query, params);
		return matchingRightIds;
	}

	@Override @Nonnull
	public Collection<LID> getRight(RID rightId) {
		return getRightLimit(rightId, null);
	}
	
	public Collection<LID> getRightLimit(RID rightId, @Nullable Long limit) {
		final String query = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[:LIKE]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left." + idProperty + " AS leftId" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("rightId", rightId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final List<LID> matchingLeftIds = ImmutableList.copyOf(rows.<LID>columnAs("leftId"));
		log.info("getRight {} {} limit {} returned {} {} lefts: {} - {}",
				rightKind, rightId, limit, matchingLeftIds.size(), leftKind, query, params);
		return matchingLeftIds;
	}

}
