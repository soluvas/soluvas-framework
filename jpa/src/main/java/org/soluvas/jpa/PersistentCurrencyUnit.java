package org.soluvas.jpa;

import javax.money.CurrencyUnit;

import org.jadira.usertype.spi.shared.AbstractSingleColumnUserType;

/**
 * Maps a {@link CurrencyUnit} to and from String for Hibernate.
 */
public class PersistentCurrencyUnit extends AbstractSingleColumnUserType<CurrencyUnit, String, StringColumnCurrencyUnitMapper> {

	private static final long serialVersionUID = 5653012946771904484L;
}
