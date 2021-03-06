package org.soluvas.push;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CollectionDelete extends PushMessage {

	private String collection;
	private String entryId;
	
	public CollectionDelete() {
		super();
	}

	public CollectionDelete(String trackingId, String topic, String collection, String entryId) {
		super(trackingId, topic);
		this.collection = collection;
		this.entryId = entryId;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	@Override
	public String toString() {
		return String.format(
				"CollectionDelete [collection=%s, entryId=%s]",
				collection, entryId);
	}

}
