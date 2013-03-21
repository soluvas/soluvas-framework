/**
 */
package org.soluvas.image.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.ImageTransform;
import org.soluvas.image.ImageTransformer;
import org.soluvas.image.ImageVariant;
import org.soluvas.image.UploadedImage;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.image.impl.ImageTransformerImpl#getExecutor <em>Executor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ImageTransformerImpl extends EObjectImpl implements ImageTransformer {
	/**
	 * The default value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @ordered
	 */
	protected static final ListeningExecutorService EXECUTOR_EDEFAULT = MoreExecutors.sameThreadExecutor();

	/**
	 * The cached value of the '{@link #getExecutor() <em>Executor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutor()
	 * @generated
	 * @ordered
	 */
	protected ListeningExecutorService executor = EXECUTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageTransformerImpl() {
		super();
	}
	
	public ImageTransformerImpl(ExecutorService executor) {
		super();
		this.executor = MoreExecutors.listeningDecorator(executor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_TRANSFORMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListeningExecutorService getExecutor() {
		return executor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListenableFuture<List<UploadedImage>> transform(ImageConnector source, String namespace, String imageId, ImageVariant sourceVariant, Map<ImageTransform, ImageVariant> transforms) {
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
			case ImagePackage.IMAGE_TRANSFORMER__EXECUTOR:
				return getExecutor();
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
			case ImagePackage.IMAGE_TRANSFORMER__EXECUTOR:
				return EXECUTOR_EDEFAULT == null ? executor != null : !EXECUTOR_EDEFAULT.equals(executor);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (executor: ");
		result.append(executor);
		result.append(')');
		return result.toString();
	}

} //ImageTransformerImpl
