package org.soluvas.jpa.jpa;

import org.soluvas.commons.Describable2;

/**
 * A representation of the model object '<em><b>Describable</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Has
 * description. <!-- end-model-doc -->
 *
 * @deprecated Use {@link Describable2}
 */
@Deprecated
public interface Describable {
	/**
	 * Returns the value of '<em><b>description</em></b>' feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>description</b></em>' feature
	 * @generated
	 */
	public String getDescription();

	/**
	 * Sets the '{@link Describable#getDescription() <em>description</em>}'
	 * feature.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newDescription
	 *            the new value of the '{@link Describable#getDescription()
	 *            <em>description</em>}' feature.
	 * @generated
	 */
	public void setDescription(String newDescription);

}
