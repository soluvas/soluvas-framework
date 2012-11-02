package org.soluvas.commons;

import java.net.URL;

import javax.annotation.Nonnull;

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
	private final EPackage ePackage;
	private T obj;
	
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull Class<?> loaderClass, @Nonnull String resourcePath) {
		super();
		this.ePackage = ePackage;
		
		log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
		final URL resourceUrl = loaderClass.getResource(resourcePath);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
				resourcePath, loaderClass.getName());
		final URI resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(resourceUri, ResourceType.BUNDLE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull String fileName) {
		super();
		this.ePackage = ePackage;
		
		load(URI.createFileURI(fileName), ResourceType.FILE);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull URL resourceUrl,
			ResourceType resourceType) {
		super();
		this.ePackage = ePackage;
		
		final URI resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(resourceUri, resourceType);
	}

	@Deprecated
	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackageClass, @Nonnull Class<?> loaderClass, @Nonnull String resourcePath) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		this( (EPackage) ePackageClass.getDeclaredField("eINSTANCE").get(ePackageClass),
				loaderClass, resourcePath);
	}

	@Deprecated
	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackageClass, @Nonnull String fileName) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		this( (EPackage) ePackageClass.getDeclaredField("eINSTANCE").get(ePackageClass),
				fileName);
	}

	@Deprecated
	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackageClass, @Nonnull URL resourceUrl,
			ResourceType resourceType) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
		this( (EPackage) ePackageClass.getDeclaredField("eINSTANCE").get(ePackageClass),
				resourceUrl, resourceType);
	}

	@Override
	public T get() {
		return obj;
	}

	@SuppressWarnings("unchecked")
	protected void load(URI resourceUri, ResourceType resourceType) {
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
