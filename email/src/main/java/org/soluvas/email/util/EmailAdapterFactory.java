/**
 */
package org.soluvas.email.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;

import org.soluvas.email.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.email.EmailPackage
 * @generated
 */
public class EmailAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmailPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EmailPackage.eINSTANCE;
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
	protected EmailSwitch<Adapter> modelSwitch =
		new EmailSwitch<Adapter>() {
			@Override
			public Adapter caseEmailCatalog(EmailCatalog object) {
				return createEmailCatalogAdapter();
			}
			@Override
			public <T extends Template> Adapter caseTemplateType(TemplateType<T> object) {
				return createTemplateTypeAdapter();
			}
			@Override
			public Adapter casePageType(PageType object) {
				return createPageTypeAdapter();
			}
			@Override
			public Adapter caseLayoutType(LayoutType object) {
				return createLayoutTypeAdapter();
			}
			@Override
			public Adapter caseTemplate(Template object) {
				return createTemplateAdapter();
			}
			@Override
			public Adapter caseRecipient(Recipient object) {
				return createRecipientAdapter();
			}
			@Override
			public Adapter caseLayout(Layout object) {
				return createLayoutAdapter();
			}
			@Override
			public Adapter casePage(Page object) {
				return createPageAdapter();
			}
			@Override
			public Adapter caseTemplateLike(TemplateLike object) {
				return createTemplateLikeAdapter();
			}
			@Override
			public Adapter caseEmailManager(EmailManager object) {
				return createEmailManagerAdapter();
			}
			@Override
			public Adapter caseSender(Sender object) {
				return createSenderAdapter();
			}
			@Override
			public Adapter caseSenderType(SenderType object) {
				return createSenderTypeAdapter();
			}
			@Override
			public Adapter caseSenderLike(SenderLike object) {
				return createSenderLikeAdapter();
			}
			@Override
			public Adapter caseDefaultScope(DefaultScope object) {
				return createDefaultScopeAdapter();
			}
			@Override
			public Adapter caseNsPrefixable(NsPrefixable object) {
				return createNsPrefixableAdapter();
			}
			@Override
			public Adapter caseResourceAware(ResourceAware object) {
				return createResourceAwareAdapter();
			}
			@Override
			public Adapter caseBundleAware(BundleAware object) {
				return createBundleAwareAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNameContainer(NameContainer object) {
				return createNameContainerAdapter();
			}
			@Override
			public <T> Adapter caseJavaClassLinked(JavaClassLinked<T> object) {
				return createJavaClassLinkedAdapter();
			}
			@Override
			public Adapter caseEFactoryLinked(EFactoryLinked object) {
				return createEFactoryLinkedAdapter();
			}
			@Override
			public Adapter caseEClassLinked(EClassLinked object) {
				return createEClassLinkedAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.EmailCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.EmailCatalog
	 * @generated
	 */
	public Adapter createEmailCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.TemplateType <em>Template Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.TemplateType
	 * @generated
	 */
	public Adapter createTemplateTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.PageType <em>Page Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.PageType
	 * @generated
	 */
	public Adapter createPageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.Template
	 * @generated
	 */
	public Adapter createTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.LayoutType <em>Layout Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.LayoutType
	 * @generated
	 */
	public Adapter createLayoutTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.Recipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.Recipient
	 * @generated
	 */
	public Adapter createRecipientAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.Layout
	 * @generated
	 */
	public Adapter createLayoutAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.Page
	 * @generated
	 */
	public Adapter createPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.TemplateLike <em>Template Like</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.TemplateLike
	 * @generated
	 */
	public Adapter createTemplateLikeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.EmailManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.EmailManager
	 * @generated
	 */
	public Adapter createEmailManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.Sender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.Sender
	 * @generated
	 */
	public Adapter createSenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.SenderType <em>Sender Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.SenderType
	 * @generated
	 */
	public Adapter createSenderTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.SenderLike <em>Sender Like</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.SenderLike
	 * @generated
	 */
	public Adapter createSenderLikeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.email.DefaultScope <em>Default Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.email.DefaultScope
	 * @generated
	 */
	public Adapter createDefaultScopeAdapter() {
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

} //EmailAdapterFactory
