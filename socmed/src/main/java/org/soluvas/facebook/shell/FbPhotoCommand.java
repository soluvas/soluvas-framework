package org.soluvas.facebook.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.FacebookAccessible;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.annotation.FacebookRelated;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.EntityLookup;
import org.soluvas.facebook.FacebookManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Album;
import com.restfb.types.Page;
import com.restfb.types.Photo;
import com.restfb.types.User;

/**
 * Post a Photo to a Facebook {@link User}, {@link Page}, or {@link Album}.
 * <p>Note: albums have a limit of 200 photos! (so we want to limit each category by month+year)
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="fb", name="photo", description="Post a Photo to a Facebook User, Page, or Album.")
public class FbPhotoCommand extends ExtCommandSupport {
	
//	@Option(name="--appid", description="Specify custom Facebook OAuth App ID, if not using FacebookManager configuration.")
//	private String appId;
//	@Option(name="--appsecret", description="Specify custom Facebook OAuth App Secret, if not using FacebookManager configuration.")
//	private String appSecret;
	@Option(name="-i", description="Find the specified FacebookAccessible ID using @FacebookRelated EntityLookup to get the access token. Must be specified if not using -a and -t.")
	private String id;
	@Option(name="-t", description="OAuth Access Token for the posting Facebook user, must be specified if not using -i.")
	private String accessToken;
	@Option(name="-a", description="Person, Page, or Album ID (note: albums have a 200 photos limit)")
	private transient String albumId = "me";
	@Option(name="-b", description="Use binary attachment to upload URIs (URI will need to be downloaded first). Note this will have no effect on file URIs.")
	private transient boolean binary = false;
	
	@Argument(index=0, name="photo_uri", description="File or URI to the photo to upload. Files are always uploaded using binary attachment.")
	private String photoUri;
	/**
	 * Tagging looks like this:
	 * 
	 * <pre>{@literal
	 *    "name": "waw keren ya AksiMata Hendy Irawan :)",
	 *    "name_tags": {
	 *       "13": [
	 *          {
	 *             "id": "409555939071423",
	 *             "name": "AksiMata",
	 *             "type": "page",
	 *             "offset": 13,
	 *             "length": 8
	 *          }
	 *       ],
	 *       "22": [
	 *          {
	 *             "id": "596326671",
	 *             "name": "Hendy Irawan",
	 *             "type": "user",
	 *             "offset": 22,
	 *             "length": 12
	 *          }
	 *       ]
	 *    },
	 * }</pre>
	 * 
	 */
	@Argument(index=1, name="name", description="The user provided caption given to this photo - do not include advertising in this field. '@[596326671:Hendy Irawan]' tags don't work :(")
	private String photoName;

	private final FacebookManager facebookMgr;
	private final EntityLookup<FacebookAccessible, String> lookup;
	
	@Inject
	public FbPhotoCommand(FacebookManager facebookMgr, @FacebookRelated EntityLookup<FacebookAccessible, String> lookup) {
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
		
		final List<Parameter> params = new ArrayList<>();
		if (photoName != null) {
			params.add(Parameter.with("name", photoName));
		}

		String binaryName;
		File tmpFile = null;
		BinaryAttachment binaryAttachment = null;
		if (photoUri.startsWith("/")) {
			binaryName = new File(photoUri).getName();
			binaryAttachment = BinaryAttachment.with(photoUri, FileUtils.openInputStream(new File(photoUri)));
		} else if (photoUri.startsWith("file:")) {
			binaryName = new File(URI.create(photoUri)).getName();
			binaryAttachment = BinaryAttachment.with(photoUri, FileUtils.openInputStream(new File(URI.create(photoUri))));
		} else if (binary) {
			tmpFile = File.createTempFile(SlugUtils.generateId(photoUri), ".tmp");
			log.debug("Downloading {} to {}", photoUri, tmpFile);
			System.out.print(ansi().render("Downloading @|bold %s|@ to @|bold %s|@ ...", photoUri, tmpFile));
			FileUtils.copyURLToFile(new URL(photoUri), tmpFile);
			System.out.println(ansi().render(" @|bg_green,bold,white  OK |@"));
			binaryName = tmpFile.getName();
			binaryAttachment = BinaryAttachment.with(binaryName, FileUtils.openInputStream(tmpFile));
		} else {
			binaryName = null;
			params.add(Parameter.with("url", photoUri));			
		}

		final DefaultFacebookClient facebook = new DefaultFacebookClient(realToken);
		final String connection = albumId + "/photos";
		final String abbrToken = StringUtils.abbreviateMiddle(realToken, "…", 15);
		log.debug("Posting photo {} name '{}' binary '{}' to Facebook {} using {} ...", 
				photoUri, photoName, binaryName, connection, abbrToken);
		System.out.print(ansi().render("Posting photo @|bold %s|@ name @|bold %s|@ binary @|bold %s|@ to @|bold %s|@ using @|yellow %s|@", 
				photoUri, photoName, binaryName, connection, abbrToken));

		final Photo postedPhoto;
		if (binaryAttachment != null) {
			postedPhoto = facebook.publish(connection, Photo.class,
					binaryAttachment, params.toArray(new Parameter[] {}));
		} else {
			postedPhoto = facebook.publish(connection, Photo.class,
					params.toArray(new Parameter[] {}));
		}
		log.info("Posted {} from photo {} name '{}' binary '{}' to Facebook {} using {}: {}", 
				postedPhoto.getId(), photoUri, photoName, binaryName, connection, abbrToken, postedPhoto);
		System.out.println(ansi().render(" @|bold %s|@", connection, postedPhoto.getId()));
		return postedPhoto.getId();
	}

}
