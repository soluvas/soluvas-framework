package org.soluvas.commons;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

/**
 * Loads a predefined EMF object from an XMI file. 
 * @author rudi
 */
public class XmiObjectLoader<T extends EObject> implements Supplier<T> {
	
	private transient Logger log = LoggerFactory
			.getLogger(XmiObjectLoader.class);
	private Class<? extends EPackage> ePackage;
	private Class<?> loaderClass;
	private String resourcePath;
	private String fileName;
	
	public XmiObjectLoader(Class<? extends EPackage> ePackage, Class<?> loaderClass, String resourcePath) {
		super();
		this.ePackage = ePackage;
		this.loaderClass = loaderClass;
		this.resourcePath = resourcePath;
	}

	public XmiObjectLoader(Class<? extends EPackage> ePackage, String fileName) {
		super();
		this.ePackage = ePackage;
		this.fileName = fileName;
	}

	@SuppressWarnings("unchecked") @Override
	public T get() {
		URI resourceUri;
		if (fileName != null) {
			resourceUri = URI.createFileURI(fileName);
		} else {
			log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
			final URL resourceUrl = loaderClass.getResource(resourcePath);
			Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
					resourcePath, loaderClass.getName());
			resourceUri = URI.createURI(resourceUrl.toExternalForm());
		}
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
			return EcoreUtil.copy(obj);
		} catch (Exception e) {
			log.error("Cannot load " + resourceUri + " using package " + ePackage, e);
			throw new RuntimeException("Cannot load " + resourceUri + " using package " + ePackage, e);
		}
	}

}
