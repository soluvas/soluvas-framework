package org.soluvas.email.impl;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
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
import org.soluvas.email.util.EmailUtils;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
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
	
	private final EmailCatalog emailCatalog;
	private final String defaultLayoutNsPrefix;
	private final String defaultLayoutName;
	private final AppManifest appManifest;
	private final WebAddress webAddress;
	
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
	 * @param appManifest
	 * @param webAddress
	 */
	public EmailManagerImpl(EmailCatalog emailCatalog,
			String defaultLayoutNsPrefix, String defaultLayoutName,
			AppManifest appManifest,
			WebAddress webAddress) {
		super();
		this.emailCatalog = emailCatalog;
		this.defaultLayoutNsPrefix = defaultLayoutNsPrefix;
		this.defaultLayoutName = defaultLayoutName;
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
		final Layout layout = getDefaultLayout();
		final T page = EmailUtils.createPage(pageClass, layout);
		injectDefaultScope(page);
		return page;
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
