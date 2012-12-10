package org.soluvas.data.neo4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.joda.time.DateTime;
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
import org.soluvas.data.domain.Edge;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
import org.soluvas.data.repository.AssocRepository;
import org.soluvas.data.repository.ExtendedAssocRepository;
import org.soluvas.data.repository.ExtendedAssocRepositoryBase;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;

/**
 * Base class useful to implement Like and Follow social features,
 * It requires both left and right {@link EntityShadow}s, and uses
 * an {@link Neo4jStringIdRelationRepository} underneath.
 * using Neo4j graph database.
 * @author ceefour
 */
public abstract class Neo4jRelationRepository<L, R> extends ExtendedAssocRepositoryBase<L, R, String, String> {

	public static class ToEdge<L, R> implements Function<Relationship, Edge<L, R>> {
		private final L left;
		private final R right;
		
		/**
		 * @param left
		 * @param right
		 */
		public ToEdge(L left, R right) {
			super();
			this.left = left;
			this.right = right;
		}

		@Override
		@Nullable
		public Edge<L, R> apply(@Nullable Relationship rel) {
			final String creationTimeStr = (String) rel.getProperty("creationTime", null);
			final DateTime creationTime = !Strings.isNullOrEmpty(creationTimeStr) ? new DateTime(creationTimeStr) : null;
			final String modificationTimeStr = (String) rel.getProperty("modificationTime", null);
			final DateTime modificationTime = !Strings.isNullOrEmpty(modificationTimeStr) ? new DateTime(modificationTimeStr) : null;
			return new TimestampedEdge<L, R>(left, right, creationTime, modificationTime);
		}

	}
	
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
	/**
	 * @todo Is this still needed, now that we have {@link ExtendedAssocRepository}?
	 */
	private final Neo4jStringIdRelationRepository idRepository;
	
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
		idRepository = new Neo4jStringIdRelationRepository(graphDb, relationshipType, leftKind, rightKind, leftIdxName, rightIdxName);
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
				"MATCH left -[rel:" + relationshipType + "]-> right " +
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
		return idRepository.getRelationship(left, right);
	}
	
	/**
	 * Check whether a {@link Node} likes another {@link Node}.
	 * @param liking
	 * @param liked
	 */
	protected Relationship getRelationship(@Nonnull final String leftId, @Nonnull final String rightId) {
		return idRepository.getRelationship(leftId, rightId);
	}
	
	@Override
	public long countRights(String leftId) {
		return idRepository.countRights(leftId);
	}
	
	@Override
	public long countLefts(String rightId) {
		return idRepository.countLefts(rightId);
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
				rel.setProperty("creationTime", new DateTime().toString());
				rel.setProperty("modificationTime", new DateTime().toString());
				log.info("Added relationship {}: {} #{} {} -{}-> {} #{} {}", rel,
						leftKind, leftNode.getId(), leftId, relationshipType, rightKind, rightNode.getId(), rightId );
				return true;
			} catch (Exception e) {
				throw new DataException(String.format("Cannot add relationship: %s #%d %s -%s-> %s #%d %s",
						leftKind, leftNode.getId(), leftId, relationshipType, rightKind, rightNode.getId(), rightId), e); 
			}
		} else {
			log.info("Relationship {} already exists: {} #{} {} -{}-> {} #{} {}", rel,
						leftKind, leftNode.getId(), leftId, relationshipType, rightKind, rightNode.getId(), rightId );
			return false;
		}
	}

	@Override
	public boolean delete(String leftId, String rightId) {
		// TODO: use cypher, especially for deleteAll
		return idRepository.delete(leftId, rightId);
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
		paramsBuilder.put("leftKind", leftKind);
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

	/**
	 * Returns the {@link Neo4jIdRelationRepository}, might be useful to call {@link AssocRepository#delete(Object, Object)}
	 * based on IDs instead of objects.
	 * @return
	 */
	public Neo4jStringIdRelationRepository getIdRepository() {
		return idRepository;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.ExtendedAssocRepositoryBase#doGetLeft(java.io.Serializable, java.lang.Long, java.lang.Long)
	 */
	@Override @Nonnull
	protected Page<R> doGetLeft(String leftId, Long skip, Long limit) {
		final String totalQuery = "START left = node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(right) AS total" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");

		final String query = "START left = node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN right" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("leftId", leftId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (skip != null)
			paramsBuilder.put("skipRows", skip);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		
		final ExecutionResult totalResult = executionEngine.execute(totalQuery, params);
		final long total = Iterators.getNext(totalResult.<Long>columnAs("total"), 0L);
		
		final ExecutionResult rows = executionEngine.execute(query, params);
		
		final List<Node> matchingRightNodes = ImmutableList.copyOf(rows.<Node>columnAs("right"));
		final List<R> matchingRights = rightShadow.realize(matchingRightNodes);
		log.info("getLeft {} {} skip={} limit={} returned {}/{} {} rights: {} - {}",
				leftKind, leftId, skip, limit, matchingRights.size(), total, rightKind,
				query, params);
		
		return new PageImpl<R>(matchingRights, null, total);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.ExtendedAssocRepositoryBase#doGetLeft(java.io.Serializable, java.lang.Long, java.lang.Long)
	 */
	@Override @Nonnull
	protected Page<Edge<L, R>> doGetLeftAsEdges(String leftId, Long skip, Long limit) {
		final String totalQuery = "START left = node:" + leftIdxName + "(_rowId={leftId}) " +
				"MATCH left -[:" + relationshipType.name() + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(right) AS total" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");

		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("leftId", leftId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (skip != null)
			paramsBuilder.put("skipRows", skip);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		
		final ExecutionResult totalResult = executionEngine.execute(totalQuery, params);
		final long total = Iterators.getNext(totalResult.<Long>columnAs("total"), 0L);
		
		if (total > 0) {
			final String leftQuery = "START left = node:" + leftIdxName + "(_rowId={leftId}) " +
					"RETURN left";
			final Node leftNode = executionEngine.execute(leftQuery, params).<Node>columnAs("left").next();
			final L left = leftShadow.realize(leftNode);
			
			final String query = "START left = node:" + leftIdxName + "(_rowId={leftId}) " +
					"MATCH left -[rel:" + relationshipType.name() + "]-> right " +
					"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
					"RETURN rel, right" +
					(skip != null ? " SKIP {skipRows}" : "") +
					(limit != null ? " LIMIT {limitRows}" : "");
			final ExecutionResult rows = executionEngine.execute(query, params);
			final List<Edge<L, R>> matchingRights = ImmutableList.copyOf( Iterables.transform(rows, new Function<Map<String, Object>, Edge<L, R>>() {
				@Override @Nullable
				public Edge<L, R> apply(@Nullable Map<String, Object> input) {
					final Relationship rel = (Relationship) input.get("rel");
					final Node rightNode = (Node) input.get("right");
					final R right = rightShadow.realize(rightNode);
					return new ToEdge<L, R>(left, right).apply(rel);
				}
			}) );
			log.info("getLeft {} {} skip={} limit={} returned {}/{} {} rights: {} - {}",
					leftKind, leftId, skip, limit, matchingRights.size(), total, rightKind,
					query, params);
			
			return new PageImpl<Edge<L, R>>(matchingRights, null, total);
		} else {
			return new PageImpl<Edge<L,R>>(ImmutableList.<Edge<L, R>>of());
		}
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.repository.ExtendedAssocRepositoryBase#doGetRight(java.io.Serializable, java.lang.Long, java.lang.Long)
	 */
	@Override @Nonnull
	protected Page<L> doGetRight(String rightId, Long skip, Long limit) {
		final String totalQuery = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(left) AS total" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");
		final String query = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN left" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("rightId", rightId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (skip != null)
			paramsBuilder.put("skipRows", skip);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		
		final ExecutionResult totalResult = executionEngine.execute(totalQuery, params);
		final long total = Iterators.getNext(totalResult.<Long>columnAs("total"), 0L);
		
		final ExecutionResult rows = executionEngine.execute(query, params);
		final List<Node> matchingLeftNodes = ImmutableList.copyOf(rows.<Node>columnAs("left"));
		final List<L> matchingLefts = leftShadow.realize(matchingLeftNodes);
		log.info("getRight {} {} skip={} limit={} returned {}/{} {} lefts: {} - {}",
				rightKind, rightId, skip, limit, matchingLefts.size(), total, leftKind,
				query, params);

		return new PageImpl<L>(matchingLefts, null, total);
	}
	
	@Override @Nonnull
	protected Page<Edge<L, R>> doGetRightAsEdges(String rightId, Long skip, Long limit) {
		final String totalQuery = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
				"MATCH left -[rel:" + relationshipType + "]-> right " +
				"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
				"RETURN COUNT(rel) AS total" +
				(skip != null ? " SKIP {skipRows}" : "") +
				(limit != null ? " LIMIT {limitRows}" : "");
		final ImmutableMap.Builder<String, Object> paramsBuilder = ImmutableMap.builder();
		paramsBuilder.put("rightId", rightId);
		paramsBuilder.put("leftKind", leftKind);
		paramsBuilder.put("rightKind", rightKind);
		if (skip != null)
			paramsBuilder.put("skipRows", skip);
		if (limit != null)
			paramsBuilder.put("limitRows", limit);
		final Map<String, Object> params = paramsBuilder.build();
		
		final ExecutionResult totalResult = executionEngine.execute(totalQuery, params);
		final long total = Iterators.getNext(totalResult.<Long>columnAs("total"), 0L);
		
		if (total > 0) {
			final String rightQuery = "START right = node:" + rightIdxName + "(_rowId={rightId}) " +
					"RETURN right";
			final Node rightNode = executionEngine.execute(rightQuery, params).<Node>columnAs("right").next();
			final R right = rightShadow.realize(rightNode);
			
			final String query = "START right=node:" + rightIdxName + "(_rowId={rightId}) " +
					"MATCH left -[rel:" + relationshipType + "]-> right " +
					"WHERE left.kind = {leftKind} AND right.kind = {rightKind} " +
					"RETURN rel, left" +
					(skip != null ? " SKIP {skipRows}" : "") +
					(limit != null ? " LIMIT {limitRows}" : "");
			final ExecutionResult rows = executionEngine.execute(query, params);
			final List<Edge<L, R>> matchingLefts = ImmutableList.copyOf( Iterables.transform(rows, new Function<Map<String, Object>, Edge<L, R>>() {
				@Override @Nullable
				public Edge<L, R> apply(@Nullable Map<String, Object> input) {
					final Relationship rel = (Relationship) input.get("rel");
					final Node leftNode = (Node) input.get("left");
					final L left = leftShadow.realize(leftNode);
					return new ToEdge<L, R>(left, right).apply(rel);
				}
			}) );
			log.info("getRight {} {} skip={} limit={} returned {}/{} {} lefts: {} - {}",
					rightKind, rightId, skip, limit, matchingLefts.size(), total, leftKind,
					query, params);
			
			return new PageImpl<Edge<L, R>>(matchingLefts, null, total);
		} else {
			return new PageImpl<Edge<L, R>>(ImmutableList.<Edge<L, R>>of());
		}
	}
	
	@Override
	public boolean exists(String leftId, String rightId) {
		return idRepository.getRelationship(leftId, rightId) != null;
	}
	
	@Override
	public Edge<L, R> findOne(String leftId, String rightId) {
		final Relationship rel = idRepository.getRelationship(leftId, rightId);
		if (rel == null)
			return null;
		final L left = leftShadow.realize(rel.getStartNode());
		final R right = rightShadow.realize(rel.getEndNode());
		return new ToEdge<L, R>(left, right).apply(rel);
	}
	
}
