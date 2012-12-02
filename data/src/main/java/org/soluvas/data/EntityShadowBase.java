package org.soluvas.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.PersonInfo;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

/**
 * Implements the single-parameter methods as using the {@link Collection} methods.
 * @author ceefour
 */
public abstract class EntityShadowBase<T, ID extends Serializable, D> implements EntityShadow<T, ID, D> {
	
	protected Class<T> entityClass;
	protected String kind;
	protected Function<D, T> realizer;
	
	/**
	 * @param entityClass The {@code <T>} type parameter e.g. {@link PersonInfo}.
	 * @param kind e.g. {@code Person}.
	 */
	public EntityShadowBase(@Nonnull final Class<T> entityClass, @Nonnull final String kind,
			@Nonnull final Function<D, T> realizer) {
		super();
		this.entityClass = entityClass;
		this.kind = kind;
		this.realizer = realizer;
	}

	@Override
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
	@Override
	public String getKind() {
		return kind;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.EntityIndex#ensure(java.lang.Object)
	 */
	@Override
	public D ensure(T obj) {
		return ensure(ImmutableList.of(obj)).iterator().next();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.EntityIndex#refresh(java.lang.Object)
	 */
	@Override
	public D refresh(T obj) {
		return refresh(ImmutableList.of(obj)).iterator().next();
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.EntityIndex#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(T obj) {
		return remove(ImmutableList.of(obj)) > 0;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.EntityIndex#ensure(java.util.Collection)
	 */
	@Override
	public Collection<D> ensure(@Nonnull final Collection<T> objs) {
		return ImmutableList.copyOf(Collections2.transform(objs, new Function<T, D>() {
			@Override @Nullable
			public D apply(@Nullable T obj) {
				return doEnsure(obj, false);
			}
		}));
	}

	/* (non-Javadoc)
	 * @see org.soluvas.data.EntityIndex#refresh(java.util.Collection)
	 */
	@Override
	public Collection<D> refresh(@Nonnull final Collection<T> objs) {
		return ImmutableList.copyOf(Collections2.transform(objs, new Function<T, D>() {
			@Override @Nullable
			public D apply(@Nullable T obj) {
				return doEnsure(obj, true);
			}
		}));
	}
	
	/**
	 * Implement this method to ensure the entity, optionally refreshing.
	 * @param obj
	 * @param refresh
	 * @return
	 */
	protected abstract D doEnsure(@Nonnull final T obj, final boolean refresh);
	
	@Override
	public T realize(D doc) {
		return realize(ImmutableList.of(doc)).iterator().next();
	}
	
	@Override
	public List<T> realize(Collection<D> docs) {
		return ImmutableList.copyOf(Collections2.transform(docs, realizer));
	}

}
