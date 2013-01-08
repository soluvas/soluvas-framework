package org.soluvas.security;

import java.util.Collection;

import org.apache.shiro.realm.Realm;
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
		log.trace("BEFORE subjectContext.sessionId = {}", subjectContext.getSessionId());
		final Subject subject = super.createSubject(subjectContext);
		log.trace("AFTER subjectContext.sessionId = {}; subject.session.id = {}", subjectContext.getSessionId(),
				subject.getSession().getId());
		return subject;
	}

	@Override
	protected SubjectContext resolveSession(SubjectContext context) {
		return super.resolveSession(context);
	}

}
