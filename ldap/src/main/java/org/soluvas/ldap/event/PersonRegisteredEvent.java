package org.soluvas.ldap.event;

import org.soluvas.ldap.SocialPerson;
import org.soluvas.push.TrackableEvent;

/**
 * 
 * @author atang
 *
 */
@SuppressWarnings("serial")
@Deprecated
public class PersonRegisteredEvent extends TrackableEvent {
	
	@Deprecated
	private final SocialPerson socPerson;

	/**
	 * @param person
	 */
	@Deprecated
	public PersonRegisteredEvent(SocialPerson socPerson, String trackingId) {
		super(trackingId);
		this.socPerson = socPerson;
	}

	@Deprecated
	public SocialPerson getSocPerson() {
		return socPerson;
	}

	@Override
	public String toString() {
		return "PersonRegisteredEvent ["
				+ (socPerson != null ? "socPerson=" + socPerson : "") + "]";
	}
	
}
