package org.soluvas.commons;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Function;

/**
 * You can also use {@link EcoreUtil#copyAll(java.util.Collection)} instead.
 * @author adri
 */
public class EcoreCopyFunction<T extends EObject> implements Function<T, T> {

	@Override @Nullable
	public T apply(@Nullable T input) {
		return input != null ? EcoreUtil.copy(input) : null;
	}

}
