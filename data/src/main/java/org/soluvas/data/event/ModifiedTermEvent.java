package org.soluvas.data.event;

import org.soluvas.data.Term;
import org.soluvas.push.TenantEvent;

/**
 * @author rudi
 *
 */
public class ModifiedTermEvent extends TenantEvent {
	
	private static final long serialVersionUID = 1L;
	
	private final String oldUName;
	private final Term term;

	public ModifiedTermEvent(String oldUName, Term term, String tenantId, String trackingId) {
		super(tenantId, trackingId);
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
