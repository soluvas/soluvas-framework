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
 * Count associations from {@link AssocRepository} using {@link AssocRepository#count()}.
 * @author ceefour
 */
@Command(scope="assoc", name="count", description="Count associations from assoc repository.")
public class AssocCountCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocCountCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";

	public AssocCountCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Long doExecute() throws Exception {
		return svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository<?, ?>, Long>() {
			@Override
			@Nullable
			public Long apply(@Nullable AssocRepository<?, ?> repo) {
				return repo.count();
			}
		});
	}

}
