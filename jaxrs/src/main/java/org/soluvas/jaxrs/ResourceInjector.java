package org.soluvas.jaxrs;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Filtered;
import org.soluvas.commons.Namespaced;
import org.soluvas.commons.Supplied;
import org.soluvas.commons.Supplied.Layer;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantUtils;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;

/**
 * Manages the lifecycle of tenant-scoped JAX-RS resources and performs dependency injection
 * using {@link Inject}, {@link Supplied}, {@link Namespaced} and {@link Filtered}.
 * Similar in purpose to MultitenantPage.
 * @todo Flawed design: What if a depended service suddenly gone in the middle of resource's operation?
 *   Blueprint manages that, but we don't. :(
 * @todo Support {@link PostConstruct} and {@link PreDestroy}.
 * @author ceefour
 */
public class ResourceInjector {

	private transient Logger log = LoggerFactory
			.getLogger(ResourceInjector.class);
	
	public static enum InjectMode {
		SERVICE, SUPPLIED
	}
	
	public static class Injectable {
		private final Field field;
		private final Class<?> clazz;
		private final InjectMode mode;
		private final Layer layer;
		private final String namespace;
		private final String filter;
		
		/**
		 * @param field
		 * @param clazz
		 * @param mode
		 * @param layer
		 * @param namespace
		 * @param filter
		 */
		public Injectable(Field field, Class<?> clazz, InjectMode mode,
				Layer layer, String namespace, String filter) {
			super();
			this.field = field;
			this.clazz = clazz;
			this.mode = mode;
			this.layer = layer;
			this.namespace = namespace;
			this.filter = filter;
		}

		/**
		 * @return the field
		 */
		public Field getField() {
			return field;
		}

		/**
		 * @return the clazz
		 */
		public Class<?> getClazz() {
			return clazz;
		}

		/**
		 * @return the mode
		 */
		public InjectMode getMode() {
			return mode;
		}

		/**
		 * @return the namespace
		 */
		public String getNamespace() {
			return namespace;
		}

		/**
		 * @return the filter
		 */
		public String getFilter() {
			return filter;
		}

		/**
		 * @return the layer
		 */
		public Layer getLayer() {
			return layer;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Injectable ["
					+ (field != null ? "field=" + field + ", " : "")
					+ (clazz != null ? "clazz=" + clazz + ", " : "")
					+ (mode != null ? "mode=" + mode + ", " : "")
					+ (layer != null ? "layer=" + layer + ", " : "")
					+ (namespace != null ? "namespace=" + namespace + ", " : "")
					+ (filter != null ? "filter=" + filter : "") + "]";
		}
		
	}
	
	public static class Injection {
		private final ServiceReference<?> ref;
		private final Field field;
		
		/**
		 * @param ref
		 * @param field
		 */
		public Injection(ServiceReference<?> ref, Field field) {
			super();
			this.ref = ref;
			this.field = field;
		}

		/**
		 * @return the ref
		 */
		public ServiceReference<?> getRef() {
			return ref;
		}

		/**
		 * @return the field
		 */
		public Field getField() {
			return field;
		}
		
	}
	
	public static class Instance {
		private final Object object;
		private final List<Injection> injections;
		
		/**
		 * @param object
		 * @param injections
		 */
		public Instance(Object object, List<Injection> injections) {
			super();
			this.object = object;
			this.injections = injections;
		}

		/**
		 * @return the object
		 */
		public Object getObject() {
			return object;
		}

		/**
		 * @return the injections
		 */
		public List<Injection> getInjections() {
			return injections;
		}
		
	}
	
	private final BundleContext bundleContext;
	private final TenantRef tenant;
	private final List<Instance> instances = Lists.newCopyOnWriteArrayList();
	
