package org.soluvas.data.person.shell; 

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.LookupKey;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to show an entity of {@link Person} using {@link PersonRepository#lookupOne(org.soluvas.data.StatusMask, org.soluvas.data.LookupKey, java.io.Serializable)}
 * {@link LookupKey#EMAIL}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="byemail", description="Get Person by email.")
public class PersonByEmailCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(PersonByEmailCommand.class);

	@Option(name="-m", aliases="--mask", description="Status mask.")
	private transient StatusMask statusMask = StatusMask.RAW;
	@Argument(index=0, name="email", required=true, description="Email.")
	private String email;
	
	private final PersonRepository personRepo;
	
	@Inject
	public PersonByEmailCommand(PersonRepository personRepo) {
		super();
		this.personRepo = personRepo;
	}

	@Override
	protected Object doExecute() throws Exception {
		return personRepo.lookupOne(statusMask, LookupKey.EMAIL, email);
	}

}