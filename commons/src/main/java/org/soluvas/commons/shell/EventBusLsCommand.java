package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameUtils;

import com.google.common.base.Supplier;

/**
 * List EventBus subscribers.
 * @author ceefour
 */
@Command(scope="eventbus", name="ls", description="List EventBus subscribers.")
public class EventBusLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected Object doExecute() throws Exception {
		final Collection<ServiceReference<Supplier>> serviceRefs = bundleContext.getServiceReferences(
				Supplier.class, "(type=eventbus)");
		
		System.out.println(ansi().render("@|negative_on %3s|%-35s|%-34s|@",
				"№", "Class", "Bundle" ));
		int i = 0;
		for (final ServiceReference<Supplier> ref : serviceRefs) {
			final Supplier subscriberSupplier = getService(Supplier.class, ref);
			final Object subscriber = subscriberSupplier.get();
			final String subscriberName = subscriber.getClass().getName();
			final String subscriberNameAnsi = NameUtils.shortenClassAnsi(subscriberName, 35);
			System.out.println(ansi().render("@|bold,black %3d||@" + subscriberNameAnsi + "@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, ref.getBundle().getSymbolicName(), ref.getBundle().getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ EventBus subscribers", i));
		return null;
	}

}
