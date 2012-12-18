/**
 */
package org.soluvas.data;

import javax.measure.quantity.Quantity;
import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.data.DataPackage
 * @generated
 */
public interface DataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataFactory eINSTANCE = org.soluvas.data.impl.DataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value</em>'.
	 * @generated
	 */
	<T> Value<T> createValue();

	/**
	 * Returns a new object of class '<em>Measure Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measure Value</em>'.
	 * @generated
	 */
	<Q extends Quantity> MeasureValue<Q> createMeasureValue();

	/**
	 * Returns a new object of class '<em>Currency Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Currency Value</em>'.
	 * @generated
	 */
	CurrencyValue createCurrencyValue();

	/**
	 * Returns a new object of class '<em>Mixin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mixin</em>'.
	 * @generated
	 */
	Mixin createMixin();

	/**
	 * Returns a new object of class '<em>Range Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Value</em>'.
	 * @generated
	 */
	<T> RangeValue<T> createRangeValue();

	/**
	 * Returns a new object of class '<em>Term Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term Value</em>'.
	 * @generated
	 */
	TermValue createTermValue();

	/**
	 * Returns a new object of class '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Term</em>'.
	 * @generated
	 */
	Term createTerm();

	/**
	 * Returns a new object of class '<em>List Vocab</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Vocab</em>'.
	 * @generated
	 */
	ListVocab createListVocab();

	/**
	 * Returns a new object of class '<em>Tree Vocab</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Vocab</em>'.
	 * @generated
	 */
	TreeVocab createTreeVocab();

	/**
	 * Returns a new object of class '<em>Free Vocab</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Vocab</em>'.
	 * @generated
	 */
	FreeVocab createFreeVocab();

	/**
	 * Returns a new object of class '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Catalog</em>'.
	 * @generated
	 */
	DataCatalog createDataCatalog();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataPackage getDataPackage();

} //DataFactory
