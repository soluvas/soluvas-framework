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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Page;

/**
 * Get the <a href="http://developers.facebook.com/docs/reference/api/page/#page_access_tokens">Page Access Token</a>
 * of a Facebook <a href="http://developers.facebook.com/docs/reference/api/page/">Page</a>.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="fb", name="page", description="Get the Page Access Token of a Facebook Page.")
public class FbPageCommand extends ExtCommandSupport {
	
//	@Option(name="--appid", description="Specify custom Facebook OAuth App ID, if not using FacebookManager configuration.")
//	private String appId;
//	@Option(name="--appsecret", description="Specify custom Facebook OAuth App Secret, if not using FacebookManager configuration.")
//	private String appSecret;
	@Option(name="-i", description="Find the specified FacebookAccessible ID using @FacebookRelated EntityLookup to get the user access token. Must be specified if not using -a and -t.")
	private String id;
	@Option(name="-t", description="OAuth Access Token for the Facebook user that manages the page, must be specified if not using -i.")
	private String accessToken;
	
	@Argument(index=0, name="page_id", required=true, description="Page ID or username")
	private String pageId;

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
		
		final DefaultFacebookClient facebook = new DefaultFacebookClient(realToken);
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		log.debug("Fetching page '{}' using {}", pageId, abbrToken);
		System.out.println(ansi().render("Fetching page @|bold %s|@ using @|yellow %s|@ ...", 
				pageId, abbrToken));
		final Page page = facebook.fetchObject(pageId, Page.class, Parameter.with("fields", "access_token"));
		final String pageAccessToken = Preconditions.checkNotNull(page.getAccessToken(),
				"Facebook returned null access token for page '%s' using token '%s', probably not having 'manage_pages' permission (hint: use fb:login then fb:auth)",
				pageId, abbrToken);
		log.debug("Got page access token {} for '{}' using {}: {}", 
				pageAccessToken, pageId, abbrToken, page);
		return pageAccessToken;
	}

}
