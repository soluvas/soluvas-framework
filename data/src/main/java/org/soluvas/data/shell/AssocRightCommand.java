package org.soluvas.data.shell;

import java.util.Set;

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
 * Calls {@link AssocRepository#rights()}.
 * @author ceefour
 */
@Command(scope="assoc", name="right", description="List RightSet from assoc repository.")
public class AssocRightCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocRightCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";

	public AssocRightCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected Set<?> doExecute() throws Exception {
		return svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository, Set<?>>() {
			@Override
			@Nullable
			public Set<?> apply(@Nullable AssocRepository repo) {
				return repo.rightSet();
			}
		});
	}

}
