package org.soluvas.image.store;

import java.io.File;
import java.io.Serializable;

/**
 * Value Object to comply with Soluvas Data during Repository.add().
 * @author ceefour
 */
@SuppressWarnings("serial")
public class NewImage implements Serializable {

	private File originalFile;
	private String contentType;
	private String name;
	
	public NewImage() {
		super();
	}

	public NewImage(File originalFile, String contentType, String name) {
		super();
		this.originalFile = originalFile;
		this.contentType = contentType;
		this.name = name;
	}

	public File getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(File originalFile) {
		this.originalFile = originalFile;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format(
				"NewImage [originalFile=%s, contentType=%s, name=%s]",
				originalFile, contentType, name);
	}
	
}
