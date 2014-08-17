package org.soluvas.email;

import org.apache.commons.mail.Email;
import org.soluvas.email.impl.EmailTemplate;

public class SendResult<T> {
	
	final EmailTemplate<T> template;
	final T model;
	final Email email;
	final String messageId;
	final Exception exception;
	
	public SendResult(EmailTemplate<T> template, T model, Email email,
			String messageId) {
		super();
		this.template = template;
		this.model = model;
		this.email = email;
		this.messageId = messageId;
		this.exception = null;
	}

	public SendResult(EmailTemplate<T> template, T model, Email email,
			Exception exception) {
		super();
		this.template = template;
		this.model = model;
		this.email = email;
		this.messageId = null;
		this.exception = exception;
	}
	
	public boolean isSuccessful() {
		return messageId != null;
	}

	/**
	 * @return the template
	 */
	public EmailTemplate<T> getTemplate() {
		return template;
	}

	/**
	 * @return the model
	 */
	public T getModel() {
		return model;
	}

	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}
	
}
