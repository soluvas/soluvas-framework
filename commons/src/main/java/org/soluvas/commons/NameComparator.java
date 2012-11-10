package org.soluvas.commons;

import java.util.Comparator;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.BeanUtils;

import com.google.common.base.Throwables;

/**
 * Uses {@link BeanUtils} to sort any object based on {@literal name} property.
 * @author ceefour
 */
public class NameComparator<T> implements Comparator<T> {
	
	@Override
	public int compare(@Nullable T o1, @Nullable T o2) {
		if (o1 != null && o2 != null) {
			try {
				String name1 = BeanUtils.getProperty(o1, "name");
				String name2 = BeanUtils.getProperty(o2, "name");
				if (name1 != null && name2 != null) {
					return name1.compareToIgnoreCase(name2);
				} else if (name1 == null) {
					return -1;
				} else {
					return 1;
				}
			} catch (Exception e) {
				Throwables.propagate(e);
				return 0;
			}
		} else return 0;
	};
	
}
