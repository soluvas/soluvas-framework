package org.soluvas.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTransientConnectionException;
import java.sql.Statement;
import java.util.Optional;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.hibernate.service.spi.Stoppable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import static org.soluvas.jpa.SoluvasMultiTenantConnectionProviderImpl.dataSource;

/**
 * Implementing Hibernate 4.3 {@link MultiTenantConnectionProvider} using single connection pool.
 * Simplistic implementation for illustration purposes showing a single connection pool used to serve
 * multiple schemas using "connection altering".  Here we use the PostgreSQL specific SET SCHEMA command; Oracle
 * users might use the ALTER SESSION SET SCHEMA command; etc.
 *
 * See http://stackoverflow.com/a/31825971/122441
 *
 * See http://docs.jboss.org/hibernate/core/4.2/devguide/en-US/html/ch16.html#d5e4698
 *
 * @see SoluvasTenantIdentifierResolver
 * @author ceefour
 */
@SuppressWarnings("serial")
public class SoluvasMultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, Stoppable {

	private static final Logger log = LoggerFactory
			.getLogger(SoluvasMultiTenantConnectionProviderImpl.class);
	public static final String PUBLIC_SCHEMA = "public";

	@Deprecated
	public static DataSource dataSource;

	@Inject
	private DataSource injectedDataSource;

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
		final DataSource dataSource = Optional.ofNullable(this.injectedDataSource)
				.orElse(SoluvasMultiTenantConnectionProviderImpl.dataSource);
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
		final DataSource dataSource = Optional.ofNullable(this.injectedDataSource)
				.orElse(SoluvasMultiTenantConnectionProviderImpl.dataSource);
		Preconditions.checkNotNull(dataSource, "dataSource must be provided");
		Preconditions.checkArgument(tenantIdentifier.matches("[A-Za-z0-9_]+"),
				"Invalid tenantIdentifier syntax, it must contain only alphanumeric and '_' characters.");
		final Connection conn = dataSource.getConnection();
		try (final Statement st = conn.createStatement()) {
			if ("public".equalsIgnoreCase(tenantIdentifier)) {
				log.debug("Trying to switch " +  conn + " to tenant schema 'public', are you sure this is what you want?");
						//new Exception("Trying to switch " +  conn + " to tenant schema 'public', are you sure this is what you want?"));
			}
			log.trace("Switching Hibernate connection {} to tenant schema '{}'", conn, tenantIdentifier);
			st.executeUpdate("SET SCHEMA '" + tenantIdentifier + "'");
		} catch (SQLException e) {
			throw new SQLTransientConnectionException(
					"Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
		}
		return conn;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection)
			throws SQLException {
		log.trace("Switching back Hibernate connection {} to schema '{}'", connection, PUBLIC_SCHEMA);
		try (final Statement st = connection.createStatement()) {
			st.executeUpdate("SET SCHEMA '" + PUBLIC_SCHEMA + "'");
		} catch (SQLException e) {
			// on error, throw an exception to make sure the connection is not returned to the pool.
			// your requirements may differ
			throw new SQLTransientConnectionException(
					"Could not alter released JDBC connection from schema '" + tenantIdentifier + "' to schema '" + PUBLIC_SCHEMA + "'", e);
		} finally {
			connection.close();
		}
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return true;
	}

}
