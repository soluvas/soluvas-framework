package org.soluvas.commons;

import java.time.ZoneId;

/**
 * Created by ceefour on 23/12/2016.
 */
public interface ITenant {
    String getTitle();

    /**
     * Short description to be used in page title, usually 3-10 words.
     * @return
     */
    String getSummary();

    /**
     * Longer description to be used in meta description, recommended to be less than 160 characters.
     * @return
     */
    String getDescription();

    ZoneId getDefaultTimeZone();
}
