package org.soluvas.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.PostalAddressImpl;

import com.google.code.morphia.Morphia;
import com.google.common.base.Function;
import com.mongodb.DBObject;

/**
 * @author rudi
 *
 */
public class DBObjectToPostalAddress implements Function<DBObject, PostalAddressImpl> {
	
	private static final Logger log = LoggerFactory.getLogger(DBObjectToPostalAddress.class);
	
	private final Morphia morphia;

	public DBObjectToPostalAddress(final Morphia morphia) {
		super();
		this.morphia = morphia;
	}

	@Override
	public PostalAddressImpl apply(DBObject input) {
		if (input == null)
			return null;
		try {
			return morphia.fromDBObject(PostalAddressImpl.class, input);
		} catch (Exception e) {
			log.error("Cannot deserialize MongoDB object to "
					+ PostalAddressImpl.class.getName() + ": " + input, e);
			throw new CommonsException(
					"Cannot deserialize MongoDB object to "
							+ PostalAddressImpl.class.getName() + ": " + input, e);
		}
	}


}
