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
	
	private final SocialPerson socPerson;

	/**
	 * @param socPerson
	 */
	public PersonRegisteredEvent(SocialPerson socPerson,
			String trackingId) {
		super(trackingId);
		this.socPerson = socPerson;
	}

	public SocialPerson getSocPerson() {
		return socPerson;
	}

}
