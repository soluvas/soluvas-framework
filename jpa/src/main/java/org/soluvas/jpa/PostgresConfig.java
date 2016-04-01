package org.soluvas.jpa;

import com.google.common.base.Preconditions;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * C3P0 {@link DataSource} {@link Configuration} for PostgreSQL.
 * <p>
 * <p>Required properties:
 * <p>
 * <ul>
 * <li>{@code sqlUrl} or {@code spring.datasource.url}: JDBC URL.</li>
 * <li>{@code sqlUser} or {@code spring.datasource.username}: JDBC username.</li>
 * <li>{@code sqlPassword} or {@code spring.datasource.password}: For compatibility reasons, it must exist. Some libraries don't work with empty JDBC password.</li>
 * </ul>
 *
 * @author atang
 */
@Configuration
public class PostgresConfig {

    /**
     * @deprecated Use Spring Boot's auto-configured {@link DataSource}, which usually uses {@code tomcat-dbcp}.
     */
    @Deprecated
    public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final Logger log = LoggerFactory.getLogger(PostgresConfig.class);

    @Inject
    private Environment env;

    /**
     * @return
     * @deprecated Use Spring Boot's auto-configured {@link DataSource}, which usually uses {@code tomcat-dbcp}.
     */
    @Deprecated
    @Profile("!springDataSource")
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final String jdbcUrl = Preconditions.checkNotNull(env.getProperty("sqlUrl", env.getProperty("spring.datasource.url")),
                "spring.datasource.url configuration is required");
        final String jdbcUser = Preconditions.checkNotNull(env.getProperty("sqlUser", env.getProperty("spring.datasource.username")),
                "spring.datasource.username configuration is required");
        final String jdbcPassword = Preconditions.checkNotNull(env.getProperty("sqlPassword", env.getProperty("spring.datasource.password")),
                "spring.datasource.password configuration is required");
        log.info("Initializing c3p0 Connection Pool to {} as '{}'", jdbcUrl, jdbcUser);
        final ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(POSTGRESQL_DRIVER);
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Cannot load PostgreSQL driver " + POSTGRESQL_DRIVER + ": " + e, e);
        }

//			cpds.setConnectionCustomizerClassName(SoluvasConnectionCustomizer.class.getName());
        cpds.setAutoCommitOnClose(false);
        cpds.setJdbcUrl(jdbcUrl);
        cpds.setUser(jdbcUser);
        cpds.setPassword(jdbcPassword);
        cpds.setTestConnectionOnCheckin(true);
        return cpds;
    }

    /**
     * Note: You need to mark the {@link org.springframework.orm.jpa.JpaTransactionManager} as @{@link Primary}.
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
