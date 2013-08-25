package org.soluvas.security.shell; 

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Lists {@link Realm}s for each tenant.
 * 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="sec", name="realmls", description="Lists Realms for each tenant.")
public class SecRealmLsCommand extends ExtCommandSupport {

	private static final Logger log = LoggerFactory.getLogger(SecRealmLsCommand.class);

	@Override
	protected Object doExecute() throws Exception {
		final Map<String, Realm> realmMap = beanFactory.getBean("realmMap", Map.class);
		System.out.println(ansi().render("@|negative_on %3s|%-15s|%-25s|%-15s|@",
				"№", "Tenant ID", "Class", "Name"));
		int i = 0;
		for (final Entry<String, Realm> entry : realmMap.entrySet()) {
			final Realm realm = entry.getValue();
			final String classAnsi = NameUtils.shortenClassAnsi(realm.getClass(), 25);
			System.out.println(ansi().render("@|bold,black %3d||@%-15s@|bold,black ||@" + classAnsi + "@|bold,black ||@%-15s",
				++i, entry.getKey(), realm.getName()));
		}
		System.out.println(ansi().render("@|bold %d|@ realms", i));
		return null;
	}

}