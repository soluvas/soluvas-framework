package org.soluvas.image;

import org.soluvas.commons.PersonRelated;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.image.store.ImageRepository;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Why not {@code ArticleRelated}? Because {@link ImageRepository} will be
 * an {@link EntityLookup} and also {@link CrudRepository},
 * even a {@link PagingAndSortingRepository}.
 * @author ceefour
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageForArticle {

}
