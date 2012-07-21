package org.soluvas.push;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CollectionAdd<T> extends PushMessage {

	private String collection;
	private T entry;
	private Long position;
	
	public CollectionAdd() {
		super();
	}

	@Deprecated
	public CollectionAdd(String collection, T entry) {
		super();
		this.collection = collection;
		this.entry = entry;
	}

	public CollectionAdd(String collection, T entry, long position) {
		super();
		this.collection = collection;
		this.entry = entry;
		this.position = position;
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

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "CollectionAdd [collection=" + collection + ", entry=" + entry
				+ ", position=" + position + "]";
	}

}
