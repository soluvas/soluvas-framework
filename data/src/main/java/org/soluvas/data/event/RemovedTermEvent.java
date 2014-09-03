package org.soluvas.data.event;

import org.soluvas.data.Term;
import org.soluvas.push.TrackableEvent;

/**
 * @author rudi
 *
 */
public class RemovedTermEvent extends TrackableEvent {
	
	private static final long serialVersionUID = 1L;
	
	private final Term term;

	public RemovedTermEvent(Term term, String trackingId) {
		super(trackingId);
		this.term = term;
	}

	public Term getTerm() {
		return term;
	}

}
