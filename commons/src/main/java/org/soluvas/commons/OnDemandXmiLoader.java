package org.soluvas.commons;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.google.common.collect.ImmutableMap;

/**
 * Loads a predefined EMF object from an XMI file on every {@link #get()} call.
 * 
 * Note: the object is supplied as-is from the {@link XMIResource}, i.e. not
 * cloned.
 * 
 * @author rudi
 */
public class OnDemandXmiLoader<T extends EObject> implements Supplier<T> {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	protected final String ePackageName;
	protected final String ePackageNsUri;
	protected final URI resourceUri;
	protected final ResourceType resourceType;
	protected final String resourceName;
	protected final Bundle bundle;
	protected final EPackage ePackage;
	protected final ImmutableMap<String, Object> scope;
	
	/**
	 * Will load using a {@link ClassLoader}, without {@code scope}.
	 * @param ePackage
	 * @param loaderClass
	 * @param resourcePath
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final Class<?> loaderClass, final String resourcePath) {
		this(ePackage, loaderClass, resourcePath, ImmutableMap.<String, Object>of());
	}

	/**
	 * Will load using a {@link ClassLoader}, with {@code scope}.
	 * @param ePackage
	 * @param loaderClass
	 * @param resourcePath
	 * @param scope
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final Class<?> loaderClass, final String resourcePath,
			Map<String, ?> scope) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(loaderClass, "loaderClass cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(resourcePath), "resourcePath cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		log.info("Loading XMI: {} from {}", resourcePath, loaderClass.getName());
		final URL resourceUrl = loaderClass.getResource(resourcePath);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s using class %s",
				resourcePath, loaderClass.getName());
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.bundle = FrameworkUtil.getBundle(loaderClass);
//		final Bundle bundle = Preconditions.checkNotNull(FrameworkUtil.getBundle(loaderClass),
//				"Cannot get bundle for %s", loaderClass);
		if (bundle != null) {
			this.resourceType = ResourceType.BUNDLE;
			this.resourceName = resourcePath;
		} else {
			this.resourceType = ResourceType.CLASSPATH;
			this.resourceName = resourcePath;
		}
		this.scope = ImmutableMap.copyOf(scope);
	}

	/**
	 * Will load from filesystem {@link File}, without {@code scope}.
	 * @param ePackage
	 * @param file
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final File file) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(file != null, "fileName cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(file.toString());
		this.resourceType = ResourceType.FILE;
		this.resourceName = file.toString();
		this.bundle = null;
		this.scope = ImmutableMap.of();
	}

	/**
	 * Will load from filesystem {@link File}, with {@code scope}.
	 * @param ePackage
	 * @param file
	 * @param scope
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final File file, Map<String, Object> scope) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(file != null, "fileName cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(file.toString());
		this.resourceType = ResourceType.FILE;
		this.resourceName = file.toString();
		this.bundle = null;
		this.scope = ImmutableMap.copyOf(scope);
	}

	/**
	 * Loads from a file inside a {@link Bundle}.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final Bundle bundle, final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(bundle, "bundle cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		final URL resourceUrl = bundle.getResource(fileName);
		Preconditions.checkNotNull(resourceUrl, "Cannot find resource %s in bundle %s [%s]",
				fileName, bundle.getSymbolicName(), bundle.getBundleId());
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.resourceType = ResourceType.BUNDLE;
		this.resourceName = fileName;
		this.bundle = null;
		this.scope = ImmutableMap.of();
	}

	/**
	 * Loads from a file inside a baseDir, this makes it much easier to configure in Blueprint XML, because Blueprint property configurer does not support expressions.
	 * @param ePackage
	 * @param baseDir
	 * @param fileName
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final String baseDir, final String fileName) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(baseDir), "baseDir cannot be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "fileName cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createFileURI(baseDir + "/" + fileName);
		this.resourceType = ResourceType.FILE;
		this.resourceName = fileName;
		this.bundle = null;
		this.scope = ImmutableMap.of();
	}

	/**
	 * 
	 * @param ePackage
	 * @param resourceUrl
	 * @param resourceType
	 */
	public OnDemandXmiLoader(final EPackage ePackage, final URL resourceUrl,
			final ResourceType resourceType) {
		this(ePackage, resourceUrl, resourceType, ImmutableMap.<String, Object>of());
	}
	
