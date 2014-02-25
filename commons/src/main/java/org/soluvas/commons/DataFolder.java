package org.soluvas.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import org.soluvas.commons.config.TenantSelector;

/**
 * Gets the data folder, e.g. {@literal /home/rudi/cintalama_dev}.
 * @author rudi
 * @deprecated Use {@link TenantSelector#dataDir()}.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface DataFolder {

}
