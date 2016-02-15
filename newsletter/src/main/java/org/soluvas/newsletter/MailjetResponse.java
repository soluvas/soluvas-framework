package org.soluvas.newsletter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author atang
 *
 */
public class MailjetResponse {
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Data")
	private List<DataResponse> data;
	@JsonProperty("Total")
	private Integer total;
	@JsonProperty("Count")
	private Integer count;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "MailjetResponse [status=" + status + ", data=" + data
				+ ", total=" + total + ", count=" + count + "]";
	}
	
}
