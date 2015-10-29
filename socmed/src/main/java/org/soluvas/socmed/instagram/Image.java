package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Image implements Serializable{

	String url;
	BigDecimal width;
	BigDecimal height;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "Image [url=" + url + ", width=" + width + ", height=" + height
				+ "]";
	}
	
}
