/**
 */
package org.soluvas.email;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.EClassLinked;
import org.soluvas.commons.EFactoryLinked;
import org.soluvas.commons.JavaClassLinked;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.soluvas.email.EmailPackage#getTemplateType()
 * @model abstract="true"
 * @generated
 */
public interface TemplateType<T extends Template> extends ResourceAware, BundleAware, NameContainer, TemplateLike, NsPrefixable, JavaClassLinked<T>, EFactoryLinked, EClassLinked {
} // EmailTemplate
