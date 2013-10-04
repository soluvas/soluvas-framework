package org.soluvas.ldap.event;

import org.soluvas.ldap.SocialPerson;
import org.soluvas.push.TrackableEvent;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class SocialPersonRegisteredEvent extends TrackableEvent {
	
	private final SocialPerson socPerson;

	/**
	 * @param socPerson
	 */
	public SocialPersonRegisteredEvent(SocialPerson socPerson,
			String trackingId) {
		super(trackingId);
		this.socPerson = socPerson;
	}

	public SocialPerson getPerson() {
		return socPerson;
	}

}
