package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.person.PersonRepository;

/**
 * Shell command to search {@link Person} entities.
 *
 * @author ceefour
 */
@Command(scope="person", name="search", description="Search Person entities by partial Numeric ID, partial slug, or partial title.")
public class PersonSearchCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonSearchCommand.class);

	@Argument(index=0, name="searchText", required=true, description="Search text.")
	private String searchText; 

	@Override
	protected Void doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		final TenantRef tenant = getBean(TenantRef.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-15s|%-21s|%-20s|@",
				"#", "ID", "Slug", "Name", "Email" ));
		
		final List<Person> personList = personRepo.findBySearchText(StatusMask.RAW, searchText, new CappedRequest(100)).getContent();
		int i = 0;
		for (final Person it : personList) {
			final String genderStr = it.getGender() == Gender.MALE ? "@|bold,blue ♂|@" : it.getGender() == Gender.FEMALE ? "@|bold,magenta ♀|@" : " "; 
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-15s|@@|bold,black ||@%-15s@|bold,black ||@" + genderStr + "%-20s@|bold,black ||@%-20s",
				++i, it.getId(), it.getSlug(), it.getName(), it.getEmail()) );
		}
		System.out.println(ansi().render("@|bold %d|@ Person entities in '@|bold %s|@'",
				personList.size(), tenant.getTenantId()));
		return null;
	}

}