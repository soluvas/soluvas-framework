package org.soluvas.email;

import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.commons.Email;
import org.soluvas.commons.Person;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Get the {@link Person#getEmails()} and {@link Person#getVirtualMail()}, 
 * and combines them into List of {@link Recipient}s.
 * No duplicate emails.
 * @author ceefour
 */
public class PersonToRecipients implements
		Function<Person, Set<Recipient>> {
	
	private final String roleName;
	
	/**
	 * @param roleName
	 */
	public PersonToRecipients(String roleName) {
		super();
		this.roleName = roleName;
	}

	@Override @Nullable
	public Set<Recipient> apply(@Nullable Person person) {
		final Set<Recipient> recipients = Sets.newHashSet();
		if (person != null) {
			if (person.getEmails() != null) {
				for (final Email email : person.getEmails()) {
					recipients.add(EmailFactory.eINSTANCE.createRecipient(
							person.getName(), email.getEmail(), roleName));
				}
			}
			if (!Strings.isNullOrEmpty(person.getVirtualMail())) {
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						person.getName(), person.getVirtualMail(), roleName));
			}
		}
		return recipients;
	}

}
