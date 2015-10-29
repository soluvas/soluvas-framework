package org.soluvas.socmed.instagram;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
@SuppressWarnings("serial")
public class Images implements Serializable{

	private Image low_resolution;
	private Image standard_resolution;
	private Image thumbnail;
	
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
	
	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public String toString() {
		return "Images [low_resolution=" + low_resolution
				+ ", standard_resolution=" + standard_resolution
				+ ", thumbnail=" + thumbnail + "]";
	}
	
}
