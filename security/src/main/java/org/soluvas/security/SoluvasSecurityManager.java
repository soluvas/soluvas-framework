package org.soluvas.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.apache.shiro.web.subject.WebSubjectContext;
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
	public Session start(SessionContext context) throws AuthorizationException {
		final Session session = super.start(context);
		log.debug("Started session {}", session.getId());
		if (context instanceof WebSessionContext) {
			HttpServletResponse resp = (HttpServletResponse) ((WebSessionContext) context).getServletResponse();
			final Cookie cookie = new Cookie("accessToken", (String) session.getId());
			// TODO: support non-root cookies via webAddress.basePath
			cookie.setPath("/");
			log.debug("Setting cookie {}", cookie);
			resp.addCookie(cookie);
		}
		return session;
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
			if (context instanceof WebSubjectContext) {
				final HttpServletRequest req = (HttpServletRequest) ((WebSubjectContext) context).getServletRequest();
				for (final Cookie cookie : req.getCookies()) {
					if ("accessToken".equals(cookie.getName())) {
						final String sessionId = cookie.getValue();
						log.debug("Found accessToken cookie {}", sessionId);
						context.setSessionId(sessionId);
						break;
					}
				}
			}
			
			// if fail then generate a new session ID
//			final String sessionId = UUID.randomUUID().toString();
//			log.debug("generating new session {}", sessionId);
			// AND save it to the SubjectContext
//			context.setSessionId(sessionId);
		}
		final SessionKey sessionKey = super.getSessionKey(context);
		log.trace("SessionKey={} ID={}", sessionKey, context.getSessionId());
		return sessionKey;
	}

	@Override
	public void logout(Subject subject) {
		final Session session = subject.getSession(false);
		log.trace("BEFORE logout: subject.session={}, subject.sessionId = {}", 
				session, session != null ? session.getId() : null);
		super.logout(subject);
		final Session sessionAfter = subject.getSession(false);
		log.trace("AFTER logout: subject.session={}, subject.sessionId = {}", 
				sessionAfter, sessionAfter != null ? sessionAfter.getId() : null);
	}
	
}
