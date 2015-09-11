package org.soluvas.commons.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import javax.money.Monetary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Morphia;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class CurrencyUnitConverterTest {

	private Morphia morphia;

	@Before
	public void setUp() throws Exception {
		morphia = new Morphia(ImmutableSet.<Class>of(CurrencyUnitProduct.class));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void fromProduct() {
		CurrencyUnitProduct product = new CurrencyUnitProduct(UUID.randomUUID().toString(),
				Monetary.getCurrency("IDR"));
		DBObject dbo = morphia.toDBObject(product);
		assertNotNull(dbo);
		assertEquals("IDR", dbo.get("currency"));
	}

	@Test
	public void toProduct() {
		final BasicDBObject dbo = new BasicDBObject(ImmutableMap.of("_id", "1", "currency", "IDR"));
		CurrencyUnitProduct product = morphia.fromDBObject(CurrencyUnitProduct.class, dbo);
		assertNotNull(product);
		assertEquals("IDR", product.getCurrency().getCurrencyCode());
	}

}
