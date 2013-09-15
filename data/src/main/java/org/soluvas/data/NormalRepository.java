package org.soluvas.data;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import org.soluvas.data.repository.Repository;

/**
 * Asks for non-raw repository.
 *  
 * @todo Note: Planned to be deprecated in favor of unified {@link Repository} semantic interfaces.
 * (i.e. delete() by default means trash, and we have deletePermanently(), archive(), move(), etc.)
 * @author agus
 * @deprecated Use {@link StatusMask}.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface NormalRepository {

}
