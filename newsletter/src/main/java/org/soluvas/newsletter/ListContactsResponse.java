package org.soluvas.newsletter;

import java.util.List;

/**
 * @author atang
 *
 */
public class ListContactsResponse {

	private String status;
	private String total_cnt;
	private List<Contact> result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal_cnt() {
		return total_cnt;
	}
	public void setTotal_cnt(String total_cnt) {
		this.total_cnt = total_cnt;
	}
	public List<Contact> getResult() {
		return result;
	}
	public void setResult(List<Contact> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "ListContactsResponse ["
				+ (status != null ? "status=" + status + ", " : "")
				+ (total_cnt != null ? "total_cnt=" + total_cnt + ", " : "")
				+ (result != null ? "result="
						+ result.subList(0, Math.min(result.size(), maxLen))
						: "") + "]";
	}
	
}
