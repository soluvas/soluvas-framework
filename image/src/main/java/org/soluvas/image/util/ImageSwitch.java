/**
 */
package org.soluvas.image.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.soluvas.image.*;

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
 * @see org.soluvas.image.ImagePackage
 * @generated
 */
public class ImageSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImagePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageSwitch() {
		if (modelPackage == null) {
			modelPackage = ImagePackage.eINSTANCE;
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
			case ImagePackage.IMAGE_CONFIG: {
				ImageConfig imageConfig = (ImageConfig)theEObject;
				T result = caseImageConfig(imageConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_CONNECTOR: {
				ImageConnector imageConnector = (ImageConnector)theEObject;
				T result = caseImageConnector(imageConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.S3_CONNECTOR: {
				S3Connector s3Connector = (S3Connector)theEObject;
				T result = caseS3Connector(s3Connector);
				if (result == null) result = caseImageConnector(s3Connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.BLITLINE_TRANSFORMER: {
				BlitlineTransformer blitlineTransformer = (BlitlineTransformer)theEObject;
				T result = caseBlitlineTransformer(blitlineTransformer);
				if (result == null) result = caseImageTransformer(blitlineTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.WEB_DAV_CONNECTOR: {
				WebDavConnector webDavConnector = (WebDavConnector)theEObject;
				T result = caseWebDavConnector(webDavConnector);
				if (result == null) result = caseImageConnector(webDavConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.IMAGE_TRANSFORMER: {
				ImageTransformer imageTransformer = (ImageTransformer)theEObject;
				T result = caseImageTransformer(imageTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.THUMBNAILATOR_TRANSFORMER: {
				ThumbnailatorTransformer thumbnailatorTransformer = (ThumbnailatorTransformer)theEObject;
				T result = caseThumbnailatorTransformer(thumbnailatorTransformer);
				if (result == null) result = caseImageTransformer(thumbnailatorTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImagePackage.UPLOADED_IMAGE: {
				UploadedImage uploadedImage = (UploadedImage)theEObject;
				T result = caseUploadedImage(uploadedImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageConfig(ImageConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageConnector(ImageConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>S3 Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>S3 Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseS3Connector(S3Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Blitline Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Blitline Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlitlineTransformer(BlitlineTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Web Dav Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Web Dav Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWebDavConnector(WebDavConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageTransformer(ImageTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thumbnailator Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thumbnailator Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThumbnailatorTransformer(ThumbnailatorTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uploaded Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uploaded Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUploadedImage(UploadedImage object) {
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

} //ImageSwitch
