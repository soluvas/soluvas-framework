package org.soluvas.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class SerializableEMap<K, V> extends EcoreEMap<K, V> implements Serializable {

	public static class SerializationProxy<K, V> implements Serializable {
		
		private final String entryEPackageNsUri;
		private final String entryEClassName;
		private final Class<?> entryClass;
		private final Map<K, Object> map;
		
		/**
		 * @param entryEPackageNsUri
		 * @param entryEClassName
		 * @param entryClass
		 * @param map
		 */
		public SerializationProxy(String entryEPackageNsUri,
				String entryEClassName, Class<?> entryClass, Map<K, V> map) {
			super();
			this.entryEPackageNsUri = entryEPackageNsUri;
			this.entryEClassName = entryEClassName;
			this.entryClass = entryClass;
			this.map = ImmutableMap.copyOf( Maps.transformValues(map, new Function<V, Object>() {
				@Override @Nullable
				public Object apply(@Nullable V input) {
					if (input instanceof EList) {
						return ImmutableList.copyOf((EList) input);
					} else
						return input;
				}
			}));
		}
		
		private Object readResolve() {
			final String entryEPackageNsUri = Preconditions.checkNotNull(this.entryEPackageNsUri,
					"entryEPackageNsUri is null, was not properly serialized");
			final String entryEClassName = Preconditions.checkNotNull(this.entryEClassName,
					"entryEClassName is null, was not properly serialized");
			final EClass entryEClass;
			
			// OSGi style EPackage resolution, workaround for
			// weird global EPackage.Registry behavior during deserialization
			final Bundle bundle = FrameworkUtil.getBundle(SerializableEMap.class);
			if (bundle != null) {
				final BundleContext bundleContext = bundle.getBundleContext();
				try {
					/* Code below won't work on OSGi:
					 * 
					 * java.lang.NullPointerException: Cannot find EPackage http://www.bippo.co.id/schema/product/1.0 in global EPackage Registry containing 0 entries: []
					 *      at com.google.common.base.Preconditions.checkNotNull(Preconditions.java:235)
					 *      at org.soluvas.commons.SerializableEMap$SerializationProxy.readResolve(SerializableEMap.java:70)
					 *      at java.lang.reflect.Method.invoke(Method.java:601)
					 *      at java.io.ObjectStreamClass.invokeReadResolve(ObjectStreamClass.java:1091)
					 *      at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1786)
					 *      at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1347)
					 *      at java.io.ObjectInputStream.defaultReadFields(ObjectInputStream.java:1970)
					 */
//				final EPackage entryEPackage = Preconditions.checkNotNull(EPackage.Registry.INSTANCE.getEPackage(entryEPackageNsUri),
//						"Cannot find EPackage %s in global EPackage Registry containing %s entries: %s",
//						entryEPackageNsUri, EPackage.Registry.INSTANCE.size(), EPackage.Registry.INSTANCE.keySet());
					
					final ServiceReference<EPackage> entryEPackageRef = bundleContext.getServiceReferences(EPackage.class, "(nsURI=" + entryEPackageNsUri + ")").iterator().next();
					final EPackage entryEPackage = bundleContext.getService(entryEPackageRef);
					try {
						entryEClass = (EClass) Preconditions.checkNotNull(entryEPackage.getEClassifier(entryEClassName),
								"Cannot find EClass %s in EPackage %s (%s)", entryEClassName, entryEPackage.getName(),
								entryEPackageNsUri);
					} finally {
						bundleContext.ungetService(entryEPackageRef);
					}
				} catch (Exception e) {
					throw new CommonsException(e, "Cannot find EPackage %s in OSGi EPackage Registry", entryEPackageNsUri);
				}
			} else {
				final EPackage entryEPackage = Preconditions.checkNotNull(EPackage.Registry.INSTANCE.getEPackage(entryEPackageNsUri),
					"Cannot find EPackage %s in global EPackage Registry containing %s entries: %s",
					entryEPackageNsUri, EPackage.Registry.INSTANCE.size(), EPackage.Registry.INSTANCE.keySet());
				entryEClass = (EClass) Preconditions.checkNotNull(entryEPackage.getEClassifier(entryEClassName),
						"Cannot find EClass %s in EPackage %s (%s)", entryEClassName, entryEPackage.getName(),
						entryEPackageNsUri);
			}

//			final BasicEMap<K, V> delegateEMap = new BasicEMap<K, V>(map);
//			final EList<org.eclipse.emf.common.util.BasicEMap.Entry<K, V>> eListDelegate =
//					new BasicEList<BasicEMap.Entry<K, V>>(delegateEMap.entrySet());
			final EList<BasicEMap.Entry<K, V>> eListDelegate = new BasicEList<BasicEMap.Entry<K, V>>();
			final EMap<K, V> eMap = new SerializableEMap<K, V>(entryEClass, entryClass, eListDelegate);
			
			final Map<K, V> resolvedMap = ImmutableMap.copyOf( Maps.transformValues(map, new Function<Object, V>() {
				@Override @Nullable
				public V apply(@Nullable Object input) {
					if (input instanceof List) {
						return (V) new BasicEList<Object>((List) input);
					} else
						return (V) input;
				}
			}));
			
			eMap.putAll(resolvedMap);
			return eMap;
		}
		
	}
	
	public SerializableEMap(
			EClass entryEClass,
			Class<?> entryClass,
			EList<org.eclipse.emf.common.util.BasicEMap.Entry<K, V>> delegateEList) {
		super(entryEClass, entryClass, delegateEList);
	}

	public SerializableEMap(EClass entryEClass, Class<?> entryClass,
			InternalEObject owner, int featureID, int inverseFeatureID) {
		super(entryEClass, entryClass, owner, featureID, inverseFeatureID);
	}

	public SerializableEMap(EClass entryEClass, Class<?> entryClass,
			InternalEObject owner, int featureID) {
		super(entryEClass, entryClass, owner, featureID);
	}
	
	private Object writeReplace() {
		return new SerializationProxy<K, V>(entryEClass.getEPackage().getNsURI(), entryEClass.getName(),
				entryClass, map());
	}

}
