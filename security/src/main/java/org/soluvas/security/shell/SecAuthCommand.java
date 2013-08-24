package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.security.AutologinToken;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Performs a {@link SecurityManager#authenticate(org.apache.shiro.authc.AuthenticationToken)} test.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sec", name="auth", description="Performs an authenticate() test.")
public class SecAuthCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecAuthCommand.class);

	@Option(name="-a", aliases="--autologin", description="Uses the AutologinToken (which should always work).")
	private transient boolean autologin = false;
	
	@Argument(index=0, name="principal", required=false, 
			description="Username, slug, email, or other realm-specific recognized authentication principal.")
	private String principal;
	@Argument(index=1, name="password", required=false, 
			description="Password.")
	private String password;

	@Override
	protected AuthenticationInfo doExecute() throws Exception {
		final Realm realm = getBean(Realm.class);
		System.out.println(ansi().render("Using realm @|bold %s|@ (%s) to authenticate @|bold %s|@", 
				realm.getName(), realm.getClass().getName(), principal));
		final DefaultSecurityManager securityMgr = new DefaultSecurityManager(realm);
		final AuthenticationToken token;
		if (autologin) {
			token = new AutologinToken(principal);
		} else {
			token = new UsernamePasswordToken(principal, password);
		}
		final AuthenticationInfo authInfo = securityMgr.authenticate(token);
		return authInfo;
	}

}