package org.soluvas.commons;

import javax.annotation.Nullable;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

/**
 * Guava mapper for copying an object to another object of the same properties.
 *
 * Example usage:
 *
 * <code><pre>
 * List<org.soluvas.facebook.HintPerson> facebookFriends = facebookUtils.findFriends(person.getFacebookAccessToken());
 * List<HintPerson> friends = Lists.transform(facebookFriends, new CopyMapper<HintPerson>(HintPerson.class));
 * </pre></code>
 *
 * @author rudi
 */
public class CopyMapper<T> implements Function<Object, T> {
	
	private static final Logger log = LoggerFactory.getLogger(CopyMapper.class);
	private Class<T> targetClazz;

	public CopyMapper(Class<T> targetClazz) {
		this.targetClazz = targetClazz;
	}

	@Override
	@Nullable
	public T apply(@Nullable Object input) {
		try {
			T target = targetClazz.newInstance();
			PropertyUtils.copyProperties(target, input);
			return target;
		} catch (Exception e) {
			log.error("Cannot copy as " + targetClazz + " from " + input, e);
			throw new RuntimeException("Cannot copy as " + targetClazz + " from " + input, e);
		}
	}

}
