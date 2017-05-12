package org.soluvas.email;

import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.commons.Email;
import org.soluvas.commons.Email2;
import org.soluvas.commons.Person;
import org.soluvas.commons.entity.Person2;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Get the {@link Person#getEmails()} (and {@link Person#getVirtualMail()} if enabled), 
 * and combines them into List of {@link Recipient}s.
 * No duplicate emails.
 * @author ceefour
 */
public class PersonToRecipients implements
		Function<Person2, Set<Recipient>> {
	
	private final String roleName;
	private final boolean includeVirtualMail;
	
	/**
	 * @param roleName
	 * @param includeVirtualMail TODO
	 */
	public PersonToRecipients(String roleName, boolean includeVirtualMail) {
		super();
		this.roleName = roleName;
		this.includeVirtualMail = includeVirtualMail;
	}

	@Override @Nullable
	public Set<Recipient> apply(@Nullable Person2 person) {
		final Set<Recipient> recipients = Sets.newHashSet();
		if (person != null) {
			if (person.getEmails() != null) {
				for (final Email2 email : person.getEmails()) {
					recipients.add(EmailFactory.eINSTANCE.createRecipient(
							person.getName(), email.getEmail(), roleName));
				}
			}
			if (includeVirtualMail && !Strings.isNullOrEmpty(person.getVirtualMail())) {
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						person.getName(), person.getVirtualMail(), roleName));
			}
		}
		return recipients;
	}

}
