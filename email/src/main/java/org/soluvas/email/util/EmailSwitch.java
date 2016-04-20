/**
 */
package org.soluvas.email.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.soluvas.email.EmailPackage
 * @generated
 */
public class EmailSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EmailPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailSwitch() {
		if (modelPackage == null) {
			modelPackage = EmailPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EmailPackage.EMAIL_CATALOG: {
				EmailCatalog emailCatalog = (EmailCatalog)theEObject;
				T1 result = caseEmailCatalog(emailCatalog);
				if (result == null) result = caseNsPrefixable(emailCatalog);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.TEMPLATE_TYPE: {
				TemplateType<?> templateType = (TemplateType<?>)theEObject;
				T1 result = caseTemplateType(templateType);
				if (result == null) result = caseResourceAware(templateType);
				if (result == null) result = caseBundleAware(templateType);
				if (result == null) result = caseNameContainer(templateType);
				if (result == null) result = caseTemplateLike(templateType);
				if (result == null) result = caseNsPrefixable(templateType);
				if (result == null) result = caseJavaClassLinked(templateType);
				if (result == null) result = caseEFactoryLinked(templateType);
				if (result == null) result = caseEClassLinked(templateType);
				if (result == null) result = caseNameable(templateType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.PAGE_TYPE: {
				PageType pageType = (PageType)theEObject;
				T1 result = casePageType(pageType);
				if (result == null) result = caseTemplateType(pageType);
				if (result == null) result = caseResourceAware(pageType);
				if (result == null) result = caseBundleAware(pageType);
				if (result == null) result = caseNameContainer(pageType);
				if (result == null) result = caseTemplateLike(pageType);
				if (result == null) result = caseNsPrefixable(pageType);
				if (result == null) result = caseJavaClassLinked(pageType);
				if (result == null) result = caseEFactoryLinked(pageType);
				if (result == null) result = caseEClassLinked(pageType);
				if (result == null) result = caseNameable(pageType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.LAYOUT_TYPE: {
				LayoutType layoutType = (LayoutType)theEObject;
				T1 result = caseLayoutType(layoutType);
				if (result == null) result = caseTemplateType(layoutType);
				if (result == null) result = caseResourceAware(layoutType);
				if (result == null) result = caseBundleAware(layoutType);
				if (result == null) result = caseNameContainer(layoutType);
				if (result == null) result = caseTemplateLike(layoutType);
				if (result == null) result = caseNsPrefixable(layoutType);
				if (result == null) result = caseJavaClassLinked(layoutType);
				if (result == null) result = caseEFactoryLinked(layoutType);
				if (result == null) result = caseEClassLinked(layoutType);
				if (result == null) result = caseNameable(layoutType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.TEMPLATE: {
				Template template = (Template)theEObject;
				T1 result = caseTemplate(template);
				if (result == null) result = caseTemplateLike(template);
				if (result == null) result = caseDefaultScope(template);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.RECIPIENT: {
				Recipient recipient = (Recipient)theEObject;
				T1 result = caseRecipient(recipient);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.LAYOUT: {
				Layout layout = (Layout)theEObject;
				T1 result = caseLayout(layout);
				if (result == null) result = caseTemplate(layout);
				if (result == null) result = caseTemplateLike(layout);
				if (result == null) result = caseDefaultScope(layout);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.PAGE: {
				Page page = (Page)theEObject;
				T1 result = casePage(page);
				if (result == null) result = caseTemplate(page);
				if (result == null) result = caseTemplateLike(page);
				if (result == null) result = caseDefaultScope(page);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.TEMPLATE_LIKE: {
				TemplateLike templateLike = (TemplateLike)theEObject;
				T1 result = caseTemplateLike(templateLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.EMAIL_MANAGER: {
				EmailManager emailManager = (EmailManager)theEObject;
				T1 result = caseEmailManager(emailManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.SENDER: {
				Sender sender = (Sender)theEObject;
				T1 result = caseSender(sender);
				if (result == null) result = caseSenderLike(sender);
				if (result == null) result = caseDefaultScope(sender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.SENDER_TYPE: {
				SenderType senderType = (SenderType)theEObject;
				T1 result = caseSenderType(senderType);
				if (result == null) result = caseNameContainer(senderType);
				if (result == null) result = caseBundleAware(senderType);
				if (result == null) result = caseNsPrefixable(senderType);
				if (result == null) result = caseSenderLike(senderType);
				if (result == null) result = caseNameable(senderType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.SENDER_LIKE: {
				SenderLike senderLike = (SenderLike)theEObject;
				T1 result = caseSenderLike(senderLike);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EmailPackage.DEFAULT_SCOPE: {
				DefaultScope defaultScope = (DefaultScope)theEObject;
				T1 result = caseDefaultScope(defaultScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Catalog</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEmailCatalog(EmailCatalog object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Template> T1 caseTemplateType(TemplateType<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePageType(PageType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplate(Template object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLayoutType(LayoutType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recipient</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recipient</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRecipient(Recipient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLayout(Layout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePage(Page object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTemplateLike(TemplateLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEmailManager(EmailManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSender(Sender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sender Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sender Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSenderType(SenderType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sender Like</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sender Like</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSenderLike(SenderLike object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDefaultScope(DefaultScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ns Prefixable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ns Prefixable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNsPrefixable(NsPrefixable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceAware(ResourceAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle Aware</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBundleAware(BundleAware object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNameContainer(NameContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Class Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Class Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseJavaClassLinked(JavaClassLinked<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFactory Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFactory Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEFactoryLinked(EFactoryLinked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass Linked</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass Linked</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEClassLinked(EClassLinked object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //EmailSwitch
