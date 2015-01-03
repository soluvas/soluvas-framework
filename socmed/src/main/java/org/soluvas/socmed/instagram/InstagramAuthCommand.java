package org.soluvas.socmed.instagram;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.concurrent.Callable;

import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author ceefour
 *
 */
@Parameters(commandNames=InstagramAuthCommand.CMD, commandDescription="Authenticate Instagram app and get access token")
public class InstagramAuthCommand implements Callable<InstagramAuthResult> {
	
	public static final String CMD = "instaauth";
	
	@Parameter(names="-i", description="Instagram App ID")
	String appId;
	@Parameter(names="-s", description="Instagram App Secret")
	String appSecret;
	@Parameter(names="-c", description="Instagram Callback URI")
	String authUri;
	@Parameter(names="--scope", description="Instagram Authorization Scope")
	String scope;

	@Override
	public InstagramAuthResult call() throws Exception {
		final InstagramAuthService instab = new InstagramAuthService().apiKey(appId).apiSecret(appSecret).callback(authUri);
		if (scope != null) {
			instab.scope(scope);
		}
		final InstagramService instagram = instab.build();
		final String authorizationUrl = instagram.getAuthorizationUrl(null);
		System.out.println(ansi().render("API Key: @|bold %s|@", appId));
		System.out.println(ansi().render("Callback URI: @|bold %s|@", authUri));
		System.out.println(ansi().render("Please login now using your browser at: @|bold %s|@", authorizationUrl));
		System.out.print(ansi().render("When finished, enter the @|bold code|@ part here: "));
		final Verifier verifier = new Verifier(System.console().readLine().trim());
		final Token accessToken = instagram.getAccessToken(null, verifier);
		System.out.println(ansi().render("Access token: @|bold %s|@", accessToken.getToken()));
		return new InstagramAuthResult(accessToken.getToken());
	}
	
}
