package org.soluvas.jpa;

import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.jadira.usertype.spi.shared.AbstractColumnMapper;
import org.soluvas.commons.CommonsException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Types;

public class InetAddressMapper extends AbstractColumnMapper<InetAddress, String> {

    @Override
    public final int getSqlType() {
        return Types.OTHER;
    }

    @Override
    public final StringType getHibernateType() {
        return StandardBasicTypes.STRING;
    }

    @Override
    public InetAddress fromNonNullValue(String value) {
        return fromNonNullString(value);
    }

    @Override
    public InetAddress fromNonNullString(String s) {
        try {
            return InetAddress.getByName(s);
        } catch (UnknownHostException e) {
            throw new CommonsException(e, "Cannot parse IPv4/IPv6 address '%s' as InetAddress", s);
        }
    }

    @Override
    public String toNonNullValue(InetAddress value) {
        return toNonNullString(value);
    }

    @Override
    public String toNonNullString(InetAddress value) {
        return value.toString();
    }
}
