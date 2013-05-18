package org.soluvas.twitter.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Authenticate OAuth verifier code given by {@link Twitter}
 * and returns {@link AccessToken}. 
 * @author rudi
 */
@Service @Scope("prototype")
@Command(scope="twitter", name="auth", description="Authenticate OAuth verifier code given by Twitter and returns access token.")
public class TwitterAuthCommand extends ExtCommandSupport {
	
	@Option(name="-c", required=true, description="Twitter OAuth Consumer key.")
	private String consumerKey;
	@Option(name="-s", required=true, description="Twitter OAuth Consumer secret.")
	private String consumerSecret;
	@Argument(index=0, name="requestToken", required=true, description="OAuth Request token.")
	private String requestTokenCode;
	@Argument(index=1, name="verifier", required=true, description="OAuth verifier code.")
	private String verifier;
	
	@Override
	protected Object doExecute() throws Exception {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		final RequestToken requestToken = new RequestToken(requestTokenCode, "");
		final AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
		System.out.println(ansi().render("Access Token:        @|bold %s|@", accessToken.getToken()));
		System.out.println(ansi().render("Access Token Secret: @|bold %s|@", accessToken.getTokenSecret()));
		System.out.println(ansi().render("User ID:             @|bold %s|@", accessToken.getUserId()));
		System.out.println(ansi().render("Screen Name:         @|bold %s|@", accessToken.getScreenName()));
		return accessToken;
	}

}
