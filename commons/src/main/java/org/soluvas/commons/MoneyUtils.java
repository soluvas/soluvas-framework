package org.soluvas.commons;

import java.math.BigDecimal;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.format.AmountFormatQuery;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.format.AmountFormatParams;
import org.javamoney.moneta.format.CurrencyStyle;

/**
 * @author ceefour
 *
 */
public class MoneyUtils {

	public static String getSymbol(Locale locale, CurrencyUnit currency) {
		final AmountFormatQuery symbolQuery = AmountFormatQueryBuilder.of(locale).set(CurrencyStyle.SYMBOL)
				.set(AmountFormatParams.PATTERN, "¤").build();
		final String symbol = MonetaryFormats.getAmountFormat(symbolQuery).format(Money.of(BigDecimal.ZERO, currency));
		return symbol;
	}

	public static String getName(Locale locale, CurrencyUnit currency) {
		final AmountFormatQuery symbolQuery = AmountFormatQueryBuilder.of(locale).set(CurrencyStyle.NAME)
				.set(AmountFormatParams.PATTERN, "¤").build();
		final String symbol = MonetaryFormats.getAmountFormat(symbolQuery).format(Money.of(BigDecimal.ZERO, currency));
		return symbol;
	}

}
