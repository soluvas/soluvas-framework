package org.soluvas.email.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.List;

import javax.inject.Inject;
import javax.mail.Session;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.email.EmailFactory;
import org.soluvas.email.EmailManager;
import org.soluvas.email.EmailSecurity;
import org.soluvas.email.Sender;
import org.soluvas.email.builtin.Tester;
import org.soluvas.email.impl.SenderImpl;
import org.soluvas.email.util.EmailUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

/**
 * Sends a test email, to check SMTP settings, layout, app logo, Mustache variable replacement.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="email", name="test", description="Sends a test email, to check SMTP settings, layout, app logo, Mustache variable replacement.")
public class EmailTestCommand extends ExtCommandSupport {
	
	@Option(name="-n", description="Name of the recipient.")
	private final String recipientName = "You Gorgeous Member";
	@Option(name="-r", description="Role of the recipient.")
	private final String recipientRole = "our big fan";
	@Option(name="-t", description="Title content, which will become part of email subject.")
	private final String title = "You are so amazing!";
	@Option(name="-m", description="Message content, which will become part of email body.")
	private final String message = "I am not kidding ;-)";
	@Option(name="-g", description="Also add the general email as recipient as '${appManifest.title} administrator'.")
	private transient boolean alsoGeneral = false;
	@Option(name="--host", description="Use a different SMTP host in the MailSession.")
	private String smtpHost;
	@Option(name="--port", description="Use a different SMTP port in the MailSession. 25 for plain, 465 for SSL, 587 for STARTTLS. (Amazon SES seems to only support 465 and 587, port 25 always times out).")
	private Integer smtpPort;
	@Option(name="--user", description="Use a different SMTP user in the MailSession. 'mail.smtp.auth' will be set to true.")
	private String smtpUser;
	@Option(name="--password", description="Use a different SMTP password in the MailSession. 'mail.smtp.auth' will be set to true.")
	private String smtpPassword;
	@Option(name="--sec", description="NONE|STARTTLS|SSL. STARTTLS sets 'mail.smtp.starttls.enable' to true. (Amazon SES supports this at port 587) " +
			"SSL sets 'mail.smtp.socketFactory.class' to 'javax.net.ssl.SSLSocketFactory'. (Amazon SES only supports this at port 465)")
	private EmailSecurity smtpSecurity;
	@Option(name="--from", description="Set a different sender email.")
	private String from;
	@Option(name="--fromname", description="Set a different sender name.")
	private String fromName;
	@Argument(name="recipientEmail", required=false, description="Where to send the email, by default it will send to ${appManifest.generalEmail}.")
	private String recipientEmail;
	
	private final EmailManager emailMgr;
	private final AppManifest appManifest;
	
	@Inject
	public EmailTestCommand(EmailManager emailMgr, AppManifest appManifest) {
		super();
		this.emailMgr = emailMgr;
		this.appManifest = appManifest;
	}

	@Override
	protected Object doExecute() throws Exception {
		final String realRecipientEmail = Optional.fromNullable(recipientEmail).or(appManifest.getGeneralEmail());
		log.info("Sending test email to {} <{}> as {} titled {}",
				recipientName, realRecipientEmail, recipientRole, title);
		System.out.println(ansi().render("Sending test email to @|bold %s|@ <@|bold %s|@> as @|bold %s|@ titled @|yellow %s|@...",
				recipientName, realRecipientEmail, recipientRole, title));
		final Tester tester = emailMgr.createPage(Tester.class);
		tester.setTitle(title);
		tester.setMessage(message);
		if (from != null) {
			final Sender sender = new SenderImpl();
			sender.setEmail(from);
			sender.setFrom(Optional.fromNullable(fromName).or(from));
			tester.setSender(sender);
		}
		
		tester.getRecipients().add(EmailFactory.eINSTANCE.createRecipient(recipientName, realRecipientEmail, recipientRole));
		if (alsoGeneral) {
			tester.getRecipients().add(EmailFactory.eINSTANCE.createRecipient(
					appManifest.getTitle() + " administrator", appManifest.getGeneralEmail(), 
					appManifest.getTitle() + " administrator"));
		}
		
		final List<String> sent;
		if (smtpHost != null || smtpPort != null || smtpUser != null || smtpPassword != null || smtpSecurity != null) {
			final Session customMailSession = EmailUtils.createSmtpSession(smtpHost, smtpPort, 
					smtpUser, smtpPassword, smtpSecurity);
			sent = emailMgr.sendAll(tester, customMailSession);
		} else {
			sent = emailMgr.sendAll(tester);
		}
		
		log.info("Sent {} test emails to {} <{}> as {} titled {}: {}",
				sent.size(), recipientName, recipientEmail, recipientRole, title, sent);
		
		return sent;
	}

}
