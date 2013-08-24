package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Kind;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Display all {@link Kind}s.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="kind", name="ls", description="Display all Kinds. To list terms use term:attrs.")
public class KindLsCommand extends ExtCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final DataCatalog dataCatalog = getBean(DataCatalog.class);
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
