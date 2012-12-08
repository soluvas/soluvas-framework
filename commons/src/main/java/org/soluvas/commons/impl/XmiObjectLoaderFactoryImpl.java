package org.soluvas.commons.impl;

import java.net.URL;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.commons.XmiObjectLoaderFactory;

/**
 * Creates {@link XmiObjectLoader}. This is not necessary, but simply attempt to workaround
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
	public <T extends EObject> XmiObjectLoader<T> create(@Nonnull final EPackage ePackage, @Nonnull final Class<?> loaderClass, @Nonnull final String resourcePath) {
		return new XmiObjectLoader<T>(ePackage, loaderClass, resourcePath);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.lang.String)
	 */
	@Override
	public <T extends EObject> XmiObjectLoader<T> create(@Nonnull final EPackage ePackage, @Nonnull final String fileName) {
		return new XmiObjectLoader<T>(ePackage, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, org.osgi.framework.Bundle, java.lang.String)
	 */
	@Override
	public <T extends EObject> XmiObjectLoader<T> create(@Nonnull final EPackage ePackage, @Nonnull final Bundle bundle, @Nonnull final String fileName) {
		return new XmiObjectLoader<T>(ePackage, bundle, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.lang.String, java.lang.String)
	 */
	@Override
	public <T extends EObject> XmiObjectLoader<T> create(@Nonnull final EPackage ePackage, @Nonnull final String baseDir, @Nonnull final String fileName) {
		return new XmiObjectLoader<T>(ePackage, baseDir, fileName);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.commons.XmiObjectLoaderFactory#create(org.eclipse.emf.ecore.EPackage, java.net.URL, org.soluvas.commons.ResourceType)
	 */
	@Override
	public <T extends EObject> XmiObjectLoader<T> create(@Nonnull final EPackage ePackage, @Nonnull final URL resourceUrl,
			@Nonnull final ResourceType resourceType) {
		return new XmiObjectLoader<T>(ePackage, resourceUrl, resourceType);
	}

}
