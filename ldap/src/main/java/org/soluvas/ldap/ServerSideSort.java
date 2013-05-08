package org.soluvas.ldap;

import org.apache.directory.api.ldap.model.message.Control;

/**
 * RFC 2891 - LDAP Control Extension for Server Side Sorting of Search Results
 * http://www.faqs.org/rfcs/rfc2891.html 
 * @author atang
 */
public interface ServerSideSort extends Control
{
	public static final String OID = "1.2.840.113556.1.4.473";
	
	public String getAttributeType();

	public String getMatchingRuleId();

	public boolean isReverseOrder();
    
}