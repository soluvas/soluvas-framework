/**
 */
package org.soluvas.social.builtin;

import javax.annotation.Nullable;

import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.PhotoIdContainer;
import org.soluvas.commons.Sluggable;
import org.soluvas.social.PersonLike;
import org.soluvas.social.Target;
import org.soluvas.social.util.SocialUtils;

import com.google.common.base.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Internal Person profile.
 * <!-- end-model-doc -->
 *
 *
 * @see org.soluvas.social.builtin.BuiltinPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Target, Identifiable, NameContainer, PhotoIdContainer, Sluggable, PersonLike {
	
	public static class FromInfo implements Function<PersonInfo, Person> {
		
		@Override @Nullable
		public Person apply(@Nullable PersonInfo input) {
			final Person person = SocialUtils.createTarget(Person.class);
			person.setTitle(input.getName());
			person.setName(input.getName());
			person.setId(input.getId());
			person.setSlug(input.getSlug());
			person.setPhotoId(input.getPhotoId());
			person.setGender(input.getGender());
			return person;
		}
		
	}
	
} // Person
