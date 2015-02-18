package org.soluvas.facebook;

import com.restfb.Facebook;

/**
 * @author rudi
 *
 */
public class FqlLiker {

	@Facebook("user_id")
	private String userId;

	@Override
	public String toString() {
		return userId;
	}

}
