package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameUtils;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Term;

/**
 * Display all {@link Term}s.
 * @author rully
 */
@Command(scope="term", name="ls", description="Display all Terms.")
public class TermLsCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<DataCatalog> dataCatalogRef = bundleContext.getServiceReference(DataCatalog.class);
		final DataCatalog dataCatalog = getService(DataCatalog.class, dataCatalogRef);
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
