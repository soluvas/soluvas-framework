package org.soluvas.commons;

import org.joda.time.DateTimeZone;
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
    private DateTimeZone defaultTimeZone;

    public Tenant() {
    }

    public Tenant(Environment env) {
        this.title = env.getRequiredProperty("tenant.title");
        this.summary = env.getRequiredProperty("tenant.summary");
        this.description = env.getRequiredProperty("tenant.description");
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public DateTimeZone getDefaultTimeZone() {
        return defaultTimeZone;
    }

    public void setDefaultTimeZone(DateTimeZone defaultTimeZone) {
        this.defaultTimeZone = defaultTimeZone;
    }
}
