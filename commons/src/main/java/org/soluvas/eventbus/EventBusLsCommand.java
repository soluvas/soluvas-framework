package org.soluvas.eventbus;

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
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
	
	private List<Supplier<?>> subscriberSuppliers;
	
	public EventBusLsCommand(List<Supplier<?>> subscriberSuppliers) {
		super();
		this.subscriberSuppliers = subscriberSuppliers;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-40s | %s\n",
				"#", "Class", "Name");
		int i = 0;
		for (Supplier<?> subscriberSupplier : subscriberSuppliers) {
			Object subscriber = subscriberSupplier.get();
			System.out.format("%3d | %-40s | %s\n",
				++i, subscriber.getClass().getName(), subscriber );
		}
		System.out.format("%d EventBus subscribers\n", i);
		return null;
	}

}
