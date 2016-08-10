package org.soluvas.commons;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.PostalAddressImpl;

import com.google.common.base.Function;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

/**
 * @author rudi
 *
 */
public class DBObjectToPostalAddress implements Function<DBObject, PostalAddressImpl> {
	
	private static final Logger log = LoggerFactory.getLogger(DBObjectToPostalAddress.class);
	
	public DBObjectToPostalAddress() {
		super();
	}

	@Override
	public PostalAddressImpl apply(DBObject input) {
		if (input == null)
			return null;
		try {
			final PostalAddressImpl postalAddressImpl = new PostalAddressImpl();
			postalAddressImpl.setCity(input.get("city") != null ? String.valueOf(input.get("city")) : null);
			postalAddressImpl.setCountry(input.get("country") != null ? String.valueOf(input.get("country")) : null);
			postalAddressImpl.setCountryCode(input.get("countryCode") != null ? String.valueOf(input.get("countryCode")) : null);
			postalAddressImpl.setDescription(input.get("description") != null ? String.valueOf(input.get("description")) : null);
			postalAddressImpl.setDistrict(input.get("district") != null ? String.valueOf(input.get("district")) : null);
			postalAddressImpl.setId(input.get("id") != null ? String.valueOf(input.get("id")) : null);
			postalAddressImpl.setName(input.get("name") != null ? String.valueOf(input.get("name")) : null);
			postalAddressImpl.setOrganization(input.get("organization") != null ? String.valueOf(input.get("organization")) : null);
			postalAddressImpl.setPostalCode(input.get("postalCode") != null ? String.valueOf(input.get("postalCode")) : null);
			postalAddressImpl.setPrimary(input.get("primary") != null ? Boolean.getBoolean(String.valueOf(input.get("primary"))) : null);
			postalAddressImpl.setPrimaryBilling(input.get("primaryBilling") != null ? Boolean.getBoolean(String.valueOf(input.get("primaryBilling"))) : null);
			postalAddressImpl.setPrimaryEmail(input.get("primaryEmail") != null ? String.valueOf(input.get("primaryEmail")) : null);
			postalAddressImpl.setPrimaryHomePhone(input.get("primaryHomePhone") != null ? String.valueOf(input.get("primaryHomePhone")) : null);
			postalAddressImpl.setPrimaryMobile(input.get("primaryMobile") != null ? String.valueOf(input.get("primaryMobile")) : null);
			postalAddressImpl.setPrimaryPhone(input.get("primaryPhone") != null ? String.valueOf(input.get("primaryPhone")) : null);
			postalAddressImpl.setPrimaryShipping(input.get("primaryShipping") != null ? Boolean.valueOf(String.valueOf(input.get("primaryShipping"))) : null);
			postalAddressImpl.setPrimaryWorkPhone(input.get("primaryWorkPhone") != null ? String.valueOf(input.get("primaryWorkPhone")) : null);
			postalAddressImpl.setProvince(input.get("province") != null ? String.valueOf(input.get("province")) : null);
			postalAddressImpl.setStreet(input.get("street") != null ? String.valueOf(input.get("street")) : null);
			postalAddressImpl.setValidationTime(input.get("validationTime") != null ? new DateTime(input.get("validationTime")) : null);
			if (input.get("emails") != null) {
				final BasicDBList objEmails = (BasicDBList) input.get("emails");
				for (final Object object : objEmails) {
					postalAddressImpl.getEmails().add(String.valueOf(object));
				}
			}
			if (input.get("homePhones") != null) {
				final BasicDBList objHomePhones = (BasicDBList) input.get("homePhones");
				for (final Object object : objHomePhones) {
					postalAddressImpl.getHomePhones().add(String.valueOf(object));
				}
			}
			if (input.get("mobiles") != null) {
				final BasicDBList objMobiles = (BasicDBList) input.get("mobiles");
				for (final Object object : objMobiles) {
					postalAddressImpl.getMobiles().add(String.valueOf(object));
				}
			}
			if (input.get("phones") != null) {
				final BasicDBList objPhones = (BasicDBList) input.get("phones");
				for (final Object object : objPhones) {
					postalAddressImpl.getPhones().add(String.valueOf(object));
				}
			}
			if (input.get("workPhones") != null) {
				final BasicDBList objWorkPhones = (BasicDBList) input.get("workPhones");
				for (final Object object : objWorkPhones) {
					postalAddressImpl.getWorkPhones().add(String.valueOf(object));
				}
			}
			return postalAddressImpl;
		} catch (Exception e) {
			log.error("Cannot deserialize MongoDB object to "
					+ PostalAddressImpl.class.getName() + ": " + input, e);
			throw new CommonsException(
					"Cannot deserialize MongoDB object to "
							+ PostalAddressImpl.class.getName() + ": " + input, e);
		}
	}


}
