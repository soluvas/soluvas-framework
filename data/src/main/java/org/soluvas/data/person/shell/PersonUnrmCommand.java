package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.UntrashResult;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Untrash a {@link Person}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="unrm", description="Untrash Person by ID.")
public class PersonUnrmCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonUnrmCommand.class);

	@Argument(index=0, name="id ...", required=true, multiValued=true,
			description="Person ID(s).")
	private String[] ids;

	@Override
	protected Object doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		long i = 0;
		for (final String id : ids) {
			System.out.print(ansi().render("Untrashing @|bold %-40s|@...", id));
			try {
				final UntrashResult result = personRepo.untrashById(id);
				switch (result) {
				case ALREADY_UNTRASHED:
					System.out.println(ansi().render(" @|bold,bg_red,white  ALREADY |@", id));
					break;
				case NOT_FOUND:
					System.out.println(ansi().render(" @|bold,bg_red,white  NOT FOUND |@", id));
					break;
				case UNTRASHED:
					System.out.println(ansi().render(" @|bold,bg_green,white  UNTRASHED |@", id));
					i++;
					break;
				}
			} catch (Exception e) {
				System.out.println(ansi().render(" @|bold,bg_red,yellow  ERROR |@", id));
				System.err.println(e);
				log.error("Cannot untrash " + id, e);
			}
		}
		return i;
	}

}