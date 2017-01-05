package org.soluvas.commons;

import java.io.Serializable;

/**
 * Created by ceefour on 05/01/2017.
 */
public class GeneralSysConfig2 implements Serializable {

    private Boolean sslSupported;

    /**
     * Whether Wicket/Spring MVC controllers can require secure channel, and whether URI generators (used in Sitemaps, Atom Feeds, Canonical URIs, etc.) use HTTPS URIs. This should always be {@code true}.
     *
     * <p>For development and debugging purposes (i.e. a bug is caused or made harder to diagnose due to SSL mechanism), this can be set to false. Otherwise, the development Tomcat/Undertow container should have SSL configured using self-signed (wildcard?) certificates.
     *
     * <p>For production purpose, when the customer doesn't have an SSL certificate yet, this can be disabled. But such scenario should be temporary and SSL should be enabled whenever possible.
     *
     * @see #setSslSupported(Boolean)
     */
    public Boolean getSslSupported() {
        return sslSupported;
    }

    public void setSslSupported(Boolean value) {
        this.sslSupported = value;
    }

}
