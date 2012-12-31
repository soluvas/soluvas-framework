package org.soluvas.security;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Nonnull;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.SessionDAO;

/**
 * Shiro {@link SessionDAO} implementation using {@link AppSessionRepository}.
 * @author ceefour
 */
public class SoluvasSessionDAO implements SessionDAO {

	private AppSessionRepository appSessionRepo;

	/**
	 * 
	 */
	public SoluvasSessionDAO(@Nonnull final AppSessionRepository appSessionRepo) {
		this.appSessionRepo = appSessionRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#create(org.apache.shiro.session.Session)
	 */
	@Override
	public Serializable create(Session session) {
		final AppSession appSession = new AppSession.FromSession().apply(session);
		final AppSession added = appSessionRepo.add(appSession);
		return added;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#readSession(java.io.Serializable)
	 */
	@Override
	public Session readSession(Serializable sessionId)
			throws UnknownSessionException {
		
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#update(org.apache.shiro.session.Session)
	 */
	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#delete(org.apache.shiro.session.Session)
	 */
	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#getActiveSessions()
	 */
	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

}
