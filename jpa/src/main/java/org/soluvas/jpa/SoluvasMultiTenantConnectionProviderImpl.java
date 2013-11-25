package org.soluvas.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.service.UnknownUnwrapTypeException;
import org.hibernate.service.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.Stoppable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * Implementing MultiTenantConnectionProvider using single connection pool.
 * Simplistic implementation for illustration purposes showing a single connection pool used to serve
 * multiple schemas using "connection altering".  Here we use the PostgreSQL specific SET SCHEMA command; Oracle
 * users might use the ALTER SESSION SET SCHEMA command; etc.
 * @see http://docs.jboss.org/hibernate/core/4.2/devguide/en-US/html/ch16.html#d5e4698
 * @author ceefour
 */
public class SoluvasMultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, Stoppable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(SoluvasMultiTenantConnectionProviderImpl.class);
	public static final String PUBLIC_SCHEMA = "public";
	
	@Inject
	private DataSource dataSource;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return MultiTenantConnectionProvider.class.equals( unwrapType ) ||
				SoluvasMultiTenantConnectionProviderImpl.class.isAssignableFrom( unwrapType );
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		if ( isUnwrappableAs( unwrapType ) ) {
			return (T) this;
		}
		else {
			throw new UnknownUnwrapTypeException( unwrapType );
		}
	}

	@Override
	public void stop() {
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		Preconditions.checkNotNull(dataSource, "dataSource must be provided");
		return dataSource.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		connection.close();
	}

	@Override
	public Connection getConnection(String tenantIdentifier)
			throws SQLException {
		Preconditions.checkNotNull(dataSource, "dataSource must be provided");
		final Connection conn = dataSource.getConnection();
		try {
			final PreparedStatement st = conn.prepareStatement("SET SCHEMA ?");
			st.setString(1, tenantIdentifier);
			st.execute();
		} catch (SQLException e) {
			throw new RuntimeException(
					"Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
		}
		return conn;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection)
			throws SQLException {
		try {
			final PreparedStatement st = connection.prepareStatement("SET SCHEMA ?");
			st.setString(1, PUBLIC_SCHEMA);
			st.execute();
		} catch (SQLException e) {
			// on error, throw an exception to make sure the connection is not returned to the pool.
			// your requirements may differ
			throw new RuntimeException(
					"Could not alter released JDBC connection from schema '" + tenantIdentifier + "' to schema '" + PUBLIC_SCHEMA + "'", e);
		}
		connection.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}

}
