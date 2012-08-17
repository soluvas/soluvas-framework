package org.soluvas.json.money;

import org.joda.money.BigMoney;
import org.joda.money.Money;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 */
public class JodaMoneyModule extends SimpleModule {
	
	public JodaMoneyModule() {
		super("joda-time", new Version(0, 6, 0, "", "org.joda", "joda-money"));
		addSerializer(Money.class, new MoneySerializer());
		addSerializer(BigMoney.class, new BigMoneySerializer());
		addDeserializer(Money.class, new MoneyDeserializer());
		addDeserializer(BigMoney.class, new BigMoneyDeserializer());
	}

}
