package org.soluvas.commons.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Morphia;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class BigDecimalConverterTest {
	
	private Morphia morphia;

	@Before
	public void setUp() throws Exception {
		morphia = new Morphia(ImmutableSet.<Class>of(BigDecimalProduct.class));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void goodFloat() {
		assertEquals("0.1", Float.toString(0.1f));
		assertEquals("0.1", BigDecimalConverter.MONEY_FORMAT.format(0.1f));
	}

	@Test
	public void fromProduct() {
		final BigDecimalProduct product = new BigDecimalProduct(new BigDecimal(2500));
		final DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals(2500.0d, dbo.get("price"));
		assertEquals("2500.0", dbo.get("price").toString());
	}

	@Test
	public void fromExponentialProduct() {
		final BigDecimalProduct product = new BigDecimalProduct(new BigDecimal(2.5e+3));
		final DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals(2500.0d, dbo.get("price"));
		assertEquals("2500.0", dbo.get("price").toString());
	}

	@Test
	public void fromStringToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", "12900"));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromExponentialStringToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", "1.29E+4"));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertThat(product.getPrice(), Matchers.comparesEqualTo(new BigDecimal(12900)));
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromExponentialDoubleToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", 1.29E+4));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertThat(product.getPrice(), Matchers.comparesEqualTo(new BigDecimal(12900)));
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromIntToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", 12900));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromLongToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", 12900L));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromFloatToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", 12900.0f));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertEquals(new BigDecimal(12900), product.getPrice());
	}

	@Test
	public void fromDoubleToProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "price", 12900.0d));
		final BigDecimalProduct product = morphia.fromDBObject(BigDecimalProduct.class, dbo);
		assertNotNull(product);
		assertEquals(new BigDecimal(12900), product.getPrice());
	}
	
	@Test
	public void roundingDown() {
		final BigDecimal bigDecimal = new BigDecimal("33000.07700000");
		System.err.println(bigDecimal.setScale(1, RoundingMode.UP));
	}

}
