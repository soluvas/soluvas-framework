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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Link;

/**
 * Posts a {@link Link} object on Facebook.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="fb", name="link", description="Shares a Link on Facebook.")
public class FbLinkCommand extends ExtCommandSupport {
	
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
	@Option(name="-p", description="Person or Page to post this link")
	private transient String profileId = "me";
	
	@Argument(index=0, name="link", required=true, description="The URL to share. To share a Photo, use this URI: http://www.facebook.com/photo.php?fbid={photoId}")
	private String linkUri;

	private final FacebookManager facebookMgr;
	private final EntityLookup<FacebookAccessible, String> lookup;
	
	@Inject
	public FbLinkCommand(FacebookManager facebookMgr, @FacebookRelated EntityLookup<FacebookAccessible, String> lookup) {
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
		final String connection = profileId + "/links";
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		final List<Parameter> params = new ArrayList<>();
		params.add(Parameter.with("link", linkUri));
		if (explicitlyShared) {
			params.add(Parameter.with("fb:explicitly_shared", true));
		}
		log.debug("Posting link {] to Facebook {} {} using {}", linkUri, connection, params, abbrToken);
		System.out.print(ansi().render("Post link @|bold %s|@ to Facebook @|bold %s|@ @|cyan %s|@ using @|yellow %s|@", 
				linkUri, connection, params, abbrToken));
		final Link postedLink = facebook.publish(connection, Link.class,
				params.toArray(new Parameter[] {}));
		System.out.println(ansi().render(" @|bold %s|@", postedLink.getId()));		
		log.info("Posted link {} to Facebook {}: {}", 
				postedLink.getId(), connection, postedLink);
		return postedLink.getId();
	}

}
