package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.joda.time.DateTime;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Email;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Person;
import org.soluvas.commons.PhoneNumber;
import org.soluvas.commons.PostalAddress;
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
	@Option(name="-s", aliases="--status", description="Account status: DRAFT|ACTIVE|VALIDATED|VERIFIED|INACTIVE|VOID.")
	private transient AccountStatus accountStatus = AccountStatus.ACTIVE;
	@Option(name="-g", aliases="--gender", description="Gender: m(ale)|f(emale)")
	private transient String gender;
	@Option(name="-f", aliases="--fbAccessToken", description="Facebook Access Token.")
	private String fbAccessToken;
	@Option(name="--mobile", description="Mobile number.")
	private String mobileNumber;
	@Option(name="--street", description="Street address.")
	private String streetAddress;
	@Option(name="--city", description="City.")
	private String city;
	@Option(name="--postalcode", description="Postal code.")
	private String postalCode;
	@Option(name="--province", description="Province, e.g. 'Jawa Timur'.")
	private String province;
	@Option(name="--cc", description="Country code, e.g. 'ID'. Note: Please also set --countryname.")
	private String countryCode;
	@Option(name="--countryname", description="Country name, e.g. 'Indonesia'")
	private String countryName;
	
	@Argument(index=0, name="id", required=true,
		description="Person ID to be created.")
	private String id;
	@Argument(index=1, name="name", required=true,
		description="Full name of Person to be created.")
	private String name;
	
	@Override
	protected Person doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		
		final Person person = CommonsFactory.eINSTANCE.createPerson();
		person.setId(id);
		person.setGuid(Person.class.getSimpleName() + "_" + id);
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
		
		if (gender != null) {
			if (StringUtils.startsWithIgnoreCase(gender, "m")) {
				gender = Gender.MALE.name();
			} else if (StringUtils.startsWithIgnoreCase(gender, "f")) {
				gender = Gender.FEMALE.name();
			}
			person.setGender(Gender.valueOf(gender.toUpperCase()));
		}

		if (fbAccessToken != null)
			person.setFacebookAccessToken(fbAccessToken);

		if (!Strings.isNullOrEmpty(mobileNumber)) {
			PhoneNumber theMobile = CommonsFactory.eINSTANCE.createPhoneNumber();
			theMobile.setPhoneNumber(mobileNumber);
			theMobile.setPrimary(true);
			person.getMobileNumbers().add(theMobile);
		}
		
		PostalAddress address = CommonsFactory.eINSTANCE.createPostalAddress();
		address.setId(UUID.randomUUID().toString());
		address.setName(person.getName());
		address.setPrimary(true);
		address.setPrimaryBilling(true);
		address.setPrimaryShipping(true);
		if (!Strings.isNullOrEmpty(streetAddress)) {
			address.setStreet(streetAddress);
		}
		if (!Strings.isNullOrEmpty(city)) {
			address.setCity(city);
		}
		if (!Strings.isNullOrEmpty(province)) {
			address.setProvince(province);
		}
		if (!Strings.isNullOrEmpty(postalCode)) {
			address.setPostalCode(postalCode);
		}
		if (!Strings.isNullOrEmpty(countryCode)) {
			address.setCountryCode(countryCode);
		}
		if (!Strings.isNullOrEmpty(countryName)) {
			address.setCountry(countryName);
		}
		person.getAddresses().add(address);

		final Person added = personRepo.add(person);
		return added;
	}

}