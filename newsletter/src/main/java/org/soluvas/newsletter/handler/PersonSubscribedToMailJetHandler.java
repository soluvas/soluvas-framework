package org.soluvas.newsletter.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.entity.Person2;
import org.soluvas.mongo.event.PersonSubscribedToMailJetEvent;
import org.soluvas.newsletter.Mailjet;
import org.soluvas.newsletter.MailjetManager;

import com.google.common.base.Preconditions;

/**
 * @author atang
 *
 */
public class PersonSubscribedToMailJetHandler {
	
	private static final Logger log = LoggerFactory
			.getLogger(PersonSubscribedToMailJetHandler.class);
	
	private final MailjetManager mailJetMgr;
	
	/**
	 * @param mailJet
	 * @param mailJetMgr
	 */
	public PersonSubscribedToMailJetHandler(MailjetManager mailJetMgr) {
		super();
		this.mailJetMgr = mailJetMgr;
	}

	public void subcribeToMailJet(PersonSubscribedToMailJetEvent ev) {
		final Person2 person = ev.getPerson();
		log.debug("Attempting to put person id  {} with email ({}) to subscriber contact", person.getId(), person.getEmail());
		try {
			Preconditions.checkState(person.getNewsletterSubscriptionEnabled(), 
					String.format("Person with name/email {}/{} dont want to be subscriber", person.getName(), person.getEmail()));
			final Mailjet mailjet = new Mailjet(mailJetMgr);
			mailjet.addContact(mailJetMgr.getListId(), person.getEmail());
		} catch (IllegalStateException e) {
			log.info("Adding contact {}/{} list is canceled", person.getName(), person.getEmail());
		} catch (Exception e) {
			log.error("Can not subribe {} with email {}", person.getId(), person.getEmail());
		}
	}
}
