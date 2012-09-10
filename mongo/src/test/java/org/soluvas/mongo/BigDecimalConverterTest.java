package org.soluvas.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Morphia;
import com.google.common.collect.ImmutableSet;
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
	public void toProduct() {
		BigDecimalProduct product = new BigDecimalProduct(new BigDecimal(2500));
		DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals("2500", dbo.get("price"));
	}

}
