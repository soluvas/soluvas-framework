/**
 */
package org.soluvas.commons.util;

import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.commons.CommonsPackage
 * @generated
 */
public class CommonsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CommonsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommonsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CommonsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommonsSwitch<Adapter> modelSwitch =
		new CommonsSwitch<Adapter>() {
			@Override
			public Adapter caseResourceAware(ResourceAware object) {
				return createResourceAwareAdapter();
			}
			@Override
			public Adapter casePositionable(Positionable object) {
				return createPositionableAdapter();
			}
			@Override
			public Adapter caseAppManifest(AppManifest object) {
				return createAppManifestAdapter();
			}
			@Override
			public Adapter casePersonInfo(PersonInfo object) {
				return createPersonInfoAdapter();
			}
			@Override
			public Adapter caseTimestamped(Timestamped object) {
				return createTimestampedAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseSluggable(Sluggable object) {
				return createSluggableAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseImageable(Imageable object) {
				return createImageableAdapter();
			}
			@Override
			public Adapter casePhotoIdContainer(PhotoIdContainer object) {
				return createPhotoIdContainerAdapter();
			}
			@Override
			public Adapter caseNameContainer(NameContainer object) {
				return createNameContainerAdapter();
			}
			@Override
			public <T extends Identifiable> Adapter caseInformer(Informer<T> object) {
				return createInformerAdapter();
			}
			@Override
			public Adapter caseDescribable(Describable object) {
				return createDescribableAdapter();
			}
			@Override
			public Adapter caseBundleAware(BundleAware object) {
				return createBundleAwareAdapter();
			}
			@Override
			public <T> Adapter caseJavaClassLinked(JavaClassLinked<T> object) {
				return createJavaClassLinkedAdapter();
			}
			@Override
			public Adapter caseEClassLinked(EClassLinked object) {
				return createEClassLinkedAdapter();
			}
			@Override
			public Adapter caseSchemaVersionable(SchemaVersionable object) {
				return createSchemaVersionableAdapter();
			}
			@Override
			public Adapter caseEFactoryLinked(EFactoryLinked object) {
				return createEFactoryLinkedAdapter();
			}
			@Override
			public Adapter caseNsPrefixable(NsPrefixable object) {
				return createNsPrefixableAdapter();
			}
			@Override
			public Adapter caseWebAddress(WebAddress object) {
				return createWebAddressAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseAdded(Added<T> object) {
				return createAddedAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseModelNotification(ModelNotification<T> object) {
				return createModelNotificationAdapter();
			}
			@Override
			public <T extends EObject, V> Adapter caseAttributeSet(AttributeSet<T, V> object) {
				return createAttributeSetAdapter();
			}
			@Override
			public <T extends EObject, V> Adapter caseAttributeUnset(AttributeUnset<T, V> object) {
				return createAttributeUnsetAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseRemoved(Removed<T> object) {
				return createRemovedAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseObjectNotification(ObjectNotification<T> object) {
				return createObjectNotificationAdapter();
			}
			@Override
			public <T extends EObject, V> Adapter caseAttributeNotification(AttributeNotification<T, V> object) {
				return createAttributeNotificationAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseAddedMany(AddedMany<T> object) {
				return createAddedManyAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseRemovedMany(RemovedMany<T> object) {
				return createRemovedManyAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseObjectsNotification(ObjectsNotification<T> object) {
				return createObjectsNotificationAdapter();
			}
			@Override
			public <T extends EObject> Adapter caseEObjectLinked(EObjectLinked<T> object) {
				return createEObjectLinkedAdapter();
			}
			@Override
			public <P> Adapter caseParentable(Parentable<P> object) {
				return createParentableAdapter();
			}
			@Override
			public Adapter caseCategoryLike(CategoryLike object) {
				return createCategoryLikeAdapter();
			}
			@Override
			public Adapter caseCategoryInfo(CategoryInfo object) {
				return createCategoryInfoAdapter();
			}
			@Override
			public Adapter caseProgressMonitor(ProgressMonitor object) {
				return createProgressMonitorAdapter();
			}
			@Override
			public Adapter caseShellProgressMonitor(ShellProgressMonitor object) {
				return createShellProgressMonitorAdapter();
			}
			@Override
			public Adapter caseProgressMonitorWrapper(ProgressMonitorWrapper object) {
				return createProgressMonitorWrapperAdapter();
			}
			@Override
			public Adapter caseColorable(Colorable object) {
				return createColorableAdapter();
			}
			@Override
			public Adapter caseTranslatable(Translatable object) {
				return createTranslatableAdapter();
			}
			@Override
			public Adapter caseTranslation(Translation object) {
				return createTranslationAdapter();
			}
			@Override
			public Adapter caseTranslationMessageEntry(Map.Entry<String, String> object) {
				return createTranslationMessageEntryAdapter();
			}
			@Override
			public Adapter caseTranslationManager(TranslationManager object) {
				return createTranslationManagerAdapter();
			}
			@Override
			public Adapter caseTranslationEntry(Map.Entry<String, Translation> object) {
				return createTranslationEntryAdapter();
			}
			@Override
			public Adapter caseStyleConfiguration(StyleConfiguration object) {
				return createStyleConfigurationAdapter();
			}
			@Override
			public Adapter caseExpandable(Expandable object) {
				return createExpandableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ResourceAware <em>Resource Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ResourceAware
	 * @generated
	 */
	public Adapter createResourceAwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Positionable <em>Positionable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Positionable
	 * @generated
	 */
	public Adapter createPositionableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.AppManifest <em>App Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.AppManifest
	 * @generated
	 */
	public Adapter createAppManifestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.PersonInfo <em>Person Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.PersonInfo
	 * @generated
	 */
	public Adapter createPersonInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Timestamped <em>Timestamped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Timestamped
	 * @generated
	 */
	public Adapter createTimestampedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Sluggable <em>Sluggable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Sluggable
	 * @generated
	 */
	public Adapter createSluggableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Imageable <em>Imageable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Imageable
	 * @generated
	 */
	public Adapter createImageableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.PhotoIdContainer <em>Photo Id Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.PhotoIdContainer
	 * @generated
	 */
	public Adapter createPhotoIdContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.NameContainer <em>Name Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.NameContainer
	 * @generated
	 */
	public Adapter createNameContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Informer <em>Informer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Informer
	 * @generated
	 */
	public Adapter createInformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Describable <em>Describable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Describable
	 * @generated
	 */
	public Adapter createDescribableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.BundleAware <em>Bundle Aware</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.BundleAware
	 * @generated
	 */
	public Adapter createBundleAwareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.JavaClassLinked <em>Java Class Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.JavaClassLinked
	 * @generated
	 */
	public Adapter createJavaClassLinkedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.EClassLinked <em>EClass Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.EClassLinked
	 * @generated
	 */
	public Adapter createEClassLinkedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.SchemaVersionable <em>Schema Versionable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.SchemaVersionable
	 * @generated
	 */
	public Adapter createSchemaVersionableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.EFactoryLinked <em>EFactory Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.EFactoryLinked
	 * @generated
	 */
	public Adapter createEFactoryLinkedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.NsPrefixable <em>Ns Prefixable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.NsPrefixable
	 * @generated
	 */
	public Adapter createNsPrefixableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.WebAddress <em>Web Address</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.WebAddress
	 * @generated
	 */
	public Adapter createWebAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Added <em>Added</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Added
	 * @generated
	 */
	public Adapter createAddedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ModelNotification <em>Model Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ModelNotification
	 * @generated
	 */
	public Adapter createModelNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.AttributeSet <em>Attribute Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.AttributeSet
	 * @generated
	 */
	public Adapter createAttributeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.AttributeUnset <em>Attribute Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.AttributeUnset
	 * @generated
	 */
	public Adapter createAttributeUnsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Removed <em>Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Removed
	 * @generated
	 */
	public Adapter createRemovedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ObjectNotification <em>Object Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ObjectNotification
	 * @generated
	 */
	public Adapter createObjectNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.AttributeNotification <em>Attribute Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.AttributeNotification
	 * @generated
	 */
	public Adapter createAttributeNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.AddedMany <em>Added Many</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.AddedMany
	 * @generated
	 */
	public Adapter createAddedManyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.RemovedMany <em>Removed Many</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.RemovedMany
	 * @generated
	 */
	public Adapter createRemovedManyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ObjectsNotification <em>Objects Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ObjectsNotification
	 * @generated
	 */
	public Adapter createObjectsNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.EObjectLinked <em>EObject Linked</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.EObjectLinked
	 * @generated
	 */
	public Adapter createEObjectLinkedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Parentable <em>Parentable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Parentable
	 * @generated
	 */
	public Adapter createParentableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.CategoryLike <em>Category Like</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.CategoryLike
	 * @generated
	 */
	public Adapter createCategoryLikeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.CategoryInfo <em>Category Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.CategoryInfo
	 * @generated
	 */
	public Adapter createCategoryInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ProgressMonitor <em>Progress Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ProgressMonitor
	 * @generated
	 */
	public Adapter createProgressMonitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ShellProgressMonitor <em>Shell Progress Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ShellProgressMonitor
	 * @generated
	 */
	public Adapter createShellProgressMonitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.ProgressMonitorWrapper <em>Progress Monitor Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.ProgressMonitorWrapper
	 * @generated
	 */
	public Adapter createProgressMonitorWrapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Colorable <em>Colorable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Colorable
	 * @generated
	 */
	public Adapter createColorableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Translatable <em>Translatable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Translatable
	 * @generated
	 */
	public Adapter createTranslatableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Translation <em>Translation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Translation
	 * @generated
	 */
	public Adapter createTranslationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Translation Message Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createTranslationMessageEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.TranslationManager <em>Translation Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.TranslationManager
	 * @generated
	 */
	public Adapter createTranslationManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Translation Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createTranslationEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.StyleConfiguration <em>Style Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.StyleConfiguration
	 * @generated
	 */
	public Adapter createStyleConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Expandable <em>Expandable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Expandable
	 * @generated
	 */
	public Adapter createExpandableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CommonsAdapterFactory
