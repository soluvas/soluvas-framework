package org.soluvas.commons;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.base.Strings;

/**
 * The provided object must implement both {@link NsPrefixable} and {@link Nameable}.
 * @author rudi
 */
public class QNameFunction implements Function<EObject, String> {

	@Override @Nullable
	public String apply(@Nullable EObject input) {
		if (input == null) {
			return null;
		} else {
			return Strings.nullToEmpty(((NsPrefixable) input).getNsPrefix()) + "_" + Strings.nullToEmpty(((Nameable) input).getName());
		}
	}

}