	/**
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	public ResourceInjector(BundleContext bundleContext, String tenantId,
			String tenantEnv) {
		super();
		this.bundleContext = bundleContext;
		this.tenant = new TenantRef(null, tenantId, tenantEnv);
	}

	protected List<Field> getAllDeclaredFields(Class<?> clazz) {
		Builder<Field> fields = ImmutableList.builder();
		Class<?> superclass = clazz.getSuperclass();
		if (superclass != null) {
			fields.addAll(ImmutableList.copyOf(superclass.getDeclaredFields()));
		}
		return fields.build();
	}
	
	protected List<Injectable> analyzeClass(Class<?> clazz) {
		final List<Field> fields = getAllDeclaredFields(clazz);
		final Builder<Injectable> injectables = ImmutableList.builder();
		for (Field field : fields) {
			if (!field.isAnnotationPresent(Inject.class)) {
				continue;
			}
			final InjectMode injectMode = field.isAnnotationPresent(Supplied.class) ? InjectMode.SUPPLIED : InjectMode.SERVICE;
			final Layer layer = field.isAnnotationPresent(Supplied.class) ? field.getAnnotation(Supplied.class).value() : null;
			final String namespace = field.isAnnotationPresent(Namespaced.class) ? field.getAnnotation(Namespaced.class).value() : null;
			final String filter = field.isAnnotationPresent(Filtered.class) ? field.getAnnotation(Filtered.class).value() : null;
			injectables.add( new Injectable(field, field.getType(), injectMode, layer, namespace, filter) );
		}
		return injectables.build();
	}
	
	public <T> T getInstance(Class<T> clazz) {
		final List<Injectable> injectables = analyzeClass(clazz);
		log.debug("Creating {} JAX-RS resource for {} in {} [{}] with {} injectables: {}", clazz.getName(), tenant,
				bundleContext.getBundle().getSymbolicName(), bundleContext.getBundle().getBundleId(),
				injectables.size(), injectables);
		final T obj;
		final Builder<Injection> injections = ImmutableList.builder();
		try {
			obj = clazz.newInstance();
			for (Injectable injectable : injectables) {
				switch (injectable.getMode()) {
				case SERVICE: {
						final ServiceReference<?> ref = TenantUtils.getService(bundleContext, tenant, injectable.getClazz(), injectable.getNamespace(), injectable.getFilter());
						final Object dep = bundleContext.getService(ref);
						injections.add( new Injection(ref, injectable.getField()) );
						FieldUtils.writeField(injectable.getField(), obj, dep, true);
						break;
					}
				case SUPPLIED: {
						final Object dep = TenantUtils.getSupplied(bundleContext, tenant, injectable.getClazz());
						injections.add( new Injection(null, injectable.getField()) );
						FieldUtils.writeField(injectable.getField(), obj, dep, true);
						break;
					}
				}
			}
			final Instance instance = new Instance(obj, injections.build());
			instances.add(instance);
		} catch (Exception e) {
			// rollback OSGi getService
			for (Injection injection : injections.build()) {
				if (injection.getRef() != null) {
					bundleContext.ungetService(injection.getRef());
				}
			}
			Throwables.propagate(e);
			return null;
		}
		return obj;
	}
	
	/**
	 * Uninjects all dependencies and ungets all services (except supplieds).
	 */
	@PreDestroy
	public void destroy() {
		for (Instance instance : ImmutableList.copyOf(instances)) {
			destroyInstance(instance);
		}
	}

	protected void destroyInstance(Instance instance) {
		try {
			log.debug("Destroying {} JAX-RS resource of {} with {} injections from {} [{}]",
					instance.getObject().getClass(), tenant, instance.getInjections().size(),
					bundleContext.getBundle().getSymbolicName(), bundleContext.getBundle().getBundleId());
			for (Injection injection : instance.getInjections()) {
				if (injection.getRef() != null) {
					bundleContext.ungetService(injection.getRef());
				}
				FieldUtils.writeField(injection.getField(), instance.getObject(), null, true);
			}
			instances.remove(instance);
		} catch (IllegalAccessException e) {
			Throwables.propagate(e);
		}
	}

}
