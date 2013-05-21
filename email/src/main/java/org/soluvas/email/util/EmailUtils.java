package org.soluvas.email.util;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.mail.Session;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.EmailSecurity;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;
import org.soluvas.email.PersonToRecipients;
import org.soluvas.email.Recipient;
import org.soluvas.email.Sender;
import org.soluvas.email.SenderType;
import org.soluvas.email.SocialPersonToRecipients;
import org.soluvas.email.impl.EmailManagerImpl;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author ceefour
 */
public class EmailUtils {
	private static final Logger log = LoggerFactory.getLogger(EmailUtils.class);

	/**
	 * Helper method to create a {@link Layout}.
	 * @param nsPrefix
	 * @param name
	 * @return
	 * @deprecated Only used by OSGi code. Nobody uses this anyway. See {@link EmailManagerImpl#getDefaultLayout()}.
	 */
	@Deprecated
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
	@Deprecated
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
	
	/**
	 * Get email recipients for {@link PersonInfo} based on:
	 * 
	 * 1. {@link PersonInfo#getEmail()}
	 * 2. If {@link PersonInfo#getId()} is not empty and {@code personLookup} is provided,
	 * {@link SocialPerson#getPrimaryEmail()} and {@link SocialPerson#getEmails()},
	 * using {@link SocialPersonToRecipients}.
	 * 
	 * Will not duplicate recipients with same email address.
	 * 
	 * @param personLookup
	 * @return
	 */
	public static Set<Recipient> getRecipients(@Nullable PersonInfo personInfo, @Nullable EntityLookup<SocialPerson, String> personLookup) {
		final Set<Recipient> recipients = Sets.newHashSet();
		
		if (personInfo != null) {
			if (!Strings.isNullOrEmpty(personInfo.getEmail())) {
				final String name = Optional.fromNullable(personInfo.getName()).or(personInfo.getEmail());
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						name, personInfo.getEmail(), "customer"));
			}
			//find person by customerId
			if (!Strings.isNullOrEmpty(personInfo.getId()) && personLookup != null) {
				final SocialPerson socialPerson = personLookup.findOne(personInfo.getId());
				recipients.addAll(new SocialPersonToRecipients("registered customer").apply(socialPerson));
			}
		}
		
		return recipients;
	}
	
	
	/**
	 * Get email recipients for {@link PersonInfo} based on:
	 * 
	 * 1. {@link PersonInfo#getEmail()}
	 * 2. If {@link PersonInfo#getId()} is not empty and {@code personLookup} is provided,
	 * {@link Person#getEmail()s},
	 * using {@link PersonToRecipients}.
	 * 
	 * Will not duplicate recipients with same email address.
	 * 
	 * @param personLookup
	 * @param roleName e.g. "registered customer"
	 * @return
	 */
	public static Set<Recipient> getRecipientsNew(@Nullable PersonInfo personInfo, @Nullable EntityLookup<Person, String> personLookup,
			String roleName) {
		final Set<Recipient> recipients = Sets.newHashSet();
		
		if (personInfo != null) {
			if (!Strings.isNullOrEmpty(personInfo.getEmail())) {
				final String name = Optional.fromNullable(personInfo.getName()).or(personInfo.getEmail());
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						name, personInfo.getEmail(), roleName));
			}
			//find person by customerId
			if (!Strings.isNullOrEmpty(personInfo.getId()) && personLookup != null) {
				final Person person = personLookup.findOne(personInfo.getId());
				recipients.addAll(new PersonToRecipients(roleName).apply(person));
			}
		}
		
		return recipients;
	}
	
	/**
	 * Create a javax.mail {@link Session} specifically used for sending email messages.
	 * @param smtpHost SMTP server host.
	 * @param smtpPort SMTP server port.
	 * @param smtpUser SMTP user for authentication. {@code mail.smtp.auth} will be set to true
	 * @param smtpPassword SMTP password for authentication. {@code smtpUser} is required to use this.
	 * @return
	 */
	public static Session createSmtpSession(@Nullable String smtpHost, @Nullable Integer smtpPort, @Nullable String smtpUser,
			@Nullable String smtpPassword, @Nullable EmailSecurity protocol) {
		final Properties props = new Properties();
		if (smtpHost != null) {
			props.setProperty(Email.MAIL_HOST, smtpHost);
		}
		if (smtpPort != null) {
			props.setProperty(Email.MAIL_PORT, Integer.toString(smtpPort));
		}
		props.setProperty(Email.MAIL_SMTP_AUTH, Boolean.toString(!Strings.isNullOrEmpty(smtpUser)));
		if (smtpUser != null) {
			props.setProperty(Email.MAIL_SMTP_USER, smtpUser);
		}
		if (protocol != null) {
			if (protocol == EmailSecurity.STARTTLS) {
				props.setProperty("mail.smtp.starttls.enable", "true");
			} else if (protocol == EmailSecurity.SSL) {
				props.setProperty("mail.smtp.socketFactory.class", SSLSocketFactory.class.getName());
			}
		}
		log.debug("Creating javax.mail Session with {} ({} ommitted)", props, Email.MAIL_SMTP_PASSWORD);
		if (smtpPassword != null) {
			props.setProperty(Email.MAIL_SMTP_PASSWORD, smtpPassword);
		}
		final Session session = Session.getInstance(props);
		return session;
	}
	
}