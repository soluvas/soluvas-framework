package org.soluvas.commons;

import java.net.URL;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;

/**
 * Loads a predefined EMF object from an XMI file.
 * 
 * Note: the object is supplied as-is from the {@link XMIResource}, i.e. not
 * cloned.
 * 
 * @author rudi
 */
public class XmiObjectLoader<T extends EObject> implements Supplier<T> {
	
	private static Logger log = LoggerFactory
			.getLogger(XmiObjectLoader.class);
	private final T obj;
	private final String ePackageName;
	private final String ePackageNsUri;
	private final URI resourceUri;
	
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final Class<?> loaderClass, @Nonnull final String resourcePath) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(loaderClass, "loaderClass cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(resourcePath), "resourcePath cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
		final URL resourceUrl = loaderClass.getResource(resourcePath);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
				resourcePath, loaderClass.getName());
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.obj = load(ePackage, resourceUri, ResourceType.BUNDLE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(fileName);
		this.obj = load(ePackage, resourceUri, ResourceType.FILE);
	}

	/**
	 * Loads from a file inside a {@link Bundle}.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final Bundle bundle, @Nonnull final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(bundle, "bundle cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		final URL resourceUrl = bundle.getResource(fileName);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s in bundle %s [%s]",
				fileName, bundle.getSymbolicName(), bundle.getBundleId());
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.obj = load(ePackage, resourceUri, ResourceType.BUNDLE);
	}

	/**
	 * Loads from a file inside a baseDir, this makes it much easier to configure in Blueprint XML, because Blueprint property configurer does not support expressions.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final String baseDir, @Nonnull final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(baseDir), "baseDir cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(baseDir + "/" + fileName);
		this.obj = load(ePackage, resourceUri, ResourceType.FILE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final URL resourceUrl,
			@Nonnull final ResourceType resourceType) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
		Preconditions.checkNotNull(resourceType, "resourceType cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.obj = load(ePackage, resourceUri, resourceType);
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Destroying XMI Loader for {} from {} [{}]", resourceUri, ePackageName, ePackageNsUri);
	}

	@Override
	@Nullable
	public T get() {
		if (obj == null) {
			log.warn("Returning null, probably XMI Loader has been destroyed for {} from {} [{}]",
					resourceUri, ePackageName, ePackageNsUri);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	protected T load(@Nonnull final EPackage ePackage, @Nonnull final URI resourceUri,
			@Nonnull final ResourceType resourceType) {
		log.debug("Loading XMI from URI: {}", resourceUri);
		
		final ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("xmi", new XMIResourceFactoryImpl());
		
		final T obj;
		try {
			rset.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			
			final Resource resource = rset.getResource(resourceUri, true);
			obj = (T)resource.getContents().get(0);
			log.info("Loaded {} from {}", obj, resourceUri);
		} catch (Exception e) {
			log.error("Cannot load " + resourceUri + " using package " + ePackage, e);
			throw new RuntimeException("Cannot load " + resourceUri + " using package " + ePackage, e);
		}
		
		// Augment resource information
		augmentResourceInfo(resourceUri, resourceType, obj);
		final TreeIterator<EObject> allContents = obj.eAllContents();
		long augmented = 0;
		while (allContents.hasNext()) {
			EObject content = allContents.next();
			augmented += augmentResourceInfo(resourceUri, resourceType, content);
		}
		if (augmented > 0)
			log.debug("Augmented {} EObjects with resource information from {}",
					augmented, resourceUri);
		
		return obj;
	}

	protected long augmentResourceInfo(@Nonnull final URI resourceUri,
			@Nonnull final ResourceType resourceType, @Nonnull final EObject content) {
		if (content instanceof ResourceAware) {
			// TODO: add the resourcePath, relative to parent resource
			((ResourceAware) content).setResourceType(resourceType);
			((ResourceAware) content).setResourceUri(resourceUri.toString());
			return 1;
		} else {
			return 0;
		}
	}

}
