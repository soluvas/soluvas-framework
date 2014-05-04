package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Used as MBean to expose {@link AccountStatus#VOID} account counters.
 * @author ceefour
 */
public class VoidAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public VoidAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.VOID.getLiteral());
	}

}
