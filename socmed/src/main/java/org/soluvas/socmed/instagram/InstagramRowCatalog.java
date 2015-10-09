package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class InstagramRowCatalog implements Serializable{

	private List<InstagramRow> data;

	public List<InstagramRow> getData() {
		return data;
	}

	public void setData(List<InstagramRow> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "InstagramRowCatalog [data=" + data + "]";
	}

	
}
