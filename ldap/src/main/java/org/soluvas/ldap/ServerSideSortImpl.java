package org.soluvas.ldap;

import org.apache.directory.api.ldap.model.message.controls.AbstractControl;

/**
 * RFC 2891 - LDAP Control Extension for Server Side Sorting of Search Results
 * http://www.faqs.org/rfcs/rfc2891.html 
 * @author atang
 */
public class ServerSideSortImpl extends AbstractControl
	implements ServerSideSort
{
	private final String attributeType;
	private final String matchingRuleId = null;
	private final boolean reverseOrder= false;
	
	public ServerSideSortImpl()
    {
		super( OID );
        this.attributeType = null;
    }
	
    /**
     * Default constructor.
     */
    public ServerSideSortImpl(String attributeType)
    {
        super( OID );
        this.attributeType = attributeType;
    }

    /**
     * Creates instance and sets criticality at same time.
     * 
     * @param isCritical true if critical, false otherwise
     */
    public ServerSideSortImpl(boolean isCritical, String attributeType)
    {
        super( OID );
        setCritical( isCritical );
        this.attributeType = attributeType;
    }

	@Override
	public String getAttributeType() {
		return attributeType;
	}

	@Override
	public String getMatchingRuleId() {
		return matchingRuleId;
	}

	@Override
	public boolean isReverseOrder() {
		return reverseOrder;
	}
    
}