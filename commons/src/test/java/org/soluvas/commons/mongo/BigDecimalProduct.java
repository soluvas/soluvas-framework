package org.soluvas.commons.mongo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.soluvas.commons.mongo.BigDecimalConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity @Converters(BigDecimalConverter.class)
public class BigDecimalProduct implements Serializable {

	@Id private String id;
	private BigDecimal price = new BigDecimal(1000.0);

	public BigDecimalProduct() {
		super();
	}

	public BigDecimalProduct(BigDecimal price) {
		super();
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("BigDecimalProduct [price=%s]", price);
	}
	
}
