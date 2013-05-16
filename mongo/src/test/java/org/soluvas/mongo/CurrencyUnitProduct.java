package org.soluvas.mongo;

import java.io.Serializable;

import org.joda.money.CurrencyUnit;
import org.soluvas.commons.mongo.CurrencyUnitConverter;

import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity @Converters(CurrencyUnitConverter.class)
public class CurrencyUnitProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private String id;
	private CurrencyUnit currency;

	public CurrencyUnitProduct() {
		super();
	}
	
	public CurrencyUnitProduct(String id, CurrencyUnit currency) {
		super();
		this.id = id;
		this.currency = currency;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the currency
	 */
	public CurrencyUnit getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(CurrencyUnit currency) {
		this.currency = currency;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyUnitProduct [" + (id != null ? "id=" + id + ", " : "")
				+ (currency != null ? "currency=" + currency : "") + "]";
	}

}
