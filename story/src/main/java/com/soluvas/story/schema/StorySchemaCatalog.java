/**
 */
package com.soluvas.story.schema;

import com.soluvas.story.Action;
import java.net.URL;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.social.schema.TargetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Story Schema Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The loader will load two files for each catalog:
 * 
 * 1. <catalogName>.StorySchemaCatalog.xmi, declaring the action/target/aggregation/story types, but not the structure.
 * 2. <catalogName>.ecore. This defines the structure of the types.
 * 
 * The loader will resolve eClass names mentioned in the StorySchemaCatalog inside the related ecore file.
 * 
 * nsPrefix = Used to resolve a TargetType subject types inside ActionType.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getStoryTypes <em>Story Types</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getActionTypes <em>Action Types</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getAggregationTypes <em>Aggregation Types</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getGeneratedPackageName <em>Generated Package Name</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getXmiUrl <em>Xmi Url</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getEcoreUrl <em>Ecore Url</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link com.soluvas.story.schema.StorySchemaCatalog#getEFactory <em>EFactory</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog()
 * @model
 * @generated
 */
public interface StorySchemaCatalog extends ResourceAware, BundleAware, NsPrefixable {
	/**
	 * Returns the value of the '<em><b>Story Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.soluvas.story.schema.StoryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Story Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Story Types</em>' containment reference list.
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_StoryTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<StoryType> getStoryTypes();

	/**
	 * Returns the value of the '<em><b>Action Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.soluvas.story.schema.ActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Types</em>' containment reference list.
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_ActionTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActionType> getActionTypes();

	/**
	 * Returns the value of the '<em><b>Aggregation Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.soluvas.story.schema.AggregationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Types</em>' containment reference list.
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_AggregationTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AggregationType> getAggregationTypes();

	/**
	 * Returns the value of the '<em><b>Generated Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to lookup the Java class. e.g. "id.co.bippo.person.story".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generated Package Name</em>' attribute.
	 * @see #setGeneratedPackageName(String)
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_GeneratedPackageName()
	 * @model required="true"
	 * @generated
	 */
	String getGeneratedPackageName();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.StorySchemaCatalog#getGeneratedPackageName <em>Generated Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated Package Name</em>' attribute.
	 * @see #getGeneratedPackageName()
	 * @generated
	 */
	void setGeneratedPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Xmi Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used at runtime by XmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Xmi Url</em>' attribute.
	 * @see #setXmiUrl(URL)
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_XmiUrl()
	 * @model dataType="org.soluvas.commons.URL" transient="true"
	 * @generated
	 */
	URL getXmiUrl();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.StorySchemaCatalog#getXmiUrl <em>Xmi Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmi Url</em>' attribute.
	 * @see #getXmiUrl()
	 * @generated
	 */
	void setXmiUrl(URL value);

	/**
	 * Returns the value of the '<em><b>Ecore Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used at runtime by XmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ecore Url</em>' attribute.
	 * @see #setEcoreUrl(URL)
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_EcoreUrl()
	 * @model dataType="org.soluvas.commons.URL" transient="true"
	 * @generated
	 */
	URL getEcoreUrl();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.StorySchemaCatalog#getEcoreUrl <em>Ecore Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore Url</em>' attribute.
	 * @see #getEcoreUrl()
	 * @generated
	 */
	void setEcoreUrl(URL value);

	/**
	 * Returns the value of the '<em><b>EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used by XmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EPackage</em>' reference.
	 * @see #setEPackage(EPackage)
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_EPackage()
	 * @model transient="true"
	 * @generated
	 */
	EPackage getEPackage();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.StorySchemaCatalog#getEPackage <em>EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPackage</em>' reference.
	 * @see #getEPackage()
	 * @generated
	 */
	void setEPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>EFactory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Only used by XmiTracker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EFactory</em>' reference.
	 * @see #setEFactory(EFactory)
	 * @see com.soluvas.story.schema.SchemaPackage#getStorySchemaCatalog_EFactory()
	 * @model transient="true"
	 * @generated
	 */
	EFactory getEFactory();

	/**
	 * Sets the value of the '{@link com.soluvas.story.schema.StorySchemaCatalog#getEFactory <em>EFactory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EFactory</em>' reference.
	 * @see #getEFactory()
	 * @generated
	 */
	void setEFactory(EFactory value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Helper method to create an {@link Action}.
	 * <!-- end-model-doc -->
	 * @model TBounds="com.soluvas.story.schema.Action"
	 * @generated
	 */
	<T extends Action> T createAction(Class<T> targetClass);

} // StorySchemaCatalog
