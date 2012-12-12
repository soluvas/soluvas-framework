/**
 * 
 */
package org.soluvas.jaxrs;

/**
 * @author rudi
 *
 */
public class DataStatus<T> extends Status<T> {

	private T data;
	
	public DataStatus() {
		super();
	}

	public DataStatus(T data) {
		super("success");
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DataStatus [data=%s]", data);
	}
	
}
