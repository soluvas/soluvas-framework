package org.soluvas.email.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.locale.FormatCurrency;
import org.soluvas.commons.locale.FormatDateTime;
import org.soluvas.commons.locale.FormatMeasure;
import org.soluvas.commons.util.AppUtils;
import org.soluvas.email.DefaultScope;
import org.soluvas.email.EmailCatalog;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailModel;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.EmailSecurity;
import org.soluvas.email.Layout;
import org.soluvas.email.LayoutType;
import org.soluvas.email.Page;
import org.soluvas.email.Recipient;
import org.soluvas.email.SendResult;
import org.soluvas.email.Sender;
import org.soluvas.email.util.EmailUtils;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

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
public class EmailManagerImpl extends MinimalEObjectImpl.Container implements EmailManager {
	
	private static final MustacheFactory MF = new DefaultMustacheFactory(); 
	
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

	private Class<?> defaultLayoutClass;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EmailManagerImpl() {
		throw new UnsupportedOperationException("Please use constructor arguments");
	}
	
	/**
	 * @param emailCatalog
	 * @param defaultLayoutClass TODO
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
			Class<?> defaultLayoutClass, String defaultLayoutNsPrefix,
			String defaultLayoutName, String smtpHost, Integer smtpPort,
			String smtpUser, String smtpPassword,
			EmailSecurity smtpSecurity, AppManifest appManifest, WebAddress webAddress) {
		super();
		this.emailCatalog = emailCatalog;
		this.defaultLayoutClass = defaultLayoutClass;
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
	
	@Override
	public <T> EmailTemplate<T> loadTemplate(Class<T> modelClass) {
		final EmailTemplate<T> template = new EmailTemplate<>();
		EmailModel emailModel = modelClass.getAnnotation(EmailModel.class);
		template.setSubject(emailModel.subject());
		template.setFromEmail(emailModel.fromEmail());
		template.setFromName(emailModel.fromName());
		template.setReplyToEmail(Strings.emptyToNull(emailModel.replyToEmail()));
		template.setReplyToName(Strings.emptyToNull(emailModel.replyToName()));
		final String mustacheName = modelClass.getSimpleName() + ".html.mustache";
		final URL mustacheRes = Preconditions.checkNotNull(modelClass.getResource(mustacheName),
				"Cannot load resource '%s' in package %s", mustacheName, modelClass.getPackage().getName());
		try {
			template.setHtml( IOUtils.toString(mustacheRes) );
		} catch (IOException e) {
			throw new EmailException(e, "Cannot load resource '%s' in package %s", 
					mustacheName, modelClass.getPackage().getName());
		}
		return template;
	}
	
	@Override
	public <T> Email compose(EmailTemplate<T> template, T model, Recipient recipient) {
		return compose(template, model, ImmutableList.of(recipient)).values().iterator().next();
	}
	
	/**
	 * Outbound only {@link Email} without <a href="http://camel.apache.org/correlation-identifier.html">Correlation ID</a>.
	 * @param template
	 * @param model
	 * @param recipients
	 * @return
	 */
	@Override
	public <T> Map<Recipient, Email> compose(final EmailTemplate<T> template, final T model, List<Recipient> recipients) {
		Preconditions.checkNotNull(defaultLayoutClass, "EmailManager.defaultLayout is required to use the new compose()");
		final String mustacheName = defaultLayoutClass.getSimpleName() + ".html.mustache";
		final URL mustacheRes = Preconditions.checkNotNull(defaultLayoutClass.getResource(mustacheName),
				"Cannot load layout Mustache '%s' in package %s", mustacheName, defaultLayoutClass.getPackage().getName());
		final Mustache layoutMustache;
		try {
			final String layoutTemplate = IOUtils.toString(mustacheRes);
			layoutMustache = MF.compile(new StringReader(layoutTemplate), "layout");
		} catch (IOException e) {
			throw new EmailException(e, "Cannot load layout Mustache '%s' in package %s", 
					mustacheName, defaultLayoutClass.getPackage().getName());
		}
		
		final ImmutableMap<Recipient, Email> emails = Maps.toMap(recipients, new Function<Recipient, Email>() {
			@Override
			public Email apply(Recipient recipient) {
				HtmlEmail email = new HtmlEmail();
				try {
					email.setSubject(renderIfMustache(template.getSubject(), model, recipient));
					if (template.getReplyToEmail() != null) {
						final String replyToEmail = renderIfMustache(template.getReplyToEmail(), model, recipient);
						final String replyToName = renderIfMustache(template.getReplyToName(), model, recipient);
						final InternetAddress replyToAddress = replyToName != null ? new InternetAddress(replyToEmail, replyToName) : new InternetAddress(replyToEmail);
						email.setReplyTo(ImmutableList.of(replyToAddress));
					}
					email.setFrom(renderIfMustache(template.getFromEmail(), model, recipient), renderIfMustache(template.getFromName(), model, recipient));
					final InternetAddress toAddress = recipient.getName() != null ? new InternetAddress(recipient.getEmail(), recipient.getName()) : new InternetAddress(recipient.getEmail());
					email.setTo(ImmutableList.of(toAddress));
					
					// render msg using layout
					String pageHtml = renderIfMustache(template.getHtml(), model, recipient);
					final Map<String, Object> extras = ImmutableMap.<String, Object>builder()
							.put("appManifest", appManifest)
							.put("webAddress", webAddress)
							.put("recipient", recipient)
							.put("formatMeasure", new FormatMeasure(appManifest.getDefaultLocale()))
							.put("formatCurrency", new FormatCurrency(appManifest.getDefaultLocale(), appManifest.getDefaultCurrency()))
							.put("formatDateTime", new FormatDateTime(appManifest.getDefaultLocale()))
							.put("emailLogoUri", AppUtils.getEmailLogoUri(appManifest, webAddress))
							.put("pageHtml", pageHtml)
							.build();
					try (StringWriter sw = new StringWriter()) {
						layoutMustache.execute(sw, new Object[] { model, extras });
						email.setHtmlMsg(sw.toString());
					} catch (Exception e) {
						throw new EmailException(e, "Cannot render layout %s using model %s", defaultLayoutClass.getName(), model);
					}
					return email;
				} catch (org.apache.commons.mail.EmailException | UnsupportedEncodingException | AddressException e) {
					throw new EmailException(e, "Cannot compose template '%s' using model %s", template, model);
				}
			}
		});
		return emails;
	}
	
