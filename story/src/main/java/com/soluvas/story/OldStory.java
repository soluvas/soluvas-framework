package com.soluvas.story;

import java.io.Serializable;
import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * kelas ini digunakan untuk simulasi tabel
 * @author atang
 */
@Entity
public class OldStory implements Serializable {
	
	public enum Status {
		/**
		 * Active story.
		 */
		ACTIVE,
		
		/**
		 * Deleted story, e.g. comment has been deleted.
		 */
		INACTIVE
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * @todo Rename to schemaVersion. entityVersion/Revision may refer to
	 * that entity's (not schema's) own version.
	 */
	@SuppressWarnings("unused")
	private final long entityVersion = serialVersionUID;
	@Id private String id;
	private String subject;
	private boolean publicized;
	private String kind;
	private Date created;
	private Status status;

	public OldStory() {
		super();
	}
	
	public OldStory(String id, String subject, boolean publicized,
			String kind, Status status) {
		super();
		this.id = id;
		this.subject = subject;
		this.publicized = publicized;
		this.kind = kind;
		this.created = new Date();
		this.status = status;		
	}

	public boolean isPublicized() {
		return publicized;
	}

	public void setPublicized(boolean publicized) {
		this.publicized = publicized;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Story [id=%s, subject=%s, publicized=%s, kind=%s, created=%s, status=%s]",
						id, subject, publicized, kind, created, status);
	}

}
