package org.soluvas.json;

import org.eclipse.emf.common.util.EMap;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 */
public class EmfModule extends SimpleModule {
	
	private static final long serialVersionUID = 1L;

	public EmfModule() {
		super("emf", new Version(2, 8, 1, "", "org.soluvas", "emf"));
		
		// TODO: put it someplace better
		addSerializer(DateTimeZone.class, new DateTimeZoneSerializer());
		addDeserializer(DateTimeZone.class, new DateTimeZoneDeserializer());
		
		addSerializer(EMap.class, new EMapSerializer());
		addDeserializer(EMap.class, new EMapDeserializer());
//		addSerializer(EList.class, new EListSerializer());
	}
	
}
