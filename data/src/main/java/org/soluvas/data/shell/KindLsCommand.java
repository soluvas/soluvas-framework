package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameUtils;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Kind;

/**
 * Display all {@link Kind}s.
 * @author rully
 */
@Command(scope="kind", name="ls", description="Display all Kinds. To list terms use term:attrs.")
public class KindLsCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<DataCatalog> dataCatalogRef = bundleContext.getServiceReference(DataCatalog.class);
		final DataCatalog dataCatalog = getService(DataCatalog.class, dataCatalogRef);
		System.out.println(ansi().render("@|negative_on %3s|%-10s|%-20s|%-20s|@",
				"№", "NsPrefix", "Name", "Bundle"));
		int i = 0;
		for (final Kind kind : dataCatalog.getKinds()) {
			final String bundleAnsi = NameUtils.shortenBundleAnsi(kind.getBundle(), 20);
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-10s|@@|bold,black ||@%-20s@|bold,black ||@" + bundleAnsi,
					++i, kind.getNsPrefix(), kind.getName() ));
		}
		return null;
	}

}
