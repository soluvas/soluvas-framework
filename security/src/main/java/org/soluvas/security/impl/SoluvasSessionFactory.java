package org.soluvas.security.impl;

import java.util.UUID;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.SimpleSessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * @author rio
 *
 */
public class SoluvasSessionFactory extends SimpleSessionFactory {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasSessionFactory.class);
	
	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.SessionFactory#createSession(org.apache.shiro.session.mgt.SessionContext)
	 */
	@Override
	public Session createSession(SessionContext initData) {
		Preconditions.checkArgument(initData instanceof WebSessionContext,
				"initData is %s, expected WebSessionContext", initData.getClass().getName());
		Preconditions.checkNotNull(initData.getHost(),
				"SessionContext.host required");
		final SimpleSession session = (SimpleSession) super.createSession(initData);
		// FIXME: get accessToken from here
		final WebSessionContext webSessionContext = (WebSessionContext) initData;
		final String sessionId = UUID.randomUUID().toString();
		session.setId(sessionId);
		log.debug("Creating Session instance {}", sessionId);
//		final String sessionId = (String) Preconditions.checkNotNull(initData.getSessionId(),
//				"SessionContext.sessionId required, check your SecurityManager.getSessionKey() implementation");
//		final SoluvasSession session = new SoluvasSession(sessionId, host);
		return session;
	}

}
