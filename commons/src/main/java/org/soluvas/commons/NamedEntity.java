package org.soluvas.commons;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.google.common.net.UrlEscapers;

/**
 * Useful for returning binary content that can be converted to Spring MVC {@link ResponseEntity}.
 * @author atang
 */
public class NamedEntity implements Serializable {

	public static final MediaType APPLICATION_PDF = MediaType.valueOf("application/pdf");

	private static final long serialVersionUID = 1L;
	
	private final MediaType contentType;
	private final byte[] body;
	private final String name;
	
	public NamedEntity(MediaType contentType, byte[] body, String name) {
		super();
		this.contentType = contentType;
		this.body = body;
		this.name = name;
	}

	public MediaType getContentType() {
		return contentType;
	}

	public byte[] getBody() {
		return body;
	}

	public String getName() {
		return name;
	}
	
	/**
	 * Converts the entity into {@link ResponseEntity} with proper {@code Content-Disposition} HTTP header
	 * using {@link #getName()}, URL-encoded.
	 * @param statusCode
	 * @return
	 */
	public ResponseEntity<byte[]> toInlineResponseEntity(HttpStatus statusCode) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(contentType);
		headers.set("Content-Disposition", "inline; filename=\"" + UrlEscapers.urlFragmentEscaper().escape(name) + "\"");
		return new ResponseEntity<>(body, headers, statusCode);
	}

	/**
	 * Uses {@link HttpStatus#OK}.
	 * @see #toInlineResponseEntity(HttpStatus)
	 */
	public ResponseEntity<byte[]> toInlineResponseEntity() {
		return toInlineResponseEntity(HttpStatus.OK);
	}
	
	public ResponseEntity<byte[]> toAttachmentResponseEntity(HttpStatus statusCode) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(contentType);
		headers.set("Content-Disposition", "attachment; filename=\"" + UrlEscapers.urlFragmentEscaper().escape(name) + "\"");
		return new ResponseEntity<>(body, headers, statusCode);
	}
	
	public ResponseEntity<byte[]> toAttachmentResponseEntity() {
		return toAttachmentResponseEntity(HttpStatus.OK);
	}

}
