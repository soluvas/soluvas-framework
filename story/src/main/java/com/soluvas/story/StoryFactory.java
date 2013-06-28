/**
 */
package com.soluvas.story;

import java.util.Collection;

import org.eclipse.emf.ecore.EFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.social.Target;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.soluvas.story.StoryPackage
 * @generated
 */
public interface StoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoryFactory eINSTANCE = com.soluvas.story.impl.StoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Story</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Story</em>'.
	 * @generated
	 */
	Story createStory();

	/**
	 * Returns a new object of class '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manager</em>'.
	 * @generated
	 */
	StoryManager createStoryManager();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StoryPackage getStoryPackage();

	Story createActiveStory(Identifiable owner, Target subject, Action action,
			Target receiver);

	<R extends Target> Story createActiveStory(Identifiable owner, Target subject, Action action,
			Collection<R> receivers);
	
	Story createActiveStory(Identifiable owner, Target subject, Action action,
			Target receiver, Target attachment);

	<A extends Target> Story createActiveStory(Identifiable owner, Target subject, Action action,
			Target receiver, Collection<A> attachments);

	<R extends Target, A extends Target> Story createActiveStory(Identifiable owner, Target subject, Action action,
			Collection<R> receivers, Collection<A> attachments);

} //StoryFactory
