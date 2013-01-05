package org.soluvas.security.impl;

import java.io.Serializable;

import org.apache.shiro.session.mgt.SimpleSession;

/**
 * @author rio
 *
 */
public class SoluvasSession extends SimpleSession {

	private final String id;

	/**
	 * @param host
	 */
	public SoluvasSession(String id, String host) {
		super(host);
		this.id = id;
	}

	@Override
	public Serializable getId() {
		return super.getId();
	}
	
}
