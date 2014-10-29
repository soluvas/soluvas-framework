package org.soluvas.schedule;

import java.text.MessageFormat;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.plugins.history.LoggingJobHistoryPlugin;
import org.slf4j.Logger;

/**
 * Enhanced Quartz {@link LoggingJobHistoryPlugin} that on {@link JobExecutionException}:
 * if {@link JobExecutionException#refireImmediately()}, uses {@link Logger#info(String)};
 * if not {@link JobExecutionException#refireImmediately()}, uses {@link Logger#error(String)}.
 * @author rudi
 */
public class LoggingJobHistoryPlugin2 extends LoggingJobHistoryPlugin {
	
	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
        Trigger trigger = context.getTrigger();
        
        if (jobException != null) {
        	String errMsg = jobException.getMessage();
        	Object[] args = new Object[] {
        			context.getJobDetail().getKey().getName(),
        			context.getJobDetail().getKey().getGroup(), new java.util.Date(),
        			trigger.getKey().getName(), trigger.getKey().getGroup(),
        			trigger.getPreviousFireTime(), trigger.getNextFireTime(),
        			Integer.valueOf(context.getRefireCount()), errMsg
        	};
        	if (jobException.refireImmediately() && getLog().isInfoEnabled()) {
                getLog().info(MessageFormat.format(getJobFailedMessage(), args), jobException); 
        	} else if (!jobException.refireImmediately() && getLog().isErrorEnabled()) {
        		getLog().error(MessageFormat.format(getJobFailedMessage(), args), jobException);
        	}
        } else {
            if (!getLog().isInfoEnabled()) {
                return;
            } 
            
            String result = String.valueOf(context.getResult());
            Object[] args =
                new Object[] {
                    context.getJobDetail().getKey().getName(),
                    context.getJobDetail().getKey().getGroup(), new java.util.Date(),
                    trigger.getKey().getName(), trigger.getKey().getGroup(),
                    trigger.getPreviousFireTime(), trigger.getNextFireTime(),
                    Integer.valueOf(context.getRefireCount()), result
                };
            
            getLog().info(MessageFormat.format(getJobSuccessMessage(), args));
        }
	}

}
