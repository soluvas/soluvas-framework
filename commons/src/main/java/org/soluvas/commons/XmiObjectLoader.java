package org.soluvas.commons;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
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
		final Bundle bundle = FrameworkUtil.getBundle(loaderClass);
		this.obj = load(ePackage, ResourceType.BUNDLE, resourceUri, resourcePath, bundle);
	}

	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(fileName);
		this.obj = load(ePackage, ResourceType.FILE, resourceUri, fileName, null);
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
		this.obj = load(ePackage, ResourceType.BUNDLE, resourceUri, fileName, bundle);
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
		this.obj = load(ePackage, ResourceType.FILE, resourceUri, fileName, null);
	}

	/**
	 * 
	 * @param ePackage
	 * @param resourceUrl
	 * @param resourceType
	 * @deprecated Use {@link #XmiObjectLoader(EPackage, URL, Bundle)}.
	 */
	@Deprecated
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final URL resourceUrl,
			@Nonnull final ResourceType resourceType) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
		Preconditions.checkNotNull(resourceType, "resourceType cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.obj = load(ePackage, resourceType, resourceUri, resourceUri.toString(), null);
	}
	
	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final URL resourceUrl,
			@Nonnull final Bundle bundle) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
		Preconditions.checkNotNull(bundle, "bundle cannot be null");
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		final Matcher matcher = Pattern.compile("([^.]+).*").matcher(resourceUri.lastSegment());
		final String resourceName = matcher.matches() ? matcher.group(1) : resourceUri.lastSegment();
		this.obj = load(ePackage, ResourceType.BUNDLE, resourceUri, resourceName, bundle);
	}
	
//	@Deprecated
//	public XmiObjectLoader(@Nonnull final EPackage ePackage, @Nonnull final URL resourceUrl,
//			@Nonnull final String resourceName, @Nonnull final Bundle bundle) {
//		super();
//		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
//		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
//		Preconditions.checkNotNull(resourceName, "resourceName cannot be null");
//		Preconditions.checkNotNull(bundle, "bundle cannot be null");
//		this.ePackageName = ePackage.getName();
//		this.ePackageNsUri = ePackage.getNsURI();
//		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
//		this.obj = load(ePackage, ResourceType.BUNDLE, resourceUri, resourceName, bundle);
//	}
	
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
	protected T load(@Nonnull final EPackage ePackage, @Nonnull final ResourceType resourceType,
			@Nonnull final URI resourceUri, @Nonnull final String resourceName,
			@Nullable final Bundle bundle) {
		log.debug("Loading XMI from URI: {}", resourceUri);
		
		final ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("ecore", new EcoreResourceFactoryImpl());
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
			throw new CommonsException("Cannot load " + resourceUri + " using package " + ePackage, e);
		}
		
		// Augment resource information
		{
			augmentResourceInfo(resourceType, resourceUri, resourceName, obj);
			final TreeIterator<EObject> allContents = obj.eAllContents();
			long augmented = 0;
			while (allContents.hasNext()) {
				EObject content = allContents.next();
				augmented += augmentResourceInfo(resourceType, resourceUri, resourceName, content);
			}
			if (augmented > 0)
				log.debug("Augmented {} EObjects with resource information from {}",
						augmented, resourceUri);
		}
		
		// Augment bundle information
		if (bundle != null) {
			augmentBundleInfo(bundle, obj);
			final TreeIterator<EObject> allContents = obj.eAllContents();
			long augmented = 0;
			while (allContents.hasNext()) {
				EObject content = allContents.next();
				augmented += augmentBundleInfo(bundle, content);
			}
			if (augmented > 0)
				log.debug("Augmented {} EObjects with Bundle information from {} [{}]",
						augmented, bundle.getSymbolicName(), bundle.getBundleId());
		}
		
		return obj;
	}

	protected long augmentResourceInfo(@Nonnull final ResourceType resourceType, @Nonnull final URI resourceUri,
			@Nonnull final String resourceName, @Nonnull final EObject content) {
		if (content instanceof ResourceAware) {
			final ResourceAware resourceContent = (ResourceAware) content;
			resourceContent.setResourceType(resourceType);
			resourceContent.setResourceUri(resourceUri.toString());
			resourceContent.setResourceName(resourceName);
			return 1;
		} else {
			return 0;
		}
	}

	protected long augmentBundleInfo(@Nonnull final Bundle bundle, @Nonnull final EObject content) {
		if (content instanceof BundleAware) {
			final BundleAware bundleContent = (BundleAware) content;
			bundleContent.setBundle(bundle);
			return 1;
		} else {
			return 0;
		}
	}

}
