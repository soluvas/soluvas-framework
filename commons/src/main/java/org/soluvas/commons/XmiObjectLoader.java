package org.soluvas.commons;

import java.net.URL;

import javax.annotation.Nonnull;

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
	private final Class<? extends EPackage> ePackage;
	private Class<?> loaderClass;
	private String resourcePath;
	private String fileName;
	private T obj;
	
	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackage, @Nonnull Class<?> loaderClass, @Nonnull String resourcePath) {
		super();
		this.ePackage = ePackage;
		this.loaderClass = loaderClass;
		this.resourcePath = resourcePath;
		
		log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
		final URL resourceUrl = loaderClass.getResource(resourcePath);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
				resourcePath, loaderClass.getName());
		final URI resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(resourceUri);
	}

	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackage, @Nonnull String fileName) {
		super();
		this.ePackage = ePackage;
		this.fileName = fileName;
		
		load(URI.createFileURI(fileName));
	}

	public XmiObjectLoader(@Nonnull Class<? extends EPackage> ePackage, @Nonnull URL resourceUrl) {
		super();
		this.ePackage = ePackage;
		
		final URI resourceUri = URI.createURI(resourceUrl.toExternalForm());
		load(resourceUri);
	}

	@Override
	public T get() {
		return obj;
	}

	@SuppressWarnings("unchecked")
	protected void load(URI resourceUri) {
		log.debug("Loading XMI from URI: {}", resourceUri);
		
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("xmi", new XMIResourceFactoryImpl());
		
		try {
			String packageNsUri = (String) ePackage.getDeclaredField("eNS_URI").get(ePackage);
			EPackage packageInstance = (EPackage) ePackage.getDeclaredField("eINSTANCE").get(ePackage);
//		rset.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			rset.getPackageRegistry().put(packageNsUri, packageInstance);
			
			Resource resource = rset.getResource(resourceUri, true);
			T obj = (T)resource.getContents().get(0);
			log.info("Loaded {} from {}", obj, resourceUri);
			this.obj = obj;
		} catch (Exception e) {
			log.error("Cannot load " + resourceUri + " using package " + ePackage, e);
			throw new RuntimeException("Cannot load " + resourceUri + " using package " + ePackage, e);
		}
	}

}
