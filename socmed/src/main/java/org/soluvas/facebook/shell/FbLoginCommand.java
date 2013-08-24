package org.soluvas.facebook.shell;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.http.client.utils.URIBuilder;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.facebook.FacebookException;
import org.soluvas.facebook.FacebookManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

/**
 * Get login URI
 * @author rudi
 */
@Service @Scope("prototype")
@Command(scope="fb", name="login", description="Get login URI.")
public class FbLoginCommand extends ExtCommandSupport {
	
	@Option(name="-r", description="Redirect URI. Default is '{webAddress.baseUri}fb_recipient/'.")
	private String redirectUri;
	@Option(name="-s", description="Permissions to ask from this Facebook user.")
	private transient String scope = "read_stream,email,user_birthday,user_hometown,user_about_me,user_photos,user_religion_politics,user_relationships,user_work_history,user_education_history,user_website,offline_access,publish_stream,publish_actions,share_item";	
	@Argument(name="appId", required=false, description="Specify custom Facebook OAuth App ID, if not using FacebookManager configuration.")
	private String appId;
	
	@Override
	protected Object doExecute() throws Exception {
		final FacebookManager facebookMgr = getBean(FacebookManager.class);
		final WebAddress webAddress = getBean(WebAddress.class);

		if (redirectUri == null) {
			redirectUri = webAddress.getBaseUri() + "fb_recipient/";
		}
		final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
		final String realAppId = Optional.fromNullable(appId).or(facebookMgr.getAppId());
		try {
			final URIBuilder fbLoginUriBuilder = new URIBuilder(facebookRedirectUri);
			fbLoginUriBuilder.addParameter("client_id", realAppId);
			fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
			fbLoginUriBuilder.addParameter("scope", scope);
			final String fbLoginUri = fbLoginUriBuilder.toString();
			log.debug("facebook login uri {}", fbLoginUri);
			return fbLoginUri;
		} catch (final Exception ex) {
			throw new FacebookException("Error when building URI for " + realAppId, ex);
		}
	}

}
