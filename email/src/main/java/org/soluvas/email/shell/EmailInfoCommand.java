package org.soluvas.email.shell;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.email.EmailManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Get current {@link EmailManager} configuration.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="email", name="info", description="Get current {@link EmailManager} configuration.")
public class EmailInfoCommand extends ExtCommandSupport {
	
	private final EmailManager emailMgr;
	
	@Inject
	public EmailInfoCommand(EmailManager emailMgr) {
		super();
		this.emailMgr = emailMgr;
	}

	@Override
	protected Object doExecute() throws Exception {
		return emailMgr;
	}

}
