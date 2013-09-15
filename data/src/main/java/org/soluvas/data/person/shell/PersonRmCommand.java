package org.soluvas.data.person.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.TrashResult;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Trash {@link Person}, or can also delete permanently.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="rm", description="Trash Person by ID.")
public class PersonRmCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonRmCommand.class);

	@Option(name="-p", aliases="--permanent", 
			description="By default the command only moves the Person entity to trash, this option makes it delete the entity permanently.")
	private transient boolean permanent = false;
	@Argument(index=0, name="id ...", required=true, multiValued=true,
			description="Person ID(s).")
	private String[] ids;

	@Override
	protected Object doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		long i = 0;
		for (final String id : ids) {
			System.out.print(ansi().render("%s @|bold %-40s|@...", 
					permanent ? "Deleting PERMANENTLY" : "Trashing", id));
			try {
				if (permanent) {
					final boolean deleted = personRepo.delete(id);
					if (deleted) {
						System.out.println(ansi().render(" @|bold,bg_yellow,white  DELETED |@", id));
						i++;
					} else {
						System.out.println(ansi().render(" @|bold,bg_red,white  WARN |@", id));
					}
				} else {
					final TrashResult result = personRepo.trashById(id);
					switch (result) {
					case ALREADY_TRASHED:
						System.out.println(ansi().render(" @|bold,bg_red,white  ALREADY |@", id));
						break;
					case NOT_FOUND:
						System.out.println(ansi().render(" @|bold,bg_red,white  NOT FOUND |@", id));
						break;
					case TRASHED:
						System.out.println(ansi().render(" @|bold,bg_yellow,white  TRASHED |@", id));
						i++;
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(ansi().render(" @|bold,bg_red,yellow  ERROR |@", id));
				System.err.println(e);
				log.error("Cannot trash/delete " + id, e);
			}
		}
		return i;
	}

}