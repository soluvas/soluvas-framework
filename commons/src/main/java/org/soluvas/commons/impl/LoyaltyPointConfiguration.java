package org.soluvas.commons.impl;

import java.math.BigDecimal;
import java.util.List;

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
	
	List<Long> getRedeemIds();
	
	void setRedeemIds(List<Long> redeemIds);
	
	

}
