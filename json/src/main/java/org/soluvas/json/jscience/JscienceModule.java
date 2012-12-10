package org.soluvas.json.jscience;

import javax.measure.unit.Unit;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Jackson module for serialization/deserialization of {@link Unit} to JSON.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JscienceModule extends SimpleModule {
	
	public JscienceModule() {
		super("jscience", new Version(4, 3, 1, "", "org.jscience", "jscience"));
		addSerializer(Unit.class, new UnitSerializer());
		addDeserializer(Unit.class, new UnitDeserializer());
	}

}
