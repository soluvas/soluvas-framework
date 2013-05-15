package org.soluvas.ldap;

import javax.annotation.Nullable;

import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.PersonInfo;

import com.google.common.base.Function;

/**
 * Converts {@link SocialPerson} to {@link PersonInfo}.
 * @author ceefour
 */
public class ToPersonInfo implements Function<SocialPerson, PersonInfo> {

	@Override @Nullable
	public PersonInfo apply(@Nullable final SocialPerson input) {
		if (input == null)
			return null;
		final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
		personInfo.setId(input.getId());
		personInfo.setSlug(input.getSlug());
		personInfo.setName(input.getName());
		personInfo.setPhotoId(input.getPhotoId());
		personInfo.setGender(input.getGender());
		if (input.getPrimaryEmail() != null) {
			personInfo.setEmail(input.getPrimaryEmail());
		} else if (input.getEmails() != null && !input.getEmails().isEmpty()) {
			personInfo.setEmail(input.getEmails().iterator().next());
		}
		return personInfo;
	}

}
