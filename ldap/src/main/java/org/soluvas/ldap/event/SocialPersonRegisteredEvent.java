package org.soluvas.ldap.event;

import org.soluvas.ldap.SocialPerson;
import org.soluvas.push.TrackableEvent;

/**
 * 
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class SocialPersonRegisteredEvent extends TrackableEvent {
	
	@Deprecated
	private final SocialPerson person;

	@Deprecated
	public SocialPersonRegisteredEvent(SocialPerson person, String trackingId) {
		super(trackingId);
		this.person = person;
	}

	public SocialPerson getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "SocialPersonRegisteredEvent ["
				+ (person != null ? "person=" + person : "") + "]";
	}
	
}
