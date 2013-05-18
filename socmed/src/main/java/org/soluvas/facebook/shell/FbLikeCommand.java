package org.soluvas.facebook.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.FacebookAccessible;
import org.soluvas.commons.annotation.FacebookRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.EntityLookup;
import org.soluvas.facebook.FacebookManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.DefaultFacebookClient;
import com.restfb.types.Post.Likes;

/**
 * {@link Likes} an object on Facebook.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="fb", name="like", description="Likes an object on Facebook.")
public class FbLikeCommand extends ExtCommandSupport {
	
//	@Option(name="--appid", description="Specify custom Facebook OAuth App ID, if not using FacebookManager configuration.")
//	private String appId;
//	@Option(name="--appsecret", description="Specify custom Facebook OAuth App Secret, if not using FacebookManager configuration.")
//	private String appSecret;
	@Option(name="-i", description="Find the specified FacebookAccessible ID using @FacebookRelated EntityLookup to get the access token. Must be specified if not using -a and -t.")
	private String id;
	@Option(name="-t", description="OAuth Access Token for the posting Facebook user, must be specified if not using -i.")
	private String accessToken;
	
	@Argument(index=0, name="objectId", description="Object ID to like")
	private String objectId;

	private final FacebookManager facebookMgr;
	private final EntityLookup<FacebookAccessible, String> lookup;
	
	@Inject
	public FbLikeCommand(FacebookManager facebookMgr, @FacebookRelated EntityLookup<FacebookAccessible, String> lookup) {
		super();
		this.facebookMgr = facebookMgr;
		this.lookup = lookup;
	}

	@Override
	protected Object doExecute() throws Exception {
		Preconditions.checkArgument(id != null || accessToken != null,
				"Either id or access token must be specified.");
		
		final String realToken;
		if (id != null) {
			final FacebookAccessible facebookAccessible = Preconditions.checkNotNull(lookup.findOne(id),
					"Cannot find '%s' using %s", id, lookup);
			realToken = facebookAccessible.getFacebookAccessToken();
		} else {
			realToken = accessToken;
		}
		
		final DefaultFacebookClient facebook = new DefaultFacebookClient(realToken);
		final String connection = objectId + "/likes";
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		log.debug("Posting like to Facebook {} using {}", connection, abbrToken);
		System.out.print(ansi().render("Liking @|bold %s|@ using @|yellow %s|@", connection, abbrToken));
		final boolean postedLike = facebook.publish(connection, Boolean.class);
		System.out.println(ansi().render(" @|bold %s|@", postedLike));		
		log.info("Posted like {} to Facebook {}", 
				postedLike, connection, postedLike);
		return postedLike;
	}

}
