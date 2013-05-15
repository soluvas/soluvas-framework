package org.soluvas.commons.impl;

import java.net.URL;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.commons.XmiObjectLoaderFactory;

/**
 * Creates {@link StaticXmiLoader}. This is not necessary, but simply attempt to workaround
 * for Karaf/Blueprint bug. which didn't work anyway.
 * @author ceefour
 * @deprecated Delete this class after not referenced.
 */
@Deprecated
public class XmiObjectLoaderFactoryImpl implements XmiObjectLoaderFactory {
	
	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.lang.Class, java.lang.String)
	 */
	@Override
	public <T extends EObject> StaticXmiLoader<T> create(final EPackage ePackage, final Class<?> loaderClass, final String resourcePath) {
		return new StaticXmiLoader<T>(ePackage, loaderClass, resourcePath);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.lang.String)
	 */
	@Override
	public <T extends EObject> StaticXmiLoader<T> create(final EPackage ePackage, final String fileName) {
		return new StaticXmiLoader<T>(ePackage, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, org.osgi.framework.Bundle, java.lang.String)
	 */
	@Override
	public <T extends EObject> StaticXmiLoader<T> create(final EPackage ePackage, final Bundle bundle, final String fileName) {
		return new StaticXmiLoader<T>(ePackage, bundle, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.lang.String, java.lang.String)
	 */
	@Override
	public <T extends EObject> StaticXmiLoader<T> create(final EPackage ePackage, final String baseDir, final String fileName) {
		return new StaticXmiLoader<T>(ePackage, baseDir, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.net.URL, org.soluvas.commons.ResourceType)
	 */
	@Override
	public <T extends EObject> StaticXmiLoader<T> create(final EPackage ePackage, final URL resourceUrl,
			final ResourceType resourceType) {
		return new StaticXmiLoader<T>(ePackage, resourceUrl, resourceType);
	}

}
