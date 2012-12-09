/**
 */
package org.soluvas.commons.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;

import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.joda.money.CurrencyUnit;
import org.joda.time.DateTime;
import org.soluvas.commons.*;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.commons.Gender;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.ResourceType;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonsFactoryImpl extends EFactoryImpl implements CommonsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommonsFactory init() {
		try {
			CommonsFactory theCommonsFactory = (CommonsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/commons/1.0"); 
			if (theCommonsFactory != null) {
				return theCommonsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommonsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonsFactoryImpl() {
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
			case CommonsPackage.APP_MANIFEST: return (EObject)createAppManifest();
			case CommonsPackage.PERSON_INFO: return (EObject)createPersonInfo();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CommonsPackage.RESOURCE_TYPE:
				return createResourceTypeFromString(eDataType, initialValue);
			case CommonsPackage.GENDER:
				return createGenderFromString(eDataType, initialValue);
			case CommonsPackage.ECLASS_STATUS:
				return createEClassStatusFromString(eDataType, initialValue);
			case CommonsPackage.JAVA_CLASS_STATUS:
				return createJavaClassStatusFromString(eDataType, initialValue);
			case CommonsPackage.DATE_TIME:
				return createDateTimeFromString(eDataType, initialValue);
			case CommonsPackage.CURRENCY_UNIT:
				return createCurrencyUnitFromString(eDataType, initialValue);
			case CommonsPackage.UNIT:
				return createUnitFromString(eDataType, initialValue);
			case CommonsPackage.LIST:
				return createListFromString(eDataType, initialValue);
			case CommonsPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			case CommonsPackage.SET:
				return createSetFromString(eDataType, initialValue);
			case CommonsPackage.COLLECTION:
				return createCollectionFromString(eDataType, initialValue);
			case CommonsPackage.MULTIMAP:
				return createMultimapFromString(eDataType, initialValue);
			case CommonsPackage.NAVIGABLE_MAP:
				return createNavigableMapFromString(eDataType, initialValue);
			case CommonsPackage.QUEUE:
				return createQueueFromString(eDataType, initialValue);
			case CommonsPackage.MULTISET:
				return createMultisetFromString(eDataType, initialValue);
			case CommonsPackage.SERIALIZABLE:
				return createSerializableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CommonsPackage.RESOURCE_TYPE:
				return convertResourceTypeToString(eDataType, instanceValue);
			case CommonsPackage.GENDER:
				return convertGenderToString(eDataType, instanceValue);
			case CommonsPackage.ECLASS_STATUS:
				return convertEClassStatusToString(eDataType, instanceValue);
			case CommonsPackage.JAVA_CLASS_STATUS:
				return convertJavaClassStatusToString(eDataType, instanceValue);
			case CommonsPackage.DATE_TIME:
				return convertDateTimeToString(eDataType, instanceValue);
			case CommonsPackage.CURRENCY_UNIT:
				return convertCurrencyUnitToString(eDataType, instanceValue);
			case CommonsPackage.UNIT:
				return convertUnitToString(eDataType, instanceValue);
			case CommonsPackage.LIST:
				return convertListToString(eDataType, instanceValue);
			case CommonsPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			case CommonsPackage.SET:
				return convertSetToString(eDataType, instanceValue);
			case CommonsPackage.COLLECTION:
				return convertCollectionToString(eDataType, instanceValue);
			case CommonsPackage.MULTIMAP:
				return convertMultimapToString(eDataType, instanceValue);
			case CommonsPackage.NAVIGABLE_MAP:
				return convertNavigableMapToString(eDataType, instanceValue);
			case CommonsPackage.QUEUE:
				return convertQueueToString(eDataType, instanceValue);
			case CommonsPackage.MULTISET:
				return convertMultisetToString(eDataType, instanceValue);
			case CommonsPackage.SERIALIZABLE:
				return convertSerializableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AppManifest createAppManifest() {
		AppManifestImpl appManifest = new AppManifestImpl();
		return appManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PersonInfo createPersonInfo() {
		PersonInfoImpl personInfo = new PersonInfoImpl();
		return personInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType createResourceTypeFromString(EDataType eDataType, String initialValue) {
		ResourceType result = ResourceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gender createGenderFromString(EDataType eDataType, String initialValue) {
		Gender result = Gender.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassStatus createEClassStatusFromString(EDataType eDataType, String initialValue) {
		EClassStatus result = EClassStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEClassStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaClassStatus createJavaClassStatusFromString(EDataType eDataType, String initialValue) {
		JavaClassStatus result = JavaClassStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaClassStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTime createDateTimeFromString(EDataType eDataType, String initialValue) {
		return (DateTime)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDateTimeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrencyUnit createCurrencyUnitFromString(EDataType eDataType, String initialValue) {
		return (CurrencyUnit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCurrencyUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnitFromString(EDataType eDataType, String initialValue) {
		return (Unit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<?> createListFromString(EDataType eDataType, String initialValue) {
		return (List<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertListToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Set<?> createSetFromString(EDataType eDataType, String initialValue) {
		return (Set<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<?> createCollectionFromString(EDataType eDataType, String initialValue) {
		return (Collection<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multimap<?, ?> createMultimapFromString(EDataType eDataType, String initialValue) {
		return (Multimap<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultimapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigableMap<?, ?> createNavigableMapFromString(EDataType eDataType, String initialValue) {
		return (NavigableMap<?, ?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNavigableMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Queue<?> createQueueFromString(EDataType eDataType, String initialValue) {
		return (Queue<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiset<?> createMultisetFromString(EDataType eDataType, String initialValue) {
		return (Multiset<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultisetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Serializable createSerializableFromString(EDataType eDataType, String initialValue) {
		return (Serializable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSerializableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CommonsPackage getCommonsPackage() {
		return (CommonsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommonsPackage getPackage() {
		return CommonsPackage.eINSTANCE;
	}

	@Override
	public PersonInfo createPersonInfo(String id, String slug, String name,
			String photoId, Gender gender) {
		final PersonInfo person = createPersonInfo();
		person.setId(id);
		person.setSlug(slug);
		person.setName(name);
		person.setPhotoId(photoId);
		person.setGender(gender);
		return person;
	}

} //CommonsFactoryImpl
