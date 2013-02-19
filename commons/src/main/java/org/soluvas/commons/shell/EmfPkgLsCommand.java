package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.soluvas.commons.NameComparator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

/**
 * List {@link EPackage}s.
 * @author ceefour
 */
@Command(scope="emf", name="pkgls", description="List registered EPackages.")
public class EmfPkgLsCommand extends OsgiCommandSupport {
	
	public EmfPkgLsCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" }) @Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-50s|%-34s|@",
				"№", "Name", "Namespace URI", "Bundle"));
		int i = 0;
		final Collection<EPackage> origPackages = (Collection) EPackage.Registry.INSTANCE.values();
		final ImmutableList<EPackage> sortedPackages = Ordering.from(new NameComparator<EPackage>()).immutableSortedCopy(origPackages);
		for (final EPackage pkg : sortedPackages) {
			final Bundle bundle = FrameworkUtil.getBundle(pkg.getClass());
			System.out.println(ansi().render("@|bold,black %3d||@%-15s@|bold,black ||@%-50s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, pkg.getName(), pkg.getNsURI(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ EPackages", i));
		return null;
	}

}
