package org.soluvas.commons.impl;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author rudi
 *
 */
public interface LoyaltyPointConfiguration {
	
	BigDecimal getNetShoppingAmount();
	
	void setNetShoppingAmount(BigDecimal netShoppingAmount);
	
	BigDecimal getNetReturnAmount();
	
	void setNetReturnAmount(BigDecimal netReturnAmount);
	
	boolean isAllowedRedeemFromProductSn();
	
	void setAllowedRedeemFromProductSn(boolean allowedRedeemFromProductSn);
	
	boolean isAllowedReceivePoint();
	
	void setAllowedReceivePoint(boolean allowedReceivePoint);
	
	boolean isAllowedSendPoint();
	
	void setAllowedSendPoint(boolean allowedSendPoint);
	
	BigDecimal getExpiryPointPeriod();
	
	void setExpiryPointPeriod(BigDecimal expiryPointPeriodInDays);
	
	/**
	 * {"UMROH": 3000, "5_DAYS_IN_JAPAN": 2000}
	 * 
	 * @return
	 */
	Map<RewardType, BigDecimal> getRewards();
	
	void setRewards(Map<RewardType, BigDecimal> rewards);
	
	

}
