package org.soluvas.ldap;

import org.apache.directory.api.ldap.model.message.controls.AbstractControl;

/**
 * RFC 2891 - LDAP Control Extension for Server Side Sorting of Search Results
 * http://www.faqs.org/rfcs/rfc2891.html 
 * @author atang
 */
public class ServerSideSort extends AbstractControl
{
	public static final String OID = "1.2.840.113556.1.4.473";
	private final String attributeType;
	private final String matchingRuleId = null;
	private final boolean reverseOrder= false;
	
    /**
     * Default constructor.
     */
    public ServerSideSort(String attributeType)
    {
        super( OID );
        this.attributeType = attributeType;
    }

    /**
     * Creates instance and sets criticality at same time.
     * 
     * @param isCritical true if critical, false otherwise
     */
    public ServerSideSort(boolean isCritical, String attributeType)
    {
        super( OID );
        setCritical( isCritical );
        this.attributeType = attributeType;
    }

	public String getAttributeType() {
		return attributeType;
	}

	public String getMatchingRuleId() {
		return matchingRuleId;
	}

	public boolean isReverseOrder() {
		return reverseOrder;
	}
    
}