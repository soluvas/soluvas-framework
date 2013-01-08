package org.soluvas.json;

import org.eclipse.emf.common.util.EMap;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class EmfModule extends SimpleModule {
	
	public EmfModule() {
		super("emf", new Version(2, 8, 1, "", "org.soluvas", "emf"));
		addSerializer(EMap.class, new EMapSerializer());
		addDeserializer(EMap.class, new EMapDeserializer());
//		addSerializer(EList.class, new EListSerializer());
	}
	
}
