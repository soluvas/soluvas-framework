package org.soluvas.commons;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableSet;

/**
 * FIXME: <del>Move to xmi file for each tenant.</del>, tapi ke Mongo
 * 
 * Holds valid {@link SocialPerson#getCustomerRole()} values.
 * @author rudi
 */
@Deprecated
public class CustomerRoles {
	
	public static final String AGENT = "agent";
	
	public static final String COMMON = "common";
	
	public static final String DEPOSIT = "deposit";
	
	public static final String DROP_SHIP = "drops";
	
	public static final String MEMBER = "member";
	
	/**
	 * Agen Spesial / Besar. 
	 */
	public static final String SPECIAL_AGENT = "ag-sp";
	
	//GERAIRAZHA
	public static final String AGENT_RAZHA = "agent_razha";
	
	public static final String DISTRIBUTOR_RAZHA = "distributor_razha";
	
	public static final ImmutableSet<String> ALL = ImmutableSet.copyOf(new String[] { 
			AGENT, COMMON, DEPOSIT, DROP_SHIP, MEMBER, SPECIAL_AGENT,
			AGENT_RAZHA, DISTRIBUTOR_RAZHA});
	
	public static final Map<String, String> DISPLAY_NAMES;
	
	static {
		DISPLAY_NAMES = new HashMap<>();
		DISPLAY_NAMES.put(AGENT, "Agen 30");
		DISPLAY_NAMES.put(COMMON, "Retail");
		DISPLAY_NAMES.put(DEPOSIT, "Agen 20");
		DISPLAY_NAMES.put(DROP_SHIP, "Drop Ship");
		DISPLAY_NAMES.put(MEMBER, "Member");
		DISPLAY_NAMES.put(SPECIAL_AGENT, "Agen Besar"); // Agen Besar
		DISPLAY_NAMES.put(AGENT_RAZHA, "Agen RaZha");
		DISPLAY_NAMES.put(DISTRIBUTOR_RAZHA, "Disributor RaZha");
	}
}
