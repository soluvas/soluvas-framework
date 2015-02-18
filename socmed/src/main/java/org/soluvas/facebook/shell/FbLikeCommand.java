package org.soluvas.facebook.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.facebook.FacebookManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
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
	@Option(name="-x", description="Indicates it to be an explicit action and lets it appear on the left-hand side of that person's timeline.")
	private transient boolean explicitlyShared = false;
	
	@Argument(index=0, name="objectId", required=true, description="Object ID to like")
	private String objectId;

	@Override
	protected Object doExecute() throws Exception {
		final FacebookManager facebookMgr = getBean(FacebookManager.class);
//		final EntityLookup<FacebookAccessible, String> lookup = getBean(EntityLookup.class, FacebookRelated.class);

		Preconditions.checkArgument(id != null || accessToken != null,
				"Either id or access token must be specified.");
		
		final String realToken;
//		if (id != null) {
//			final FacebookAccessible facebookAccessible = Preconditions.checkNotNull(lookup.findOne(id),
//					"Cannot find '%s' using %s", id, lookup);
//			realToken = facebookAccessible.getFacebookAccessToken();
//		} else {
			realToken = accessToken;
//		}
		
		final DefaultFacebookClient facebook = new DefaultFacebookClient(realToken);
		final String connection = objectId + "/likes";
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		log.debug("Posting like to Facebook {} using {}", connection, abbrToken);
		System.out.print(ansi().render("Liking @|bold %s|@ using @|yellow %s|@", connection, abbrToken));
		final List<Parameter> params = new ArrayList<>();
		if (explicitlyShared) {
			params.add(Parameter.with("fb:explicitly_shared", true));
		}
		final boolean postedLike = facebook.publish(connection, Boolean.class,
				params.toArray(new Parameter[] {}));
		System.out.println(ansi().render(" @|bold %s|@", postedLike));		
		log.info("Posted like {} to Facebook {}", postedLike, connection);
		return postedLike;
	}

}
