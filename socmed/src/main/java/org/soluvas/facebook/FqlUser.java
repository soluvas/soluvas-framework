package org.soluvas.facebook;

import com.restfb.Facebook;

/**
 * @author rudi
 *
 */
public class FqlUser {

	@Facebook
	private String uid;

	@Facebook
	private String name;

	@Override
	public String toString() {
		return String.format("%s (%s)", name, uid);
	}

}
