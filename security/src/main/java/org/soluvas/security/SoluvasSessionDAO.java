package org.soluvas.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Shiro {@link SessionDAO} implementation using {@link AppSessionRepository}.
 * @author ceefour
 */
public class SoluvasSessionDAO implements SessionDAO {

	private final AppSessionRepository appSessionRepo;

	public SoluvasSessionDAO(@Nonnull final AppSessionRepository appSessionRepo) {
		this.appSessionRepo = appSessionRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#create(org.apache.shiro.session.Session)
	 */
	@Override
	public Serializable create(@Nonnull final Session session) {
		final AppSession appSession = new AppSession.FromSession().apply(session);
		final AppSession added = appSessionRepo.add(appSession);
		return added;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#readSession(java.io.Serializable)
	 */
	@Override
	public Session readSession(@Nonnull final Serializable sessionId)
			throws UnknownSessionException {
		final AppSession appSession = appSessionRepo.findOne((String) sessionId);
		return appSession.toSession();
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#update(org.apache.shiro.session.Session)
	 */
	@Override
	public void update(@Nonnull final Session session) throws UnknownSessionException {
		final AppSession newAppSession = new AppSession.FromSession().apply(session);
		appSessionRepo.modify((String) session.getId(), newAppSession); 
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#delete(org.apache.shiro.session.Session)
	 */
	@Override
	public void delete(Session session) {
		appSessionRepo.delete((String) session.getId());
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#getActiveSessions()
	 */
	@Override
	public Collection<Session> getActiveSessions() {
		final List<AppSession> appSessions = appSessionRepo.findAllByActive();
		final List<Session> sessions = ImmutableList.copyOf(Lists.transform(appSessions,
				new AppSession.ToSession() ));
		return sessions;
	}

}
