package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.data.repository.AssocRepository;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;

/**
 * List all associations in an {@link AssocRepository} using {@link AssocRepository#findAll()}.
 * @author ceefour
 */
@Command(scope="assoc", name="ls", description="List all associations in an AssocRepository.")
public class AssocLsCommand extends OsgiCommandSupport {

	private static Logger log = LoggerFactory.getLogger(AssocLsCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Option(name="-b", aliases="--batch",
			description="Batch mode, return objects instead of human readable output.")
	private volatile boolean batch = false;

	public AssocLsCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Multimap<?, ?> doExecute() throws Exception {
		return svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository<?, ?>, Multimap<?, ?>>() {
			@Override
			@Nullable
			public Multimap<?, ?> apply(@Nullable AssocRepository<?, ?> repo) {
				Multimap<?, ?> assocs = repo.findAll();
				if (batch) {
					return assocs;
				} else {
					System.out.println( ansi().render("@|negative_on %3s|%-30s|%-30s|@",
							"№", "« Left", "» Right") );
					int i = 0;
					for (Map.Entry<?, ?> entry : assocs.entries()) {
						System.out.println( ansi().render("@|bold,black %3d||@%-30s@|bold,black ||@%-30s",
								++i, entry.getKey(), entry.getValue()) );
					}
					System.out.println( ansi().render("@|bold %d|@ associations in '@|bold %s|@' (@|bold %s|@)",
						assocs.size(), namespace, repo) );
					return null;
				}
			}
		});
	}

}
