package org.soluvas.facebook.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Photo;
import com.restfb.types.Photo.Tag;
import com.restfb.types.User;

/**
 * {@link Tag}s a Facebook {@link User} in a {@link Photo}.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="fb", name="phototag", description="Tags a Facebook User in a Photo.")
public class FbPhotoTagCommand extends ExtCommandSupport {
	
	@Option(name="-i", description="Find the specified FacebookAccessible ID using @FacebookRelated EntityLookup to get the access token. Must be specified if not using -a and -t.")
	private String id;
	@Option(name="-t", description="OAuth Access Token for the posting Facebook user, must be specified if not using -i.")
	private String accessToken;
	@Option(name="-s", description="Treats userId as a text string tag, not a user ID.")
	private transient boolean isTagText = false;
	@Option(name="-x", description="x coordinate of tag, as a percentage offset from the left edge of the picture.")
	private Double x;
	@Option(name="-y", description="y coordinate of tag, as a percentage offset from the top edge of the picture.")
	private Double y;
	
	@Argument(index=0, name="photoId", required=true, description="Photo ID to be tagged.")
	private String photoId;
	@Argument(index=1, name="userId", required=true, description="User ID or tag text to be tagged in the photo.")
	private String userId;

	@Inject
	private FacebookManager facebookMgr;
	@Autowired(required=false) @FacebookRelated
	private EntityLookup<FacebookAccessible, String> lookup;
	
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
		
		final List<Parameter> params = new ArrayList<>();
		if (isTagText) {
			params.add(Parameter.with("tag_text", userId));
		} else {
			params.add(Parameter.with("to", userId));
		}
		if (x != null) {
			params.add(Parameter.with("x", x));
		}
		if (y != null) {
			params.add(Parameter.with("y", y));
		}
		
		final DefaultFacebookClient facebook = new DefaultFacebookClient(realToken);
		final String connection = photoId + "/tags";
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		log.debug("Tagging photo {} user {} to Facebook {} {} using {}", 
				photoId, userId, connection, params, abbrToken);
		System.out.print(ansi().render("Tagging photo @|bold %s|@ user @|bold %s|@ to @|bold %s|@ using @|yellow %s|@ ...", 
				photoId, userId, connection, abbrToken));

		final boolean postedTag = facebook.publish(connection, Boolean.class,
				params.toArray(new Parameter[] {}));
		log.info("Posted tag from photo {} to user {} to Facebook {} using {}: {}", 
				photoId, userId, connection, abbrToken, postedTag);
		System.out.println(ansi().render(" @|bold %s|@", connection, postedTag));
		return postedTag;
		
	}

}
