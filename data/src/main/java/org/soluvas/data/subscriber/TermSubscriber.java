package org.soluvas.data.subscriber;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;
import org.soluvas.data.event.AddedTermEvent;
import org.soluvas.data.event.ModifiedTermEvent;
import org.soluvas.data.event.RemovedTermEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.eventbus.Subscribe;

/**
 * @author rudi
 *
 */
@Service @Scope("prototype")
public class TermSubscriber {
	
	private static final Logger log = LoggerFactory
			.getLogger(TermSubscriber.class);
	
	private final TermManager termManager;

	@Inject
	public TermSubscriber(TermManager termManager) {
		this.termManager = termManager;
	}
	
	@Subscribe
	public void addNewTermToDataCatalogForTermManager(final AddedTermEvent ev) {
		final Term addedTerm = ev.getTerm();
		
		log.debug("{} --> Adding to TermManager's dataCatalog ({} rows) for term: {}", ev.getTenantId(), termManager.getDataCatalog().getTerms().size(), addedTerm);
		termManager.getDataCatalog().getTerms().add(addedTerm);
//		log.debug("Now terms on dataCatalog is {} rows", termManager.getDataCatalog().getTerms().size());
	}
	
	@Subscribe
	public void modifyTermOnDataCatalogForTermManager(final ModifiedTermEvent ev) {
		final Term modifiedTerm = ev.getTerm();
		final String oldUName = ev.getOldUName();
		
		log.debug("{} --> Modifying {} on TermManager's dataCatalog to modified term: {}", ev.getTenantId(), oldUName, modifiedTerm);
		final Term curTerm = Iterables.find(termManager.getDataCatalog().getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(Term input) {
				return input.getQName().equals(oldUName);
			}
		});
		termManager.getDataCatalog().getTerms().remove(curTerm);
		termManager.getDataCatalog().getTerms().add(modifiedTerm);
	}
	
	@Subscribe
	public void removeTermOnDataCatalogForTermManager(final RemovedTermEvent ev) {
		final Term removedTerm = ev.getTerm();
		
		log.debug("{} --> Removing TermManager's dataCatalog for term: {}", ev.getTenantId(), removedTerm);
		termManager.getDataCatalog().getTerms().remove(removedTerm);
	}

}
