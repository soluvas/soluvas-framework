package org.soluvas.commons.impl;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rudi
 *
 */
public interface PointConfiguration {
	
	BigDecimal getNetShoppingAmount();
	
	void setNetShoppingAmount(BigDecimal netShoppingAmount);
	
	BigDecimal getNetReturnAmount();
	
	void setNetReturnAmount(BigDecimal netReturnAmount);
	
	boolean isGetPointFromTokenOnly();

	void setGetPointFromTokenOnly(boolean getPointFromTokenOnly);
	
	boolean isAllowedReceivePoint();
	
	void setAllowedReceivePoint(boolean allowedReceivePoint);
	
	boolean isAllowedSendPoint();
	
	void setAllowedSendPoint(boolean allowedSendPoint);
	
	BigDecimal getExpiryPointPeriod();
	
	void setExpiryPointPeriod(BigDecimal expiryPointPeriodInDays);
	
	List<Long> getRewardIds();
	
	void setRewardIds(List<Long> rewardIds);
	
	BigDecimal getMinimumBalanceAfterSendPoints();
	
	void setMinimumBalanceAfterSendPoints(BigDecimal minimumBalanceAfterSendPoints);

}
