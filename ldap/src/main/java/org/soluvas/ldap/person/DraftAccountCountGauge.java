package org.soluvas.ldap.person;

import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.ldap.LdapRepository;

import com.codahale.metrics.CachedGauge;

/**
 * Returns number of {@link AccountStatus#DRAFT} accounts.
 * @author adri
 */
public class DraftAccountCountGauge extends CachedGauge<Long> {
	
	final LdapRepository<?> repo;
	
	public DraftAccountCountGauge(long timeout, TimeUnit timeoutUnit, LdapRepository<?> repo) {
		super(timeout, timeoutUnit);
		this.repo = repo;
	}

	@Override
	protected Long loadValue() {
		return repo.countByAttribute("accountStatus", AccountStatus.DRAFT.getLiteral());
	}

}
