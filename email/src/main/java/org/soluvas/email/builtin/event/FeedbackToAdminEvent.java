package org.soluvas.email.builtin.event;

import org.soluvas.email.builtin.Contact;
import org.soluvas.push.TrackableEvent;

/**
 * @author haidar
 *
 */
@SuppressWarnings("serial")
public class FeedbackToAdminEvent extends TrackableEvent {
	
	private Contact contact;

	/**
	 * @param trackingId
	 */
	public FeedbackToAdminEvent(Contact contact, String trackingId) {
		super(trackingId);
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
