package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Returns count of {@link AccountStatus#ACTIVE} accounts.
 * @author adri
 */
public class ActiveAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public ActiveAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.ACTIVE.getLiteral());
	}

}
