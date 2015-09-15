package org.soluvas.commons.locale;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Locale;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.collect.ImmutableMap;

/**
 * @author rudi
 *
 */
public class FormatMeasureTest {

	private static final Logger log = LoggerFactory
			.getLogger(FormatMeasureTest.class);
	private FormatMeasure formatMeasureId;
	private FormatMeasure formatMeasureEn;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		formatMeasureId = new FormatMeasure(Locale.forLanguageTag("id-ID"));
		formatMeasureEn = new FormatMeasure(Locale.forLanguageTag("en-US"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void oneDimension() {
		assertThat(formatMeasureId.apply("600000.00000000 cm"), equalTo("600.000 cm"));
		// TODO: why this gets rounded to 3 decimal digits?? 
//		assertThat(formatMeasureId.apply("7511.2375 cm"), equalTo("7.511,2375 cm"));
//		assertThat(formatMeasureEn.apply("7511.2375 cm"), equalTo("7,511.2375 cm"));
		assertThat(formatMeasureId.apply("7511.234 cm"), equalTo("7.511,234 cm"));
		assertThat(formatMeasureEn.apply("7511.234 cm"), equalTo("7,511.234 cm"));
		assertThat(formatMeasureEn.apply("7511.234 " + SI.CELSIUS), equalTo("7,511.234 ℃"));
	}

	@Test
	public void multiDimensions() {
		assertThat(formatMeasureId.apply("600000.00000000 cm^2"), equalTo("600.000 cm²"));
		// TODO: why this gets rounded to 3 decimal digits?? 
//		assertThat(formatMeasureId.apply("7511.2375 cm"), equalTo("7.511,2375 cm"));
//		assertThat(formatMeasureEn.apply("7511.2375 cm"), equalTo("7,511.2375 cm"));
		//log.info("{}", SI.CELSIUS.times(SI.KILOMETER));
		assertThat(formatMeasureId.apply("7511.234 cm/h"), equalTo("7.511,234 cm/h"));
		assertThat(formatMeasureEn.apply("7511.234 " + SI.WATT.times(1000).times(NonSI.HOUR)), equalTo("7,511.234 kW·h"));
	}

	@Test
	public void mustacheFunc() throws IOException {
		DefaultMustacheFactory mf = new DefaultMustacheFactory();
		Mustache id1 = mf.compile(new StringReader("{{#formatMeasure}}7511.238 cm{{/formatMeasure}}"), "idr1");
		try (final StringWriter idr1w = new StringWriter()) {
			id1.execute(idr1w, ImmutableMap.of("formatMeasure", formatMeasureId));
			assertThat(idr1w.toString(), equalTo("7.511,238 cm"));
		}
	}

}
