package org.soluvas.data.neo4j;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.DataException;
import org.soluvas.data.EntityShadow;
import org.soluvas.data.repository.AssocRepositoryBase;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Multimap;

/**
 * Base class useful to implement Like and Follow social features,
 * It requires both left and right {@link EntityShadow}s, and uses
 * an {@link Neo4jStringIdRelationRepository} underneath.
 * using Neo4j graph database.
 * @author ceefour
 */
public abstract class Neo4jRelationRepository<L, R> extends AssocRepositoryBase<L, R> {

	private static Logger log = LoggerFactory.getLogger(Neo4jRelationRepository.class);

//	private final GraphDatabaseService graphDb;
	private final RelationshipType relationshipType;
	private final String leftKind;
	private final String rightKind;
	private final String leftIdxName;
	private final String rightIdxName;
	private final EntityShadow<L, String, Node> leftShadow;
	private final EntityShadow<R, String, Node> rightShadow;
	private final ExecutionEngine executionEngine;
	private final Neo4jStringIdRelationRepository idRepo;
	
	/**
	 * @param graphDb
	 * @param prefix Sets the prefix in multitenant environments, e.g. <tt>berbatik_dev</tt>.
	 */
	public Neo4jRelationRepository(@Nonnull final GraphDatabaseService graphDb,
			@Nonnull final RelationshipType relationshipType,
			@Nonnull final String leftKind, @Nonnull final String rightKind,
			@Nonnull final String leftIdxName, @Nonnull final String rightIdxName,
			@Nonnull final EntityShadow<L, String, Node> leftShadow,
			@Nonnull final EntityShadow<R, String, Node> rightShadow) {
		super();
		log.info("Initializing Neo4j {} Repository with left={} right={} using {}",
				relationshipType, leftIdxName, rightIdxName, graphDb);
//		this.graphDb = graphDb;
		this.relationshipType = relationshipType;
		this.leftKind = leftKind;
		this.rightKind = rightKind;
		this.leftIdxName = leftIdxName;
		this.rightIdxName = rightIdxName;
		Neo4jUtils.ensureIndex(graphDb, leftIdxName);
		Neo4jUtils.ensureIndex(graphDb, rightIdxName);
		this.leftShadow = leftShadow;
		this.rightShadow = rightShadow;
		executionEngine = new ExecutionEngine(graphDb);
		idRepo = new Neo4jStringIdRelationRepository(graphDb, relationshipType, leftKind, rightKind, leftIdxName, rightIdxName);
	}
	
