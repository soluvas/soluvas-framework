package org.soluvas.ldap.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.PersonRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Delete all guest {@link SocialPerson} users.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="rmguests", description="Delete all guest users.")
public class PersonRmGuestsCommand extends ExtCommandSupport {

	private final LdapRepository<SocialPerson> personLdapRepo;
	
	@Option(name="-f", description="Actually perform the operation, otherwise simply list the guest IDs.")
	private transient boolean force = false;
	
	@Inject
	public PersonRmGuestsCommand(
			@PersonRelated LdapRepository<SocialPerson> personLdapRepo) {
		super();
		this.personLdapRepo = personLdapRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		System.err.print(ansi().render("Finding guests..."));
		// for some strange reason "(uniqueidentifier=guest_*)" filter won't work. sigh LDAP :(
		final List<String> guestIds = personLdapRepo.findIdsByFilter("(cn=Guest Guest)");
		System.err.println(ansi().render(" @|bold,yellow %s|@ guests.", guestIds.size()));
		
		for (final String guestId : guestIds) {
			if (force) {
				System.err.print(ansi().render("Deleting @|bold %s|@ ...", guestId));
				personLdapRepo.delete(guestId);
				System.err.println(ansi().render(" @|bold DELETED |@"));
			} else {
				System.out.println(guestId);
			}
		}

		return guestIds.size();
	}

}
