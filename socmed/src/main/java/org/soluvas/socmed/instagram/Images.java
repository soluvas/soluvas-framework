package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
@SuppressWarnings("serial")
public class Images implements Serializable{

	private Image low_resolution;
	private Image standard_resolution;
	
	public Image getStandard_resolution() {
		return standard_resolution;
	}

	public void setStandard_resolution(Image standard_resolution) {
		this.standard_resolution = standard_resolution;
	}

	public Image getLow_resolution() {
		return low_resolution;
	}

	public void setLow_resolution(Image low_resolution) {
		this.low_resolution = low_resolution;
	}

	@Override
	public String toString() {
		return "Images [low_resolution=" + low_resolution
				+ ", standard_resolution=" + standard_resolution + "]";
	} 
	
	
}
