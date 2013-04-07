package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.yammer.metrics.CachedGauge;

/**
 * Returns count of {@link AccountStatus#INACTIVE} accounts.
 * @author adri
 */
public class InactiveAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public InactiveAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.INACTIVE.getLiteral());
	}

}