	protected <T> String renderIfMustache(String templateOrPlain, T model, Recipient recipient) {
		if (templateOrPlain == null) { 
			return null;
		} else if (templateOrPlain.contains("{{")) {
			Mustache mustache = MF.compile(new StringReader(templateOrPlain), "template");
			final Map<String, Object> extras = ImmutableMap.<String, Object>builder()
					.put("appManifest", appManifest)
					.put("webAddress", webAddress)
					.put("recipient", recipient)
					.put("formatMeasure", new FormatMeasure(appManifest.getDefaultLocale()))
					.put("formatCurrency", new FormatCurrency(appManifest.getDefaultLocale(), appManifest.getDefaultCurrency()))
					.put("formatDateTime", new FormatDateTime(appManifest.getDefaultLocale()))
					.put("emailLogoUri", AppUtils.getEmailLogoUri(appManifest, webAddress))
					.build();
			try (StringWriter sw = new StringWriter()) {
				mustache.execute(sw, new Object[] { model, extras });
				return sw.toString();
			} catch (Exception e) {
				throw new EmailException(e, "Cannot render template '%s' using model %s", templateOrPlain, model);
			}
		} else {
			return templateOrPlain;
		}
	}
	
	@Override
	public <T> SendResult send(EmailTemplate<T> template, T model, Recipient recipient) {
		return send(template, model, ImmutableList.of(recipient)).values().iterator().next();
	}
	
	@Override
	public <T> Map<Recipient, SendResult> send(final EmailTemplate<T> template, final T model, List<Recipient> recipients) {
		Map<Recipient, Email> emails = compose(template, model, recipients);
		log.info("Sending email '{}' using {} to {} recipients: {}", 
				template.getSubject(), model.getClass().getName(), recipients.size(), recipients);
		LinkedHashMap<Recipient, SendResult> results = new LinkedHashMap<>();
		for (Map.Entry<Recipient, Email> entry : emails.entrySet()) {
			Email email = entry.getValue();
			email.setMailSession(mailSession);
			try {
				String messageId = email.send();
				SendResult<T> result = new SendResult<>(template, model, email, messageId);
				results.put(entry.getKey(), result);
				log.info("Sent email {} '{}' using {} from {} to {}", 
						messageId, email.getSubject(), model.getClass().getName(), email.getFromAddress(), email.getToAddresses());
			} catch (org.apache.commons.mail.EmailException e) {
				log.error(String.format("Cannot send email '%s' using %s from %s to %s: %s", 
						email.getSubject(), model.getClass().getName(), email.getFromAddress(), email.getToAddresses(), e), e);
				SendResult<T> result = new SendResult<>(template, model, email, e);
				results.put(entry.getKey(), result);
			}
		}
		return results;
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
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EmailPackage.EMAIL_MANAGER___CREATE_PAGE__CLASS:
				return createPage((Class)arguments.get(0));
			case EmailPackage.EMAIL_MANAGER___CREATE_SENDER__STRING:
				return createSender((String)arguments.get(0));
			case EmailPackage.EMAIL_MANAGER___SEND_ALL__PAGE:
				return sendAll((Page)arguments.get(0));
			case EmailPackage.EMAIL_MANAGER___SEND_ALL__PAGE_SESSION:
				return sendAll((Page)arguments.get(0), (Session)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
