/**
 */
package org.soluvas.commons;

import com.google.common.base.MoreObjects;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.joda.time.DateTime;

import java.io.Serializable;

public class Email2 implements Serializable {
	protected String email;
	protected Boolean primary;
	protected DateTime validationTime;

	public Email2() {
		super();
	}

	public Email2(String email, boolean primary) {
		super();
		this.email = email;
		this.primary = primary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public DateTime getValidationTime() {
		return validationTime;
	}

	public void setValidationTime(DateTime validationTime) {
		this.validationTime = validationTime;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues()
				.add("email", email)
				.add("primary", primary)
				.add("validationTime", validationTime)
				.toString();
	}
}
