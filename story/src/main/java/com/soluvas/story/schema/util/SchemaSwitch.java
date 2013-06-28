/**
 */
package com.soluvas.story.schema.util;

import com.soluvas.story.schema.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.social.schema.TargetType;

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
 * @see com.soluvas.story.schema.SchemaPackage
 * @generated
 */
public class SchemaSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SchemaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaSwitch() {
		if (modelPackage == null) {
			modelPackage = SchemaPackage.eINSTANCE;
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
			case SchemaPackage.STORY_TYPE: {
				StoryType storyType = (StoryType)theEObject;
				T1 result = caseStoryType(storyType);
				if (result == null) result = caseResourceAware(storyType);
				if (result == null) result = caseNameContainer(storyType);
				if (result == null) result = caseJavaClassLinked(storyType);
				if (result == null) result = caseEClassLinked(storyType);
				if (result == null) result = caseNameable(storyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchemaPackage.STORY_SCHEMA_CATALOG: {
				StorySchemaCatalog storySchemaCatalog = (StorySchemaCatalog)theEObject;
				T1 result = caseStorySchemaCatalog(storySchemaCatalog);
				if (result == null) result = caseResourceAware(storySchemaCatalog);
				if (result == null) result = caseBundleAware(storySchemaCatalog);
				if (result == null) result = caseNsPrefixable(storySchemaCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchemaPackage.ACTION_TYPE: {
				ActionType actionType = (ActionType)theEObject;
				T1 result = caseActionType(actionType);
				if (result == null) result = caseNameContainer(actionType);
				if (result == null) result = caseBundleAware(actionType);
				if (result == null) result = caseResourceAware(actionType);
				if (result == null) result = caseJavaClassLinked(actionType);
				if (result == null) result = caseEClassLinked(actionType);
				if (result == null) result = caseEFactoryLinked(actionType);
				if (result == null) result = caseActionLike(actionType);
				if (result == null) result = caseNsPrefixable(actionType);
				if (result == null) result = caseNameable(actionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchemaPackage.AGGREGATION_TYPE: {
				AggregationType aggregationType = (AggregationType)theEObject;
				T1 result = caseAggregationType(aggregationType);
				if (result == null) result = caseResourceAware(aggregationType);
				if (result == null) result = caseNameContainer(aggregationType);
				if (result == null) result = caseBundleAware(aggregationType);
				if (result == null) result = caseJavaClassLinked(aggregationType);
				if (result == null) result = caseEClassLinked(aggregationType);
				if (result == null) result = caseNameable(aggregationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchemaPackage.ACTION_LIKE: {
				ActionLike actionLike = (ActionLike)theEObject;
				T1 result = caseActionLike(actionLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SchemaPackage.TARGET_TYPE_REF: {
				TargetTypeRef targetTypeRef = (TargetTypeRef)theEObject;
				T1 result = caseTargetTypeRef(targetTypeRef);
				if (result == null) result = caseNsPrefixable(targetTypeRef);
				if (result == null) result = caseNameContainer(targetTypeRef);
				if (result == null) result = caseNameable(targetTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Story Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Story Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStoryType(StoryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Story Schema Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Story Schema Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStorySchemaCatalog(StorySchemaCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActionType(ActionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregationType(AggregationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActionLike(ActionLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTargetTypeRef(TargetTypeRef object) {
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

} //SchemaSwitch
