package org.soluvas.security.shell; 

import java.util.Map;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Test login using the specified {@link Realm}.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sec", name="login", description="Tests login using the specified Realm.")
public class SecLoginCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecLoginCommand.class);
	
	@Option(name="-h", aliases="--host", description="Host for AuthenticationToken which the same as Tenant ID, e.g. acme. A null host will authenticate against the app realm.")
	private transient String host = null;
	
	@Argument(index=0, name="username", required=true, description="Username.")
	private String username;
	@Argument(index=1, name="password", required=false, description="Password.")
	private transient String password = "";

	@Override
	protected Object doExecute() throws Exception {
		final Map<String, Realm> realmMap = appCtx.getBean("realmMap", Map.class);
		final DefaultSecurityManager securityMgr = new DefaultSecurityManager(realmMap.values());
		final Subject subject = securityMgr.createSubject(new DefaultSubjectContext());
		subject.login(new UsernamePasswordToken(username, password, host));
		return subject.getPrincipal();
	}

}