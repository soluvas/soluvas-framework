/**
 */
package org.soluvas.commons;

import com.google.common.base.MoreObjects;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Email2 implements Serializable {
	protected String email;
	protected Boolean primary;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Email2 email2 = (Email2) o;
		return Objects.equals(email, email2.email) &&
				Objects.equals(primary, email2.primary) &&
				Objects.equals(validationTime, email2.validationTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, primary, validationTime);
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
