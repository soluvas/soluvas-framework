package org.soluvas.commons;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;

/**
 * Helper methods for dealing with Neo4j {@link Node}s and {@link Index}es.
 * @author ceefour
 */
public class Neo4jUtils {
	
	/**
	 * The original {@link Node#setProperty(String, Object)} does not accept {@literal null} as values.
	 * This will set the property if not null, otherwise the property will be removed.
	 * @param node
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public static <T> T safeSetProperty(@Nonnull final Node node, @Nonnull final String key, @Nullable T value) {
		if (value != null) {
			node.setProperty(key, value);
			return value;
		} else {
			return (T) node.removeProperty(key);
		}
	}

}
