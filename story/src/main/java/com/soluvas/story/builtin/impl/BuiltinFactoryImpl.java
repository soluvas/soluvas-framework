/**
 */
package com.soluvas.story.builtin.impl;

import com.soluvas.story.builtin.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.soluvas.story.builtin.BuiltinFactory;
import com.soluvas.story.builtin.BuiltinPackage;
import com.soluvas.story.builtin.Comment;
import com.soluvas.story.builtin.Follow;
import com.soluvas.story.builtin.Like;
import com.soluvas.story.builtin.Listen;
import com.soluvas.story.builtin.Read;
import com.soluvas.story.builtin.Share;
import com.soluvas.story.builtin.Watch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuiltinFactoryImpl extends EFactoryImpl implements BuiltinFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BuiltinFactory init() {
		try {
			BuiltinFactory theBuiltinFactory = (BuiltinFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.com/schema/story.builtin/1.0"); 
			if (theBuiltinFactory != null) {
				return theBuiltinFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BuiltinFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BuiltinPackage.FOLLOW: return createFollow();
			case BuiltinPackage.LIKE: return createLike();
			case BuiltinPackage.LISTEN: return createListen();
			case BuiltinPackage.READ: return createRead();
			case BuiltinPackage.WATCH: return createWatch();
			case BuiltinPackage.COMMENT: return createComment();
			case BuiltinPackage.SHARE: return createShare();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Follow createFollow() {
		FollowImpl follow = new FollowImpl();
		return follow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Like createLike() {
		LikeImpl like = new LikeImpl();
		return like;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Listen createListen() {
		ListenImpl listen = new ListenImpl();
		return listen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Read createRead() {
		ReadImpl read = new ReadImpl();
		return read;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Watch createWatch() {
		WatchImpl watch = new WatchImpl();
		return watch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Share createShare() {
		ShareImpl share = new ShareImpl();
		return share;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuiltinPackage getBuiltinPackage() {
		return (BuiltinPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BuiltinPackage getPackage() {
		return BuiltinPackage.eINSTANCE;
	}

} //BuiltinFactoryImpl
