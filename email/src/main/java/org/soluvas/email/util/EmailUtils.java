package org.soluvas.email.util;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;
import org.soluvas.email.Recipient;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderType;
import org.soluvas.email.impl.EmailManagerImpl;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 */
public class EmailUtils {

	/**
	 * Helper method to create a {@link Layout}.
	 * @param nsPrefix
	 * @param name
	 * @return
	 * @deprecated Only used by OSGi code. Nobody uses this anyway. See {@link EmailManagerImpl#getDefaultLayout()}.
	 */
	@SuppressWarnings("unchecked") @Deprecated
	public static <T extends Layout> T createLayout(@Nonnull final Class<T> targetClass) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(EmailUtils.class).getBundleContext();
		final ServiceReference<EmailCatalog> emailCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(EmailCatalog.class),
				"Cannot get %s service reference", EmailCatalog.class.getName());
		final EmailCatalog emailCatalog = Preconditions.checkNotNull(
				bundleContext.getService(emailCatalogRef),
				"Cannot get %s service", EmailCatalog.class.getName());
		try {
			final LayoutType type = Iterables.find(emailCatalog.getLayoutTypes(),
					new Predicate<LayoutType>() {
				@Override
				public boolean apply(@Nullable final LayoutType input) {
					return targetClass.equals( input.getJavaClass() );
				}
			});
			return (T) type.create();
		} catch (final NoSuchElementException e) {
			final Function<LayoutType, String> targetTypeQName = new Function<LayoutType, String>() {
				@Override @Nullable
				public String apply(@Nullable LayoutType input) {
					return input.getJavaClass().getName();
				}
			};
			final List<String> supportedLayoutTypeQNames = Lists.transform(emailCatalog.getLayoutTypes(), targetTypeQName);
			throw new EmailException(String.format("Cannot find layout type %s, %s supported types are: %s",
					targetClass.getName(), supportedLayoutTypeQNames.size(), supportedLayoutTypeQNames), e);
		} finally {
			bundleContext.ungetService(emailCatalogRef);
		}
	}

	/**
	 * Helper method to create a {@link Page}.
	 * @param nsPrefix
	 * @param name
	 * @return
	 * @deprecated Only used by OSGi code.
	 */
	@SuppressWarnings("unchecked") @Deprecated
	public static <T extends Page> T createPage(@Nonnull final Class<T> targetClass, @Nonnull final Layout layout) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(EmailUtils.class).getBundleContext();
		final ServiceReference<EmailCatalog> emailCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(EmailCatalog.class),
				"Cannot get %s service reference", EmailCatalog.class.getName());
		final EmailCatalog emailCatalog = Preconditions.checkNotNull(
				bundleContext.getService(emailCatalogRef),
				"Cannot get %s service", EmailCatalog.class.getName());
		try {
			return createPage(targetClass, layout, emailCatalog);
		} finally {
			bundleContext.ungetService(emailCatalogRef);
		}
	}

	/**
	 * @param targetClass
	 * @param layout
	 * @param bundleContext
	 * @param emailCatalogRef
	 * @param emailCatalog
	 * @return
	 */
	public static <T extends Page> T createPage(final Class<T> targetClass,
			final Layout layout, final EmailCatalog emailCatalog) {
		try {
			final PageType type = Iterables.find(emailCatalog.getPageTypes(),
					new Predicate<PageType>() {
				@Override
				public boolean apply(@Nullable final PageType input) {
					return targetClass.equals( input.getJavaClass() );
				}
			});
			return (T) type.create(layout);
		} catch (final NoSuchElementException e) {
			final Function<PageType, String> targetTypeQName = new Function<PageType, String>() {
				@Override @Nullable
				public String apply(@Nullable PageType input) {
					return input.getJavaClass().getName();
				}
			};
			final List<String> supportedPageTypeQNames = Lists.transform(emailCatalog.getPageTypes(), targetTypeQName);
			throw new EmailException(String.format("Cannot find page type %s, %s supported types are: %s",
					targetClass.getName(), supportedPageTypeQNames.size(), supportedPageTypeQNames), e);
		}
	}

	/**
	 * Helper method to create a {@link Sender}.
	 * @param nsPrefix
	 * @param name
	 * @return
	 * @deprecated Only used by OSGi.
	 */
	@Deprecated
	public static Sender createSender(@Nonnull final String nsPrefix, @Nonnull final String name) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(EmailUtils.class).getBundleContext();
		final ServiceReference<EmailCatalog> emailCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(EmailCatalog.class),
				"Cannot get %s service reference", EmailCatalog.class.getName());
		final EmailCatalog emailCatalog = Preconditions.checkNotNull(
				bundleContext.getService(emailCatalogRef),
				"Cannot get %s service", EmailCatalog.class.getName());
		try {
			return createSender(nsPrefix, name, emailCatalog);
		} finally {
			bundleContext.ungetService(emailCatalogRef);
		}
	}

	/**
	 * @param nsPrefix
	 * @param name
	 * @param emailCatalog
	 * @return
	 */
	public static Sender createSender(final String nsPrefix, final String name,
			final EmailCatalog emailCatalog) {
		try {
			final SenderType type = Iterables.find(emailCatalog.getSenderTypes(),
					new Predicate<SenderType>() {
				@Override
				public boolean apply(@Nullable final SenderType input) {
					return nsPrefix.equals(input.getNsPrefix()) && name.equals(input.getName());
				}
			});
			return type.create();
		} catch (final NoSuchElementException e) {
			final Function<SenderType, String> targetTypeQName = new Function<SenderType, String>() {
				@Override @Nullable
				public String apply(@Nullable SenderType input) {
					return input.getNsPrefix() + ":" + input.getName();
				}
			};
			final List<String> supportedSenderTypeQNames = Lists.transform(emailCatalog.getSenderTypes(), targetTypeQName);
			throw new EmailException(String.format("Cannot find sender type %s:%s, %s supported types are: %s",
					nsPrefix, name, supportedSenderTypeQNames.size(), supportedSenderTypeQNames), e);
		}
	}

	/**
	 * Check if a Recipient with the specified email already in a list of {@link Recipient}s. 
	 * @param recipients
	 * @param needle
	 * @return
	 */
	public static boolean hasRecipient(Iterable<Recipient> recipients, final String needle) {
		return Iterables.any(recipients, new Predicate<Recipient>() {
			@Override
			public boolean apply(@Nullable Recipient input) {
				return StringUtils.equalsIgnoreCase(input.getEmail(), needle);
			}
		});
	}
	
}