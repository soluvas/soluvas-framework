package org.soluvas.socmed.instagram;

/**
 * @author ceefour
 *
 */
public class InstagramAuthResult {
	
	private final String accessToken;

	public InstagramAuthResult(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}
	
}
