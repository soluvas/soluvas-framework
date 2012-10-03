package org.soluvas.facebook;


import java.io.Serializable;

/**
 * Value Object used for AJAX AutoCompletion.
 * @author rudi
 */
@SuppressWarnings("serial")
public class HintPerson implements Serializable {

	private String personId;
	private String slug;
	private String name;
	private String photoId;
	private String virtualMail;
	private Long fbId;
	
	public HintPerson() {
		super();
	}

	public HintPerson(String personId, String slug,
			String name, String photoId) {
		super();
		this.personId = personId;
		this.slug = slug;
		this.name = name;
		this.photoId = photoId;
	}
	
	public HintPerson(String personId, String slug,
			String name, String photoId, String virtualMail) {
		super();
		this.personId = personId;
		this.slug = slug;
		this.name = name;
		this.photoId = photoId;
		this.virtualMail = virtualMail;
	}
	
	public HintPerson(String personId, String slug,
			String name, String photoId, String virtualMail,
			Long fbId) {
		super();
		this.personId = personId;
		this.slug = slug;
		this.name = name;
		this.photoId = photoId;
		this.virtualMail = virtualMail;
		this.fbId = fbId;
	}
	
	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the photoId
	 */
	public String getPhotoId() {
		return photoId;
	}
	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	/**
	 * @return the virtualMail
	 */
	public String getVirtualMail() {
		return virtualMail;
	}

	/**
	 * @param virtualMail the virtualMail to set
	 */
	public void setVirtualMail(String virtualMail) {
		this.virtualMail = virtualMail;
	}

	/**
	 * @return the fbId
	 */
	public Long getFbId() {
		return fbId;
	}

	/**
	 * @param fbId the fbId to set
	 */
	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("HintPerson [personId=%s, slug=%s, name=%s, photoId=%s, virtualMail=%s, fbId=%s]",
						personId, slug, name, photoId, virtualMail, fbId);
	}

}
