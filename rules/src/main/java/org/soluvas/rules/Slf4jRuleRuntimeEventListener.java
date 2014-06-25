package org.soluvas.rules;

import org.apache.commons.lang3.StringUtils;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ceefour
 */
public class Slf4jRuleRuntimeEventListener implements
		RuleRuntimeEventListener {
	private static final Logger log = LoggerFactory
			.getLogger(Slf4jRuleRuntimeEventListener.class);

	/* (non-Javadoc)
	 * @see org.kie.api.event.rule.WorkingMemoryEventListener#objectInserted(org.kie.api.event.rule.ObjectInsertedEvent)
	 */
	@Override
	public void objectInserted(ObjectInsertedEvent event) {
		// getFactHandle()=5:6:1904201901:1904201901:6:DEFAULT:com.soluvas.wathkur.core.impl.ParticipantQuestionImpl@717fd0ad (creationTime: null, modificationTime: null, category: what_is_x), getObject()=com.soluvas.wathkur.core.impl.ParticipantQuestionImpl@717fd0ad (creationTime: null, modificationTime: null, category: what_is_x), getKnowledgeRuntime()=org.drools.core.impl.StatefulKnowledgeSessionImpl@715ad51a, getPropagationContext()=PhreakPropagationContext [entryPoint=EntryPoint::DEFAULT, factHandle=5:6:1904201901:1904201901:6:DEFAULT:com.soluvas.wathkur.core.impl.ParticipantQuestionImpl@717fd0ad (creationTime: null, modificationTime: null, category: what_is_x), leftTuple=null, originOffset=-1, propagationNumber=6, rule=null, type=0]]
		log.debug("Inserted {} obj={}", 
				StringUtils.abbreviateMiddle(event.getFactHandle().toString(), "…", 180),
				event.getObject());
	}

	/* (non-Javadoc)
	 * @see org.kie.api.event.rule.WorkingMemoryEventListener#objectUpdated(org.kie.api.event.rule.ObjectUpdatedEvent)
	 */
	@Override
	public void objectUpdated(ObjectUpdatedEvent event) {
		log.debug("Updated {}, old={}. obj={}", 
				StringUtils.abbreviateMiddle(event.getFactHandle().toString(), "…", 180), 
				StringUtils.abbreviateMiddle(event.getOldObject().toString(), "…", 100),
				event.getObject());
	}

	/* (non-Javadoc)
	 * @see org.kie.api.event.rule.WorkingMemoryEventListener#objectDeleted(org.kie.api.event.rule.ObjectDeletedEvent)
	 */
	@Override
	public void objectDeleted(ObjectDeletedEvent event) {
		log.debug("Deleted {}, old={}", 
				StringUtils.abbreviateMiddle(event.getFactHandle().toString(), "…", 180),
				event.getOldObject());
	}

}
