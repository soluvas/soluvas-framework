package org.soluvas.email;

import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.commons.Person;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Get the {@link SocialPerson#getPrimaryEmail()}, {@link SocialPerson#getEmails()},
 * (and {@link Person#getVirtualMail()} if enabled)
 * and combines them into List of {@link Recipient}s.
 * No duplicate emails.
 * @author ceefour
 */
public class SocialPersonToRecipients implements
		Function<SocialPerson, Set<Recipient>> {
	
	private final String roleName;
	private final boolean includeVirtualMail;
	
	/**
	 * @param roleName
	 * @param includeVirtualMail TODO
	 */
	@Deprecated
	public SocialPersonToRecipients(String roleName, boolean includeVirtualMail) {
		super();
		this.roleName = roleName;
		this.includeVirtualMail = includeVirtualMail;
	}

	@Override @Nullable
	public Set<Recipient> apply(@Nullable SocialPerson socialPerson) {
		final Set<Recipient> recipients = Sets.newHashSet();
		if (socialPerson != null) {
			if (!Strings.isNullOrEmpty(socialPerson.getPrimaryEmail())) {
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						socialPerson.getName(), socialPerson.getPrimaryEmail(), roleName));
			}
			if (socialPerson.getEmails() != null) {
				for (final String email : socialPerson.getEmails()) {
					recipients.add(EmailFactory.eINSTANCE.createRecipient(
							socialPerson.getName(), email, roleName));
				}
			}
			if (includeVirtualMail && !Strings.isNullOrEmpty(socialPerson.getVirtualMail())) {
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						socialPerson.getName(), socialPerson.getVirtualMail(), roleName));
			}
		}
		return recipients;
	}

}
