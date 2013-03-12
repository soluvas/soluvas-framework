package org.soluvas.email.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.mail.Session;

import org.apache.commons.mail.Email;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.email.DefaultScope;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;
import org.soluvas.email.Page;
import org.soluvas.email.Sender;
import org.soluvas.email.util.EmailUtils;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
/**
 * @author rully
 *
 */
@SuppressWarnings("serial")
public class EmailManagerImpl extends EObjectImpl implements EmailManager {
	
	private static final Logger log = LoggerFactory.getLogger(EmailManagerImpl.class);

	private final EmailCatalog emailCatalog;
	private final String defaultLayoutNsPrefix;
	private final String defaultLayoutName;
	private final AppManifest appManifest;
	private final WebAddress webAddress;
	private final Session mailSession;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EmailManagerImpl() {
		throw new UnsupportedOperationException("Please use constructor arguments");
	}
	
	/**
	 * @param emailCatalog
	 * @param defaultLayoutNsPrefix
	 * @param defaultLayoutName
	 * @param smtpHost
	 * @param smtpPort
	 * @param smtpUser
	 * @param smtpPassword
	 * @param appManifest
	 * @param webAddress
	 */
	public EmailManagerImpl(EmailCatalog emailCatalog,
			String defaultLayoutNsPrefix, String defaultLayoutName,
			String smtpHost, int smtpPort, String smtpUser,
			String smtpPassword, AppManifest appManifest, WebAddress webAddress) {
		super();
		this.emailCatalog = emailCatalog;
		this.defaultLayoutNsPrefix = defaultLayoutNsPrefix;
		this.defaultLayoutName = defaultLayoutName;
		final Properties props = new Properties();
		props.setProperty(Email.MAIL_HOST, smtpHost);
		props.setProperty(Email.MAIL_PORT, Integer.toString(smtpPort));
		props.setProperty(Email.MAIL_SMTP_USER, smtpUser);
		props.setProperty(Email.MAIL_SMTP_PASSWORD, smtpPassword);
		mailSession = Session.getInstance(props);
		this.appManifest = appManifest;
		this.webAddress = webAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.EMAIL_MANAGER;
	}
	
	protected void injectDefaultScope(DefaultScope scope) {
		scope.setAppManifest(appManifest);
		scope.setWebAddress(webAddress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public <T extends Page> T createPage(Class<T> pageClass) {
		try {
			final Layout layout = getDefaultLayout();
			final T page = EmailUtils.createPage(pageClass, layout);
			injectDefaultScope(page);
			final Sender sender = createSender(page.getPageType().getSenderTypeName());
			sender.expand();
			page.setSender(sender);
			page.setMailSession(mailSession);
			return page;
		} catch (Exception e) {
			throw new EmailException("Cannot create Page " + pageClass.getName(), e);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Sender createSender(String qname) {
		final String senderQName = Optional.fromNullable(qname).or("builtin:general");
		final Matcher qnameMatcher = Pattern.compile("(.+):(.+)").matcher(senderQName);
		final String senderNsPrefix = qnameMatcher.matches() ? qnameMatcher.group(1) : "builtin";
		final String senderName = qnameMatcher.matches() ? qnameMatcher.group(2) : senderQName;
		final Sender sender = EmailUtils.createSender(senderNsPrefix, senderName);
		injectDefaultScope(sender);
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<String> sendAll(Page page) {
		final List<Email> emails = page.composeAll();
		
		log.info("Sending {} emails using {}@{}:{}",
				emails.size(), mailSession.getProperty(Email.MAIL_SMTP_USER),
				mailSession.getProperty(Email.MAIL_HOST), mailSession.getProperty(Email.MAIL_PORT));
		final List<String> results = ImmutableList.copyOf(Lists.transform(emails, new Function<Email, String>() {
			@Override @Nullable
			public String apply(@Nullable Email email) {
				String result;
				try {
					Preconditions.checkNotNull(email.getMailSession(),
							"Invalid mailSession for %s", email);
					result = email.send();
					log.info("Email sent from {} to {}: {} - {}",
							email.getFromAddress(), email.getToAddresses(), result,
							email.getSubject());
					return result;
				} catch (org.apache.commons.mail.EmailException e) {
					log.error("Cannot send email from " + email.getFromAddress() + " to " +
							email.getToAddresses() + " subject: " + email.getSubject(), e);
					// cannot be null because ImmutableList
					return "";
				}
			}
		}));
		return results;
	}

	protected Layout getDefaultLayout() {
		try {
			final LayoutType layoutType = Iterables.find(emailCatalog.getLayoutTypes(), new Predicate<LayoutType>() {
				@Override
				public boolean apply(@Nullable LayoutType input) {
					return Objects.equal(defaultLayoutNsPrefix, input.getNsPrefix())
							&& Objects.equal(defaultLayoutName, input.getName());
				}
			});
			final Layout layout = layoutType.create();
			injectDefaultScope(layout);
			return layout;
		} catch (NoSuchElementException e) {
			final List<String> layoutNames = Lists.transform(emailCatalog.getLayoutTypes(), new Function<LayoutType, String>() {
				@Override @Nullable
				public String apply(@Nullable LayoutType input) {
					return input.getNsPrefix() + ":" + input.getName();
				}
			});
			throw new EmailException(String.format("Cannot find layout %s:%s. %d available layouts are: %s.",
					defaultLayoutNsPrefix, defaultLayoutName, layoutNames.size(), layoutNames), e);
		}
	}

} //EmailManagerImpl
