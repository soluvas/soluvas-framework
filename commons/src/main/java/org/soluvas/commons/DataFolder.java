package org.soluvas.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Gets the data folder, e.g. {@literal /home/rudi/cintalama_dev}.
 * @author rudi
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DataFolder {

}
