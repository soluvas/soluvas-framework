package org.soluvas.data.event;

import org.soluvas.data.Term;
import org.soluvas.push.TrackableEvent;

/**
 * @author rudi
 *
 */
public class ModifiedTermEvent extends TrackableEvent {
	
	private static final long serialVersionUID = 1L;
	
	private final String oldUName;
	private final Term term;

	public ModifiedTermEvent(String oldUName, Term term, String trackingId) {
		super(trackingId);
		this.oldUName = oldUName;
		this.term = term;
	}
	public String getOldUName() {
		return oldUName;
	}

	public Term getTerm() {
		return term;
	}

}
