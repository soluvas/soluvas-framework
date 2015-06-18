package org.soluvas.commons.locale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Function to format a {@link BigDecimal} monetary value using a specified currency.
 * Useful as Mustache function.
 * 
 * <p>The {@link BigDecimal#setScale(int, java.math.RoundingMode)} will be set to 
 * {@link CurrencyUnit#getDecimalPlaces()} using {@link RoundingMode#HALF_EVEN} if available, or left as is.
 * 
 * <p>The input can be:
 * <ol>
 * <li>just number, defaultCurrency will be used. If defaultCurrency is null, this mode
 * 		is not supported.</li>
 * <li>both currency code and number, separated by space, e.g. "IDR 275000"</li>
 * </ol>
 * 
 * https://github.com/spullara/mustache.java
 * 
 * @author rudi
 */
public class FormatCurrency implements
		Function<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormatCurrency.class);
	private static final Pattern embeddedPattern = Pattern.compile("(.+) (.+)");
	private final CurrencyUnit defaultCurrency;
	private final MoneyFormatter formatter;

	@Deprecated
	public FormatCurrency() {
		this(Locale.forLanguageTag("id-ID"), null);
	}
	
	@Deprecated
	public FormatCurrency(@Nullable CurrencyUnit defaultCurrency) {
		this(Locale.forLanguageTag("id-ID"), defaultCurrency);
	}

	public FormatCurrency(Locale locale) {
		this(locale, null);
	}
	
	public FormatCurrency(Locale locale, @Nullable CurrencyUnit defaultCurrency) {
		super();
		this.defaultCurrency = defaultCurrency;
		formatter = new MoneyFormatterBuilder()
			.appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter(locale);
	}

	@Override @Nullable
	public String apply(@Nullable String input) {
		if (!Strings.isNullOrEmpty(input)) {
			try {
				final Matcher matcher = embeddedPattern.matcher(input);
				final CurrencyUnit currency;
				final BigDecimal scaled;
				if (matcher.matches()) {
					final String currencyCode = matcher.group(1);
					currency = CurrencyUnit.of(currencyCode);
					scaled = new BigDecimal(matcher.group(2)).setScale(currency.getDecimalPlaces(), RoundingMode.HALF_EVEN);
				} else {
					currency = Preconditions.checkNotNull(defaultCurrency,
							"input string '%s' does not embed currency code, either defaultCurrency must be specified or fix your input",
							input);
					scaled = new BigDecimal(input);
				}
				final BigMoney money = BigMoney.of(currency, scaled);
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