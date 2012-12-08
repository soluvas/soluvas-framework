/**
 */
package org.soluvas.commons;

import javax.annotation.Nonnull;

import org.osgi.framework.Bundle;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Class Linked</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Implementation is in {@link org.soluvas.commons.JavaClassLinked.Trait}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClassName <em>Java Class Name</em>}</li>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClass <em>Java Class</em>}</li>
 *   <li>{@link org.soluvas.commons.JavaClassLinked#getJavaClassStatus <em>Java Class Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked()
 * @model interface="true" abstract="true"
 * @extends SerializableEObject
 * @generated
 */
public interface JavaClassLinked<T> extends SerializableEObject {
	
	public static class Trait {

		/**
		 * Implementation for {@link JavaClassLinked#resolveJavaClass(Bundle)}.
		 * @param obj
		 * @param bundle
		 */
		@SuppressWarnings("unchecked")
		public static <T> void resolveJavaClass(@Nonnull final JavaClassLinked<T> obj, @Nonnull final Bundle bundle) {
			Preconditions.checkState(!Strings.isNullOrEmpty(obj.getJavaClassName()),
					"Cannot resolve empty Java class from bundle %s", bundle);
			Preconditions.checkNotNull(bundle, "Cannot resolve class %s because specified bundle is null", obj.getJavaClassName());
			try {
				final Class<T> clazz = (Class<T>) bundle.loadClass(obj.getJavaClassName());
				obj.setJavaClass(clazz);
				obj.setJavaClassStatus(JavaClassStatus.RESOLVED);
			} catch (ClassNotFoundException e) {
				throw new CommonsException(String.format("Cannot resolve class %s from bundle %s [%d]",
						obj.getJavaClassName(), bundle.getSymbolicName(), bundle.getBundleId()), e);
			}
		}
		
	}
	
	/**
	 * Returns the value of the '<em><b>Java Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Java class name linked to this type. Used to resolve the Java Class instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Java Class Name</em>' attribute.
	 * @see #setJavaClassName(String)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClassName()
	 * @model
	 * @generated
	 */
	String getJavaClassName();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClassName <em>Java Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class Name</em>' attribute.
	 * @see #getJavaClassName()
	 * @generated
	 */
	void setJavaClassName(String value);

	/**
	 * Returns the value of the '<em><b>Java Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Java class linked to this type. Only available when resolved.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Java Class</em>' attribute.
	 * @see #setJavaClass(Class)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClass()
	 * @model
	 * @generated
	 */
	Class<T> getJavaClass();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClass <em>Java Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class</em>' attribute.
	 * @see #getJavaClass()
	 * @generated
	 */
	void setJavaClass(Class<T> value);

	/**
	 * Returns the value of the '<em><b>Java Class Status</b></em>' attribute.
	 * The default value is <code>"unresolved"</code>.
	 * The literals are from the enumeration {@link org.soluvas.commons.JavaClassStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Class Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Class Status</em>' attribute.
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see #setJavaClassStatus(JavaClassStatus)
	 * @see org.soluvas.commons.CommonsPackage#getJavaClassLinked_JavaClassStatus()
	 * @model default="unresolved"
	 * @generated
	 */
	JavaClassStatus getJavaClassStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.commons.JavaClassLinked#getJavaClassStatus <em>Java Class Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class Status</em>' attribute.
	 * @see org.soluvas.commons.JavaClassStatus
	 * @see #getJavaClassStatus()
	 * @generated
	 */
	void setJavaClassStatus(JavaClassStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Resolve referenced Java Class.
	 * @param bundle Resolve referenced Java Class using the specified Bundle.
	 * <!-- end-model-doc -->
	 * @model bundleDataType="org.soluvas.commons.Bundle"
	 * @generated
	 */
	void resolveJavaClass(Bundle bundle);

} // JavaClassLinked
