package org.soluvas.json;

import org.eclipse.emf.common.util.EMap;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author ceefour
 */
public class EmfModule extends SimpleModule {
	
	private static final long serialVersionUID = 1L;

	public EmfModule() {
		super("emf", new Version(2, 9, 2, "", "org.soluvas", "emf"));
		
		// TODO: this breaks EMap<String, EList<Value<?>>> in Product
//		setMixInAnnotation(EList.class, EListMixin.class);
		
		addSerializer(EMap.class, new EMapSerializer());
		addDeserializer(EMap.class, new EMapDeserializer());
//		addSerializer(EList.class, new EListSerializer());
	}
	
}
