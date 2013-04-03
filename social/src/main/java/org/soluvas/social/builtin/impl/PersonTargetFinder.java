package org.soluvas.social.builtin.impl;

import javax.annotation.Nullable;

import org.soluvas.commons.Gender;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.social.TargetFinder;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.schema.SocialSchemaCatalog;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/**
 * @author rully
 */
public class PersonTargetFinder implements TargetFinder<Person> {
	
	public static class ToTarget implements Function<SocialPerson, Person> {
		
		private final SocialSchemaCatalog socialSchemaCatalog;
		
		public ToTarget(SocialSchemaCatalog socialSchemaCatalog) {
			super();
			this.socialSchemaCatalog = socialSchemaCatalog;
		}

		@Override @Nullable
		public Person apply(@Nullable SocialPerson input) {
			final Person person = socialSchemaCatalog.createTarget(Person.class);
			person.setId(input.getId());
			person.setSlug(input.getSlug());
			person.setName(input.getName());
			person.setTitle(input.getName());
			person.setFirstName(input.getFirstName());
			person.setLastName(input.getLastName());
			person.setGender(input.getGender() != null ? Gender.get(input.getGender().name().toLowerCase()) : null);
			person.setUsername(input.getSlug());
			person.setPhotoId(input.getPhotoId());
			return person;
		}
	}

	private final EntityLookup<SocialPerson, String> lookup;
	private final SocialSchemaCatalog socialSchemaCatalog;

	/**
	 * @param lookup
	 */
	public PersonTargetFinder(SocialSchemaCatalog socialSchemaCatalog,
			EntityLookup<SocialPerson, String> lookup) {
		super();
		this.lookup = lookup;
		this.socialSchemaCatalog = socialSchemaCatalog;
	}

	@Override
	public Person findOne(String id) {
		final SocialPerson socialPerson = Preconditions.checkNotNull(lookup.findOne(id),
				"Cannot find person %s in %s", id, lookup);
		return new ToTarget(socialSchemaCatalog).apply(socialPerson);
	}

}
