/**
 */
package com.soluvas.story.schema.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.social.Target;
import org.soluvas.social.schema.TargetType;
import org.soluvas.social.schema.impl.TargetTypeImpl;

import com.soluvas.story.Action;
import com.soluvas.story.Aggregation;
import com.soluvas.story.Story;
import com.soluvas.story.schema.*;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.AggregationType;
import com.soluvas.story.schema.SchemaFactory;
import com.soluvas.story.schema.SchemaPackage;
import com.soluvas.story.schema.StorySchemaCatalog;
import com.soluvas.story.schema.StoryType;
import com.soluvas.story.schema.Tenses;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchemaFactoryImpl extends EFactoryImpl implements SchemaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchemaFactory init() {
		try {
			SchemaFactory theSchemaFactory = (SchemaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.com/schema/story.schema/1.0"); 
			if (theSchemaFactory != null) {
				return theSchemaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchemaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchemaFactoryImpl() {
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
			case SchemaPackage.STORY_TYPE: return createStoryType();
			case SchemaPackage.STORY_SCHEMA_CATALOG: return createStorySchemaCatalog();
			case SchemaPackage.ACTION_TYPE: return createActionType();
			case SchemaPackage.AGGREGATION_TYPE: return createAggregationType();
			case SchemaPackage.TARGET_TYPE_REF: return createTargetTypeRef();
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
			case SchemaPackage.TENSES:
				return createTensesFromString(eDataType, initialValue);
			case SchemaPackage.ACTION_TYPE_STATUS:
				return createActionTypeStatusFromString(eDataType, initialValue);
			case SchemaPackage.STORY:
				return createStoryFromString(eDataType, initialValue);
			case SchemaPackage.ACTION:
				return createActionFromString(eDataType, initialValue);
			case SchemaPackage.AGGREGATION:
				return createAggregationFromString(eDataType, initialValue);
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
			case SchemaPackage.TENSES:
				return convertTensesToString(eDataType, instanceValue);
			case SchemaPackage.ACTION_TYPE_STATUS:
				return convertActionTypeStatusToString(eDataType, instanceValue);
			case SchemaPackage.STORY:
				return convertStoryToString(eDataType, instanceValue);
			case SchemaPackage.ACTION:
				return convertActionToString(eDataType, instanceValue);
			case SchemaPackage.AGGREGATION:
				return convertAggregationToString(eDataType, instanceValue);
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
	public StoryType createStoryType() {
		StoryTypeImpl storyType = new StoryTypeImpl();
		return storyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StorySchemaCatalog createStorySchemaCatalog() {
		StorySchemaCatalogImpl storySchemaCatalog = new StorySchemaCatalogImpl();
		return storySchemaCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ActionType createActionType() {
		ActionTypeImpl actionType = new ActionTypeImpl();
		return actionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AggregationType createAggregationType() {
		AggregationTypeImpl aggregationType = new AggregationTypeImpl();
		return aggregationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetTypeRef createTargetTypeRef() {
		TargetTypeRefImpl targetTypeRef = new TargetTypeRefImpl();
		return targetTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tenses createTensesFromString(EDataType eDataType, String initialValue) {
		Tenses result = Tenses.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTensesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionTypeStatus createActionTypeStatusFromString(EDataType eDataType, String initialValue) {
		ActionTypeStatus result = ActionTypeStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Story createStoryFromString(EDataType eDataType, String initialValue) {
		return (Story)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStoryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createActionFromString(EDataType eDataType, String initialValue) {
		return (Action)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation createAggregationFromString(EDataType eDataType, String initialValue) {
		return (Aggregation)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAggregationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SchemaPackage getSchemaPackage() {
		return (SchemaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchemaPackage getPackage() {
		return SchemaPackage.eINSTANCE;
	}
	
	public static SchemaFactory getInstance() {
		return SchemaFactory.eINSTANCE;
	}

} //SchemaFactoryImpl
