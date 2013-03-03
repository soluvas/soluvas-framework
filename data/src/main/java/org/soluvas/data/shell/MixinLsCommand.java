package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameFunction;
import org.soluvas.commons.NameUtils;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Mixin;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * Displays all {@link Mixin}s.
 * @author rully
 */
@Command(scope="mixin", name="ls", description="Displays all Mixins.")
public class MixinLsCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<DataCatalog> dataCatalogRef = bundleContext.getServiceReference(DataCatalog.class);
		final DataCatalog dataCatalog = getService(DataCatalog.class, dataCatalogRef);
		System.out.println(ansi().render("@|negative_on %3s|%-10s|%-15s|%3s|%-30s|%-20s|@",
				"№", "NsPrefix", "Name", "Σ", "Attributes", "Bundle"));
		int i = 0;
		for (final Mixin mixin : dataCatalog.getMixins()) {
			final List<String> mixinNames = Lists.transform(mixin.getAttributes(), new NameFunction());
			final String bundleAnsi = NameUtils.shortenBundleAnsi(mixin.getBundle(), 20);
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-10s|@@|bold,black ||@%-15s@|bold,black ||@%3d@|bold,black ||@%-30s@|bold,black ||@" + bundleAnsi,
					++i, mixin.getNsPrefix(), mixin.getName(),
					mixin.getAttributes().size(), Joiner.on(' ').join(mixinNames) ));
		}
		return null;
	}

}
