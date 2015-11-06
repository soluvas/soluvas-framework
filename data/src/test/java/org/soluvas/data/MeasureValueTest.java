package org.soluvas.data;

import javax.measure.Measure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeasureValueTest {
	
	private static final Logger log = LoggerFactory.getLogger(MeasureValueTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final String string = "44 cm";
		final Measure<?> valueOf = Measure.valueOf(string);
		log.info("string '{}' to measure: {}", string, valueOf);
	}

}
