package org.soluvas.commons.locale;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Function to format a {@link BigDecimal} monetary value using a specified currency.
 * Useful as Mustache function.
 * 
 * The input can be:
 * 1. just number, defaultCurrency will be used. If defaultCurrency is null, this mode
 * 		is not supported.
 * 2. both currency code and number, separated by space, e.g. "IDR 275000"
 * 
 * @author rudi
 */
public final class FormatCurrency implements
		Function<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormatCurrency.class);
	private final CurrencyUnit defaultCurrency;
	private static final Pattern embeddedPattern = Pattern.compile("(.+) (.+)");
	
	public FormatCurrency() {
		this(null);
	}

	public FormatCurrency(@Nullable CurrencyUnit defaultCurrency) {
		super();
		this.defaultCurrency = defaultCurrency;
	}

	@Override @Nullable
	public String apply(@Nullable String input) {
		if (!Strings.isNullOrEmpty(input)) {
			try {
				final Matcher matcher = embeddedPattern.matcher(input);
				final CurrencyUnit currency;
				final String value;
				if (matcher.matches()) {
					final String currencyCode = matcher.group(1);
					currency = CurrencyUnit.of(currencyCode);
					value = matcher.group(2);
				} else {
					currency = Preconditions.checkNotNull(defaultCurrency,
							"input string '%s' does not embed currency code, either defaultCurrency must be specified or fix your input",
							input);
					value = input;
				}
				// TODO: proper support for locale, e.g. "id" to get proper decimal places, separators etc.
				final Locale locale = Locale.forLanguageTag("id-ID");
				final MoneyFormatter formatter = new MoneyFormatterBuilder()
					.appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter(locale);
				final BigMoney money = BigMoney.of(currency, new BigDecimal(value));
				return formatter.print(money);
			} catch (Exception e) {
				log.error("Cannot formatCurrency from " + input, e);
				return input;
			}
		} else {
			return "";
		}
	}
}