package org.soluvas.socmed;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author rudi
 *
 */
@Configuration @Lazy
@ComponentScan({"org.soluvas.facebook", "org.soluvas.twitter"})
public class SocMedConfig {

}
