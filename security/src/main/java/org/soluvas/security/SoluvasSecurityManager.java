package org.soluvas.security;

import java.util.UUID;

import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.impl.SoluvasSessionFactory;

/**
 * @author rio
 *
 */
public class SoluvasSecurityManager extends DefaultWebSecurityManager {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasSecurityManager.class);
	
	public SoluvasSecurityManager(SessionDAO sessionDao) {
		super();
		final DefaultSessionManager sessionManager = new DefaultSessionManager();
		sessionManager.setSessionFactory(new SoluvasSessionFactory());
		sessionManager.setSessionDAO(sessionDao);
		setSessionManager(sessionManager);
	}

	@Override
	public Subject createSubject(SubjectContext subjectContext) {
		log.trace("BEFORE createSubject: subjectContext.session={}, subjectContext.sessionId = {}", 
				subjectContext.getSession(), subjectContext.getSessionId());
		final Subject subject = super.createSubject(subjectContext);
		log.trace("AFTER createSubject: subjectContext.session={}, subjectContext.sessionId={}, subject.session.id = {}",
				subjectContext.getSession(), subjectContext.getSessionId(),
				subject.getSession().getId());
		return subject;
	}
	
	@Override
	protected SubjectContext resolveSession(SubjectContext context) {
		log.trace("BEFORE resolveSession: context.session = {}, sessionId={}",
				context.getSession(), context.getSessionId());
		final SubjectContext newContext = super.resolveSession(context);
		log.trace("AFTER resolveSession: context.session = {}, sessionId={}",
				newContext.getSession(), newContext.getSessionId());
		return newContext;
	}
	
	@Override
	protected SessionKey getSessionKey(SubjectContext context) {
		if (context.getSessionId() == null) {
			// FIXME: first lookup from HttpServletRequest's cookie
			
			// if fail then generate a new session ID
			final String sessionId = UUID.randomUUID().toString();
			log.debug("generating new session {}", sessionId);
			context.setSessionId(sessionId);
		}
		final SessionKey sessionKey = super.getSessionKey(context);
		log.trace("SessionKey={}", sessionKey);
		return sessionKey;
	}

}
