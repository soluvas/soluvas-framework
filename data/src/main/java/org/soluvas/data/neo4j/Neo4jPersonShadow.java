package org.soluvas.data.neo4j;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.DataException;
import org.soluvas.data.EntityShadowBase;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * Helper methods to convert between soluvas commons data classes and Neo4j graph {@link Node}s.
 * @todo Use Lucene Queries to increase performance for multiple ensure/refresh/remove.
 *   i.e. {@code _rowId:("hendy" "arum" "rio")}
 * @author ceefour
 */
public class Neo4jPersonShadow extends EntityShadowBase<PersonInfo, String, Node> {

	/**
	 * ID is {@code _rowId}. {@code className} and {@code kind} are ignored.
	 * 
	 * @author ceefour
	 */
	public static class ToPersonInfo implements Function<Node, PersonInfo> {
		
		@Override
		@Nullable
		public PersonInfo apply(@Nullable Node node) {
			final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
			personInfo.setId((String) node.getProperty("_rowId"));
			personInfo.setSlug((String) node.getProperty("slug", null));
			personInfo.setName((String) node.getProperty("name", null));
			personInfo.setPhotoId((String) node.getProperty("photoId", null));
			final String genderLiteral = (String) node.getProperty("gender", null);
			if (genderLiteral != null)
				personInfo.setGender(Gender.get(genderLiteral.toLowerCase()));
			return personInfo;
		}
		
	}

	/**
	 * ID is {@code _rowId}.
	 * Two properties are automatically added, {@code className} and {@code kind}={@code Person}. 
	 * @author ceefour
	 */
	public static class FromPersonInfo implements Function<PersonInfo, Node> {
		
		private final GraphDatabaseService graphDb;
		private final Node node;
		
		/**
		 * This will create new {@link Node}s in the {@link GraphDatabaseService}.
		 * @param graphDb
		 */
		public FromPersonInfo(@Nonnull final GraphDatabaseService graphDb) {
			super();
			this.graphDb = graphDb;
			this.node = null;
		}
		
		/**
		 * Update existing node.
		 * @param node
		 */
		public FromPersonInfo(@Nonnull final Node node) {
			super();
			this.graphDb = null;
			this.node = node;
		}
		
		protected Node getNode() {
			return graphDb != null ? graphDb.createNode() : this.node;
		}
		
		@Override
		@Nullable
		public Node apply(@Nullable PersonInfo personInfo) {
			final Node node = getNode();
			Neo4jUtils.safeSetProperty(node, "_rowId", personInfo.getId());
			Neo4jUtils.safeSetProperty(node, "className", personInfo.getClass().getName());
			Neo4jUtils.safeSetProperty(node, "kind", "Person");
			Neo4jUtils.safeSetProperty(node, "slug", personInfo.getSlug());
			Neo4jUtils.safeSetProperty(node, "name", personInfo.getName());
			Neo4jUtils.safeSetProperty(node, "photoId", personInfo.getPhotoId());
			Neo4jUtils.safeSetProperty(node, "gender", 
					personInfo.getGender() != null ? personInfo.getGender().getLiteral() : null);
			return node;
		}

	}
	
	private static Logger log = LoggerFactory.getLogger(Neo4jPersonShadow.class);
	private final GraphDatabaseService graph;
	private final Index<Node> idx;
	
	/**
	 * @param graph
	 * @param idx
	 */
	public Neo4jPersonShadow(@Nonnull final GraphDatabaseService graph, @Nonnull final Index<Node> idx) {
		super(PersonInfo.class, "Person", new ToPersonInfo());
		this.graph = graph;
		this.idx = idx;
	}

	/**
	 * @param graph
	 * @param idxName
	 */
	public Neo4jPersonShadow(@Nonnull final GraphDatabaseService graph, @Nonnull final String idxName) {
		this(graph, Neo4jUtils.ensureIndex(graph, idxName));
	}
	
	@Override
	protected Node doEnsure(PersonInfo person, boolean refresh) {
		try {
			Node personNode = Neo4jUtils.getOnlyElement(idx.get("_rowId", person.getId()), null);
			log.debug("Get person {} in {} returned {}", 
					person.getId(), idx, personNode);
			
			if (personNode == null) {
				personNode = new FromPersonInfo(graph).apply(person);
				log.info("Adding person {} ({}) to Neo4j shadow as {}", person.getId(), person.getName(), personNode);
			} else {
				if (refresh) {
					personNode = new FromPersonInfo(personNode).apply(person);
					log.info("Refreshing person {} ({}) in Neo4j shadow as {}", person.getId(), person.getName(), personNode);
				}
			}
			if (refresh) {
				idx.remove(personNode);
			}
			idx.putIfAbsent(personNode, "_id", person.getId());
			idx.putIfAbsent(personNode, "_rowId", person.getId());
			
			return personNode;
		} catch (Exception e) {
			throw new DataException("Cannot find person " + person.getId() + " in index", e);
		}			
	}

	@Override
	public long remove(@Nonnull final Collection<PersonInfo> people) {
		return Iterables.frequency( Collections2.transform(people, new Function<PersonInfo, Boolean>() {
			@Override
			@Nullable
			public Boolean apply(@Nullable PersonInfo person) {
				final List<Node> nodes = Neo4jUtils.asList(idx.get("_rowId", person.getId()));
				if (nodes.isEmpty())
					return false;
				log.info("Removing person shadow for {} nodes: {}", nodes.size(), nodes);
				for (final Node node : nodes) {
					idx.remove(node);
				}
				return true;
			}
		}), true);
	}

	@Override
	public String getKey(PersonInfo person) {
		return person.getId();
	}

}
