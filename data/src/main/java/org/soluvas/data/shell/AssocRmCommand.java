package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.ServiceLookup;
import org.soluvas.data.repository.AssocRepository;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * Remove an association(s) in an {@link AssocRepository} using {@link AssocRepository#remove(Object, Object)}.
 * @author ceefour
 */
@Command(scope="assoc", name="rm", description="Remove an association(s) in an AssocRepository.")
public class AssocRmCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocRmCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Argument(index=0, name="left", required=true, description="Left value.")
	private Object left;
	@Argument(index=1, name="right ...", required=false, multiValued=true, description="Right value(s).")
	private Object[] rights;
	@Option(name="-a", aliases="--all", description="Delete all right values, right argument must not be given.")
	private volatile boolean all = false;

	public AssocRmCommand(ServiceLookup svcLookup) {
		super();
		this.svcLookup = svcLookup;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Long doExecute() throws Exception {
		return svcLookup.withService(AssocRepository.class, session, namespace, new Function<AssocRepository<Object, Object>, Long>() {
			@Override
			@Nullable
			public Long apply(@Nullable AssocRepository<Object, Object> repo) {
				final long deleted;
				if (all) {
					if (rights != null || rights.length > 0) {
						// avoid a typo!
						throw new RuntimeException("Do not provide the right argument if you want to delete all rights. Probably a typo?");
					}
					System.out.print(ansi().render("Deleting all rights of @|bold %s|@...", left));
					deleted = repo.deleteAllRights(left);
				} else {
					System.out.print(ansi().render("Deleting @|bold %s|@ with @|bold %s|@...", left, Joiner.on(", ").join(rights)));
					final List<Object> rightList = ImmutableList.copyOf(rights);
					deleted = repo.delete(left, rightList);
				}
				System.out.println(ansi().render(" @|bold %d|@ deleted", deleted));
				return deleted;
			}
		});
	}

}
