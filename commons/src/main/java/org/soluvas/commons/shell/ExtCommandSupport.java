package org.soluvas.commons.shell;

import org.apache.karaf.shell.console.AbstractAction;
import org.soluvas.commons.ShellProgressMonitor;
import org.soluvas.commons.impl.ShellProgressMonitorImpl;
import org.soluvas.commons.locale.LocaleContext;

/**
 * @author agus
 *
 */
public abstract class ExtCommandSupport extends AbstractAction {

	/**
	 * Tenant for the currently executing {@link CommandSession}.
	 * May be {@literal null} if no session is executing.
	 */
//	protected TenantRef tenant;
	/**
	 * @todo Proper locale support.
	 */
	protected LocaleContext localeContext = new LocaleContext();
	protected ShellProgressMonitor monitor = new ShellProgressMonitorImpl();
	
}
