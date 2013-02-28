/**
 */
package org.soluvas.data.impl;

import java.util.List;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.DataPackage;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.TermManagerImpl#getDataCatalog <em>Data Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermManagerImpl extends EObjectImpl implements TermManager {
	/**
	 * The cached value of the '{@link #getDataCatalog() <em>Data Catalog</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataCatalog()
	 * @generated
	 * @ordered
	 */
	protected DataCatalog dataCatalog;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected TermManagerImpl() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param dataCatalog
	 */
	public TermManagerImpl(DataCatalog dataCatalog) {
		super();
		this.dataCatalog = dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TERM_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataCatalog getDataCatalog() {
		if (dataCatalog != null && ((EObject)dataCatalog).eIsProxy()) {
			InternalEObject oldDataCatalog = (InternalEObject)dataCatalog;
			dataCatalog = (DataCatalog)eResolveProxy(oldDataCatalog);
			if (dataCatalog != oldDataCatalog) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.TERM_MANAGER__DATA_CATALOG, oldDataCatalog, dataCatalog));
			}
		}
		return dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataCatalog basicGetDataCatalog() {
		return dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public List<Term> findTerms(final String attributeTypeNsPrefix, final String attributeTypeName) {
		final List<Term> terms = ImmutableList.copyOf(Iterables.filter(dataCatalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				return Objects.equal(input.getNsPrefix(), attributeTypeNsPrefix) && Objects.equal(input.getAttributeTypeName(), attributeTypeName);
			}
		}));
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Multimap<String, Term> getTermsByAttributeTypes() {
		final Multimap<String, Term> multimap = Multimaps.index(dataCatalog.getTerms(), new Function<Term, String>() {
			@Override @Nullable
			public String apply(@Nullable Term input) {
				return Strings.nullToEmpty(input.getAttributeTypeNsPrefix()) + "_" + Strings.nullToEmpty(input.getAttributeTypeName());
			}
		});
		return multimap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TERM_MANAGER__DATA_CATALOG:
				if (resolve) return getDataCatalog();
				return basicGetDataCatalog();
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
			case DataPackage.TERM_MANAGER__DATA_CATALOG:
				return dataCatalog != null;
		}
		return super.eIsSet(featureID);
	}

} //TermManagerImpl
