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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
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
	
	private transient Logger log = LoggerFactory
			.getLogger(XmiObjectLoader.class);
	private T obj;
	private final String ePackageName;
	private final String ePackageNsUri;
	private final URI resourceUri;
	
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull Class<?> loaderClass, @Nonnull String resourcePath) {
		super();
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
		final URL resourceUrl = loaderClass.getResource(resourcePath);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
				resourcePath, loaderClass.getName());
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(ePackage, resourceUri, ResourceType.BUNDLE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull String fileName) {
		super();
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(fileName);
		load(ePackage, resourceUri, ResourceType.FILE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull URL resourceUrl,
			ResourceType resourceType) {
		super();
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(ePackage, resourceUri, resourceType);
	}
	
	@PreDestroy
	public void destroy() {
		log.info("Destroying XMI Loader for {} from {} [{}]", resourceUri, ePackageName, ePackageNsUri);
		obj = null;
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
	protected void load(EPackage ePackage, URI resourceUri, ResourceType resourceType) {
		log.debug("Loading XMI from URI: {}", resourceUri);
		
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("xmi", new XMIResourceFactoryImpl());
		
		try {
			rset.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			
			Resource resource = rset.getResource(resourceUri, true);
			T obj = (T)resource.getContents().get(0);
			log.info("Loaded {} from {}", obj, resourceUri);
			this.obj = obj;
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
			augmentResourceInfo(resourceUri, resourceType, content);
		}
		if (augmented > 0)
			log.debug("Augmented {} EObjects with resource information from {}",
					augmented, resourceUri);
	}

	protected void augmentResourceInfo(URI resourceUri,
			ResourceType resourceType, EObject content) {
		if (content instanceof ResourceAware) {
			((ResourceAware) content).setResourceType(resourceType);
			((ResourceAware) content).setResourceUri(resourceUri.toString());
		}
	}

}
