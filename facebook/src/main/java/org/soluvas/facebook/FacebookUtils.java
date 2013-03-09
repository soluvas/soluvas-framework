package org.soluvas.facebook;

import java.util.List;

public interface FacebookUtils {

	/**
	 * Get list of friends as HintPerson object.
	 * @param accessToken
	 * @return
	 */
	public abstract List<HintPerson> findFriends(String accessToken);

	public abstract List<HintPerson> findFriendsCached(String accessToken);

}