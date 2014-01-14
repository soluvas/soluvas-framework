/**
 */
package org.soluvas.email;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sender Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.email.EmailPackage#getSenderType()
 * @model
 * @generated
 */
public interface SenderType extends NameContainer, BundleAware, NsPrefixable, SenderLike {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Sender create();
} // SenderType
