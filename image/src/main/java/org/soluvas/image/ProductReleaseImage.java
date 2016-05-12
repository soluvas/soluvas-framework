package org.soluvas.image;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import org.soluvas.commons.PersonRelated;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.image.store.ImageRepository;

/**
 * @author atang
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductReleaseImage {

}
