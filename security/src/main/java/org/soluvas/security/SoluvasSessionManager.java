package org.soluvas.security;

import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionManager;

/**
 * @author ceefour
 */
public class SoluvasSessionManager extends DefaultSessionManager implements
		WebSessionManager {

	/**
	 * 
	 */
	public SoluvasSessionManager() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.web.session.mgt.WebSessionManager#isServletContainerSessions()
	 */
	@Override
	public boolean isServletContainerSessions() {
		return false;
	}

}
