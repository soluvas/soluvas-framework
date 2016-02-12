package org.soluvas.newsletter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author atang
 *
 */
public class AddListContactsResponse {
	
	private String status;
	private List<DataResponse> data;
	private Integer total;
	private Integer count;
	
	/**
	 * 
	 */
	public AddListContactsResponse() {
		super();
	}
	
	
	public String getStatus() {
		return status;
	}
	
	@JsonProperty("Status")
	public void setStatus(String status) {
		status = status;
	}
	
	public List<DataResponse> getData() {
		return data;
	}
	
	@JsonProperty("Data")
	public void setData(List<DataResponse> data) {
		data = data;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	@JsonProperty("Total")
	public void setTotal(Integer total) {
		total = total;
	}
	
	public Integer getCount() {
		return count;
	}
	
	@JsonProperty("Count")
	public void setCount(Integer count) {
		count = count;
	}


	@Override
	public String toString() {
		return "AddListContactsResponse [Status=" + status + ", Data=" + data
				+ ", Total=" + total + ", Count=" + count + "]";
	}
	
	
}
