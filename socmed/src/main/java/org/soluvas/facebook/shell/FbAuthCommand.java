package org.soluvas.facebook.shell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.facebook.FacebookException;
import org.soluvas.facebook.FacebookManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

/**
 * Authorize OAuth verifier code and get access token.
 * @author rudi
 */
@Service @Scope("prototype")
@Command(scope="fb", name="auth", description="Authorize OAuth verifier code and get access token.")
public class FbAuthCommand extends ExtCommandSupport {
	
	@Option(name="--appid", description="Specify custom Facebook OAuth App ID, if not using FacebookManager configuration.")
	private String appId;
	@Option(name="--appsecret", description="Specify custom Facebook OAuth App Secret, if not using FacebookManager configuration.")
	private String appSecret;
	@Option(name="-r", description="Redirect URI. Default is '{webAddress.baseUri}fb_recipient/'.")
	private String redirectUri;
	@Argument(name="code", required=false, description="Verification code after login.")
	private String code;

	@Override
	protected Object doExecute() throws Exception {
		final FacebookManager facebookMgr = getBean(FacebookManager.class);
		final WebAddress webAddress = getBean(WebAddress.class);

		if (redirectUri == null) {
			redirectUri = webAddress.getBaseUri() + "fb_recipient/";
		}
		final String accessToken = fetchAccessToken(facebookMgr, appId, appSecret, redirectUri, code);
		return accessToken;
	}

	public String fetchAccessToken(FacebookManager facebookMgr, String appId, String appSecret, String redirectUri, String code) {
		final String realAppId = Optional.fromNullable(appId).or(facebookMgr.getAppId());
		final String realAppSecret = Optional.fromNullable(appSecret).or(facebookMgr.getAppSecret());
		final String accessTokenUriStr;
		try {
			final URIBuilder accessTokenUri = new URIBuilder("https://graph.facebook.com/oauth/access_token");
			accessTokenUri.addParameter("client_id", realAppId);
			accessTokenUri.addParameter("client_secret", realAppSecret);
			accessTokenUri.addParameter("redirect_uri", redirectUri);
//			accessTokenUri.addParameter("code", code);
			accessTokenUriStr = accessTokenUri.build().toString();
		} catch (final Exception ex) {
			throw new FacebookException("Error when building Facebook URI for appId " + 
				realAppId + " and redirectUri " + redirectUri, ex);
		}
		final HttpGet accessTokenUriRequest = new HttpGet(accessTokenUriStr);
		try (final CloseableHttpClient client = HttpClients.createDefault()) {
			try (final CloseableHttpResponse responseAccessTokenReq = client.execute(accessTokenUriRequest)) {
				if (responseAccessTokenReq.getStatusLine().getStatusCode() != 200)
					throw new IOException(String.format(
							"GET %s throws HTTP Error %d: %s", accessTokenUriRequest, responseAccessTokenReq
							.getStatusLine().getStatusCode(), responseAccessTokenReq
							.getStatusLine().getReasonPhrase()));
				final Scanner scanner = new Scanner(responseAccessTokenReq.getEntity().getContent());
				final List<NameValuePair> data = new ArrayList<>();
				URLEncodedUtils.parse(data, scanner, "UTF-8");
				
				final String accessToken = data.get(0).getValue();
				return accessToken;
			} catch (Exception e) {
				throw new FacebookException("Cannot get access token for appId " + realAppId + 
						" and redirectUri " + redirectUri + ": " + e, e);
			}
		} catch (IllegalStateException | IOException e) {
			throw new FacebookException("Cannot get access token for appId " + realAppId + 
					" and redirectUri " + redirectUri + ": " + e, e);
		}
	}
	
}
