package org.soluvas.json;

import org.eclipse.emf.common.util.BasicEList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author ceefour
 * @see EmfModule
 */
@JsonDeserialize(as=BasicEList.class)
abstract class EListMixin {

}
