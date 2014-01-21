package org.soluvas.data.person.shell; 

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Shell command to edit {@link Person} in a {@link PersonRepository}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="mod", description="Modify Person by ID.")
public class PersonModCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonModCommand.class);
	
	@Option(aliases="-e", description="Email", name="--email")
	private transient String emailStr;
	@Option(aliases="-g", description="Gender", name="--gender")
	private transient Object gender;
	@Option(aliases="-s", description="Slug", name="--slug")
	private transient String slug;

	@Argument(index=0, name="id", required=true, description="Person ID.")
	private transient String id;
	
	private final PersonRepository personRepo;
	
	@Inject
	public PersonModCommand(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

	@SuppressWarnings("null")
	@Override
	protected Object doExecute() throws Exception {
		final Person person = Preconditions.checkNotNull(personRepo.findOne(id), String.format("Person by ID %s must not be null", id));
		if (!Strings.isNullOrEmpty(emailStr)) {
			final Person personByEmail = personRepo.findOneByEmail(StatusMask.RAW, emailStr);
			if (personByEmail != null && !personByEmail.getId().equalsIgnoreCase(id)) {
				 log.warn("Person by email {} is already exists by {}", emailStr, personByEmail.getId());
			} else {
				// remove last primary email AND the new email before adding a new one
				String lastPrimaryEmail = person.getEmail();
				final Iterator<Email> emailIter = person.getEmails().iterator();
				while (emailIter.hasNext()) {
					final Email email = emailIter.next();
					if (lastPrimaryEmail != null && lastPrimaryEmail.equalsIgnoreCase(email.getEmail())) {
						emailIter.remove();
					} else if (emailStr.equalsIgnoreCase(email.getEmail())) {
						// avoid duplicate by pre-removing existing new email address
						// note that Iterator.remove() can only be called once
						emailIter.remove();
					}
				}
				
				final Email email = CommonsFactory.eINSTANCE.createEmail();
				email.setEmail(emailStr);
				email.setPrimary(true);
				email.setValidationTime(new DateTime());
				person.getEmails().add(email);
			}
		}
		
		if (gender != null) {
			person.setGender(Gender.valueOf(String.valueOf(gender).toUpperCase()));
		}
		
		if (!Strings.isNullOrEmpty(slug)) {
			final Existence<String> existsBySlug = personRepo.existsBySlug(StatusMask.RAW, slug);
			if (!existsBySlug.isPresent()) {
				person.setSlug(slug);
				person.setCanonicalSlug(SlugUtils.canonicalize(slug));
			} else {
				System.err.println(String.format("Slug '%s' already used person '%s'", 
						existsBySlug.get(), existsBySlug.getId()));
				return null;
			}
		}
		
		personRepo.modify(id, person);
		
		return null;
	}

}