/**
 */
package org.soluvas.email.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.email.EmailException;
import org.soluvas.email.EmailFormat;
import org.soluvas.email.EmailPackage;
import org.soluvas.email.Layout;
import org.soluvas.email.Page;
import org.soluvas.email.PageType;
import org.soluvas.email.Recipient;
import org.soluvas.email.Sender;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.email.impl.PageImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.soluvas.email.impl.PageImpl#getPageType <em>Page Type</em>}</li>
 *   <li>{@link org.soluvas.email.impl.PageImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link org.soluvas.email.impl.PageImpl#getMailSession <em>Mail Session</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PageImpl extends TemplateImpl implements Page {
	
	private static final Logger log = LoggerFactory.getLogger(PageImpl.class);
	private final Map<String, byte[]> attachments = new HashMap<>();
	
	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected Layout layout;

	/**
	 * The cached value of the '{@link #getPageType() <em>Page Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageType()
	 * @generated
	 * @ordered
	 */
	protected PageType pageType;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected Sender sender;

	/**
	 * The default value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected static final Session MAIL_SESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMailSession() <em>Mail Session</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailSession()
	 * @generated
	 * @ordered
	 */
	protected Session mailSession = MAIL_SESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmailPackage.Literals.PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Layout getLayout() {
		if (layout != null && layout.eIsProxy()) {
			InternalEObject oldLayout = (InternalEObject)layout;
			layout = (Layout)eResolveProxy(oldLayout);
			if (layout != oldLayout) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__LAYOUT, oldLayout, layout));
			}
		}
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layout basicGetLayout() {
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayout(Layout newLayout) {
		Layout oldLayout = layout;
		layout = newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageType getPageType() {
		if (pageType != null && pageType.eIsProxy()) {
			InternalEObject oldPageType = (InternalEObject)pageType;
			pageType = (PageType)eResolveProxy(oldPageType);
			if (pageType != oldPageType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__PAGE_TYPE, oldPageType, pageType));
			}
		}
		return pageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageType basicGetPageType() {
		return pageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void setPageType(PageType newPageType) {
		PageType oldPageType = pageType;
		pageType = newPageType;
		
		setSubjectTemplate(newPageType.getSubjectTemplate());
		setPlainTemplate(newPageType.getPlainTemplate());
		setHtmlTemplate(newPageType.getHtmlTemplate());
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__PAGE_TYPE, oldPageType, pageType));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sender getSender() {
		if (sender != null && sender.eIsProxy()) {
			InternalEObject oldSender = (InternalEObject)sender;
			sender = (Sender)eResolveProxy(oldSender);
			if (sender != oldSender) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmailPackage.PAGE__SENDER, oldSender, sender));
			}
		}
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sender basicGetSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSender(Sender newSender) {
		Sender oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Session getMailSession() {
		return mailSession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMailSession(Session newMailSession) {
		Session oldMailSession = mailSession;
		mailSession = newMailSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmailPackage.PAGE__MAIL_SESSION, oldMailSession, mailSession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Email compose(Recipient recipient) {
		final String subject = renderSubject(recipient);
		final EmailFormat format = Optional.fromNullable(recipient.getPreferredFormat()).or(EmailFormat.MULTIPART);
		try {
			final MultiPartEmail email;
			// Render the page first, then set the output of Page rendering to the layout's
			final String pageHtml = renderHtml(recipient);
			layout.setPageHtml(pageHtml);
			layout.setPageSubject(subject);
			switch (format) {
			case MULTIPART:
				email = new HtmlEmail();
				if (!Strings.isNullOrEmpty(getPlainTemplate())) {
					// only if Page has plainTemplate, which due to our laziness, not all does
					final String pageText = renderText(recipient);
					layout.setPagePlain(pageText);
					((HtmlEmail) email).setTextMsg(layout.renderText(recipient));
				}
				((HtmlEmail) email).setHtmlMsg(layout.renderHtml(recipient));

				// email logo is now using direct URI
//				final URL logoResource = appManifest.getBundle().getResource("logo_email.png");
//				if (logoResource != null) {
//					((HtmlEmail) email).embed(new URLDataSource(logoResource),
//							"logo_email.png", "logo_email.png");
//				} else {
//					log.warn("Cannot get logo_email.png resource from AppManifest bundle {}",
//							appManifest.getBundle());
//				}
				
				break;
			case PLAIN:
				email = new MultiPartEmail();
				final String pageText = renderText(recipient);
				layout.setPagePlain(pageText);
				email.setMsg(pageText);
				break;
			case HTML:
				email = new HtmlEmail();
				((HtmlEmail) email).setHtmlMsg(pageHtml);
				break;
			default:
				throw new org.soluvas.email.EmailException("Unknown format: " + format);
			}
			email.setMailSession(mailSession);
//			email.setFrom("cantik@berbatik.com", "Berbatik");
			try {
				email.setFrom(getSender().getEmail(), getSender().getFrom());
			} catch (Exception e) {
				throw new EmailException(String.format("Invalid Sender: \"%s\" <%s>",
						getSender().getFrom(), getSender().getEmail()), e);
			}
			if (!Strings.isNullOrEmpty(getSender().getReplyTo())) {
				email.setReplyTo(ImmutableList.of(new InternetAddress(getSender().getReplyTo())));
			}
			email.setSubject(layout.renderSubject(recipient));
			email.addTo(recipient.getEmail(), recipient.getName());
			
			for (final Entry<String, byte[]> attachment : attachments.entrySet()) {
				// FIXME: don't hardcode to application/octet-stream!
				email.attach(new ByteArrayDataSource(attachment.getValue(), "application/octet-stream"),
						attachment.getKey(), attachment.getKey());
			}
			
			email.setDebug(true);
//			email.buildMimeMessage();
//			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//			email.getMimeMessage().writeTo(outputStream);
//			log.info("Composed {}", outputStream);
			return email;
		} catch (Exception e) {
			throw new org.soluvas.email.EmailException("Cannot compose " + pageType.getNsPrefix() + ":" + pageType.getName() +
					" email to " + recipient, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<Email> composeAll() {
		log.info("Composing {}:{} email to {} recipients", getPageType().getNsPrefix(), getPageType().getName(),
				recipients.size());
		final List<Email> emails = ImmutableList.copyOf( Lists.transform(recipients, new Function<Recipient, Email>() {
			@Override @Nullable
			public Email apply(@Nullable Recipient input) {
				return compose(input);
			}
		}) );
		return emails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void attach(byte[] content, String fileName) {
		attachments.put(fileName, content);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmailPackage.PAGE__LAYOUT:
				if (resolve) return getLayout();
				return basicGetLayout();
			case EmailPackage.PAGE__PAGE_TYPE:
				if (resolve) return getPageType();
				return basicGetPageType();
			case EmailPackage.PAGE__SENDER:
				if (resolve) return getSender();
				return basicGetSender();
			case EmailPackage.PAGE__MAIL_SESSION:
				return getMailSession();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmailPackage.PAGE__LAYOUT:
				setLayout((Layout)newValue);
				return;
			case EmailPackage.PAGE__PAGE_TYPE:
				setPageType((PageType)newValue);
				return;
			case EmailPackage.PAGE__SENDER:
				setSender((Sender)newValue);
				return;
			case EmailPackage.PAGE__MAIL_SESSION:
				setMailSession((Session)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmailPackage.PAGE__LAYOUT:
				setLayout((Layout)null);
				return;
			case EmailPackage.PAGE__PAGE_TYPE:
				setPageType((PageType)null);
				return;
			case EmailPackage.PAGE__SENDER:
				setSender((Sender)null);
				return;
			case EmailPackage.PAGE__MAIL_SESSION:
				setMailSession(MAIL_SESSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmailPackage.PAGE__LAYOUT:
				return layout != null;
			case EmailPackage.PAGE__PAGE_TYPE:
				return pageType != null;
			case EmailPackage.PAGE__SENDER:
				return sender != null;
			case EmailPackage.PAGE__MAIL_SESSION:
				return MAIL_SESSION_EDEFAULT == null ? mailSession != null : !MAIL_SESSION_EDEFAULT.equals(mailSession);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EmailPackage.PAGE___COMPOSE__RECIPIENT:
				return compose((Recipient)arguments.get(0));
			case EmailPackage.PAGE___COMPOSE_ALL:
				return composeAll();
			case EmailPackage.PAGE___ATTACH__BYTE_STRING:
				attach((byte[])arguments.get(0), (String)arguments.get(1));
				return null;
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
		result.append(" (mailSession: ");
		result.append(mailSession);
		result.append(')');
		return result.toString();
	}

} //PageImpl
