package org.soluvas.commons;

import javax.annotation.Nullable;

import com.google.common.base.Function;

public interface PersonCustomerRoleHistory extends NameContainer, PhotoIdContainer, Identifiable, PersonLike, Informer<PersonInfo>, Timestamped, SchemaVersionable, Describable, Sluggable, CanonicalSluggable, TwitterAccessible, TwitterIdentity, FacebookIdentity, FacebookAccessible, Revisionable {
	
	public static class ToPersonInfo implements Function<PersonCustomerRoleHistory, PersonInfo> {
		@Override @Nullable
		public PersonInfo apply(@Nullable PersonCustomerRoleHistory input) {
			if (input == null)
				return null;
			final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo();
			personInfo.setId(input.getId());
			personInfo.setSlug(input.getSlug());
			personInfo.setName(input.getName());
			personInfo.setPhotoId(input.getPhotoId());
			personInfo.setGender(input.getGender());
			personInfo.setEmail(input.getEmail());
//			personInfo.setMobileNumber(input.getMobileNumber());
			return personInfo;
		}
	}
}
