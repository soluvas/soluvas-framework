package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Gender;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.util.HashedPasswordUtils;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Shell command to edit {@link Person}(s) in a {@link PersonRepository}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="mod", description="Modify Person by ID.")
public class PersonModCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonModCommand.class);
	
	@Option(name="-n", aliases="--name", description="Name")
	private transient String nameStr;
	@Option(aliases="-e", description="Email", name="--email")
	private transient String emailStr;
	@Option(name="-g", aliases="--gender", description="Gender: male|female")
	private transient String gender;
	@Option(aliases="-s", description="Slug", name="--slug")
	private transient String slug;
	@Option(name="-p", aliases="--password", description="Password (will be encoded as SSHA).")
	private String password;
	@Argument(index=0, name="id ...", required=true, multiValued=true, description="Person ID(s).")
	private transient String[] ids;
	
	@Override
	protected String[] doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		for (final String id : ids) {
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
			
			if (nameStr != null) {
				final PersonName personName = NameUtils.splitName(nameStr);
				person.setName(nameStr);
				person.setFirstName(personName.getFirstName());
				person.setLastName(personName.getLastName());
			}
			
			if (gender != null) {
				if (StringUtils.startsWithIgnoreCase(gender, "m")) {
					gender = Gender.MALE.name();
				} else if (StringUtils.startsWithIgnoreCase(gender, "f")) {
					gender = Gender.FEMALE.name();
				}
				person.setGender(Gender.valueOf(gender.toUpperCase()));
			}
			
			if (!Strings.isNullOrEmpty(slug)) {
				final Existence<String> existsBySlug = personRepo.existsBySlug(StatusMask.RAW, slug);
				if (!existsBySlug.isPresent()) {
					person.setSlug(slug);
					person.setCanonicalSlug(SlugUtils.canonicalize(slug));
				} else {
					System.err.println(String.format("Slug '%s' already used by person '%s'", 
							existsBySlug.get(), existsBySlug.getId()));
					return null;
				}
			}
			
			if (!Strings.isNullOrEmpty(password)) {
				final String encoded = HashedPasswordUtils.encodeSsha(password);
				System.err.println(ansi().render("Encoded password: @|bold %s|@", encoded));
				person.setPassword(encoded);
			}
	
			personRepo.modify(id, person);
		}
		
		return ids;
	}

}