package org.soluvas.data.neo4j;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;

/**
 * Helper methods for dealing with Neo4j {@link Node}s and {@link Index}es.
 * @author ceefour
 */
public class Neo4jUtils {
	
	private static Logger log = LoggerFactory.getLogger(Neo4jUtils.class);
	
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

	public static Index<Node> ensureIndex(@Nonnull final GraphDatabaseService graph,
			@Nonnull final String indexName) {
		log.debug("Getting vertex index {}", indexName);
		final Index<Node> index = graph.index().forNodes(indexName,
				ImmutableMap.of("_blueprints:type", "MANUAL", "type", "exact"));
		return index;
	}

	/**
	 * Safe way to get {@link IndexHits} results, always calling {@link IndexHits#close()}.
	 * @param indexHits
	 * @return
	 */
	public static <T> List<T> asList(@Nonnull final IndexHits<T> indexHits) {
		try {
			return ImmutableList.copyOf(indexHits.iterator());
		} finally {
			indexHits.close();
		}
	}

	/**
	 * Safe way to get the only {@link IndexHits} result, always calling {@link IndexHits#close()}.
	 * @param indexHits
	 * @return
	 */
	public static <T> T getOnlyElement(@Nonnull final IndexHits<T> indexHits) {
		try {
			return Iterators.getOnlyElement(indexHits.iterator());
		} finally {
			indexHits.close();
		}
	}

	/**
	 * Safe way to get the only {@link IndexHits} result, always calling {@link IndexHits#close()}.
	 * @param indexHits
	 * @return
	 */
	public static <T> T getOnlyElement(@Nonnull final IndexHits<T> indexHits, 
			@Nullable final T defaultValue) {
		try {
			return Iterators.getOnlyElement(indexHits.iterator(), defaultValue);
		} finally {
			indexHits.close();
		}
	}

}
