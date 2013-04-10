package org.soluvas.ldap.person;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.metrics.FailTolerantGaugeDecorator;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;

import com.yammer.metrics.Metric;
import com.yammer.metrics.MetricRegistry;
import com.yammer.metrics.MetricSet;

/**
 * Gives all the gauges for a {@link LdapRepository} that supports {@link AccountStatus},
 * e.g. {@link SocialPerson}.
 * @author adri
 */
public class RepositoryAccountGaugeSet implements MetricSet {

	final LdapRepository<?> repo;
	
	public RepositoryAccountGaugeSet(LdapRepository<?> repo) {
		super();
		this.repo = repo;
	}

	/* (non-Javadoc)
	 * @see com.yammer.metrics.MetricSet#getMetrics()
	 */
	@Override
	public Map<String, Metric> getMetrics() {
		final Map<String, Metric> metrics = new HashMap<>();
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "totalCount"),
				new FailTolerantGaugeDecorator<>(
					new TotalAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "activeCount"),
				new FailTolerantGaugeDecorator<>(
					new ActiveAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "draftCount"),
				new FailTolerantGaugeDecorator<>(
					new DraftAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "inactiveCount"),
				new FailTolerantGaugeDecorator<>(
					new InactiveAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "validatedCount"),
				new FailTolerantGaugeDecorator<>(
					new ValidatedAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "verifiedCount"),
				new FailTolerantGaugeDecorator<>(
					new VerifiedAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		metrics.put(MetricRegistry.name(LdapRepository.class, "person", "voidCount"),
				new FailTolerantGaugeDecorator<>(
					new VoidAccountCountGauge(1, TimeUnit.MINUTES, repo)));
		return metrics;
	}

}
