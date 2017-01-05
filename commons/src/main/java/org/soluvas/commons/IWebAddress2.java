package org.soluvas.commons;

/**
 * Created by ceefour on 05/01/2017.
 */
public interface IWebAddress2 {

    /**
     * Absolute URI of the website, it can be HTTP or HTTPS depending on system configuration.
     * Used by email notifications, external servers, etc.
     */
    String getBaseUri();

}
