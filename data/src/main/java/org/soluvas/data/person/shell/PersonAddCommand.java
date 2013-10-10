package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.util.HashedPasswordUtils;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;

/**
 * Add {@link Person} entity.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="add", description="Add a new Person entity.")
public class PersonAddCommand extends ExtCommandSupport {

	@Option(name="-e", aliases="--email", description="Email.")
	private String emailStr;
	@Option(name="-p", aliases="--password", description="Password (will be encoded as SSHA).")
	private String password;
	@Option(name="-f", aliases="--fbAccessToken", description="Facebook Access Token.")
	private String fbAccessToken;
	@Option(name="-s", aliases="--status", description="Account status: DRAFT|ACTIVE|VALIDATED|VERIFIED|INACTIVE|VOID.")
	private transient AccountStatus accountStatus = AccountStatus.ACTIVE;
	
	@Argument(index=0, name="id", required=true,
		description="Person ID to be created.")
	private String id;
	@Argument(index=1, name="name", required=true,
		description="Full name of Person to be created.")
	private String name;
	
	private final PersonRepository personRepo;

	@Inject
	public PersonAddCommand(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		final Person person = CommonsFactory.eINSTANCE.createPerson();
		person.setId(id);
		person.setGuid((Person.class.getSimpleName() + "_" + id).toLowerCase());
		person.setAccountStatus(accountStatus);
		person.setName(name);
		person.setSlug(SlugUtils.generateValidScreenName(name, new Predicate<String>() {
			@Override
			public boolean apply(@Nullable String input) {
				return !personRepo.existsBySlug(StatusMask.RAW, input).isPresent();
			}
		}));
		final Matcher nameMatcher = Pattern.compile("(.+) (.+)").matcher(name);
		if (nameMatcher.matches()) {
			person.setFirstName(nameMatcher.group(1));
			person.setLastName(nameMatcher.group(2));
		} else {
			person.setFirstName(name);
			person.setLastName(name);
		}
		
		if (!Strings.isNullOrEmpty(emailStr)) {
			final Person personByEmail = personRepo.findOneByEmail(StatusMask.RAW, emailStr);
			if (personByEmail != null) {
				log.info("Email {} already exists for person {}", emailStr, personByEmail.getId());
				System.err.println(ansi().render("@|red Email|@ @|bold %s|@ @|red already exists for person|@ @|bold %s|@",
						emailStr, personByEmail.getId()));
				return null;
			} else {
				final Email email = CommonsFactory.eINSTANCE.createEmail();
				email.setEmail(emailStr);
				email.setPrimary(true);
				email.setValidationTime(new DateTime());
				person.getEmails().add(email);
			}
		}
		
		if (!Strings.isNullOrEmpty(password)) {
			final String encoded = HashedPasswordUtils.encodeSsha(password);
			System.err.println(ansi().render("Encoded password: @|bold %s|@", encoded));
			person.setPassword(encoded);
		}
		
		if (fbAccessToken != null)
			person.setFacebookAccessToken(fbAccessToken);

		personRepo.add(person);
		return person;
	}

}