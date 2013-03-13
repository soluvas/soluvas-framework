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
 * Add an association(s) in an {@link AssocRepository} in inverse, using {@link AssocRepository#put(Iterable, Object)}.
 * @author ceefour
 */
@Command(scope="assoc", name="addinv", description="Add an association(s) in an AssocRepository, in inverse.")
public class AssocAddInvCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocAddInvCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Argument(index=0, name="right", required=true, description="Right value.")
	private String right;
	@Argument(index=1, name="left ...", required=true, multiValued=true, description="Left value(s).")
	private String[] lefts;

	public AssocAddInvCommand(ServiceLookup svcLookup) {
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
				System.out.print(ansi().render("Putting @|bold %s|@ as @|bold %s|@...", Joiner.on(", ").join(lefts), right));
				final List<String> leftList = ImmutableList.copyOf(lefts);
				long assocs = repo.put(leftList, right);
				System.out.println(ansi().render(" @|bold %d|@ added", assocs));
				return assocs;
			}
		});
	}

}
