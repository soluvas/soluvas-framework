package org.soluvas.commons;

import javax.annotation.Nullable;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import com.google.common.base.Function;

/**
 * Helper methods to convert between soluvas commons data classes and Neo4j graph {@link Node}s.
 * @author ceefour
 */
public class SoluvasNodes {
	
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
	 * ID is {@code _rowId}, this will create a new {@link Node} in the {@link GraphDatabaseService}!
	 * Two properties are automatically added, {@code className} and {@code kind}={@code Person}. 
	 * @author ceefour
	 */
	public static class FromPersonInfo implements Function<PersonInfo, Node> {
		
		private final GraphDatabaseService graphDb;
		
		/**
		 * @param graphDb
		 */
		public FromPersonInfo(GraphDatabaseService graphDb) {
			super();
			this.graphDb = graphDb;
		}
		
		@Override
		@Nullable
		public Node apply(@Nullable PersonInfo personInfo) {
			final Node node = graphDb.createNode();
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

}
