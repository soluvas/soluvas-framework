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
	
    public static final String BCA_SYARIAH = "BCA SYARIAH";

    public static final String BNI_SYARIAH = "BNI SYARIAH";

    public static final String BRI_SYARIAH = "BRI SYARIAH";

    public static final String MEGA = "MEGA";

    public static final String BJB = "BJB";

    public static final String BTPN = "BTPN";

    public static final String BANK_BUKOPIN = "BANK BUKOPIN";

    public static final String BANK_CIMB_NIAGA = "BANK CIMB NIAGA";

    public static final String BANK_OCBC_NISP = "BANK OCBC NISP";

    public static final String BANK_MUAMALAT = "BANK MUAMALAT";

    public static final String BANK_PANIN = "BANK PANIN";
	
	public static final List<String> ALL = ImmutableList.copyOf(new String[] { 
			BCA, BNI, BRI, BTN, DANAMON, BANK_JABAR, BANK_MANDIRI, BANK_PERMATA, BCA_SYARIAH, BNI_SYARIAH, BRI_SYARIAH, MEGA, BJB, BTPN,
			BANK_BUKOPIN, BANK_CIMB_NIAGA, BANK_OCBC_NISP, BANK_MUAMALAT, BANK_PANIN});
	
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
		
		DISPLAY_NAMES.put(BCA_SYARIAH,"BCA SYARIAH");
		DISPLAY_NAMES.put(BNI_SYARIAH,"BNI SYARIAH ");
		DISPLAY_NAMES.put(BRI_SYARIAH,"BRI SYARIAH");
		DISPLAY_NAMES.put(MEGA,"MEGA");
		DISPLAY_NAMES.put(BJB,"BJB");
		DISPLAY_NAMES.put(BTPN,"BTPN");
		DISPLAY_NAMES.put(BANK_BUKOPIN,"BANK BUKOPIN");
		DISPLAY_NAMES.put(BANK_CIMB_NIAGA,"BANK CIMB NIAGA");
		DISPLAY_NAMES.put(BANK_OCBC_NISP,"BANK OCBC NISP");
		DISPLAY_NAMES.put(BANK_MUAMALAT,"BANK MUAMALAT");
		DISPLAY_NAMES.put(BANK_PANIN,"BANK PANIN");
	}
	
}
