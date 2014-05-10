package org.soluvas.commons.util;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.Iterables;

/**
 * Combines multiple {@link Collection}s into a single {@link Collection} as an unmodifiable view. 
 * @param <E>
 * @author <a href="http://stackoverflow.com/users/342852/sean-patrick-floyd">Sean Patrick Floyd</a>
 * @see <a href="http://stackoverflow.com/a/4896878/122441">http://stackoverflow.com/a/4896878/122441</a>
 */
public class JoinedCollectionView<E> implements Collection<E> {

    private final Collection<? extends E>[] items;

    public JoinedCollectionView(final Collection<? extends E>[] items) {
        this.items = items;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for (final Collection<? extends E> coll : items) {
            coll.clear();
        }
    }

    @Override
    public boolean contains(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean containsAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return !iterator().hasNext();
    }

    @Override
    public Iterator<E> iterator() {
        return Iterables.concat(items).iterator();
    }

    @Override
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        int ct = 0;
        for (final Collection<? extends E> coll : items) {
            ct += coll.size();
        }
        return ct;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a live aggregated collection view of the collections passed in.
     * <p>
     * All methods except {@link Collection#size()}, {@link Collection#clear()},
     * {@link Collection#isEmpty()} and {@link Iterable#iterator()}
     *  throw {@link UnsupportedOperationException} in the returned Collection.
     * <p>
     * None of the above methods is thread safe (nor would there be an easy way
     * of making them).
     */
    public static <T> Collection<T> combine(
    		final Collection<? extends T>... items) {
    	return new JoinedCollectionView<>(items);
    }
    
}
