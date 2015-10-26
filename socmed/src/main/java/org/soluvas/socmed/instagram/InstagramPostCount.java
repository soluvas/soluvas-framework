package org.soluvas.socmed.instagram;

import java.io.Serializable;
import java.math.BigDecimal;

import org.soluvas.commons.mongo.BigDecimalConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.code.morphia.annotations.Converters;

@JsonIgnoreProperties( ignoreUnknown = true )
@Converters({BigDecimalConverter.class})
public class InstagramPostCount implements Serializable{

	private BigDecimal media_count;
	private String name;
	
	public BigDecimal getMedia_count() {
		return media_count;
	}
	public void setMedia_count(BigDecimal media_count) {
		this.media_count = media_count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
