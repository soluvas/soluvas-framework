package org.soluvas.data.shell;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.data.repository.AssocRepository;

import com.google.common.base.Function;

/**
 * Determines if assoc repository is empty using {@link AssocRepository#isEmpty()}.
 * @author ceefour
 */
@Command(scope="assoc", name="empty", description="Determines if assoc repository is empty.")
public class AssocEmptyCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocEmptyCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";

	public AssocEmptyCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Boolean doExecute() throws Exception {
		return svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository<?, ?>, Boolean>() {
			@Override
			@Nullable
			public Boolean apply(@Nullable AssocRepository<?, ?> repo) {
				return repo.isEmpty();
			}
		});
	}

}
