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
 * Remove an association(s) in an {@link AssocRepository}, in inverse, using {@link AssocRepository#remove(Object, Object)}.
 * @author ceefour
 */
@Command(scope="assoc", name="rminv", description="Remove an association(s) in an AssocRepository, in inverse.")
public class AssocRmInvCommand extends OsgiCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(AssocRmInvCommand.class);

	private final ServiceLookup svcLookup;
	@Option(name="-n", aliases={"--ns", "--namespace"},
			description="Namespace, e.g. role-person (always two parts).")
	private volatile String namespace = "";
	@Argument(index=0, name="right", required=true, description="Right value.")
	private Object right;
	@Argument(index=1, name="left ...", required=false, multiValued=true, description="Left value(s).")
	private Object[] lefts;
	@Option(name="-a", aliases="--all", description="Delete all left values, left argument must not be given.")
	private volatile boolean all = false;

	public AssocRmInvCommand(ServiceLookup svcLookup) {
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
					if (lefts != null || lefts.length > 0) {
						// avoid a typo!
						throw new RuntimeException("Do not provide the left argument if you want to delete all lefts. Probably a typo?");
					}
					System.out.print(ansi().render("Deleting all lefts of @|bold %s|@...", right));
					deleted = repo.deleteAllLefts(right);
				} else {
					System.out.print(ansi().render("Deleting @|bold %s|@ with @|bold %s|@...", Joiner.on(", ").join(lefts), right));
					final List<Object> leftList = ImmutableList.copyOf(lefts);
					deleted = repo.delete(leftList, right);
				}
				System.out.println(ansi().render(" @|bold %d|@ deleted", deleted));
				return deleted;
			}
		});
	}

}
