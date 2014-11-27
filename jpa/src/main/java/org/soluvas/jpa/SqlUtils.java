package org.soluvas.jpa;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;

import com.google.common.base.CharMatcher;

public class SqlUtils {

	private static final Logger log = LoggerFactory.getLogger(SqlUtils.class);
	
	/**
	 * {@link CharMatcher#JAVA_ISO_CONTROL} except 0D and 0A. 
	 */
	private static CharMatcher UNSAFE_CHARS = CharMatcher.inRange('\u0000', '\u0009')
			.or(CharMatcher.inRange('\u000b', '\u000c'))
			.or(CharMatcher.inRange('\u000e', '\u001f'))
			.or(CharMatcher.inRange('\u007f', '\u009f'));
	
	/**
	 * Remove ISO control characters except CR & LF.
	 * @param rs
	 * @param name
	 * @return
	 */
	public static String safeGetString(ResultSet rs, String name) {
		try {
			final String value = rs.getString(name);
			if (value != null) {
				return UNSAFE_CHARS.removeFrom(value);
			} else {
				return null;
			}
		} catch (SQLException e) {
			log.trace("Error", e);
			return null;
		}
	}
	
	public static double safeGetDouble(ResultSet resultSet, String name) {
		try {
			return resultSet.getDouble(name);
		} catch (SQLException e) {
			log.trace("Error", e);
			return 0;
		}
	}
	
	public static BigDecimal safeGetBigDecimal(ResultSet resultSet, String name) {
		try {
			return resultSet.getBigDecimal(name);
		} catch (SQLException e) {
			log.trace("Error", e);
			return BigDecimal.ZERO;
		}
	}
	
	/**
	 * Get the field as a {@link DateTime} corrected to a specific {@link DateTimeZone}
	 * from assumed {@link DateTimeZone}.
	 * @param resultSet
	 * @param name
	 * @param targetTimeZone
	 * @return
	 */
	public static DateTime getOffsetedDateTime(ResultSet resultSet, String name, 
			DateTimeZone sourceTimeZone, DateTimeZone targetTimeZone) {
		try {
			final String str = resultSet.getString(name);
			return str != null ? new DateTime(str.replace(' ', 'T'), sourceTimeZone).withZone(targetTimeZone) : null;
		} catch (SQLException e) {
			log.trace("Error reading datetime", e);
			return null;
		}
	}
	
	/**
	 * Generates SQL/JPQL ORDER BY (with leading space) from {@link Pageable}.
	 * @param pageable Can be {@code null} or without {@link Pageable#getSort()}, will return empty string.
	 * @return
	 */
	public static String toOrderBy(@Nullable Pageable pageable) {
		if (pageable != null && pageable.getSort() != null) {
			String sql = "";
			boolean first = true;
			for (Sort.Order order : pageable.getSort()) {
				if (first) {
					sql += " ORDER BY " + order.getProperty() + " " + order.getDirection();
				} else {
					sql += ", " + order.getProperty() + " " + order.getDirection();
				}
			}
			return sql;
		} else {
			return "";
		}
	}
	
}
