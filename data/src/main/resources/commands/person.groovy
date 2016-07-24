import com.google.common.base.Joiner
import com.google.common.base.Predicate
import com.google.common.base.Strings
import com.google.common.collect.ImmutableSet
import org.apache.commons.lang3.StringUtils
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.joda.time.DateTime
import org.mindrot.jbcrypt.BCrypt
import org.slf4j.LoggerFactory
import org.soluvas.commons.*
import org.soluvas.commons.util.HashedPasswordUtils
import org.soluvas.data.StatusMask
import org.soluvas.data.person.PersonRepository
import org.soluvas.data.person.PersonRepository2
import org.springframework.beans.factory.BeanFactory
import org.springframework.transaction.annotation.Transactional

import javax.annotation.Nullable
import javax.inject.Inject
import javax.inject.Provider
import java.util.regex.Matcher
import java.util.regex.Pattern

import static org.fusesource.jansi.Ansi.ansi

@Usage('Person management')
class person {
    private static final log = LoggerFactory.getLogger('org.soluvas.data.commands.person')

    @Usage('Add a person')
    @Command
    public String add(
            @Usage('Tenant ID.')
            @Required @Option(names = ['t', 'tenant']) String tenantId,
            @Usage('Email.')
            @Option(names = ['e', 'email']) String emailStr,
            @Usage('Password (will be encoded using BCrypt).')
            @Option(names = ["p", "password"]) String password,
            @Usage('Gender: m(ale)|f(emale)')
            @Option(names = ["g", "gender"]) String gender,
            @Usage('Account status: DRAFT|ACTIVE|VALIDATED|VERIFIED|INACTIVE|VOID.')
            @Option(names=["s", "status"])
            AccountStatus accountStatus,
            @Usage('Person slug to be created.')
            @Argument String slug,
            @Usage('Full name of Person to be created.')
            @Argument String name) {

        if (null == accountStatus) {
            accountStatus = AccountStatus.ACTIVE
        }

        final BeanFactory beanFactory = context.attributes['spring.beanfactory']
        final personRepo = beanFactory.getBean(PersonRepository2.class)

        final person = personRepo.newBlank()
        person.setId(slug + "@" + tenantId);
        //person.setGuid(Person.class.getSimpleName() + "_" + id);
        person.setStatus(accountStatus);
        person.setName(name);
        person.setSlug(slug);
        person.setCanonicalSlug(SlugUtils.canonicalize(slug));
        final Matcher nameMatcher = Pattern.compile("(.+) (.+)").matcher(name);
        if (nameMatcher.matches()) {
            person.setFirstName(nameMatcher.group(1));
            person.setLastName(nameMatcher.group(2));
        } else {
            person.setFirstName(name);
            person.setLastName(name);
        }

        final address = new PostalAddress2()

        if (!Strings.isNullOrEmpty(emailStr)) {
            final existingPersonByEmail = personRepo.findOneByEmail(tenantId, StatusMask.RAW, emailStr);
            if (existingPersonByEmail.isPresent()) {
                log.info("Email {} already exists for person {}", emailStr, existingPersonByEmail.get().getId());
                err.println(ansi().render("@|red Email|@ @|bold %s|@ @|red already exists for person|@ @|bold %s|@",
                        emailStr, existingPersonByEmail.get().getId()));
                return null;
            } else {
                final email = new Email2();
                email.setEmail(emailStr);
                email.setPrimary(true);
                email.setValidationTime(new DateTime());
                person.getEmails().add(email);
                // address
                address.getEmails().add(emailStr);
                address.setPrimaryEmail(emailStr);
            }
        }

        if (!Strings.isNullOrEmpty(password)) {
            final String encoded = BCrypt.hashpw(password, BCrypt.gensalt())
            err.println(ansi().render("Encoded password: @|bold %s|@", encoded));
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
            final theMobile = new PhoneNumber2()
            theMobile.setPhoneNumber(mobileNumber);
            theMobile.setPrimary(true);
            person.getMobileNumbers().add(theMobile);
            // address
            address.getMobiles().add(mobileNumber);
            address.setPrimaryMobile(mobileNumber);
        }

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

        final added = personRepo.add(tenantId, person);
        return added;
    }

    @Usage('Set security roles of a person.')
    @Command
    public String roleset(
            @Usage('Tenant ID.')
            @Required @Option(names = ['t', 'tenant']) String tenantId,
            @Usage('Person Slug.')
            @Argument String personSlug,
            @Usage('Role name(s). If none specified, will remove all roles from the person.')
            @Argument List<String> roles) {
        //final AccessControlManager acMgr = getBean(AccessControlManager.class);
        final BeanFactory beanFactory = context.attributes['spring.beanfactory']
        final personRepo = beanFactory.getBean(PersonRepository2.class)
        final person = personRepo.findOneBySlug(tenantId, StatusMask.RAW, personSlug);
        final Set<String> roleSet = roles != null ? ImmutableSet.copyOf(roles) : ImmutableSet.<String>of();
        out.print(ansi().render("Setting security roles of @|bold %s|@ to @|bold %s|@...",
                personSlug, Joiner.on(", ").join(roleSet)));
        person.get().securityRoleIds.clear()
        person.get().securityRoleIds.addAll(roleSet)
        personRepo.modify(tenantId, person.get().id, person.get())

//        acMgr.replacePersonTenantRoles(getTenant().getTenantId(), personId, roleSet);
        out.println(ansi().render(" @|bold,bg_green  OK |@"));
        return roleSet;
    }

    @Usage('Change person password')
    @Command
    public String passwd(
            @Usage('Tenant ID.')
            @Required @Option(names = ['t', 'tenant']) String tenantId,
            @Usage('Person Slug.')
            @Argument String personSlug,
            @Usage('Password (will be encoded using BCrypt).')
            @Argument String password) {

        //final AccessControlManager acMgr = getBean(AccessControlManager.class);
        final BeanFactory beanFactory = context.attributes['spring.beanfactory']
        final personRepo = beanFactory.getBean(PersonRepository2.class)
        final person = personRepo.findOneBySlug(tenantId, StatusMask.RAW, personSlug).get();

        final String encoded = BCrypt.hashpw(password, BCrypt.gensalt())
        err.println(ansi().render("Encoded password: @|bold %s|@", encoded));
        person.setPassword(encoded);

        personRepo.modify(tenantId, person.id, person)

        out.println(ansi().render(" @|bold,bg_green  OK |@"));
    }

}