package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Used as MBean to expose total LDAP entity counters.
 * @author adri
 */
public class TotalAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public TotalAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.count();
	}

}
