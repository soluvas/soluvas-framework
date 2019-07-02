package org.soluvas.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.mongo.MongoRealm;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Shiro {@link SessionDAO} implementation using {@link AppSessionRepository}.
 * @author ceefour
 * @deprecated No longer needed, just use {@link MongoRealm} or {@link CouchDbRealm} inside {@link Map},
 * then use {@link DefaultWebSecurityManager}.
 */
@Deprecated
public class SoluvasSessionDAO implements SessionDAO {

	private static final Logger log = LoggerFactory.getLogger(SoluvasSessionDAO.class);
	private final AppSessionRepository appSessionRepo;
	/**
	 * Used to store extra attributes, which is:
	 * Wicket:SessionUnbindingListener-*
	 * or
	 * Wicket:*
	 */
	private final Map<String, Map<String, Object>> extraAttributes = Maps.newConcurrentMap();

	public SoluvasSessionDAO(final AppSessionRepository appSessionRepo) {
		this.appSessionRepo = appSessionRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#create(org.apache.shiro.session.Session)
	 */
	@Override
	public Serializable create(final Session session) {
		throw new UnsupportedOperationException("Oops! AppSession isn't serializable! Need to steal code from EmfModel!");
		// Oops! AppSession isn't serializable! Need to steal code from EmfModel!
//		log.debug("Creating Shiro Session {}", session.getId());
//		final AppSession appSession = new AppSession.FromSession().apply(session);
//		final AppSession added = appSessionRepo.add(appSession);
//		
//		saveExtraAttributes(session);
//		
//		return added;
	}

	/**
	 * @param session
	 */
	protected void saveExtraAttributes(final Session session) {
		// save the extraAttribute first
		final Map<String, Object> extra = Maps.<String, Object>newHashMap();
		for (final Object key : session.getAttributeKeys()) {
			if (key instanceof String) {
				final String stringKey = (String) key;
				if (stringKey.startsWith("Wicket:") || stringKey.startsWith("wicket:")) {
					extra.put((String) key, session.getAttribute(key));
				}
			}
		}
		extraAttributes.put((String) session.getId(), extra);
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#readSession(java.io.Serializable)
	 */
	@Override
	public Session readSession(final Serializable sessionId)
			throws UnknownSessionException {
		log.trace("Reading Shiro Session {}", sessionId);
		appSessionRepo.touch((String) sessionId);
		final AppSession appSession = appSessionRepo.findOneByActive((String) sessionId);
		if (appSession == null)
			throw new UnknownSessionException("Cannot find active session " + sessionId);
		
		// read extra attributes
		final Map<String, Object> extra = extraAttributes.get(sessionId);
		if (extra != null) {
			appSession.getAttributes().putAll(extra);
		}
		
		return appSession.toSession();
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#update(org.apache.shiro.session.Session)
	 */
	@Override
	public void update(final Session session) throws UnknownSessionException {
		log.debug("Updating Shiro Session {}", session.getId());
		final AppSession newAppSession = new AppSession.FromSession().apply(session);
		newAppSession.setAccessTime(new DateTime());
		newAppSession.setModificationTime(new DateTime());
		appSessionRepo.modify((String) session.getId(), newAppSession);
		
		saveExtraAttributes(session);
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#delete(org.apache.shiro.session.Session)
	 */
	@Override
	public void delete(Session session) {
		log.debug("Deleting Shiro Session {} (actually, just marking the AppSession as inactive)", session.getId());
		extraAttributes.remove(session.getId());
		
		final AppSession newAppSession = new AppSession.FromSession().apply(session);
		newAppSession.setStatus(AppSessionStatus.INACTIVE);
		newAppSession.setModificationTime(new DateTime());
		appSessionRepo.modify((String) session.getId(), newAppSession);
//		appSessionRepo.delete((String) session.getId());
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
