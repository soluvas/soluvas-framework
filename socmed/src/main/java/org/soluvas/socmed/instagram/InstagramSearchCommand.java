package org.soluvas.socmed.instagram;

import java.util.List;
import java.util.concurrent.Callable;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.users.feed.UserFeed;
import org.soluvas.json.JsonUtils;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.google.common.base.Joiner;

/**
 * Search for users.
 * http://instagram.com/developer/endpoints/users/
 * 
 * @author ceefour
 */
@Parameters(commandNames=InstagramSearchCommand.CMD, commandDescription="Authenticate Instagram app and get access token")
public class InstagramSearchCommand implements Callable<UserFeed> {
	
	public static final String CMD = "instasearch";
	
	@Parameter(description="Query.")
	List<String> queries;
	@Parameter(names="-a", description="Instagram Access Token.")
	String accessToken;

	@Override
	public UserFeed call() throws Exception {
		final Instagram instagram = new Instagram(new Token(accessToken, null));
		final UserFeed users = instagram.searchUser(Joiner.on(' ').join(queries));
		System.out.println("Meta: " + users.getMeta());
		System.out.println("Headers: " + users.getHeaders());
		System.out.println("API limit status: " + users.getAPILimitStatus());
		System.out.println("Remaining limit status: " + users.getRemainingLimitStatus());
		System.out.println("Pagination: " + users.getPagination());
		System.out.println(JsonUtils.asJson(users.getUserList()));
		return users;
	}
	
}
