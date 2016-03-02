/**
 */
package org.soluvas.commons;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Type of <a href="https://schema.org/telephone">schema:telephone</a>.
 */
public class PhoneNumber2 implements Serializable {
    protected String phoneNumber;
    protected Boolean primary;
    protected DateTime validationTime;

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
