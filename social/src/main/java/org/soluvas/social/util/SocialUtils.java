package org.soluvas.social.util;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.soluvas.social.SocialException;
import org.soluvas.social.Target;
import org.soluvas.social.schema.SocialSchemaCatalog;
import org.soluvas.social.schema.TargetType;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author rully
 *
 */
public class SocialUtils {

	/**
	 * Helper method to create a {@link Target}. Useful for {@link TargetFinder} implementation.
	 * @param nsPrefix
	 * @param name
	 * @return
	 */
	public static <T extends Target> T createTarget(@Nonnull final Class<T> targetClass) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(SocialUtils.class).getBundleContext();
		final ServiceReference<SocialSchemaCatalog> socialSchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(SocialSchemaCatalog.class),
				"Cannot get %s service reference", SocialSchemaCatalog.class.getName());
		final SocialSchemaCatalog socialSchemaCatalog = Preconditions.checkNotNull(
				bundleContext.getService(socialSchemaCatalogRef),
				"Cannot get %s service", SocialSchemaCatalog.class.getName());
		try {
			final TargetType targetType = Iterables.find(socialSchemaCatalog.getTargetTypes(),
					new Predicate<TargetType>() {
				@Override
				public boolean apply(@Nullable final TargetType input) {
					return targetClass.equals( input.getJavaClass() );
				}
			});
			return (T) targetType.create();
		} catch (final NoSuchElementException e) {
			final Function<TargetType, String> targetTypeQName = new Function<TargetType, String>() {
				@Override @Nullable
				public String apply(@Nullable TargetType input) {
					return input.getJavaClass().getName();
				}
			};
			final List<String> supportedTargetTypeQNames = Lists.transform(socialSchemaCatalog.getTargetTypes(), targetTypeQName);
			throw new SocialException(String.format("Cannot find target type %s, %s supported types are: %s",
					targetClass.getName(), supportedTargetTypeQNames.size(), supportedTargetTypeQNames), e);
		} finally {
			bundleContext.ungetService(socialSchemaCatalogRef);
		}
	}

	/**
	 * Helper method to create a {@link Target}. Useful for {@link TargetFinder} implementation.
	 * @param nsPrefix
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public static <T extends Target> T createTarget(@Nonnull final String nsPrefix,
			@Nonnull final String name) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(SocialUtils.class).getBundleContext();
		final ServiceReference<SocialSchemaCatalog> socialSchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(SocialSchemaCatalog.class),
				"Cannot get %s service reference", SocialSchemaCatalog.class.getName());
		final SocialSchemaCatalog socialSchemaCatalog = Preconditions.checkNotNull(
				bundleContext.getService(socialSchemaCatalogRef),
				"Cannot get %s service", SocialSchemaCatalog.class.getName());
		final String qName = nsPrefix + ":" + name;
		try {
			final TargetType targetType = Iterables.find(socialSchemaCatalog.getTargetTypes(),
					new Predicate<TargetType>() {
				@Override
				public boolean apply(@Nullable final TargetType input) {
					return qName.equals(input.getEPackageNsPrefix() + ":" + input.getName());
				}
			});
			return (T) targetType.create();
		} catch (final NoSuchElementException e) {
			final Function<TargetType, String> targetTypeQName = new Function<TargetType, String>() {
				@Override @Nullable
				public String apply(@Nullable TargetType input) {
					return input.getEPackageNsPrefix() + ":" + input.getName();
				}
			};
			final List<String> supportedTargetTypeQNames = Lists.transform(socialSchemaCatalog.getTargetTypes(), targetTypeQName);
			throw new SocialException(String.format("Cannot find target type %s, %s supported types are: %s",
					qName, supportedTargetTypeQNames.size(), supportedTargetTypeQNames), e);
		} finally {
			bundleContext.ungetService(socialSchemaCatalogRef);
		}
	}

}
