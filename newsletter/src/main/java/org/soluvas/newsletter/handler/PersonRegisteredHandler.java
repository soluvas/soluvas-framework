/**
 * 
 */
package org.soluvas.newsletter.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.ldap.event.PersonRegisteredEvent;
import org.soluvas.newsletter.Mailjet;
import org.soluvas.newsletter.MailjetManager;

import com.google.common.eventbus.Subscribe;

/**
 * @author atang
 *
 */
public class PersonRegisteredHandler {
	
	private static final Logger log = LoggerFactory
			.getLogger(PersonRegisteredHandler.class);
	
	private final MailjetManager mailJetMgr;
	
	/**
	 * @param mailJet
	 * @param mailJetMgr
	 */
	public PersonRegisteredHandler(MailjetManager mailJetMgr) {
		super();
		this.mailJetMgr = mailJetMgr;
	}

	@Subscribe
	public void registerMailJet(PersonRegisteredEvent ev) {
		final SocialPerson insertedPerson = ev.getPerson();
		try {
			log.info("Trying to register mail jet for {} [{}]",
					insertedPerson.getId(), insertedPerson.getPrimaryEmail());
			final Mailjet mailjet = new Mailjet(mailJetMgr);
			mailjet.addContact(mailJetMgr.getListId(), insertedPerson.getPrimaryEmail());
		} catch (Exception e) {
			log.error("Can not register mailJet for " + insertedPerson.getId(), e);
		}
	}
}
