package org.soluvas.commons;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

/**
 * Holds valid {@link SocialPerson#getCustomerRole()} values.
 * @author rudi
 */
public class BankNames {
	
	/**
	 * Please sort here :)
	 */
	
	public static final String BCA = "BCA";
	
	public static final String BNI = "BNI";
	
	public static final String BRI = "BRI";
	
	public static final String BTN = "BTN";
	
	public static final String DANAMON = "DANAMON";
	
	public static final String BANK_JABAR = "BANK_JABAR";
	
	public static final String BANK_MANDIRI = "BANK_MANDIRI";
	
	public static final String BANK_PERMATA = "BANK_PERMATA";
	
	public static final List<String> ALL = ImmutableList.copyOf(new String[] { 
			BCA, BNI, BRI, BTN, DANAMON, BANK_JABAR, BANK_MANDIRI, BANK_PERMATA});
	
	public static final Map<String, String> DISPLAY_NAMES;
	
	static {
		DISPLAY_NAMES = new HashMap<>();
		DISPLAY_NAMES.put(BCA, "BCA");
		DISPLAY_NAMES.put(BNI, "BNI");
		DISPLAY_NAMES.put(BRI, "BRI");
		DISPLAY_NAMES.put(BTN, "BTN");
		DISPLAY_NAMES.put(DANAMON, "DANAMON");
		DISPLAY_NAMES.put(BANK_JABAR, "BANK JABAR");
		DISPLAY_NAMES.put(BANK_MANDIRI, "BANK MANDIRI");
		DISPLAY_NAMES.put(BANK_PERMATA,"BANK PERMATA");
	}
}
