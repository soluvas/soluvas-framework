package org.soluvas.commons;

import org.joda.time.DateTimeZone;

/**
 * Created by ceefour on 23/12/2016.
 */
public interface ITenant {
    String getTitle();

    void setTitle(String title);

    /**
     * Short description to be used in page title, usually 3-10 words.
     * @return
     */
    String getSummary();

    void setSummary(String summary);

    /**
     * Longer description to be used in meta description, recommended to be less than 160 characters.
     * @return
     */
    String getDescription();

    void setDescription(String description);

    DateTimeZone getDefaultTimeZone();
}
