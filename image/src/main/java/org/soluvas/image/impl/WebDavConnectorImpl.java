/**
 */
package org.soluvas.image.impl;

import java.io.File;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.soluvas.image.ImagePackage;
import org.soluvas.image.UploadedImage;
import org.soluvas.image.WebDavConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Dav Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WebDavConnectorImpl extends EObjectImpl implements WebDavConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebDavConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.WEB_DAV_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadedImage upload(String namespace, String imageId, String styleCode, String extension, File file, String contentType) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //WebDavConnectorImpl
