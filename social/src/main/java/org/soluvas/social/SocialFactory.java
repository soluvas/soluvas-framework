/**
 */
package org.soluvas.social;

import org.eclipse.emf.ecore.EFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.social.builtin.ExternalProfile;
import org.soluvas.social.builtin.Person;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.social.SocialPackage
 * @generated
 */
public interface SocialFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SocialFactory eINSTANCE = org.soluvas.social.impl.SocialFactoryImpl.init();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SocialPackage getSocialPackage();

	Person createPerson(PersonInfo personInfo);

	Person createPerson(String id, String slug, String name, String photoId,
			Gender gender);

} //SocialFactory
