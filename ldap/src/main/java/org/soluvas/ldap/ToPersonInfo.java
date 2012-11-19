package org.soluvas.ldap;

import javax.annotation.Nullable;

import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.PersonInfo;

import com.google.common.base.Function;

/**
 * @author ceefour
 *
 */
public class ToPersonInfo implements Function<SocialPerson, PersonInfo> {

	@Override
	@Nullable
	public PersonInfo apply(@Nullable final SocialPerson input) {
		final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
		personInfo.setId(input.getId());
		personInfo.setSlug(input.getSlug());
		personInfo.setName(input.getName());
		personInfo.setPhotoId(input.getPhotoId());
		return personInfo;
	}

}
