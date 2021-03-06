package org.soluvas.commons.tenant;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.felix.service.command.CommandSession;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsException;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;

/**
 * Provides helper to lookup <b>single-tenant</b> services in the OSGi runtime.
 * 
 * Note: Do <strong>not</strong> expose this as a service! Rather, create a bean for each bundle,
 * then pass it to a {@link ServiceLookup} field in the consumer class.
 *  
 * @author ceefour
 * @version 1.1
 */
public class OsgiServiceLookup implements ServiceLookup {
	
	private static final Logger log = LoggerFactory.getLogger(OsgiServiceLookup.class);
	private final BundleContext bundleContext;
	
	public OsgiServiceLookup(final BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
	}

	@Deprecated
	@Override
	public <T, S extends T> void withService(Class<T> clazz, CommandSession commandSession, final FutureCallback<S> callback) {
		withService(clazz, commandSession, new Function<S, Void>() {
			@Override
			public Void apply(S input) {
				callback.onSuccess(input);
				return null;
			};
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, R, S extends T> R withService(Class<T> clazz, String filter, Function<S,R> callback) {
		return TenantUtils.withService(bundleContext, clazz, filter, callback);
	}

	@Override
	public <T, R> R withService(Class<T> clazz, String clientId, String tenantEnv, 
			String tenantId, String namespace, Function<? extends T, R> callback) {
		final String filter = String.format("(&namespace=%s)",
				clientId, tenantId, tenantEnv, namespace);
		return withService(clazz, filter, callback);
	}

	@Override
	public <T, R> R withService(Class<T> clazz, String clientId, String tenantEnv, 
			String tenantId, Function<? extends T, R> callback) {
		return withService(clazz, (String) null, callback);
	}

	@Override
	public <T, R> R withService(Class<T> clazz,
			CommandSession commandSession, @Nullable String namespace,
			@Nullable String filter, Function<? extends T, R> callback) {
		final String realFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace=" + namespace	+ ")" : null;
		return withService(clazz, realFilter, callback);
	}

	@Override
	public <T, R> R withService(Class<T> clazz,
			CommandSession commandSession, Function<? extends T, R> callback) {
		return withService(clazz, commandSession, null, null, callback);
	}

	@Override
	public <T, R> R withService(Class<T> clazz,
			CommandSession commandSession, String namespace,
			Function<? extends T, R> callback) {
		return withService(clazz, commandSession, namespace, null, callback);
	}

	/**
	 * Get {@link TenantRefImpl} for provided {@link CommandSession}.
	 * 
	 * @return
	 */
	@Override
	public TenantRef getTenant(final CommandSession session) {
		Preconditions.checkNotNull(session, "CommandSession must not be null");
		final String clientId = null;
		final String tenantEnv = null;
		final String tenantId = null;
		return new TenantRefImpl(clientId, tenantId, tenantEnv);
	}

	/**
	 * Get OSGi {@link ServiceReference} scoped to the provided
	 * {@link CommandSession}.
	 * 
	 * @param iface
	 * @param namespace
	 * @param filter
	 * @return
	 */
	@Override
	public <T> ServiceReference<T> getService(Class<T> iface,
			CommandSession session, @Nullable String namespace,
			@Nullable String filter) {
		final String ifaceName = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		log.trace("Lookup {} for namespace={} filter: {}",
				ifaceName, namespace, additionalFilter);
		final String namespaceFilter = !Strings.isNullOrEmpty(namespace)
				? "(namespace=" + namespace + ")"
				: "";
		final String realFilter;
		if (!Strings.isNullOrEmpty(namespaceFilter) || !Strings.isNullOrEmpty(additionalFilter)) {
			realFilter = "(&" + namespaceFilter + additionalFilter + ")";
		} else {
			realFilter = null;
		}

		ServiceReference<T> serviceRef = null;
		try {
			Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty())
				throw new CommonsException("Cannot find " + ifaceName
						+ " service with filter " + realFilter);
			serviceRef = foundRefs.iterator().next();
			return serviceRef;
		} catch (InvalidSyntaxException e) {
			throw new CommonsException("Cannot find " + ifaceName + " service with filter " + realFilter, e);
		}
	}

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service.
	 * 
	 * @param clazz
	 * @return
	 */
	@Override
	public <T> T getSupplied(Class<T> clazz, CommandSession session) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(
				OsgiServiceLookup.class).getBundleContext();
		return TenantUtils.getSupplied(bundleContext, null, clazz);
	}
	
	@Override
	public <T> Set<String> getNamespaces(final Class<T> iface, final TenantRef tenant, @Nullable final String filter) {
		final String ifaceName = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		log.trace(
				"Lookup {} for filter: {}",
				ifaceName, additionalFilter );
		final String realFilter = Strings.emptyToNull(additionalFilter);

		try {
			Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty()) {
				log.trace("Cannot find {} service with filter {}", ifaceName, realFilter);
				return ImmutableSet.of();
			} else {
				Collection<String> namespaces = Collections2.transform(foundRefs, new Function<ServiceReference<T>, String>() {
					@Override
					@Nullable
					public String apply(@Nullable ServiceReference<T> ref) {
						return Optional.fromNullable((String) ref.getProperty("namespace")).or("");
					}
				});
				final Set<String> namespaceSet = ImmutableSet.copyOf(namespaces);
				log.trace("{} service namespaces with filter {}: {}", ifaceName, realFilter, namespaceSet);
				return namespaceSet;
			}
		} catch (InvalidSyntaxException e) {
			throw new CommonsException("Cannot find " + ifaceName + " service with filter " + realFilter, e);
		}
	}

}
