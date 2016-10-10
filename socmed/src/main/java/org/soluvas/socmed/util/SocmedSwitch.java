/**
 */
package org.soluvas.socmed.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.socmed.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.soluvas.socmed.SocmedPackage
 * @generated
 */
public class SocmedSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SocmedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocmedSwitch() {
		if (modelPackage == null) {
			modelPackage = SocmedPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SocmedPackage.FACEBOOK_SYS_CONFIG: {
				FacebookSysConfig facebookSysConfig = (FacebookSysConfig)theEObject;
				T result = caseFacebookSysConfig(facebookSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SocmedPackage.TWITTER_SYS_CONFIG: {
				TwitterSysConfig twitterSysConfig = (TwitterSysConfig)theEObject;
				T result = caseTwitterSysConfig(twitterSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SocmedPackage.YOU_TUBE_SYS_CONFIG: {
				YouTubeSysConfig youTubeSysConfig = (YouTubeSysConfig)theEObject;
				T result = caseYouTubeSysConfig(youTubeSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SocmedPackage.PINTEREST_SYS_CONFIG: {
				PinterestSysConfig pinterestSysConfig = (PinterestSysConfig)theEObject;
				T result = casePinterestSysConfig(pinterestSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SocmedPackage.INSTAGRAM_SYS_CONFIG: {
				InstagramSysConfig instagramSysConfig = (InstagramSysConfig)theEObject;
				T result = caseInstagramSysConfig(instagramSysConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Facebook Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facebook Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFacebookSysConfig(FacebookSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Twitter Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Twitter Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTwitterSysConfig(TwitterSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>You Tube Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>You Tube Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseYouTubeSysConfig(YouTubeSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pinterest Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pinterest Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePinterestSysConfig(PinterestSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instagram Sys Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instagram Sys Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstagramSysConfig(InstagramSysConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SocmedSwitch
