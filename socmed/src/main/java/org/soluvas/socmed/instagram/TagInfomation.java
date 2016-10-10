package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties( ignoreUnknown = true )
public class TagInfomation implements Serializable{
	@JsonProperty("data")
	private InstagramPostCount data;
	
	public InstagramPostCount getData() {
		return data;
	}

	public void setData(InstagramPostCount data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "InstagramTagCountCatalog [data=" + data + "]";
	}
	

}
