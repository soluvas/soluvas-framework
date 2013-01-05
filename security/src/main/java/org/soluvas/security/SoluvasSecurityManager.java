package org.soluvas.security;

import java.util.Collection;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author rio
 *
 */
public class SoluvasSecurityManager extends DefaultWebSecurityManager {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasSecurityManager.class);
	
	public SoluvasSecurityManager() {
		super();
	}

	public SoluvasSecurityManager(Collection<Realm> realms) {
		super(realms);
	}

	public SoluvasSecurityManager(Realm singleRealm) {
		super(singleRealm);
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
		SubjectContext newContext = super.resolveSession(context);
		log.trace("AFTER resolveSession: context.session = {}, sessionId={}",
				newContext.getSession(), newContext.getSessionId());
		return newContext;
	}
	
	@Override
	protected SessionKey getSessionKey(SubjectContext context) {
		SessionKey sessionKey = super.getSessionKey(context);
		log.trace("SessionKey={}", sessionKey);
		return sessionKey;
	}

}
