package org.soluvas.push;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CollectionCount extends PushMessage {

	private String collection;
	private Long size;
	
	public CollectionCount() {
		super();
	}

	public CollectionCount(String collection, Long size) {
		super();
		this.collection = collection;
		this.size = size;
	}

	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("CollectionCount [collection=%s, size=%s]",
				collection, size);
	}
	
}
