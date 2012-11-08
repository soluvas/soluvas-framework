package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Supplier;

/**
 * List EventBus subscribers.
 * @author ceefour
 */
@Command(scope="eventbus", name="ls", description="List EventBus subscribers.")
public class EventBusLsCommand extends OsgiCommandSupport {
	
	private transient Logger log = LoggerFactory.getLogger(EventBusLsCommand.class);
	
	private final List<Supplier<?>> subscriberSuppliers;
	
	public EventBusLsCommand(List<Supplier<?>> subscriberSuppliers) {
		super();
		this.subscriberSuppliers = subscriberSuppliers;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		Collection<ServiceReference<Supplier>> serviceRefs = bundleContext.getServiceReferences(Supplier.class, "(type=eventbus)");
		
		System.out.println(ansi().render("@|negative_on %3s|%-50s|%-34s|%-20s|@",
				"№", "Class", "Bundle", "Name"));
		int i = 0;
		for (ServiceReference<Supplier> ref : serviceRefs) {
			Supplier subscriberSupplier = bundleContext.getService(ref);
			try {
				Object subscriber = subscriberSupplier.get();
				System.out.println(ansi().render("@|bold,black %3d||@%-50s@|bold,black ||@%-30s@|bold,yellow %4d|@@|bold,black ||@%s",
					++i, subscriber.getClass().getName(),
					ref.getBundle().getSymbolicName(),
					ref.getBundle().getBundleId(),
					subscriber ));
			} finally {
				bundleContext.ungetService(ref);
			}
		}
		System.out.println(ansi().render("@|bold %d|@ EventBus subscribers", i));
		return null;
	}

}
