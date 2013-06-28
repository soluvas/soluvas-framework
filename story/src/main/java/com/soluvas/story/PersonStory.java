package com.soluvas.story;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.soluvas.commons.PersonRelated;
import org.soluvas.data.EntityLookup;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Story for Shop.
 * QA: Why not @{@link PersonRelated}? Because StoryRepository is an {@link EntityLookup}.
 * Same issue with ImageRepository.
 * @author rudi
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonStory {

}
