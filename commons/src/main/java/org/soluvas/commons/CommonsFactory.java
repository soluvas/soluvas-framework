/**
 */
package org.soluvas.commons;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage
 * @generated
 */
public interface CommonsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonsFactory eINSTANCE = org.soluvas.commons.impl.CommonsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>App Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>App Manifest</em>'.
	 * @generated
	 */
	AppManifest createAppManifest();

	/**
	 * Returns a new object of class '<em>Person Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Person Info</em>'.
	 * @generated
	 */
	PersonInfo createPersonInfo();
	
	/**
	 * Returns a new object of class '<em>Web Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Web Address</em>'.
	 * @generated
	 */
	WebAddress createWebAddress();

	/**
	 * Returns a new object of class '<em>Added</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Added</em>'.
	 * @generated
	 */
	<T extends EObject> Added<T> createAdded();

	/**
	 * Returns a new object of class '<em>Attribute Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Set</em>'.
	 * @generated
	 */
	<T extends EObject, V> AttributeSet<T, V> createAttributeSet();

	/**
	 * Returns a new object of class '<em>Attribute Unset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Unset</em>'.
	 * @generated
	 */
	<T extends EObject, V> AttributeUnset<T, V> createAttributeUnset();

	/**
	 * Returns a new object of class '<em>Removed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Removed</em>'.
	 * @generated
	 */
	<T extends EObject> Removed<T> createRemoved();

	/**
	 * Returns a new object of class '<em>Attribute Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Notification</em>'.
	 * @generated
	 */
	<T extends EObject, V> AttributeNotification<T, V> createAttributeNotification();

	/**
	 * Returns a new object of class '<em>Added Many</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Added Many</em>'.
	 * @generated
	 */
	<T extends EObject> AddedMany<T> createAddedMany();

	/**
	 * Returns a new object of class '<em>Removed Many</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Removed Many</em>'.
	 * @generated
	 */
	<T extends EObject> RemovedMany<T> createRemovedMany();

	/**
	 * Returns a new object of class '<em>Category Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category Info</em>'.
	 * @generated
	 */
	CategoryInfo createCategoryInfo();

	/**
	 * Returns a new object of class '<em>Shell Progress Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shell Progress Monitor</em>'.
	 * @generated
	 */
	ShellProgressMonitor createShellProgressMonitor();

	/**
	 * Returns a new object of class '<em>Event Bus Progress Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Bus Progress Monitor</em>'.
	 * @generated
	 */
	EventBusProgressMonitor createEventBusProgressMonitor();

	/**
	 * Returns a new object of class '<em>Progress Monitor Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Progress Monitor Wrapper</em>'.
	 * @generated
	 */
	ProgressMonitorWrapper createProgressMonitorWrapper();

	/**
	 * Returns a new object of class '<em>Translation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Translation</em>'.
	 * @generated
	 */
	Translation createTranslation();

	/**
	 * Returns a new object of class '<em>Translation Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Translation Manager</em>'.
	 * @generated
	 */
	TranslationManager createTranslationManager();

	PersonInfo createPersonInfo(String id, String slug, String name, String photoId, Gender gender);

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommonsPackage getCommonsPackage();

} //CommonsFactory
