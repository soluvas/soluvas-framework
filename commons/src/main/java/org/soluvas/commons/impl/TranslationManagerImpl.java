/**
 */
package org.soluvas.commons.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Translatable;
import org.soluvas.commons.TranslationManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Translation Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TranslationManagerImpl extends MinimalEObjectImpl.Container implements TranslationManager {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslationManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonsPackage.Literals.TRANSLATION_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void translate(Translatable entity, String targetLanguage) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //TranslationManagerImpl
