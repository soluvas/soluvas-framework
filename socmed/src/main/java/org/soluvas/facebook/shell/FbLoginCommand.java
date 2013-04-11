package org.soluvas.facebook.shell;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.http.client.utils.URIBuilder;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Get login URI
 * @author rudi
 */
@Service @Scope("prototype")
@Command(scope="fb", name="login", description="Get login URI.")
public class FbLoginCommand extends ExtCommandSupport {
	
	@Option(name="-r", description="Redirect URI. Default is '{webAddress.baseUri}fb_recipient/'.")
	private String redirectUri;
	// TODO: default appId to properties
	@Option(name="-i", required=true, description="Facebook App ID.")
	private String appId;
	
	private final WebAddress webAddress;
	
	@Inject
	public FbLoginCommand(WebAddress webAddress) {
		super();
		this.webAddress = webAddress;
	}

	@Override
	protected Object doExecute() throws Exception {
		if (redirectUri == null) {
			redirectUri = webAddress.getBaseUri() + "fb_recipient/";
		}
		final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
		try {
			final URIBuilder fbLoginUriBuilder = new URIBuilder(facebookRedirectUri);
			fbLoginUriBuilder.addParameter("client_id", appId);
			fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
			fbLoginUriBuilder.addParameter("scope", "read_stream,email,user_birthday,user_hometown,user_about_me,user_photos,user_religion_politics,user_relationships,user_work_history,user_education_history,user_website,offline_access,publish_stream,publish_actions,share_item");
			final String fbLoginUri = fbLoginUriBuilder.toString();
			log.debug("facebook login uri {}", fbLoginUri);
			return fbLoginUri;
		} catch (final Exception ex) {
			throw new RuntimeException("Error when building a uri", ex);
		}
	}

}
