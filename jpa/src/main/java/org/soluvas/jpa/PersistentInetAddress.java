package org.soluvas.jpa;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.jadira.usertype.spi.shared.AbstractSingleColumnUserType;
import org.jadira.usertype.spi.shared.AbstractUserType;
import org.postgresql.util.PGobject;
import org.soluvas.commons.CommonsException;

import javax.money.CurrencyUnit;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Maps a {@link java.net.InetAddress} to and from <a href="http://www.postgresql.org/docs/9.5/static/datatype-net-types.html">PostgreSQL inet</a> for Hibernate.
 * Inspired by https://gist.github.com/hpadmanabhan/9e3ab663f491798b897c
 */
public class PersistentInetAddress extends AbstractUserType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.OTHER};
    }

    @Override
    public Class returnedClass() {
        return InetAddress.class;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        beforeNullSafeOperation(session);
        try {
            final String identifier = rs.getString(names[0]);

            if (rs.wasNull()) {
                return null;
            }

            try {
                return InetAddress.getByName(identifier);
            } catch (UnknownHostException e) {
                throw new CommonsException(e, "Cannot parse IPv4/IPv6 address '%s' as InetAddress", identifier);
            }
        } finally {
            afterNullSafeOperation(session);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        beforeNullSafeOperation(session);
        try {
            if (value == null) {
                st.setNull(index, Types.OTHER);
            } else {
                final PGobject pgobj = new PGobject();
                pgobj.setType("inet");
                pgobj.setValue(value.toString());
                st.setObject(index, pgobj);
            }
        } finally {
            afterNullSafeOperation(session);
        }
    }

}