	@Override @Nonnull
	public NavigableMap<R, Long> getLeftCounts() {
		final String query = "START right = node:" + rightIdxName + "('*:*') " +
				"MATCH left -[rel:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN right, COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		ImmutableSortedMap.Builder<R, Long> builder = ImmutableSortedMap.orderedBy(new Comparator<R>() {
			@Override
			public int compare(R o1, R o2) {
				return getRightId(o1).compareToIgnoreCase( getRightId(o2) );
			}
		});
		for (final Map<String, Object> row : rows) {
			final Node rightNode = (Node)row.get("right");
			final R right = rightShadow.realize(rightNode);
			final Long relCount = (Long)row.get("relCount");
			builder.put(right, relCount);
		}
		final NavigableMap<R, Long> result = builder.build();
		log.info("getLeftCounts {} returned {} rights: {} - {}", 
				relationshipType, result.size(), query, params);
		return result;
	}
	
	@Override @Nonnull
	public NavigableMap<L, Long> getRightCounts() {
		final String query = "START left = node:" + leftIdxName + "('*:*') " +
				"MATCH left -[:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left, COUNT(rel) AS relCount";
		final Map<String, Object> params = ImmutableMap.<String, Object>of(
				"leftKind", leftKind, "rightKind", rightKind);
		final ExecutionResult rows = executionEngine.execute(query, params);
		ImmutableSortedMap.Builder<L, Long> builder = ImmutableSortedMap.orderedBy(new Comparator<L>() {
			@Override
			public int compare(L o1, L o2) {
				return getLeftId(o1).compareToIgnoreCase( getLeftId(o2) );
			}
		});
		for (final Map<String, Object> row : rows) {
			final Node leftNode = (Node)row.get("left");
			final L left = leftShadow.realize(leftNode);
			final Long relCount = (Long)row.get("relCount");
			builder.put(left, relCount);
		}
		final NavigableMap<L, Long> result = builder.build();
		log.info("getRightCounts {} returned {} lefts: {} - {}", 
				relationshipType, result.size(), query, params);
		return result;
	}
	
	/**
	 * Check whether a {@link Node} likes another {@link Node}.
	 * @param left
	 * @param right
	 */
	protected Relationship getRelationship(@Nonnull final Node left, @Nonnull final Node right) {
		return idRepo.getRelationship(left, right);
	}
	
	/**
	 * Check whether a {@link Node} likes another {@link Node}.
	 * @param liking
	 * @param liked
	 */
	protected Relationship getRelationship(@Nonnull final String leftId, @Nonnull final String rightId) {
		return idRepo.getRelationship(leftId, rightId);
	}
	
	@Override
	public long countRights(L left) {
		return idRepo.countRights(getLeftId(left));
	}
	
	@Override
	public long countLefts(R right) {
		return idRepo.countLefts(getRightId(right));
	}
	
	@Override
	public boolean put(L left, R right) {
		final Node leftNode 	= leftShadow.ensure(left); //for person
		final Node rightNode 	= rightShadow.ensure(right); //for product 
		final String leftId = getLeftId(left);
		final String rightId = getRightId(right);
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
	public boolean delete(L left, R right) {
		// TODO: use cypher, especially for deleteAll
		final String leftId = getLeftId(left);
		final String rightId = getRightId(right);
		return idRepo.delete(leftId, rightId);
	}

	@Override
	@Nonnull
	public Multimap<L, R> findAll() {
		return findAllLimit(null);
	}

	@Nonnull
	public Multimap<L, R> findAllLimit(@Nullable Long limit) {
		final String query = "START left=node:" + leftIdxName + "('*:*') " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left, right" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final ImmutableMultimap.Builder<L, R> resultBuilder = ImmutableMultimap.builder();
		for (final Map<String, Object> row : rows) {
			final L left = leftShadow.realize((Node) row.get("left"));
			final R right = rightShadow.realize((Node) row.get("right"));
			resultBuilder.put(left, right);
		}
		final Multimap<L, R> result = resultBuilder.build();
		log.info("findAll {} -{}-> {} limit {} returned {} relationships: {} - {}",
				leftKind, relationshipType, rightKind, limit, result.size(), query, params);
		return result;
	}

	@Override @Nonnull
	public Collection<R> getLeft(L left) {
		return getLeft(left, null);
	}
	
	protected abstract String getLeftId(L left);
	protected abstract String getRightId(R right);

	public Collection<R> getLeft(L left, Long limit) {
		final String query = "START left=node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN right" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		final String leftId = getLeftId(left);
		paramsBuilder.put("leftId", leftId);
		paramsBuilder.put("leftKind", rightKind);
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final List<Node> matchingRightNodes = ImmutableList.copyOf(rows.<Node>columnAs("right"));
		final Collection<R> matchingRights = rightShadow.realize(matchingRightNodes);
		log.info("getLeft {} {} limit {} returned {} {} rights: {} - {}",
				leftKind, leftId, limit, matchingRights.size(), rightKind, query, params);
		
		return matchingRights;
	}

	@Override @Nonnull
	public Collection<L> getRight(R right) {
		return getRight(right, null);
	}
	
	public Collection<L> getRight(R right, @Nullable Long limit) {
		final String query = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[:LIKE]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left" +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		final String rightId = getRightId(right);
		paramsBuilder.put("rightId", rightId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final List<Node> matchingLeftNodes = ImmutableList.copyOf(rows.<Node>columnAs("left"));
		final Collection<L> matchingLefts = leftShadow.realize(matchingLeftNodes);
		log.info("getRight {} {} limit {} returned {} {} lefts: {} - {}",
				rightKind, rightId, limit, matchingLefts.size(), leftKind, query, params);
		return matchingLefts;
	}

}
