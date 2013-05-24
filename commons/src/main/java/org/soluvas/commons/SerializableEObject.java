package org.soluvas.commons;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;

/**
 * Simply as it name says, please also make contructors public in your GenModel.
 * @author ceefour
 * @deprecated Use {@link SerializableEObjectImpl}.
 */
@Deprecated
public interface SerializableEObject extends EObject, Serializable {

}
