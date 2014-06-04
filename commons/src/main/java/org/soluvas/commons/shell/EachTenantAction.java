package org.soluvas.commons.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.Function;
import org.apache.karaf.shell.console.AbstractAction;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.CommandRequestAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * Execute a closure on all tenant IDs.
 * @see org.apache.karaf.shell.commands.EachAction
 */
@Service @Scope("prototype")
@Command(scope = "tenant", name = "eachtenant", description = "Execute a closure on all tenant IDs.")
public class EachTenantAction extends AbstractAction {
	
	@Inject
	private ApplicationContext appCtx;

    @Argument(name = "function", index = 0, multiValued = false, required = true, description = "The function to execute on each tenant")
    private Function function;

    @Override
    protected List<Object> doExecute() throws Exception {
    	final Map<String, AppManifest> tenantMap = appCtx.getBean("tenantMap", Map.class);
    	System.err.println(ansi().render("Executing @|bold %s|@ on @|bold %s|@ tenants: @|bold %s|@",
    			function.getClass().getSimpleName(), tenantMap.size(), StringUtils.abbreviate(Joiner.on(' ').join(tenantMap.keySet()), 40)));
    	final ArrayList<Object> results = new ArrayList<>();
        for (final String tenantId : tenantMap.keySet()) {
        	System.err.println(ansi().render(">> %s @|bold %s|@", function.getClass().getSimpleName(), tenantId));
        	try (final Closeable cl = CommandRequestAttributes.withTenant(tenantId)) {
        		results.add( function.execute(session, ImmutableList.<Object>of(tenantId)) );
        	}
        }
        return results;
    }

}
