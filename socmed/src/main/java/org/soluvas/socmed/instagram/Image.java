package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Image implements Serializable{

	String link;
	BigDecimal width;
	BigDecimal height;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
		return "Image [link=" + link + ", width=" + width + ", height=" + height
				+ "]";
	}
	
}
