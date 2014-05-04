package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Returns number of {@link AccountStatus#VERIFIED} accounts.
 * @author ceefour
 */
public class VerifiedAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public VerifiedAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.VERIFIED.getLiteral());
	}

}
