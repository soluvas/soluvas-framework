package org.soluvas.commons;

import java.net.URL;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

public interface XmiObjectLoaderFactory {

	public abstract <T extends EObject> XmiObjectLoader<T> create(
			@Nonnull EPackage ePackage, @Nonnull Class<?> loaderClass,
			@Nonnull String resourcePath);

	public abstract <T extends EObject> XmiObjectLoader<T> create(
			@Nonnull EPackage ePackage, @Nonnull String fileName);

	/**
	 * Loads from a file inside a {@link Bundle}.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public abstract <T extends EObject> XmiObjectLoader<T> create(
			@Nonnull EPackage ePackage, @Nonnull Bundle bundle,
			@Nonnull String fileName);

	/**
	 * Loads from a file inside a baseDir, this makes it much easier to configure in Blueprint XML, because Blueprint property configurer does not support expressions.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public abstract <T extends EObject> XmiObjectLoader<T> create(
			@Nonnull EPackage ePackage, @Nonnull String baseDir,
			@Nonnull String fileName);

	public abstract <T extends EObject> XmiObjectLoader<T> create(
			@Nonnull EPackage ePackage, @Nonnull URL resourceUrl,
			@Nonnull ResourceType resourceType);

}