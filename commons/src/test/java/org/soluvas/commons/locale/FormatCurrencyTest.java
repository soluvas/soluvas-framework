/**
 * 
 */
package org.soluvas.commons.locale;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Locale;

import javax.money.Monetary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.collect.ImmutableMap;

/**
 * @author rudi
 *
 */
public class FormatCurrencyTest {

	private FormatCurrency formatCurrencyId;
	private FormatCurrency formatCurrencyEn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		formatCurrencyId = new FormatCurrency(Locale.forLanguageTag("id-ID"), Monetary.getCurrency("IDR"));
		formatCurrencyEn = new FormatCurrency(Locale.forLanguageTag("en-US"), Monetary.getCurrency("USD"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void rupiah() {
		assertThat(formatCurrencyId.apply("IDR 600000.00000000"), equalTo("Rp600.000"));
		assertThat(formatCurrencyId.apply("IDR 75000"), equalTo("Rp75.000"));
		assertThat(formatCurrencyId.apply("IDR 75000.23"), equalTo("Rp75.000"));
		assertThat(formatCurrencyId.apply("IDR 75000.2375"), equalTo("Rp75.000"));
	}

	@Test
	public void dollar() {
		assertThat(formatCurrencyId.apply("USD 600000.00000000"), equalTo("USD600.000,00"));
		assertThat(formatCurrencyId.apply("USD 75000"), equalTo("USD75.000,00"));
		assertThat(formatCurrencyId.apply("USD 75000.23"), equalTo("USD75.000,23"));
		assertThat(formatCurrencyId.apply("USD 75000.2375"), equalTo("USD75.000,24"));
		
		assertThat(formatCurrencyEn.apply("USD 600000.00000000"), equalTo("$600,000.00"));
		assertThat(formatCurrencyEn.apply("USD 75000"), equalTo("$75,000.00"));
		assertThat(formatCurrencyEn.apply("USD 75000.23"), equalTo("$75,000.23"));
		assertThat(formatCurrencyEn.apply("USD 75000.2375"), equalTo("$75,000.24"));
	}

	@Test
	public void mustacheFunc() throws IOException {
		DefaultMustacheFactory mf = new DefaultMustacheFactory();
		Mustache idr1 = mf.compile(new StringReader("{{#formatCurrency}}IDR 75000.5375{{/formatCurrency}}"), "idr1");
		try (final StringWriter idr1w = new StringWriter()) {
			idr1.execute(idr1w, ImmutableMap.of("formatCurrency", formatCurrencyId));
			assertThat(idr1w.toString(), equalTo("Rp75.001"));
		}
	}

}
