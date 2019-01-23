/**
 */
package org.soluvas.commons;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

import org.joda.time.DateTime;

import com.google.code.morphia.annotations.Id;

/**
 * Type of <a href="https://schema.org/telephone">schema:telephone</a>.
 */
@Embeddable
public class PhoneNumber2 implements Serializable {
	@Id
	protected String id;
    protected String phoneNumber;
    protected Boolean primary;
    protected DateTime validationTime;

    public PhoneNumber2() {
		super();
	}

	public PhoneNumber2(String phoneNumber, Boolean primary) {
		super();
		this.id = UUID.randomUUID().toString();
		this.phoneNumber = phoneNumber;
		this.primary = primary;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
