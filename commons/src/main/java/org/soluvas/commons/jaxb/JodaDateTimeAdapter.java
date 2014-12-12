package org.soluvas.commons.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

/**
 * https://github.com/intouchfollowup/joda-time-jaxb/blob/master/src/main/java/org/joda/xmlAdapter/JodaDateTimeAdapter.java
 * 
 * @author ceefour
 *
 */
public class JodaDateTimeAdapter extends XmlAdapter<String, DateTime> {
	@Override
	public DateTime unmarshal(String v) throws Exception {
		return new DateTime(v);
	}

	@Override
	public String marshal(DateTime v) throws Exception {
		return v.toString();
	}
}