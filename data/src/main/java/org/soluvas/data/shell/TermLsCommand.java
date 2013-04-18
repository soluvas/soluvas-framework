package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Term;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Display all {@link Term}s.
 * @author rully
 */
@Service @Lazy
@Command(scope="term", name="ls", description="Display all Terms.")
public class TermLsCommand extends ExtCommandSupport {
	
	private final DataCatalog dataCatalog;

	@Inject
	public TermLsCommand(DataCatalog dataCatalog) {
		super();
		this.dataCatalog = dataCatalog;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-10s|%-15s|%-20s|%-10s|%-10s|%-20s|@",
				"№", "NsPrefix", "Name", "Display Name", "Kind NsP", "Kind Name", "Bundle"));
		int i = 0;
		for (final Term term : dataCatalog.getTerms()) {
			final String bundleAnsi = NameUtils.shortenBundleAnsi(term.getBundle(), 20);
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-10s|@@|bold,black ||@%-15s@|bold,black ||@%-20s@|bold,black ||@%-10s@|bold,black ||@%-10s@|bold,black ||@" + bundleAnsi,
					++i, term.getNsPrefix(), term.getName(), term.getDisplayName(),
					term.getKindNsPrefix(), term.getKindName() ));
		}
		return null;
	}

}
