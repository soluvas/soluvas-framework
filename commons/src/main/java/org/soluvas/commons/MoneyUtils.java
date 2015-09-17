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
	
//	private static final Logger log = LoggerFactory.getLogger(MoneyUtils.class);

	public static String getSymbol(Locale locale, CurrencyUnit currency) {
		final AmountFormatQuery symbolQuery = AmountFormatQueryBuilder.of(locale).set(CurrencyStyle.SYMBOL)
				.set(AmountFormatParams.PATTERN, "¤").build();
		final String symbol = MonetaryFormats.getAmountFormat(symbolQuery).format(Money.of(BigDecimal.ZERO, currency)).replace("0", "");
		
//		log.debug("Got symbol for locale '{}' - currency '{}': {}", locale.toLanguageTag(), currency, symbol);
		
		return symbol;
	}

	public static String getName(Locale locale, CurrencyUnit currency) {
		final AmountFormatQuery symbolQuery = AmountFormatQueryBuilder.of(locale).set(CurrencyStyle.NAME)
				.set(AmountFormatParams.PATTERN, "¤").build();
		final String symbol = MonetaryFormats.getAmountFormat(symbolQuery).format(Money.of(BigDecimal.ZERO, currency));
		return symbol;
	}

}
