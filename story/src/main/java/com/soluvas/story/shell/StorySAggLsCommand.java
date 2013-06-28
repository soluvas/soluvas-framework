package com.soluvas.story.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.soluvas.commons.NameUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.soluvas.story.schema.AggregationType;
import com.soluvas.story.schema.StorySchemaCatalog;

/**
 * List registered {@link AggregationType}s.
 * @author ceefour
 */
@Service @Lazy
@Command(scope="storys", name="aggls", description="List registered AggregationTypes.")
public class StorySAggLsCommand extends OsgiCommandSupport {
	
	private final StorySchemaCatalog storySchemaCatalog;

	@Inject
	public StorySAggLsCommand(StorySchemaCatalog storySchemaCatalog) {
		super();
		this.storySchemaCatalog = storySchemaCatalog;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAggregation#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
//		final ServiceReference<StorySchemaCatalog> storySchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(StorySchemaCatalog.class),
//				"Cannot get %s service reference", StorySchemaCatalog.class.getName());
//		final StorySchemaCatalog storySchemaCatalog = Preconditions.checkNotNull(getService(StorySchemaCatalog.class, storySchemaCatalogRef),
//				"Cannot get %s service", StorySchemaCatalog.class.getName());
		System.out.println(ansi().render("@|negative_on %3s|%-25s|%-10s|%-20s|@",
				"№", "Aggregation", "Catalog", "Bundle"));
		int i = 0;
		for (final AggregationType aggType : storySchemaCatalog.getAggregationTypes()) {
			final Bundle bundle = aggType.getBundle();
			final String classNameAnsi = NameUtils.shortenClassAnsi(aggType.getJavaClassName(), 25);
			final String bundleAnsi = NameUtils.shortenBundleAnsi(bundle, 20);
			System.out.println(ansi().render("@|bold,black %3d||@" + classNameAnsi + "@|bold,black ||@%-10s@|bold,black ||" + bundleAnsi,
				++i, aggType.getResourceName() ));
		}
		System.out.println(ansi().render("@|bold %d|@ aggTypes", i));
		return null;
	}

}
