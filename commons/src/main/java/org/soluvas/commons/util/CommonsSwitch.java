/**
 */
package org.soluvas.commons.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.commons.*;

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
 * @see org.soluvas.commons.CommonsPackage
 * @generated
 */
public class CommonsSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CommonsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonsSwitch() {
		if (modelPackage == null) {
			modelPackage = CommonsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CommonsPackage.RESOURCE_AWARE: {
				ResourceAware resourceAware = (ResourceAware)theEObject;
				T1 result = caseResourceAware(resourceAware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.POSITIONABLE: {
				Positionable positionable = (Positionable)theEObject;
				T1 result = casePositionable(positionable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.APP_MANIFEST: {
				AppManifest appManifest = (AppManifest)theEObject;
				T1 result = caseAppManifest(appManifest);
				if (result == null) result = casePositionable(appManifest);
				if (result == null) result = caseResourceAware(appManifest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.PERSON_INFO: {
				PersonInfo personInfo = (PersonInfo)theEObject;
				T1 result = casePersonInfo(personInfo);
				if (result == null) result = caseIdentifiable(personInfo);
				if (result == null) result = casePhotoIdContainer(personInfo);
				if (result == null) result = caseSluggable(personInfo);
				if (result == null) result = caseNameContainer(personInfo);
				if (result == null) result = caseImageable(personInfo);
				if (result == null) result = caseNameable(personInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.TIMESTAMPED: {
				Timestamped timestamped = (Timestamped)theEObject;
				T1 result = caseTimestamped(timestamped);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.IDENTIFIABLE: {
				Identifiable identifiable = (Identifiable)theEObject;
				T1 result = caseIdentifiable(identifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.SLUGGABLE: {
				Sluggable sluggable = (Sluggable)theEObject;
				T1 result = caseSluggable(sluggable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.NAMEABLE: {
				Nameable nameable = (Nameable)theEObject;
				T1 result = caseNameable(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.IMAGEABLE: {
				Imageable imageable = (Imageable)theEObject;
				T1 result = caseImageable(imageable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.PHOTO_ID_CONTAINER: {
				PhotoIdContainer photoIdContainer = (PhotoIdContainer)theEObject;
				T1 result = casePhotoIdContainer(photoIdContainer);
				if (result == null) result = caseImageable(photoIdContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.NAME_CONTAINER: {
				NameContainer nameContainer = (NameContainer)theEObject;
				T1 result = caseNameContainer(nameContainer);
				if (result == null) result = caseNameable(nameContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.INFORMER: {
				Informer<?> informer = (Informer<?>)theEObject;
				T1 result = caseInformer(informer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.DESCRIBABLE: {
				Describable describable = (Describable)theEObject;
				T1 result = caseDescribable(describable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.BUNDLE_AWARE: {
				BundleAware bundleAware = (BundleAware)theEObject;
				T1 result = caseBundleAware(bundleAware);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.JAVA_CLASS_LINKED: {
				JavaClassLinked<?> javaClassLinked = (JavaClassLinked<?>)theEObject;
				T1 result = caseJavaClassLinked(javaClassLinked);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ECLASS_LINKED: {
				EClassLinked eClassLinked = (EClassLinked)theEObject;
				T1 result = caseEClassLinked(eClassLinked);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.SCHEMA_VERSIONABLE: {
				SchemaVersionable schemaVersionable = (SchemaVersionable)theEObject;
				T1 result = caseSchemaVersionable(schemaVersionable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.EFACTORY_LINKED: {
				EFactoryLinked eFactoryLinked = (EFactoryLinked)theEObject;
				T1 result = caseEFactoryLinked(eFactoryLinked);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.NS_PREFIXABLE: {
				NsPrefixable nsPrefixable = (NsPrefixable)theEObject;
				T1 result = caseNsPrefixable(nsPrefixable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.WEB_ADDRESS: {
				WebAddress webAddress = (WebAddress)theEObject;
				T1 result = caseWebAddress(webAddress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ADDED: {
				Added<?> added = (Added<?>)theEObject;
				T1 result = caseAdded(added);
				if (result == null) result = caseObjectNotification(added);
				if (result == null) result = caseModelNotification(added);
				if (result == null) result = caseEObjectLinked(added);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.MODEL_NOTIFICATION: {
				ModelNotification<?> modelNotification = (ModelNotification<?>)theEObject;
				T1 result = caseModelNotification(modelNotification);
				if (result == null) result = caseEObjectLinked(modelNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ATTRIBUTE_SET: {
				AttributeSet<?, ?> attributeSet = (AttributeSet<?, ?>)theEObject;
				T1 result = caseAttributeSet(attributeSet);
				if (result == null) result = caseAttributeNotification(attributeSet);
				if (result == null) result = caseModelNotification(attributeSet);
				if (result == null) result = caseEObjectLinked(attributeSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ATTRIBUTE_UNSET: {
				AttributeUnset<?, ?> attributeUnset = (AttributeUnset<?, ?>)theEObject;
				T1 result = caseAttributeUnset(attributeUnset);
				if (result == null) result = caseAttributeNotification(attributeUnset);
				if (result == null) result = caseModelNotification(attributeUnset);
				if (result == null) result = caseEObjectLinked(attributeUnset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.REMOVED: {
				Removed<?> removed = (Removed<?>)theEObject;
				T1 result = caseRemoved(removed);
				if (result == null) result = caseObjectNotification(removed);
				if (result == null) result = caseModelNotification(removed);
				if (result == null) result = caseEObjectLinked(removed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.OBJECT_NOTIFICATION: {
				ObjectNotification<?> objectNotification = (ObjectNotification<?>)theEObject;
				T1 result = caseObjectNotification(objectNotification);
				if (result == null) result = caseModelNotification(objectNotification);
				if (result == null) result = caseEObjectLinked(objectNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ATTRIBUTE_NOTIFICATION: {
				AttributeNotification<?, ?> attributeNotification = (AttributeNotification<?, ?>)theEObject;
				T1 result = caseAttributeNotification(attributeNotification);
				if (result == null) result = caseModelNotification(attributeNotification);
				if (result == null) result = caseEObjectLinked(attributeNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.ADDED_MANY: {
				AddedMany<?> addedMany = (AddedMany<?>)theEObject;
				T1 result = caseAddedMany(addedMany);
				if (result == null) result = caseObjectsNotification(addedMany);
				if (result == null) result = caseModelNotification(addedMany);
				if (result == null) result = caseEObjectLinked(addedMany);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.REMOVED_MANY: {
				RemovedMany<?> removedMany = (RemovedMany<?>)theEObject;
				T1 result = caseRemovedMany(removedMany);
				if (result == null) result = caseObjectsNotification(removedMany);
				if (result == null) result = caseModelNotification(removedMany);
				if (result == null) result = caseEObjectLinked(removedMany);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.OBJECTS_NOTIFICATION: {
				ObjectsNotification<?> objectsNotification = (ObjectsNotification<?>)theEObject;
				T1 result = caseObjectsNotification(objectsNotification);
				if (result == null) result = caseModelNotification(objectsNotification);
				if (result == null) result = caseEObjectLinked(objectsNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.EOBJECT_LINKED: {
				EObjectLinked<?> eObjectLinked = (EObjectLinked<?>)theEObject;
				T1 result = caseEObjectLinked(eObjectLinked);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.PARENTABLE: {
				Parentable<?> parentable = (Parentable<?>)theEObject;
				T1 result = caseParentable(parentable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.CATEGORY_LIKE: {
				CategoryLike categoryLike = (CategoryLike)theEObject;
				T1 result = caseCategoryLike(categoryLike);
				if (result == null) result = casePositionable(categoryLike);
				if (result == null) result = caseSluggable(categoryLike);
				if (result == null) result = caseImageable(categoryLike);
				if (result == null) result = caseIdentifiable(categoryLike);
				if (result == null) result = caseNameContainer(categoryLike);
				if (result == null) result = caseNameable(categoryLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.CATEGORY_INFO: {
				CategoryInfo categoryInfo = (CategoryInfo)theEObject;
				T1 result = caseCategoryInfo(categoryInfo);
				if (result == null) result = caseCategoryLike(categoryInfo);
				if (result == null) result = caseParentable(categoryInfo);
				if (result == null) result = casePositionable(categoryInfo);
				if (result == null) result = caseSluggable(categoryInfo);
				if (result == null) result = caseImageable(categoryInfo);
				if (result == null) result = caseIdentifiable(categoryInfo);
				if (result == null) result = caseNameContainer(categoryInfo);
				if (result == null) result = caseNameable(categoryInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.PROGRESS_MONITOR: {
				ProgressMonitor progressMonitor = (ProgressMonitor)theEObject;
				T1 result = caseProgressMonitor(progressMonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.SHELL_PROGRESS_MONITOR: {
				ShellProgressMonitor shellProgressMonitor = (ShellProgressMonitor)theEObject;
				T1 result = caseShellProgressMonitor(shellProgressMonitor);
				if (result == null) result = caseProgressMonitor(shellProgressMonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CommonsPackage.PROGRESS_MONITOR_WRAPPER: {
				ProgressMonitorWrapper progressMonitorWrapper = (ProgressMonitorWrapper)theEObject;
				T1 result = caseProgressMonitorWrapper(progressMonitorWrapper);
				if (result == null) result = caseProgressMonitor(progressMonitorWrapper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceAware(ResourceAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Positionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Positionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePositionable(Positionable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>App Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>App Manifest</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAppManifest(AppManifest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Person Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Person Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePersonInfo(PersonInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timestamped</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timestamped</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTimestamped(Timestamped object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentifiable(Identifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sluggable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sluggable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSluggable(Sluggable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imageable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imageable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImageable(Imageable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Photo Id Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Photo Id Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePhotoIdContainer(PhotoIdContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameContainer(NameContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Informer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Informer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Identifiable> T1 caseInformer(Informer<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Describable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Describable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescribable(Describable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBundleAware(BundleAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Class Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Class Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseJavaClassLinked(JavaClassLinked<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEClassLinked(EClassLinked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schema Versionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schema Versionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSchemaVersionable(SchemaVersionable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFactory Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFactory Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEFactoryLinked(EFactoryLinked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ns Prefixable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ns Prefixable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNsPrefixable(NsPrefixable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWebAddress(WebAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Added</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Added</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseAdded(Added<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseModelNotification(ModelNotification<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject, V> T1 caseAttributeSet(AttributeSet<T, V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Unset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Unset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject, V> T1 caseAttributeUnset(AttributeUnset<T, V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Removed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Removed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseRemoved(Removed<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseObjectNotification(ObjectNotification<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject, V> T1 caseAttributeNotification(AttributeNotification<T, V> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Added Many</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Added Many</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseAddedMany(AddedMany<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Removed Many</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Removed Many</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseRemovedMany(RemovedMany<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Objects Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Objects Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseObjectsNotification(ObjectsNotification<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends EObject> T1 caseEObjectLinked(EObjectLinked<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parentable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parentable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <P> T1 caseParentable(Parentable<P> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCategoryLike(CategoryLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCategoryInfo(CategoryInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Progress Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Progress Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProgressMonitor(ProgressMonitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shell Progress Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shell Progress Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShellProgressMonitor(ShellProgressMonitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Progress Monitor Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Progress Monitor Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProgressMonitorWrapper(ProgressMonitorWrapper object) {
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
	public T1 defaultCase(EObject object) {
		return null;
	}

} //CommonsSwitch
