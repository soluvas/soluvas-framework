/**
 */
package com.soluvas.story;

import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;

import com.soluvas.story.schema.AggregationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Aggregations are summary stories on Timeline that are defined by your application to showcase the Open Graph activities of a user in a structured and interesting way. You can customize your application's Aggregations and preview their look and feel with sample data in the App Dashboard.
 * Aggregation Models
 * 
 *     Gallery
 *     Item
 *     List
 *     Map
 *     Number
 *     Table
 * 
 * Privacy Model
 * 
 * Aggregations are displayed on your Timeline, so those users who are allowed access to your Timeline will be able to see your aggregations. Each aggregation contains information based actions you've taken from the associated app. Because a user can decide to hide certain stories or change the privacy for a single story, the information in an aggregation may be different from viewer to viewer.
 * Examples
 * 
 * You may have seen Open Graph aggregations on your Timeline. Here is an example of an Open Graph aggregation for questions you may have followed using Quora:
 * 
 * Reference: https://developers.facebook.com/docs/concepts/opengraph/aggregations/
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.soluvas.story.Aggregation#getAggregationType <em>Aggregation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.soluvas.story.StoryPackage#getAggregation()
 * @model abstract="true"
 * @generated
 */
public interface Aggregation extends NameContainer, NsPrefixable {

	/**
	 * Returns the value of the '<em><b>Aggregation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Type</em>' reference.
	 * @see #setAggregationType(AggregationType)
	 * @see com.soluvas.story.StoryPackage#getAggregation_AggregationType()
	 * @model
	 * @generated
	 */
	AggregationType getAggregationType();

	/**
	 * Sets the value of the '{@link com.soluvas.story.Aggregation#getAggregationType <em>Aggregation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Type</em>' reference.
	 * @see #getAggregationType()
	 * @generated
	 */
	void setAggregationType(AggregationType value);
} // Aggregation
