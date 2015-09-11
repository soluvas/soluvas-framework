package org.soluvas.json.jscience;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnitDeserializerTest {
	
	private static final Logger log = LoggerFactory
			.getLogger(UnitDeserializerTest.class);

	@Test
	public void deserializeCentimeter() {
		log.info("SI.CENTIMETRE: {}", SI.CENTIMETRE);
		log.info("cm: {}", Unit.valueOf("cm"));
	}
	
	@Test
	public void deserializeInch() {
		log.info("NonSI.INCH: {}", NonSI.INCH);
		log.info("inch: {}", Unit.valueOf("[in_i]"));
	}

}
