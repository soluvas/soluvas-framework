/**
 */
package org.soluvas.social.schema;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.ResourceAware;
import org.soluvas.social.Target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.social.schema.SchemaPackage#getTargetType()
 * @model superTypes="org.soluvas.commons.NameContainer org.soluvas.commons.BundleAware org.soluvas.commons.ResourceAware org.soluvas.commons.JavaClassLinked<org.soluvas.social.schema.Target> org.soluvas.commons.EClassLinked org.soluvas.commons.EFactoryLinked"
 * @generated
 */
public interface TargetType extends NameContainer, BundleAware, ResourceAware, JavaClassLinked<Target>, EClassLinked, EFactoryLinked {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create Target with proper nsPrefix and targetType attributes.
	 * <!-- end-model-doc -->
	 * @model dataType="org.soluvas.social.schema.Target"
	 * @generated
	 */
	Target create();

} // TargetType
