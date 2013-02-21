/**
 * 
 */
package org.soluvas.ldap.event;

import org.soluvas.ldap.SocialPerson;
import org.soluvas.push.TrackableEvent;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class PersonRegisteredEvent extends TrackableEvent {
	
	private final SocialPerson person;

	/**
	 * @param person
	 */
	public PersonRegisteredEvent(SocialPerson person,
			String trackingId) {
		super(trackingId);
		this.person = person;
	}

	public SocialPerson getPerson() {
		return person;
	}

}
