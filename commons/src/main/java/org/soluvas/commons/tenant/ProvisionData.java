package org.soluvas.commons.tenant;

import java.io.Serializable;

import javax.annotation.Nullable;

/**
 * Base class for provision data. These are general attributes, a {@link TenantProvisioner}
 * may not be using all of them. This class should be subclassed.
 * @author ceefour
 * @see TenantRepository
 * @see DirectoryTenantRepository
 * @see TenantProvisioner
 */
public class ProvisionData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Nullable
	private String mongoPassword;
	@Nullable
	private String defaultStyle;
	@Nullable
	private String adminPersonId;
	@Nullable
	private String adminPassword;
	@Nullable
	private String adminEmail;
	
	/**
	 * @return the defaultStyle
	 */
	public String getDefaultStyle() {
		return defaultStyle;
	}
	
	/**
	 * @param defaultStyle the defaultStyle to set
	 */
	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}
	
	/**
	 * @return the adminPersonId
	 */
	public String getAdminPersonId() {
		return adminPersonId;
	}
	
	/**
	 * @param adminPersonId the adminPersonId to set
	 */
	public void setAdminPersonId(String adminPersonId) {
		this.adminPersonId = adminPersonId;
	}
	
	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	
	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * @return the mongoPassword
	 */
	public String getMongoPassword() {
		return mongoPassword;
	}

	/**
	 * @param mongoPassword the mongoPassword to set
	 */
	public void setMongoPassword(String mongoPassword) {
		this.mongoPassword = mongoPassword;
	}

	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}

	/**
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	@Override
	public String toString() {
		return "ProvisionData ["
				+ (mongoPassword != null ? "mongoPassword=" + mongoPassword
						+ ", " : "")
				+ (defaultStyle != null ? "defaultStyle=" + defaultStyle + ", "
						: "")
				+ (adminPersonId != null ? "adminPersonId=" + adminPersonId
						+ ", " : "")
				+ (adminPassword != null ? "adminPassword=" + adminPassword
						+ ", " : "")
				+ (adminEmail != null ? "adminEmail=" + adminEmail : "") + "]";
	}
	
}
