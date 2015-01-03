package org.soluvas.socmed.instagram;

import javax.inject.Inject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import com.beust.jcommander.JCommander;
import com.google.common.base.Preconditions;

/**
 * @author ceefour
 *
 */
@PropertySources({
	@PropertySource(value="application.properties", ignoreResourceNotFound=true),
	@PropertySource(value="file:application.properties", ignoreResourceNotFound=true)
})
@Configuration
public class InstagramApp {
	
	@Inject
	private Environment env;
	
	public Object run(String[] args) throws Exception {
		final InstagramAuthCommand auth = new InstagramAuthCommand();
		final InstagramSearchCommand search = new InstagramSearchCommand();
		final InstagramRecentMediaCommand recentMedia = new InstagramRecentMediaCommand();
		if (env.containsProperty(InstagramSysConfig.API_KEY_PROPERTY)) {
			System.out.println("Using application.properties Instagram configuration");
			InstagramSysConfigImpl instagramSysConfig = new InstagramSysConfigImpl(env);
			auth.appId = instagramSysConfig.getInstagramApiKey();
			auth.appSecret = instagramSysConfig.getInstagramApiSecret();
			auth.authUri = instagramSysConfig.getInstagramCallbackUri();
		} else {
			System.out.println("application.properties Instagram configuration not found");
		}
		search.accessToken = env.getProperty(InstagramSysConfig.ACCESS_TOKEN_PROPERTY);
		recentMedia.accessToken = env.getProperty(InstagramSysConfig.ACCESS_TOKEN_PROPERTY);
		
		final JCommander jc = new JCommander();
		jc.addCommand(auth);
		jc.addCommand(search);
		jc.addCommand(recentMedia);
		jc.parse(args);
		Preconditions.checkArgument(jc.getParsedCommand() != null, "Command must be given");
		switch (jc.getParsedCommand()) {
		case InstagramAuthCommand.CMD:
			return auth.call();
		case InstagramSearchCommand.CMD:
			return search.call();
		case InstagramRecentMediaCommand.CMD:
			return recentMedia.call();
		}
		throw new IllegalArgumentException("Unknown command: " + jc.getParsedCommand());
	}

	public static void main(String[] args) throws Exception {
		try (final AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(InstagramApp.class)) {
			final InstagramApp app = appCtx.getBean(InstagramApp.class);
			app.run(args);
		}
	}

}
