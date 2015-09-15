package org.soluvas.socmed;

/**
 * Facebook Pages have five levels of permissions to access settings, publish content as a page, or perform operations with the Pages API.
 * Your app will need to have the Admin role and permissions.
 * This enables your app to manage Page roles and settings, post as page, get insights and execute all Page API requests.
 * See https://developers.facebook.com/docs/pages/access-tokens
 * Created by ceefour on 15/09/2015.
 */
public enum FacebookPagePermission {
    /**
     * Manage admins
     */
    ADMINISTER,
    /**
     * Edit the Page and add apps
     */
    EDIT_PROFILE,
    /**
     * Create posts as the Page
     */
    CREATE_CONTENT,
    /**
     * Respond to and delete comments, send messages as the Page
     */
    MODERATE_CONTENT,
    /**
     * Create ads and unpublished page posts
     */
    CREATE_ADS,
    /**
     * View Insights
     */
    BASIC_ADMIN
}
