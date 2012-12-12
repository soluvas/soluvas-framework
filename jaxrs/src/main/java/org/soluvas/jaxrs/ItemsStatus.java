/**
 * 
 */
package org.soluvas.jaxrs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Status yang sekaligus me-return data dalam bentuk list.
 * @author rudi
 */
@XmlRootElement
public class ItemsStatus<T> extends Status {

	private List<T> items;
	private Long totalSize;
	
	public ItemsStatus() {
		super();
	}

	public ItemsStatus(String status, String exception, String message) {
		super(status, exception, message);
	}
	
	public ItemsStatus(List<T> items) {
		super("success");
		this.items = items;
	}

	public ItemsStatus(List<T> items, Long totalSize) {
		super("success");
		this.items = items;
		this.totalSize = totalSize;
	}

	/**
	 * Size of returned items;
	 * @return
	 */
	public int getSize() {
		return items.size();
	}
	
	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}

	/**
	 * @return the totalSize
	 */
	public Long getTotalSize() {
		return totalSize;
	}

	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	
}
