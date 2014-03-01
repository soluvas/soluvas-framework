package org.soluvas.socmed;

import org.soluvas.facebook.FacebookManagerImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author rudi
 * @deprecated Due to multitenancy, please configure each of Facebook and Twitter accordingly,
 * 		and if you want ComponentScan, then use {@code org.soluvas.facebook.shell} and {@code org.soluvas.twitter.shell}
 * 		because e.g. {@link FacebookManagerImpl} need to be excluded from scanning.
 */
@Deprecated
@Configuration @Lazy
@ComponentScan({"org.soluvas.facebook", "org.soluvas.twitter"})
public class SocMedConfig {

}
