package org.soluvas.commons;

import org.springframework.core.env.Environment;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZoneId;

/**
 * Created by ceefour on 23/12/2016.
 */
@MappedSuperclass
public class Tenant implements ITenant, Serializable {

    private String title;
    private String summary;
    private String description;
    private ZoneId defaultTimeZone;

    public Tenant() {
    }

    public Tenant(Environment env) {
        this.title = env.getRequiredProperty("tenant.title");
        this.summary = env.getRequiredProperty("tenant.summary");
        this.description = env.getRequiredProperty("tenant.description");
        this.defaultTimeZone = ZoneId.of(env.getRequiredProperty("tenant.default-time-zone"));
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ZoneId getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public void setDefaultTimeZone(ZoneId defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }
}
