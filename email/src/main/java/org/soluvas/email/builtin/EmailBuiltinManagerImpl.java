package org.soluvas.email.builtin;

import java.util.UUID;

import javax.inject.Inject;

import org.soluvas.email.builtin.event.FeedbackToAdminEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.google.common.eventbus.EventBus;

/**
 * @author haidar
 *
 */
@Service("emailBuiltinMgr") @Lazy
public class EmailBuiltinManagerImpl implements EmailBuiltinManager {
	
	private final EventBus eventBus;
	
	@Inject
	public EmailBuiltinManagerImpl(EventBus eventBus) {
		super();
		this.eventBus = eventBus;
	}

	@Override
	public void sendEmailFeedbackToAdmin(Contact contact) {
		final FeedbackToAdminEvent ev = new FeedbackToAdminEvent(contact, UUID.randomUUID().toString());
		eventBus.post(ev);
	}


}
