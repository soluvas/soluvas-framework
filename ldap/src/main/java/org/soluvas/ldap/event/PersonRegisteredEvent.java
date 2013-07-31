/**
 * 
 */
package org.soluvas.ldap.event;

import org.soluvas.commons.Person;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.push.TrackableEvent;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class PersonRegisteredEvent extends TrackableEvent {
	
	@Deprecated
	private final SocialPerson socPerson;
	private final Person person;

	/**
	 * @param person
	 */
	@Deprecated
	public PersonRegisteredEvent(SocialPerson socPerson, String trackingId) {
		super(trackingId);
		this.socPerson = socPerson;
		this.person = null;
	}
	
	public PersonRegisteredEvent(Person person, String trackingId) {
		super(trackingId);
		this.socPerson = null;
		this.person = person;
	}

	@Deprecated
	public SocialPerson getSocPerson() {
		return socPerson;
	}

	public Person getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "PersonRegisteredEvent ["
				+ (socPerson != null ? "socPerson=" + socPerson + ", " : "")
				+ (person != null ? "person=" + person : "") + "]";
	}

}
