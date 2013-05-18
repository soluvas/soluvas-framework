package org.soluvas.twitter.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

/**
 * Returns URI to be used for OAuth login.
 * @author rudi
 */
@Service @Scope("prototype")
@Command(scope="twitter", name="login", description="Get request token and authentication URI.")
public class TwitterLoginCommand extends ExtCommandSupport {
	
	@Option(name="-c", required=true, description="Twitter OAuth Consumer key.")
	private String consumerKey;
	@Option(name="-s", required=true, description="Twitter OAuth Consumer secret.")
	private String consumerSecret;
	@Option(name="-d", required=true, description="Application domain, e.g. 'aksimata.com'. The redirect URI will be 'http://www.${domain}/twitter_recipient/")
	private String domain;
	
	@Override
	protected Object doExecute() throws Exception {
		final Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		final String redirectUri = "http://www." + domain + "/twitter_recipient/";
		final RequestToken requestToken = twitter.getOAuthRequestToken(redirectUri);
		System.out.println(ansi().render("Request Token:        @|bold %s|@", requestToken.getToken()));
		System.out.println(ansi().render("Request Token Secret: @|bold %s|@", requestToken.getTokenSecret()));
		System.out.println(ansi().render("Authentication URI:   @|bold %s|@", requestToken.getAuthenticationURL()));
		return requestToken;
	}

}
