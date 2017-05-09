package org.soluvas.mongo.event;

import org.soluvas.commons.entity.Person2;
import org.soluvas.push.TrackableEvent;

/**
 * 
 * @author atang
 *
 */
public class PersonSubscribedToMailJetEvent extends TrackableEvent {
	
	private final Person2 person;

	public PersonSubscribedToMailJetEvent(Person2 person, String trackingId) {
		super(trackingId);
		this.person = person;
	}

	public Person2 getPerson() {
		return person;
	}

	@Override
	public String toString() {
		return "PersonRegisteredEvent ["
				+ (person != null ? "person=" + person : "") + "]";
	}
	
}
