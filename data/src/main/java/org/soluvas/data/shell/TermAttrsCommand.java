package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameFunction;
import org.soluvas.data.AttributeType;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Multimap;

/**
 * Display number of {@link Term}s for all recognized {@link AttributeType}s.
 * @author rully
 */
@Command(scope="term", name="attrs", description="Display Terms grouped by recognized AttributeTypes.")
public class TermAttrsCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<TermManager> dataCatalogRef = bundleContext.getServiceReference(TermManager.class);
		final TermManager termMgr = getService(TermManager.class, dataCatalogRef);
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%3s|%-40s|@",
				"№", "Attribute", "∑", "Terms"));
		final Multimap<String, Term> terms = termMgr.getTermsByAttributeTypes();
		int i = 0;
		for (final Entry<String, Collection<Term>> entry : terms.asMap().entrySet()) {
			final Collection<String> termNames = Collections2.transform(entry.getValue(), new NameFunction());
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-20s|@@|bold,black ||@%3d@|bold,black ||@%-40s",
					++i, entry.getKey(), entry.getValue().size(), Joiner.on(' ').join(termNames) ));
		}
		return null;
	}

}
