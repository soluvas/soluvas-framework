package org.soluvas.data;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Nonnull;

import org.neo4j.graphdb.Node;

/**
 * An entity typed shadow (i.e. partial entity storage) is useful to make sure that the shadow storage is "reasonably" synced with the source database.
 * The shadow storage can be Neo4j (nodes+Neo4j indexes), MongoDB, JCR, Lucene, ElasticSearch, etc.
 * The shadow storage knowns about the domain model / entity, that's why the index is typed.
 * Contrast this with {@link EntityLookup}.
 * The name is "entity shadow" and not "entity index" so the terminology won't be confused.
 * A shadow is not always used for searching, but merely to 
 * provide a convenient "placeholder" for cross-repository entities.
 * A shadow may even perform badly for searching purposes.
 * 
 * @param <T> The domain model.
 * @param <D> The index document type, e.g. Neo4j {@link Node}.
 * @see {@link EntityShadowBase}, {@link EntityLookup}
 * @author ceefour
 */
public interface EntityShadow<T, ID extends Serializable, D> {
	
	/**
	 * Some things, like Neo4jWinkDao, require this.
	 * Also useful for runtime introspection and metaprogramming purposes.
	 * @return
	 */
	public abstract Class<T> getEntityClass();
	
	/**
	 * Some things, like Neo4jWinkDao, require this.
	 * Also useful for runtime introspection and metaprogramming purposes.
	 * @return
	 */
	public abstract String getKind();
	
	/**
	 * Given an object, return its ID, to be used as caching key.
	 * @param obj
	 * @return
	 */
	public abstract ID getKey(@Nonnull final T obj);

	/**
	 * Ensures that the object exists in the index, and returns the index document.
	 * If the object doesn't exist, it will be added as index document then returned.
	 * This is a convenience method for {@link #ensure(Collection)}.
	 * @param obj
	 * @return
	 */
	public abstract D ensure(T obj);
	
	/**
	 * Ensures that the objects exists in the shadow, and returns the shadow documents.
	 * If any object did not exist, they will be added as shadow documents then returned.
	 * @param objs
	 * @return
	 */
	public abstract Collection<D> ensure(Collection<T> objs);
	
	/**
	 * Ensures that the object exists in the shadow persistence and is up-to-date with the provided object, and returns the shadow document.
	 * If the object doesn't exist, it will be added as shadow document then returned.
	 * This is a convenience method for {@link #refresh(Collection)}.
	 * @param obj
	 * @return
	 */
	public abstract D refresh(T obj);
	
	/**
	 * Ensures that the objects exist in the shadow persistence and are up-to-date with the provided objects, and returns the shadow documents.
	 * If the any object did not exist, they will be added as shadow documents then returned.
	 * @param objs
	 * @return
	 */
	public abstract Collection<D> refresh(Collection<T> objs);

	/**
	 * Removes the corresponding shadow document, if already exists.
	 * This is a convenience method for {@link #remove(Collection)}.
	 * @param obj
	 * @return Whether the shadow document existed and removed.
	 */
	public abstract boolean remove(T obj);

	/**
	 * Removes the corresponding shadow documents.
	 * @param obj
	 * @return Number of shadow documents removed.
	 */
	public abstract long remove(Collection<T> objs);
	
	/**
	 * Realize a shadow document into an entity.
	 * @param doc
	 * @return
	 */
	public abstract T realize(D doc);

	/**
	 * Realize shadow documents into entities.
	 * @param doc
	 * @return
	 */
	public abstract Collection<T> realize(Collection<D> doc);

}
