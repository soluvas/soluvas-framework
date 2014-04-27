package org.soluvas.data.person.shell; 

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.person.PersonRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shell command to show information about the current {@link PersonRepository}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="person", name="info", description="Show information about the current Person repository.")
public class PersonInfoCommand extends ExtCommandSupport {

	@Override @Nullable
	protected PersonRepository doExecute() throws Exception {
		final PersonRepository personRepo = getBean(PersonRepository.class);
		return personRepo;
	}

}