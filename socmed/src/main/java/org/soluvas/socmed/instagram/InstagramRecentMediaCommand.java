package org.soluvas.socmed.instagram;

import java.util.List;
import java.util.concurrent.Callable;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.users.feed.MediaFeed;
import org.soluvas.json.JsonUtils;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * Get the most recent media published by a user. May return a mix of both image and video types.
 * http://instagram.com/developer/endpoints/users/
 * 
 * @author ceefour
 */
@Parameters(commandNames=InstagramRecentMediaCommand.CMD, commandDescription="Get the most recent media published by a user. May return a mix of both image and video types.")
public class InstagramRecentMediaCommand implements Callable<MediaFeed> {
	
	public static final String CMD = "instarecentmedia";
	
	@Parameter(description="User ID.")
	List<String> userIds;
	@Parameter(names="-a", description="Instagram Access Token.")
	String accessToken;

	@Override
	public MediaFeed call() throws Exception {
		final Instagram instagram = new Instagram(new Token(accessToken, null));
		final MediaFeed medias = instagram.getRecentMediaFeed(userIds.get(0));
		System.out.println("Meta: " + medias.getMeta());
		System.out.println("Headers: " + medias.getHeaders());
		System.out.println("API limit status: " + medias.getAPILimitStatus());
		System.out.println("Remaining limit status: " + medias.getRemainingLimitStatus());
		System.out.println("Pagination: " + medias.getPagination());
		System.out.println(JsonUtils.asJson(medias.getData()));
		return medias;
	}
	
}
