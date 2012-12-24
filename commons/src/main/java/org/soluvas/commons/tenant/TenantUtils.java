package org.soluvas.commons.tenant;

import java.util.Collection;

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

/**
 * Get tenant-aware services.
 * @author ceefour
 */
public class TenantUtils {
	
	private static final Logger log = LoggerFactory.getLogger(TenantUtils.class);
	
	@SuppressWarnings("unchecked")
	public static <T, R, S extends T> R withService(BundleContext bundleContext, Class<T> clazz, String filter, Function<S,R> callback) {
		final ServiceReference<?>[] refs;
		try {
			refs = (ServiceReference<?>[]) bundleContext
					.getServiceReferences(clazz.getName(), filter);
		} catch (Exception e) {
			log.error(String.format("Cannot find service %s for filter %s",
						clazz.getName(), filter), e);
			throw new CommonsException(String.format("Cannot find service %s for filter %s",
					clazz.getName(), filter), e);
		}
		if (refs == null || refs.length <= 0)
			throw new CommonsException(String.format("Cannot find service %s for filter %s",
					clazz, filter));
		final ServiceReference<?> ref = refs[0];
		final S svc = (S) bundleContext.getService(ref);
		try {
			final R result = callback.apply(svc);
			return result;
		} finally {
			bundleContext.ungetService(ref);
		}
	}

	/**
	 * Get OSGi {@link ServiceReference} scoped to the provided
	 * {@link TenantRef}.
	 * 
	 * @param iface
	 * @param namespace
	 * @param filter
	 * @return Desired {@link ServiceReference or exception if not found.
	 */
	@SuppressWarnings("unchecked")
	@Nonnull
	public static <T, S extends T> ServiceReference<S> getService(@Nonnull BundleContext bundleContext,
			@Nonnull TenantRef tenant,
			@Nonnull Class<T> iface,
			@Nullable String namespace,
			@Nullable String filter) {
		final String ifaceName = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		log.trace("Lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}",
				ifaceName, tenant.getTenantId(), tenant.getTenantEnv(), namespace,
				additionalFilter );
		final String namespaceFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace="
				+ namespace + ")"
				: "";
		final String realFilter = "(&(|(tenantId=\\*)(tenantId=" + tenant.getTenantId() + "))(|(tenantEnv=\\*)(tenantEnv=" + tenant.getTenantEnv() + "))"
				+ namespaceFilter + additionalFilter + ")";

		try {
			final Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty())
				throw new IllegalStateException("Cannot find " + ifaceName
						+ " service with filter " + realFilter);
			final ServiceReference<?> serviceRef = foundRefs.iterator().next();
			return (ServiceReference<S>) serviceRef;
		} catch (InvalidSyntaxException e) {
			throw new CommonsException("Cannot find " + ifaceName + " service for " + tenant + " with filter " + realFilter, e);
		}
	}

	/**
	 * Returns a tenant-scoped supplied (layer=application) object from {@link Supplier} service.
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getSupplied(BundleContext bundleContext, TenantRef tenant, @Nonnull Class<T> clazz) {
		final ServiceReference<Supplier> supplierRef = getService(bundleContext, tenant, Supplier.class,
				null, "(suppliedClass=" + clazz.getName() + ")(layer=application)");
		final Supplier<T> supplier = bundleContext.getService(supplierRef);
		try {
			return supplier.get();
		} finally {
			bundleContext.ungetService(supplierRef);
		}
	}
	
	/**
	 * Get {@link TenantRef} for provided {@link CommandSession}.
	 * 
	 * @return
	 */
	public static TenantRef getTenant(@Nonnull final CommandSession session) {
		final BundleContext bundleContext = Preconditions.checkNotNull(
				FrameworkUtil.getBundle(TenantUtils.class).getBundleContext(),
				"Cannot get bundleContext for %s", TenantUtils.class.getName());
		final ServiceReference<ServiceLookup> serviceLookupRef = bundleContext.getServiceReference(ServiceLookup.class);
		final ServiceLookup svcLookup = bundleContext.getService(serviceLookupRef);
		try {
			return svcLookup.getTenant(session);
		} finally {
			bundleContext.ungetService(serviceLookupRef);
		}
	}

}
