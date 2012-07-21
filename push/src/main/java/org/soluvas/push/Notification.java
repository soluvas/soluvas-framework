package org.soluvas.push;

import java.io.Serializable;

/**
 * General purpose growl-like notification value object.
 * 
 * It is similar to JSF's FacesMessage or SLF4J logging event.
 * @author ceefour
 * @deprecated Please use {@link Story}.
 */
@SuppressWarnings("serial")
@Deprecated
public class Notification implements Serializable {

	private String message;
	private String richMessage;
	private String category = "info"; 
	private String uri;
	
	public Notification(String message, String category) {
		super();
		this.message = message;
		this.category = category;
	}

	public Notification(String message) {
		super();
		this.message = message;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Plain-text message.
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Notification [category=%s, message=%s]",
				category, message);
	}

	/**
	 * URI destination when the notification is clicked. (optional)
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * HTML+RDFa formatted message. (optional)
	 * @return
	 */
	public String getRichMessage() {
		return richMessage;
	}

	public void setRichMessage(String richMessage) {
		this.richMessage = richMessage;
	}
	
}