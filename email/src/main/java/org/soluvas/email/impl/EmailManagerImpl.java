package org.soluvas.email.impl;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.soluvas.email.EmailSecurity;
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
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.EmailManagerImpl#getSmtpUser <em>Smtp User</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailManagerImpl#getSmtpPassword <em>Smtp Password</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailManagerImpl#getSmtpHost <em>Smtp Host</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailManagerImpl#getSmtpPort <em>Smtp Port</em>}</li>
 *   <li>{@link org.soluvas.email.impl.EmailManagerImpl#getSmtpSecurity <em>Smtp Security</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("serial")
public class EmailManagerImpl extends EObjectImpl implements EmailManager {
	
	/**
	 * The default value of the '{@link #getSmtpUser() <em>Smtp User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpUser()
	 * @generated
	 * @ordered
	 */
	protected static final String SMTP_USER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpUser() <em>Smtp User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpUser()
	 * @generated
	 * @ordered
	 */
	protected String smtpUser = SMTP_USER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpPassword() <em>Smtp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String SMTP_PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpPassword() <em>Smtp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPassword()
	 * @generated
	 * @ordered
	 */
	protected String smtpPassword = SMTP_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpHost() <em>Smtp Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpHost()
	 * @generated
	 * @ordered
	 */
	protected static final String SMTP_HOST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpHost() <em>Smtp Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpHost()
	 * @generated
	 * @ordered
	 */
	protected String smtpHost = SMTP_HOST_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpPort() <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPort()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SMTP_PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmtpPort() <em>Smtp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpPort()
	 * @generated
	 * @ordered
	 */
	protected Integer smtpPort = SMTP_PORT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmtpSecurity() <em>Smtp Security</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpSecurity()
	 * @generated
	 * @ordered
	 */
	protected static final EmailSecurity SMTP_SECURITY_EDEFAULT = EmailSecurity.NONE;

	/**
	 * The cached value of the '{@link #getSmtpSecurity() <em>Smtp Security</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSmtpSecurity()
	 * @generated
	 * @ordered
	 */
	protected EmailSecurity smtpSecurity = SMTP_SECURITY_EDEFAULT;

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
			String smtpHost, Integer smtpPort, String smtpUser,
			String smtpPassword, EmailSecurity smtpSecurity,
			AppManifest appManifest, WebAddress webAddress) {
		super();
		this.emailCatalog = emailCatalog;
		this.defaultLayoutNsPrefix = defaultLayoutNsPrefix;
		this.defaultLayoutName = defaultLayoutName;
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.smtpUser = smtpUser;
		this.smtpPassword = smtpPassword;
		this.smtpSecurity = smtpSecurity;
		mailSession = EmailUtils.createSmtpSession(smtpHost, smtpPort, smtpUser, smtpPassword, smtpSecurity);
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSmtpUser() {
		return smtpUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSmtpPassword() {
		return smtpPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getSmtpPort() {
		return smtpPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EmailSecurity getSmtpSecurity() {
		return smtpSecurity;
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
			final T page = EmailUtils.createPage(pageClass, layout, emailCatalog);
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
		final Sender sender = EmailUtils.createSender(senderNsPrefix, senderName, emailCatalog);
		injectDefaultScope(sender);
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<String> sendAll(Page page) {
		return doSendAll(page, Optional.<Session>absent());
	}

	protected List<String> doSendAll(Page page, final Optional<Session> customMailSession) {
		final List<Email> emails = page.composeAll();
		
		final Session realMailSession = customMailSession.or(this.mailSession);
		log.info("Sending {} {} emails using {}@{}:{} to {}",
				emails.size(), page.getPageType().getName(),
				realMailSession.getProperty(Email.MAIL_SMTP_USER),
				realMailSession.getProperty(Email.MAIL_HOST), realMailSession.getProperty(Email.MAIL_PORT),
				page.getRecipients());
		final List<String> results = ImmutableList.copyOf(Lists.transform(emails, new Function<Email, String>() {
			@Override @Nullable
			public String apply(@Nullable Email email) {
				String result;
				try {
					if (customMailSession.isPresent()) {
						email.setMailSession(customMailSession.get());
					}
					Preconditions.checkNotNull(email.getMailSession(),
							"Invalid mailSession for %s", email);
					result = email.send();
					log.info("Email '{}' sent from {} to {}: {}",
							email.getSubject(),
							email.getFromAddress(), email.getToAddresses(), result);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<String> sendAll(Page page, Session mailSession) {
		return doSendAll(page, Optional.of(mailSession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.EMAIL_MANAGER__SMTP_USER:
				return getSmtpUser();
			case EmailPackage.EMAIL_MANAGER__SMTP_PASSWORD:
				return getSmtpPassword();
			case EmailPackage.EMAIL_MANAGER__SMTP_HOST:
				return getSmtpHost();
			case EmailPackage.EMAIL_MANAGER__SMTP_PORT:
				return getSmtpPort();
			case EmailPackage.EMAIL_MANAGER__SMTP_SECURITY:
				return getSmtpSecurity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmailPackage.EMAIL_MANAGER__SMTP_USER:
				return SMTP_USER_EDEFAULT == null ? smtpUser != null : !SMTP_USER_EDEFAULT.equals(smtpUser);
			case EmailPackage.EMAIL_MANAGER__SMTP_PASSWORD:
				return SMTP_PASSWORD_EDEFAULT == null ? smtpPassword != null : !SMTP_PASSWORD_EDEFAULT.equals(smtpPassword);
			case EmailPackage.EMAIL_MANAGER__SMTP_HOST:
				return SMTP_HOST_EDEFAULT == null ? smtpHost != null : !SMTP_HOST_EDEFAULT.equals(smtpHost);
			case EmailPackage.EMAIL_MANAGER__SMTP_PORT:
				return SMTP_PORT_EDEFAULT == null ? smtpPort != null : !SMTP_PORT_EDEFAULT.equals(smtpPort);
			case EmailPackage.EMAIL_MANAGER__SMTP_SECURITY:
				return smtpSecurity != SMTP_SECURITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (smtpUser: ");
		result.append(smtpUser);
		result.append(", smtpPassword: ");
		result.append(smtpPassword);
		result.append(", smtpHost: ");
		result.append(smtpHost);
		result.append(", smtpPort: ");
		result.append(smtpPort);
		result.append(", smtpSecurity: ");
		result.append(smtpSecurity);
		result.append(')');
		return result.toString();
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
