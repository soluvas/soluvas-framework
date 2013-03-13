package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.IOException;

import javax.annotation.Nullable;

import jline.console.ConsoleReader;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.data.repository.AssocRepository;

import com.google.common.base.Function;
import com.google.common.base.Throwables;

/**
 * Delete all associations in an {@link AssocRepository} using {@link AssocRepository#deleteAll()}.
 * @author ceefour
 */
@Command(scope="assoc", name="rmall", description="Delete all associations in an AssocRepository.")
public class AssocRmAllCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocRmAllCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Option(name="-f", aliases={"--force"},
			description="Do not prompt for delete confirmation.")
	private volatile boolean force = false;

	public AssocRmAllCommand(ServiceLookup svcLookup) {
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
				if (!force) {
					try {
						final ConsoleReader reader = new ConsoleReader(session.getKeyboard(), session.getConsole());
						String confirmation = reader.readLine(
								ansi().render("@|bg_red,bold,yellow ☢WARNING☢|@ Delete @|bold,red all|@ associations from @|bold %s|@? (@|red,bold y|@/@|green,bold N|@) ", repo).toString());
//						System.out.println(confirmation);
						if (!"y".equalsIgnoreCase(confirmation))
							return 0L;
					} catch (IOException e) {
						Throwables.propagate(e);
						return null;
					}
				}
				System.out.print(ansi().render("@|bold,red Deleting|@ all associations from @|bold %s|@...", repo));
				long deleted = repo.deleteAll();
				System.out.println(ansi().render(" @|bold %d|@ associations deleted", deleted));
				return deleted;
			}
		});
	}

}
