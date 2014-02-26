package org.soluvas.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

/**
 * Holds valid {@link SocialPerson#getCustomerRole()} values.
 * @author rudi
 */
public class CustomerRoles {
	
	public static final String AGENT = "agen";
	
	public static final String COMMON = "biasa";
	
	public static final String DEPOSIT = "deposit";
	
	public static final String DROP_SHIP = "drops";
	
	public static final String MEMBER = "member";
	
	/**
	 * Agen Spesial / Besar. 
	 */
	public static final String SPECIAL_AGENT = "ag-sp";
	
	public static final List<String> ALL = ImmutableList.copyOf(new String[] { 
			AGENT, COMMON, DEPOSIT, DROP_SHIP, MEMBER, SPECIAL_AGENT});
	
	public static final Map<String, String> DISPLAY_NAMES;
	
	static {
		DISPLAY_NAMES = new HashMap<>();
		DISPLAY_NAMES.put(AGENT, "Agen 30");
		DISPLAY_NAMES.put(COMMON, "Retail");
		DISPLAY_NAMES.put(DEPOSIT, "Agen 20");
		DISPLAY_NAMES.put(DROP_SHIP, "Drop Ship");
		DISPLAY_NAMES.put(MEMBER, "Member");
		DISPLAY_NAMES.put(SPECIAL_AGENT, "Agen Besar"); // Agen Besar
	}
}
