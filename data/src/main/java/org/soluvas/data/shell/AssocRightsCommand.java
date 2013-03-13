/**
 * 
 */
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
import com.google.common.collect.Multiset;

/**
 * Calls {@link AssocRepository#rights()}.
 * @author ceefour
 */
@Command(scope="assoc", name="rights", description="List Rights from assoc repository.")
public class AssocRightsCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocRightsCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
		description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Option(name="-h", description="Human readable output.")
	private volatile boolean human = false;

	public AssocRightsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected Multiset<?> doExecute() throws Exception {
		Multiset<?> rights = svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository, Multiset<?>>() {
			@Override
			@Nullable
			public Multiset<?> apply(@Nullable AssocRepository repo) {
				return repo.rights();
			}
		});
		if (human) {
			for (Multiset.Entry<?> entry : rights.entrySet()) {
				System.out.format("%-40s %3d\n", entry.getElement(), entry.getCount());
			}
			return null;
		} else {
			return rights;
		}
	}

}
