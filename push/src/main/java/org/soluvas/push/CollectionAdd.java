package org.soluvas.push;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CollectionAdd<T> extends PushMessage {

	private String collection;
	private T entry;
	
	public CollectionAdd() {
		super();
	}

	public CollectionAdd(String collection, T entry) {
		super();
		this.collection = collection;
		this.entry = entry;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collectionName) {
		this.collection = collectionName;
	}

	public T getEntry() {
		return entry;
	}

	public void setEntry(T entry) {
		this.entry = entry;
	}

	@Override
	public String toString() {
		return String.format(
				"CollectionAdd [collectionName=%s, entry=%s]",
				collection, entry);
	}

}
