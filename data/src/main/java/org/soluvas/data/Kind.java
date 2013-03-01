/**
 */
package org.soluvas.data;

import org.soluvas.commons.BundleAware;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.ResourceAware;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Kind</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1. Kind (Attribute Type / Vocab) is like an EMF DataType or Enum.
 * A Kind is always type-agnostic, but a default input method & unit can be hinted by the attribute (see below).
 * A Kind is always cardinality agnostic.
 * For example, Length kind is hinted as "measure" with "cm" unit, however all the attribute values below are valid:
 * 1. 9 cm (just like the hint)
 * 2. 10 km (different unit)
 * 3. 9-12 cm (use unit like the hint, but RangeValue instead)
 * 4. 5-6 kg (different unit and use RangeValue)
 * 5. "cukup panjang untuk orang dewasa" (StringValue)
 * 6. base_very_long (TermValue from base nsPrefix)
 * 7. tuneeca_half_a_mile (TermValue from tuneeca nsPrefix)
 * In addition, all of the above can have multiple cardinality or no value.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.data.DataPackage#getKind()
 * @model
 * @generated
 */
public interface Kind extends NsPrefixable, BundleAware, NameContainer, ResourceAware {
} // Kind
