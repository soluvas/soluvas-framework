package org.soluvas.commons;

import org.springframework.core.env.Environment;

/**
 * Created by ceefour on 23/12/2016.
 */
public class Tenant {

    private String title;
    private String summary;
    private String description;

    public Tenant() {
    }

    public Tenant(Environment env) {
        this.title = env.getRequiredProperty("tenant.title");
        this.summary = env.getRequiredProperty("tenant.summary");
        this.description = env.getRequiredProperty("tenant.description");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Short description to be used in page title, usually 3-10 words.
     * @return
     */
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Longer description to be used in meta description, recommended to be less than 160 characters.
     * @return
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
