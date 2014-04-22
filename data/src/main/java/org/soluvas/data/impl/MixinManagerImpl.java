package org.soluvas.data.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinCatalog;
import org.soluvas.data.MixinManager;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixin Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.MixinManagerImpl#getMixinCatalog <em>Mixin Catalog</em>}</li>
 *   <li>{@link org.soluvas.data.impl.MixinManagerImpl#getMixins <em>Mixins</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@Service @Lazy
public class MixinManagerImpl extends EObjectImpl implements MixinManager {
	
	/**
	 * The cached value of the '{@link #getMixinCatalog() <em>Mixin Catalog</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixinCatalog()
	 * @generated
	 * @ordered
	 */
	protected MixinCatalog mixinCatalog;

	private static final Logger log = LoggerFactory
			.getLogger(MixinManagerImpl.class);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected MixinManagerImpl() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.MIXIN_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MixinCatalog getMixinCatalog() {
		if (mixinCatalog != null && mixinCatalog.eIsProxy()) {
			InternalEObject oldMixinCatalog = (InternalEObject)mixinCatalog;
			mixinCatalog = (MixinCatalog)eResolveProxy(oldMixinCatalog);
			if (mixinCatalog != oldMixinCatalog) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.MIXIN_MANAGER__MIXIN_CATALOG, oldMixinCatalog, mixinCatalog));
			}
		}
		return mixinCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MixinCatalog basicGetMixinCatalog() {
		return mixinCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public EList getMixins() {
		return mixinCatalog.getMixins();
	}

	@Inject
	public MixinManagerImpl(MixinCatalog mixinCatalog) {
		super();
		this.mixinCatalog = mixinCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Mixin findMixin(String qName) {
		if (Strings.isNullOrEmpty(qName)) {
			log.warn("Trying to find Mixin by qName, but the qName is {}", qName);
			return null;
		}
		final String patternStr = "([^_]+)_(.+)";
		final Matcher nsPrefixMatcher = Pattern.compile(patternStr).matcher(qName);
		Preconditions.checkState(nsPrefixMatcher.matches(),
				"Cannot match QName %s against nsPrefix pattern %s",
				qName, patternStr);
		final String nsPrefix = nsPrefixMatcher.group(1);
		final String mixinName = nsPrefixMatcher.group(2);
		
		try {
			return Iterables.find(mixinCatalog.getMixins(), new Predicate<Mixin>() {
				@Override
				public boolean apply(@Nullable Mixin input) {
					return Objects.equal(nsPrefix, input.getNsPrefix()) && Objects.equal(mixinName, input.getName());
				}
			});
		} catch (NoSuchElementException e) {
			final List<String> mixinNames = ImmutableList.copyOf(Iterables.transform(mixinCatalog.getMixins(), new QNameFunction()));
			log.warn(String.format("Cannot find mixin %s_%s. %d available mixins are: %s",
					nsPrefix, mixinName, mixinNames.size(), mixinNames));
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Page<Mixin> findMixin(Pageable pageable, String term) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.MIXIN_MANAGER__MIXIN_CATALOG:
				if (resolve) return getMixinCatalog();
				return basicGetMixinCatalog();
			case DataPackage.MIXIN_MANAGER__MIXINS:
				return getMixins();
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
			case DataPackage.MIXIN_MANAGER__MIXIN_CATALOG:
				return mixinCatalog != null;
			case DataPackage.MIXIN_MANAGER__MIXINS:
				return getMixins() != null;
		}
		return super.eIsSet(featureID);
	}

} //MixinManagerImpl
