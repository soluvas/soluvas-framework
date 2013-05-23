package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Returns count of {@link AccountStatus#VALIDATED} accounts.
 * @author adri
 */
public class ValidatedAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public ValidatedAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.VALIDATED.getLiteral());
	}

}
