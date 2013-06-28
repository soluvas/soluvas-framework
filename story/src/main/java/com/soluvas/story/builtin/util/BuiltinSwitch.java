/**
 */
package com.soluvas.story.builtin.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;

import com.soluvas.story.Action;
import com.soluvas.story.Messageable;
import com.soluvas.story.builtin.*;
import com.soluvas.story.builtin.BuiltinPackage;
import com.soluvas.story.builtin.Comment;
import com.soluvas.story.builtin.Follow;
import com.soluvas.story.builtin.Like;
import com.soluvas.story.builtin.Listen;
import com.soluvas.story.builtin.Read;
import com.soluvas.story.builtin.Share;
import com.soluvas.story.builtin.TimeTrackable;
import com.soluvas.story.builtin.Watch;
import com.soluvas.story.schema.ActionLike;

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
 * @see com.soluvas.story.builtin.BuiltinPackage
 * @generated
 */
public class BuiltinSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BuiltinPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinSwitch() {
		if (modelPackage == null) {
			modelPackage = BuiltinPackage.eINSTANCE;
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
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BuiltinPackage.FOLLOW: {
				Follow follow = (Follow)theEObject;
				T result = caseFollow(follow);
				if (result == null) result = caseAction(follow);
				if (result == null) result = caseNameContainer(follow);
				if (result == null) result = caseActionLike(follow);
				if (result == null) result = caseNsPrefixable(follow);
				if (result == null) result = caseNameable(follow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.LIKE: {
				Like like = (Like)theEObject;
				T result = caseLike(like);
				if (result == null) result = caseAction(like);
				if (result == null) result = caseNameContainer(like);
				if (result == null) result = caseActionLike(like);
				if (result == null) result = caseNsPrefixable(like);
				if (result == null) result = caseNameable(like);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.LISTEN: {
				Listen listen = (Listen)theEObject;
				T result = caseListen(listen);
				if (result == null) result = caseAction(listen);
				if (result == null) result = caseNameContainer(listen);
				if (result == null) result = caseActionLike(listen);
				if (result == null) result = caseNsPrefixable(listen);
				if (result == null) result = caseNameable(listen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.READ: {
				Read read = (Read)theEObject;
				T result = caseRead(read);
				if (result == null) result = caseAction(read);
				if (result == null) result = caseTimeTrackable(read);
				if (result == null) result = caseNameContainer(read);
				if (result == null) result = caseActionLike(read);
				if (result == null) result = caseNsPrefixable(read);
				if (result == null) result = caseNameable(read);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.WATCH: {
				Watch watch = (Watch)theEObject;
				T result = caseWatch(watch);
				if (result == null) result = caseAction(watch);
				if (result == null) result = caseTimeTrackable(watch);
				if (result == null) result = caseNameContainer(watch);
				if (result == null) result = caseActionLike(watch);
				if (result == null) result = caseNsPrefixable(watch);
				if (result == null) result = caseNameable(watch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseAction(comment);
				if (result == null) result = caseMessageable(comment);
				if (result == null) result = caseNameContainer(comment);
				if (result == null) result = caseActionLike(comment);
				if (result == null) result = caseNsPrefixable(comment);
				if (result == null) result = caseNameable(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.TIME_TRACKABLE: {
				TimeTrackable timeTrackable = (TimeTrackable)theEObject;
				T result = caseTimeTrackable(timeTrackable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BuiltinPackage.SHARE: {
				Share share = (Share)theEObject;
				T result = caseShare(share);
				if (result == null) result = caseAction(share);
				if (result == null) result = caseMessageable(share);
				if (result == null) result = caseNameContainer(share);
				if (result == null) result = caseActionLike(share);
				if (result == null) result = caseNsPrefixable(share);
				if (result == null) result = caseNameable(share);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Follow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Follow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFollow(Follow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLike(Like object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Listen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Listen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListen(Listen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRead(Read object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Watch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Watch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWatch(Watch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Trackable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Trackable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeTrackable(TimeTrackable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Share</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Share</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShare(Share object) {
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
	public T caseNameable(Nameable object) {
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
	public T caseNameContainer(NameContainer object) {
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
	public T caseActionLike(ActionLike object) {
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
	public T caseNsPrefixable(NsPrefixable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Messageable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Messageable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessageable(Messageable object) {
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

} //BuiltinSwitch
