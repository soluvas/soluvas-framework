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
 * Add an association(s) in an {@link AssocRepository} using {@link AssocRepository#put(Object, Iterable)}.
 * @author ceefour
 */
@Command(scope="assoc", name="add", description="Add an association(s) in an AssocRepository.")
public class AssocAddCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocAddCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Argument(index=0, name="left", required=true, description="Left value.")
	private String left;
	@Argument(index=1, name="right ...", required=true, multiValued=true, description="Right value(s).")
	private String[] rights;

	public AssocAddCommand(ServiceLookup svcLookup) {
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
				System.out.print(ansi().render("Putting @|bold %s|@ as @|bold %s|@...", left, Joiner.on(", ").join(rights)));
				final List<String> rightList = ImmutableList.copyOf(rights);
				long assocs = repo.put(left, rightList);
				System.out.println(ansi().render(" @|bold %d|@ added", assocs));
				return assocs;
			}
		});
	}

}
