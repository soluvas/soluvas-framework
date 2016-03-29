package org.soluvas.jpa;

import org.jadira.usertype.spi.shared.AbstractSingleColumnUserType;

import javax.money.CurrencyUnit;
import java.net.InetAddress;

/**
 * Maps a {@link java.net.InetAddress} to and from <a href="http://www.postgresql.org/docs/9.5/static/datatype-net-types.html">PostgreSQL inet</a> for Hibernate.
 */
public class PersistentInetAddress extends AbstractSingleColumnUserType<InetAddress, String, InetAddressMapper> {
}
