package org.soluvas.image;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * {@link Configuration} for {@link Image} and {@link Media} stuff.
 * @author ceefour
 */
@Configuration @Lazy
@ComponentScan("org.soluvas.image.shell")
public class ImageConfig {

}
