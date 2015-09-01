package org.soluvas.commons;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Configures HTTP & HTTPS proxy with optional authentication from {@code application.properties}.
 *
 * <p>Usage: Edit {@code config/application.properties} as follows (also, make a commented template in {@code config/application.dev.properties}:</p>
 *
 * <pre>
 * # Proxy
 * http.proxyHost=cache.itb.ac.id
 * http.proxyPort=8080
 * https.proxyHost=cache.itb.ac.id
 * https.proxyPort=8080
 * http.proxyUser=hendyirawan
 * http.proxyPassword=
 * </pre>
 *
 * Then {@link org.springframework.context.annotation.Import} this class.
 */
@Configuration
public class ProxyConfig {

    private static final Logger log = LoggerFactory.getLogger(ProxyConfig.class);

    @Inject
    protected Environment env;

    @PostConstruct
    public void init() {
        if (!Strings.isNullOrEmpty(env.getProperty("http.proxyHost"))) {
            System.setProperty("http.proxyHost", env.getProperty("http.proxyHost"));
        }

        if (!Strings.isNullOrEmpty(env.getProperty("http.proxyPort"))) {
            System.setProperty("http.proxyPort", env.getProperty("http.proxyPort"));
        }

        if (!Strings.isNullOrEmpty(env.getProperty("https.proxyHost"))) {
            System.setProperty("https.proxyHost", env.getProperty("https.proxyHost"));
        }

        if (!Strings.isNullOrEmpty(env.getProperty("https.proxyPort"))) {
            System.setProperty("https.proxyPort", env.getProperty("https.proxyPort"));
        }

        if (!Strings.isNullOrEmpty(env.getProperty("http.proxyUser"))) {
            System.setProperty("http.proxyUser", env.getProperty("http.proxyUser"));
            System.setProperty("http.proxyPassword", env.getProperty("http.proxyPassword", ""));
            log.info("Using authenticated proxy http://{}:{}@{}:{}", env.getProperty("http.proxyUser"), "********", env.getProperty("http.proxyHost"), env.getProperty("http.proxyPort"));
            Authenticator.setDefault(new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(env.getProperty("http.proxyUser"), env.getProperty("http.proxyPassword", "").toCharArray());
                }

            });
        } else if (!Strings.isNullOrEmpty(env.getProperty("http.proxyHost"))) {
            log.info("Using unauthenticated proxy http://{}:{}", env.getProperty("http.proxyHost"), env.getProperty("http.proxyPort"));
        }

    }

}