	public OnDemandXmiLoader(final EPackage ePackage, final URL resourceUrl,
			final ResourceType resourceType, Map<String, ?> scope) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
		Preconditions.checkNotNull(resourceType, "resourceType cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		this.resourceType = resourceType;
		this.resourceName = resourceUrl.getFile();
		this.bundle = null;
		this.scope = ImmutableMap.copyOf(scope);
	}
	
	public OnDemandXmiLoader(final EPackage ePackage, final URL resourceUrl,
			final Bundle bundle) {
		super();
		Preconditions.checkNotNull(ePackage, "ePackage cannot be null");
		Preconditions.checkNotNull(resourceUrl, "resourceUrl cannot be null");
		Preconditions.checkNotNull(bundle, "bundle cannot be null");
		this.ePackage = ePackage;
		this.ePackageName = ePackage.getName();
		this.ePackageNsUri = ePackage.getNsURI();
		this.resourceUri = URI.createURI(resourceUrl.toExternalForm());
		final Matcher matcher = Pattern.compile("([^.]+).*").matcher(resourceUri.lastSegment());
		this.resourceName = matcher.matches() ? matcher.group(1) : resourceUri.lastSegment();
		this.resourceType = ResourceType.BUNDLE;
		this.bundle = bundle;
		this.scope = ImmutableMap.of();
	}
	
//	@Deprecated
//	public XmiObjectLoader(final EPackage ePackage, final URL resourceUrl,
//			final String resourceName, final Bundle bundle) {
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
	public T get() {
		return load();
	}

	protected T load() {
		if (bundle != null) {
			log.debug("Loading XMI from URI: {} using bundle {}", resourceUri, bundle);
		} else {
			log.debug("Loading XMI from URI: {} using {}", resourceUri, resourceType);
		}
		
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
			log.info("Loaded {} object from {}", obj.getClass().getName(), resourceUri);
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
				final EObject content = allContents.next();
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
				final EObject content = allContents.next();
				augmented += augmentBundleInfo(bundle, content);
			}
			if (augmented > 0) {
				log.debug("Augmented {} EObjects with Bundle information from {} [{}]",
						augmented, bundle.getSymbolicName(), bundle.getBundleId());
			} else {
//				final int allContentsSize = Iterators.size(allContents);
//				log.warn("Not augmenting {} EObjects with Bundle information from {} [{}] because not implementing BundleAware",
//						allContentsSize, bundle.getSymbolicName(), bundle.getBundleId());
			}
		}
		
		// Expand with scope
		expand(obj);
		final TreeIterator<EObject> allContents = obj.eAllContents();
		long augmented = 0;
		while (allContents.hasNext()) {
			final EObject content = allContents.next();
			augmented += expand(content);
		}
		if (augmented > 0)
			log.debug("Expanded {} EObjects with Scope {}",
					augmented, scope);
		
		return obj;
	}

	protected long augmentResourceInfo(final ResourceType resourceType, final URI resourceUri,
			final String resourceName, final EObject content) {
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

	protected long augmentBundleInfo(final Bundle bundle, final EObject content) {
		if (content instanceof BundleAware) {
			final BundleAware bundleContent = (BundleAware) content;
			bundleContent.setBundle(bundle);
			return 1;
		} else {
			return 0;
		}
	}

	protected long expand(final EObject content) {
		if (content instanceof Expandable) {
			try {
				((Expandable) content).expand(scope);
				return 1;
			} catch (Exception e) {
				throw new CommonsException("Cannot expand " + content.getClass().getName(), e);
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * Immutable scope, will be or was used by {@link Expandable#expand(Map)}.
	 * @return
	 */
	public ImmutableMap<String, Object> getScope() {
		return scope;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " ["
				+ (ePackageName != null ? "ePackageName=" + ePackageName + ", "
						: "")
				+ (ePackageNsUri != null ? "ePackageNsUri=" + ePackageNsUri
						+ ", " : "")
				+ (resourceUri != null ? "resourceUri=" + resourceUri + ", "
						: "")
				+ (resourceType != null ? "resourceType=" + resourceType + ", "
						: "")
				+ (resourceName != null ? "resourceName=" + resourceName + ", "
						: "")
				+ (bundle != null ? "bundle=" + bundle + ", " : "")
				+ (ePackage != null ? "ePackage=" + ePackage : "") + "]";
	}

}
