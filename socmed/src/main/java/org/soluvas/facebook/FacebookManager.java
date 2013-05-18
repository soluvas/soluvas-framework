package org.soluvas.facebook;

import org.soluvas.facebook.shell.FbPageCommand;

import com.restfb.types.Page;
import com.restfb.types.User;

public interface FacebookManager {

	/**
	 * App ID to authenticate users (Facebook Connect) and also to publish posts/activities.
	 * @return
	 */
	public String getAppId();

	/**
	 * App Secret for the corresponding {@link #getAppId()}.
	 * @return
	 */
	public String getAppSecret();

	/**
	 * The default Facebook {@link Page} access token for the app, that is used to post as Page to the Facebook Page
	 * pointed by {@link #getPageId()}.
	 * To get this page access token, use {@literal fb:page} shell command ({@link FbPageCommand}).
	 * @return
	 */
	public String getPageAccessToken();

	/**
	 * The default Facebook {@link Page} ID or username for the app.
	 * Note that if you use the page access token provided by {@link #getPageAccessToken()},
	 * it is sufficient to use the {@literal /me} connection.
	 * However this is still useful if you want to publish to this page using a Facebook {@link User}'s access token.
	 * @return
	 */
	public String getPageId();

}