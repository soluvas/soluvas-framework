package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameComparator;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * List {@link EPackage}s.
 * @author ceefour
 */
@Command(scope="emf", name="pkgls", description="List registered EPackages.")
public class EmfPkgLsCommand extends OsgiCommandSupport {
	
	private transient Logger log = LoggerFactory.getLogger(EmfPkgLsCommand.class);
	
	public EmfPkgLsCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-50s|%-34s|@",
				"№", "Name", "Namespace URI", "Bundle"));
		int i = 0;
		Iterable<EPackage> origPackages = Iterables.transform(EPackage.Registry.INSTANCE.values(), new Function<Object, EPackage>() {
			@Override
			@Nullable
			public EPackage apply(@Nullable Object input) {
				return (EPackage) input;
			}
		});
		ImmutableList<EPackage> sortedPackages = Ordering.from(new NameComparator<EPackage>()).immutableSortedCopy(origPackages);
		for (EPackage pkg : sortedPackages) {
			Bundle bundle = FrameworkUtil.getBundle(pkg.getClass());
			System.out.println(ansi().render("@|bold,black %3d||@%-15s@|bold,black ||@%-50s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, pkg.getName(), pkg.getNsURI(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ EPackages", i));
		return null;
	}

}
