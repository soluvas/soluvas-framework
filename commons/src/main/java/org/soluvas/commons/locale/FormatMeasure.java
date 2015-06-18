package org.soluvas.commons.locale;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.measure.DecimalMeasure;
import javax.measure.Measure;
import javax.measure.MeasureFormat;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import org.joda.money.CurrencyUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.BigDecimalUtils;

import com.google.common.base.Strings;

/**
 * Function to format a {@link Measure} or {@link BigDecimal} + {@link Unit} value.
 * Useful as Mustache function.
 * 
 * <p>It will call {@link BigDecimalUtils#stripFractionZeros(BigDecimal)} first.</p>
 * 
 * <p>The input can be:
 * <ol>
 * <li>just number (can be exponent).</li>
 * <li>both number (can be exponent) and unit, separated by space, e.g. "2.7645e+2 cm"</li>
 * </ol>
 * 
 * @author rudi
 */
public class FormatMeasure implements
		Function<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormatMeasure.class);
	private static final Pattern embeddedPattern = Pattern.compile("(.+) (.+)");
	private final NumberFormat numberFormat;
	private final MeasureFormat measureFormat;

	public FormatMeasure(Locale locale) {
		super();
		numberFormat = NumberFormat.getNumberInstance(locale);
		final UnitFormat unitFormat = UnitFormat.getInstance(locale);
		measureFormat = MeasureFormat.getInstance(numberFormat, unitFormat);
	}
	
	@Override @Nullable
	public String apply(@Nullable String input) {
		if (!Strings.isNullOrEmpty(input)) {
			try {
				final Matcher matcher = embeddedPattern.matcher(input);
				final CurrencyUnit currency;
				if (matcher.matches()) {
					final BigDecimal scaled = BigDecimalUtils.stripFractionZeros(new BigDecimal(matcher.group(1)));
					final String unitCode = matcher.group(2);
					return measureFormat.format(new DecimalMeasure<>(scaled, Unit.valueOf(unitCode)));
				} else {
					return numberFormat.format(new Double(input));
				}
			} catch (Exception e) {
				log.error("Cannot formatMeasure from " + input, e);
				return input;
			}
		} else {
			return "";
		}
	}

}