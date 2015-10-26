package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class InstagramTagCountCatalog implements Serializable{
	
	private InstagramPostCount data;

	public InstagramPostCount getData() {
		return data;
	}

	public void setData(InstagramPostCount data) {
		this.data = data;
	}
	
	

}
