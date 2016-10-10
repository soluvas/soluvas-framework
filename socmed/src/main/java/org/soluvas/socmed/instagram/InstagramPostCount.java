package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.math.BigDecimal;

import org.soluvas.commons.mongo.BigDecimalConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.morphia.annotations.Converters;

@JsonIgnoreProperties( ignoreUnknown = true )
@Converters({BigDecimalConverter.class})
public class InstagramPostCount implements Serializable{
	@JsonProperty("media_count")
	private BigDecimal mediaCount;
	
	@JsonProperty("name")
	private String name;
	
	public BigDecimal getMediaCount() {
		return mediaCount;
	}
	
	public void setMediaCount(BigDecimal mediaCount) {
		this.mediaCount = mediaCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "InstagramPostCount [mediaCount=" + mediaCount + ", name=" + name + "]";
	}
	
}
