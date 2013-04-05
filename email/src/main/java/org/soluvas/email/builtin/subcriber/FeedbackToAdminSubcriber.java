package org.soluvas.email.builtin.subcriber;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.Recipient;
import org.soluvas.email.builtin.Contact;
import org.soluvas.email.builtin.FeedbackToAdminManager;
import org.soluvas.email.builtin.event.FeedbackToAdminEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.eventbus.Subscribe;

import email.EmailManager;

/**
 * @author haidar
 *
 */
@Service @Lazy
public class FeedbackToAdminSubcriber {
	
	private static final Logger log = LoggerFactory
			.getLogger(FeedbackToAdminSubcriber.class);
	
	private final EmailManager emailMgr;

	@Inject
	public FeedbackToAdminSubcriber(EmailManager emailMgr) {
		super();
		this.emailMgr = emailMgr;
	}
	
	@Subscribe
	public void sendEmailFeedbackToAdmin(FeedbackToAdminEvent ev) {
		final Contact contact = ev.getContact();
		log.debug("Sending message as FeedbackToAdmin by {} to {}", contact.getName(), contact.getEmail());
		final Set<Recipient> recipients = new HashSet<>();
		final Recipient recipientFromPrimaryEmail = EmailFactory.eINSTANCE.createRecipient();
		recipientFromPrimaryEmail.setName(contact.getName());
//		recipientFromPrimaryEmail.setEmail(contact.getEmail().toString());
		recipientFromPrimaryEmail.setEmail("coder5@member.dev.tuneeca.com");
		recipients.add(recipientFromPrimaryEmail);
		
		final FeedbackToAdminManager page = emailMgr.createPage(FeedbackToAdminManager.class);
		page.getRecipients().add((email.Recipient) recipients);
		if (!recipients.isEmpty()) {
			emailMgr.sendAll(page);
		}
	}

}
