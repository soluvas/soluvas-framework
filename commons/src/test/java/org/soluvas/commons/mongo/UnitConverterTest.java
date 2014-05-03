package org.soluvas.commons.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.morphia.Morphia;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class UnitConverterTest {

	private static final Logger log = LoggerFactory
			.getLogger(UnitConverterTest.class);
	private Morphia morphia;

	@Before
	public void setUp() throws Exception {
		morphia = new Morphia(ImmutableSet.<Class>of(UnitProduct.class));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void fromProduct() {
		UnitProduct product = new UnitProduct(UUID.randomUUID().toString(),
				Unit.ONE);
		DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals("", dbo.get("unit"));
	}

	@Test
	public void toProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "unit", ""));
		UnitProduct product = morphia.fromDBObject(UnitProduct.class, dbo);
		assertNotNull(product);
		assertEquals(Unit.ONE, product.getUnit());
	}

	@Test
	public void fromProductKg() {
		UnitProduct product = new UnitProduct(UUID.randomUUID().toString(),
				SI.KILOGRAM);
		DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals("kg", dbo.get("unit"));
	}

	@Test
	public void toProductKg() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "unit", "kg"));
		UnitProduct product = morphia.fromDBObject(UnitProduct.class, dbo);
		assertNotNull(product);
		assertEquals(SI.KILOGRAM, product.getUnit());
	}

}
