/**
 */
package org.soluvas.social.schema;

import java.net.URL;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.ResourceAware;
import org.soluvas.social.Target;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Social Schema Catalog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The loader will load two files for each catalog:
 * 
 * 1. <catalogName>.StorySchemaCatalog.xmi, declaring the action/target/aggregation/story types, but not the structure.
 * 2. <catalogName>.ecore. This defines the structure of the types.
 * 
 * The loader will resolve eClass names mentioned in the StorySchemaCatalog inside the related ecore file.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getTargetTypes <em>Target Types</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getGeneratedPackageName <em>Generated Package Name</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getXmiUrl <em>Xmi Url</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getEcoreUrl <em>Ecore Url</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.soluvas.social.schema.SocialSchemaCatalog#getEFactory <em>EFactory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog()
 * @model
 * @generated
 */
public interface SocialSchemaCatalog extends ResourceAware, BundleAware {
	/**
	 * Returns the value of the '<em><b>Target Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.soluvas.social.schema.TargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Types</em>' containment reference list.
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_TargetTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<TargetType> getTargetTypes();

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to resolve a TargetType subject types inside ActionType.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_NsPrefix()
	 * @model required="true"
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Generated Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to lookup the Java class. e.g. "id.co.bippo.person.story".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generated Package Name</em>' attribute.
	 * @see #setGeneratedPackageName(String)
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_GeneratedPackageName()
	 * @model required="true"
	 * @generated
	 */
	String getGeneratedPackageName();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getGeneratedPackageName <em>Generated Package Name</em>}' attribute.
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
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_XmiUrl()
	 * @model dataType="org.soluvas.commons.URL" transient="true"
	 * @generated
	 */
	URL getXmiUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getXmiUrl <em>Xmi Url</em>}' attribute.
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
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_EcoreUrl()
	 * @model dataType="org.soluvas.commons.URL" transient="true"
	 * @generated
	 */
	URL getEcoreUrl();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getEcoreUrl <em>Ecore Url</em>}' attribute.
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
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_EPackage()
	 * @model transient="true"
	 * @generated
	 */
	EPackage getEPackage();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getEPackage <em>EPackage</em>}' reference.
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
	 * @see org.soluvas.social.schema.SchemaPackage#getSocialSchemaCatalog_EFactory()
	 * @model transient="true"
	 * @generated
	 */
	EFactory getEFactory();

	/**
	 * Sets the value of the '{@link org.soluvas.social.schema.SocialSchemaCatalog#getEFactory <em>EFactory</em>}' reference.
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
	 * Helper method to create a {@link Target}. Useful for {@link TargetFinder} implementation.
	 * <!-- end-model-doc -->
	 * @model TBounds="org.soluvas.social.schema.Target"
	 * @generated
	 */
	<T extends Target> T createTarget(Class<T> targetClass);

} // SocialSchemaCatalog
