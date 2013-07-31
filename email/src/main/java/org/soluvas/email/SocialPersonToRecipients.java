package org.soluvas.email;

import java.util.Set;

import javax.annotation.Nullable;

import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Get the {@link SocialPerson#getPrimaryEmail()}, {@link SocialPerson#getEmails()},
 * and {@link SocialPerson#getVirtualMail()}, and combines them into List of {@link Recipient}s.
 * No duplicate emails.
 * @author ceefour
 */
public class SocialPersonToRecipients implements
		Function<SocialPerson, Set<Recipient>> {
	
	private final String roleName;
	
	/**
	 * @param roleName
	 */
	@Deprecated
	public SocialPersonToRecipients(String roleName) {
		super();
		this.roleName = roleName;
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
			if (!Strings.isNullOrEmpty(socialPerson.getVirtualMail())) {
				recipients.add(EmailFactory.eINSTANCE.createRecipient(
						socialPerson.getName(), socialPerson.getVirtualMail(), roleName));
			}
		}
		return recipients;
	}

}
