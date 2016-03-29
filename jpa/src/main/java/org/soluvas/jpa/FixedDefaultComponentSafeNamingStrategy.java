package org.soluvas.jpa;

import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;

/**
 * For Hibernate 4.x. See http://stackoverflow.com/a/5274989/122441
 * Not needed for Hibernate 5.x: http://opensource.atlassian.com/projects/hibernate/browse/HHH-6005
 * Created by ceefour on 29/03/2016.
 */
public class FixedDefaultComponentSafeNamingStrategy extends DefaultComponentSafeNamingStrategy {

    @Override
    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(
                propertyName.replace(".collection&&element.", "."));
    }
}
