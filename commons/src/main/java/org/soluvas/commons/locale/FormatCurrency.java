package org.soluvas.commons.locale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.MoneyUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;

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
	private final MonetaryAmountFormat formatter;
	private final Locale locale;

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
		formatter = MonetaryFormats.getAmountFormat(locale);
		this.locale = locale;
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
					currency = Monetary.getCurrency(currencyCode);
					scaled = new BigDecimal(matcher.group(2)).setScale(currency.getDefaultFractionDigits(), RoundingMode.HALF_EVEN);
				} else {
					currency = Preconditions.checkNotNull(defaultCurrency,
							"input string '%s' does not embed currency code, either defaultCurrency must be specified or fix your input",
							input);
					scaled = new BigDecimal(input);
				}
				final String symbol = MoneyUtils.getSymbol(locale, currency);
				final Money money = Money.of(scaled, currency);
				return symbol + formatter.format(money).replace(currency.getCurrencyCode(), "");
			} catch (Exception e) {
				final List<Throwable> causes = Throwables.getCausalChain(e);
				if (causes.stream().anyMatch((it) -> it instanceof NumberFormatException)) {
					log.warn(String.format("Cannot formatCurrency from '%s'", input), e);
				} else {
					log.error(String.format("Cannot formatCurrency from '%s'", input), e);
				}
				return input;
			}
		} else {
			return "";
		}
	}

}