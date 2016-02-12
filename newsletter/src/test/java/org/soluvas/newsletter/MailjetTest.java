package org.soluvas.newsletter;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.newsletter.impl.MailjetManagerImpl;


/**
 * 
 * @author atang
 *
 */

public class MailjetTest {
	private static final Logger log = LoggerFactory.
			getLogger(MailjetTest.class);
	
	private String apiKey;
	private String secretKey;
	private long listId;
	private Properties props;
	private Session session;
	
	private Mailjet mailjet;
	private MailjetManager mailjetManager;
	@Before
	public void setUp() throws Exception {
		apiKey = "42ebca3b9a3805641f28419cdcee5f83";
		secretKey = "c4e2da2975a1d71d59c8dca9dfa33152";
		listId = 224084L;
		
		props = new Properties();
		props.put("mail.smtp.host", "in.mailjet.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		session = Session.getDefaultInstance(props, 
				new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(apiKey, secretKey);
					}
				});
		
		mailjetManager = new MailjetManagerImpl(true, apiKey, secretKey, listId);
		mailjet = new Mailjet(mailjetManager);
	}

	@Test
	public void sendMessage() {
		String from = "atang.sutisna.87@gmail.com";
		String to = "telaga.tech@gmail.com";
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("this is subject");
			message.setText("these are body messages");
			log.info("sending message from {} to {}", from, to);
			Transport.send(message);
			
		} catch (MessagingException ex) {
			throw new RuntimeException(ex);
		} 
	}
	
	
	@Test 
	public void showContactsList() {
		ListContactsResponse contacts = mailjet.showContacts();
		log.debug("Contacts {}", contacts);
		assertNotNull(contacts);
	}
	
	
	@Test
	public void addContact() {
//		AddContactResponse contact = mailjet.addContact(mailjetManager.getContactId(), "anaconda@rockmail.com");
		AddContactResponse contact = mailjet.addContact(listId, "jenggot@naga.com");
		log.debug("Contact Id {}", contact.getContact_id());
		assertNotNull(contact.getContact_id());
	}
	
	@Test
	public void createListContacts() {
		AddListContactsResponse newContact = mailjet.createListContact("berbatik_customers", "Berbatik Customers");
		assertNotNull(newContact);
	}


}
