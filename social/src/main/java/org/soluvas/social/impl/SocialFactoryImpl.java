/**
 */
package org.soluvas.social.impl;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.social.SocialFactory;
import org.soluvas.social.SocialPackage;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.schema.SocialSchemaCatalog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SocialFactoryImpl extends EFactoryImpl implements SocialFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SocialFactory init() {
		try {
			SocialFactory theSocialFactory = (SocialFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/social/1.0"); 
			if (theSocialFactory != null) {
				return theSocialFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SocialFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocialFactoryImpl() {
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
	public SocialPackage getSocialPackage() {
		return (SocialPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SocialPackage getPackage() {
		return SocialPackage.eINSTANCE;
	}

	@Override
	public Person createPerson(SocialSchemaCatalog socialSchemaCatalog, @Nonnull final PersonInfo personInfo) {
		return new Person.FromInfo(socialSchemaCatalog).apply(personInfo);
	}

	@Override
	public Person createPerson(SocialSchemaCatalog socialSchemaCatalog, @Nonnull final String id, @Nonnull final String slug,
			@Nonnull final String name, @Nonnull final String photoId, @Nonnull final Gender gender) {
		final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo(
				id, slug, name, photoId, gender);
		return createPerson(socialSchemaCatalog, personInfo);
	}

} //SocialFactoryImpl
