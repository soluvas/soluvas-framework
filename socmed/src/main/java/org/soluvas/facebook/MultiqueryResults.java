package org.soluvas.facebook;

import java.util.List;

import com.restfb.Facebook;

/**
 * @author rudi
 *
 */
public class MultiqueryResults {
	
	@Facebook
	private List<FqlUser> users;

	@Facebook
	private List<FqlLiker> likers;

	@Override
	public String toString() {
		return "MultiqueryResults [users=" + users + ", likers=" + likers + "]";
	}

}
