package org.soluvas.data.person.shell;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.Person;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.commons.util.HashedPasswordUtils;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.data.util.BatchFinder;
import org.soluvas.data.util.BatchProcessor;
import org.soluvas.data.util.RepositoryUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

/**
 * @author rudi
 *
 */
@Service @Scope("prototype")
@Command(scope="person", name="encryptpassword", description="Encrypt text password.")
public class PersonEncryptPasswordCommand extends ExtCommandSupport {
	
	@Option(aliases="--f", name="--forge", description="Forge to run.")
	private transient boolean forge = false;

	@Override
	protected Void doExecute() throws Exception {
		if (forge) {
			final PersonRepository personRepo = getBean(PersonRepository.class);
			
			RepositoryUtils.runBatch("Encrypt text password", new Sort("_id"), new BatchFinder<Person2>() {
				@Override
				public Page<Person2> find(Pageable pageable) throws Exception {
					return personRepo.findAll(pageable);
				}
			}, new BatchProcessor<Person2>() {
				@Override
				public void process(Person2 input, long elementIndex,
						long elementOffset, long numberOfElements,
						long totalElements, long pageNumber, long totalPages,
						ProgressMonitor monitor) throws Exception {
					if (!Strings.isNullOrEmpty(input.getPassword()) && !input.getPassword().startsWith("{SSHA}")) {
						input.setPassword(HashedPasswordUtils.encodeSsha(input.getPassword()));
						personRepo.modify(input.getId(), input);
					}
				}
			});
		}
		return null;
	}

}
