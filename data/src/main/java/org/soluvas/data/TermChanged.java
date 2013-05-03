package org.soluvas.data;

import org.soluvas.push.TrackableEvent;

/**
 * Posted by {@link TermRepository}.
 * @author adri
 */
public class TermChanged extends TrackableEvent {
	
	private static final long serialVersionUID = 1L;
	private final String kindNsPrefix;
	private final String kindName;

	public TermChanged(String trackingId, String kindNsPrefix, String kindName) {
		super(trackingId);
		this.kindNsPrefix = kindNsPrefix;
		this.kindName = kindName;
	}

	@Override
	public String toString() {
		return "TermChanged ["
				+ (kindNsPrefix != null ? "kindNsPrefix=" + kindNsPrefix + ", "
						: "")
				+ (kindName != null ? "kindName=" + kindName : "") + "]";
	}

}
