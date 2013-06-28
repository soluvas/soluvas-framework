package com.soluvas.story.event;

import org.soluvas.push.CollectionAdd;
import org.soluvas.push.TrackableEvent;

import com.soluvas.story.impl.StoryManagerImpl;

/**
 * @todo masih proof of concept... yang penting bisa dulu
 * @deprecated belum dipakai, yang dipakai oleh {@link StoryManagerImpl} saat ini adalah {@link CollectionAdd}
 * @author rudi
 */
@Deprecated
public class StoryAdded extends TrackableEvent {

	public StoryAdded() {
		super();
	}

	public StoryAdded(String trackingId) {
		super(trackingId);
	}

}
