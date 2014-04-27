package org.soluvas.commons;

import java.io.File;
import java.net.URL;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.osgi.framework.Bundle;

import com.google.common.collect.ImmutableMap;

/**
 * Loads a predefined EMF object from an XMI file once and keeps it in memory.
 * 
 * <p>Note: the object is supplied as-is from the {@link XMIResource}, i.e. not
 * cloned.
 * 
 * <p>Warning: {@link Expandable} scope is not supported. 
 * 
 * @author rudi
 */
public class StaticXmiLoader<T extends EObject> extends OnDemandXmiLoader<T> {
	
	private final T obj;
	
	public StaticXmiLoader(EPackage ePackage, Bundle bundle, String fileName) {
		super(ePackage, bundle, fileName);
		this.obj = load();
	}

	public StaticXmiLoader(EPackage ePackage, Class<?> loaderClass,
			String resourcePath) {
		super(ePackage, loaderClass, resourcePath);
		this.obj = load();
	}

	public StaticXmiLoader(EPackage ePackage, String baseDir, String fileName) {
		super(ePackage, baseDir, fileName);
		this.obj = load();
	}

	/**
	 * @param ePackage
	 * @param fileName
	 * @deprecated Use {@link #StaticXmiLoader(EPackage, File)} instead.
	 */
	@Deprecated
	public StaticXmiLoader(EPackage ePackage, String fileName) {
		this(ePackage, new File(fileName));
	}

	public StaticXmiLoader(EPackage ePackage, File file) {
		super(ePackage, file);
		this.obj = load();
	}

	public StaticXmiLoader(EPackage ePackage, File file, Map<String, ?> scope) {
		super(ePackage, file, scope);
		this.obj = load();
	}

	public StaticXmiLoader(EPackage ePackage, URL resourceUrl, Bundle bundle) {
		super(ePackage, resourceUrl, bundle);
		this.obj = load();
	}

	public StaticXmiLoader(EPackage ePackage, URL resourceUrl,
			ResourceType resourceType) {
		super(ePackage, resourceUrl, resourceType);
		this.obj = load();
	}

	@Override
	public T get() {
		if (obj == null) {
			log.warn("Returning null, probably XMI Loader has been destroyed for {} from {} [{}]",
					resourceUri, ePackageName, ePackageNsUri);
		}
		return obj;
	}
	
	@Override
	public ImmutableMap<String, Object> getScope() {
		return ImmutableMap.of();
	}

}
