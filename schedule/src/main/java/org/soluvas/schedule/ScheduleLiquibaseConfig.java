package org.soluvas.schedule;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Automatically creates Quartz tables in {@code public} schema.
 * Requires {@code org.liquibase:liquibase-core}.
 * Must be before {@link ScheduleConfig}.
 * Usage: 1. {@link org.springframework.context.annotation.Import} this, 2. Set application property {@code quartz.migrate=true}
 * Created by ceefour on 6/11/15.
 */
@Configuration
public class ScheduleLiquibaseConfig {

    public static final String QUARTZ_LIQUIBASE_XML = "org/soluvas/schedule/quartz.liquibase.xml";
    private static final Logger log = LoggerFactory.getLogger(ScheduleLiquibaseConfig.class);

    @Inject
    private DataSource dataSource;

    public void migrate() {
        final ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(ScheduleLiquibaseConfig.class.getClassLoader());
        final PostgresDatabase db = new PostgresDatabase();
        try {
            final Liquibase liquibase;
            try {
                liquibase = new Liquibase(QUARTZ_LIQUIBASE_XML, resourceAccessor, db);
            } catch (Exception e) {
                throw new ScheduleException(e, "Cannot migrate Quartz using '%s': %s", QUARTZ_LIQUIBASE_XML, e);
            }
            log.info("Migrating Quartz using {}", QUARTZ_LIQUIBASE_XML);
            final Contexts contexts = new Contexts();
            try (final Connection conn = dataSource.getConnection()) {
                // TODO: SET SCHEMA is workaround for Liquibase's not setting schema for <sql>. https://liquibase.jira.com/browse/CORE-1873
                final Statement st = conn.createStatement();
                st.executeUpdate("SET SCHEMA 'public'");
                final JdbcConnection jdbc = new JdbcConnection(conn);
                db.setDefaultSchemaName("public");
                try {
                    db.setConnection(jdbc);
                    liquibase.update(contexts);
                } finally {
                    st.executeUpdate("SET SCHEMA 'public'");
                }
            } catch (Exception e) {
                throw new ScheduleException(e, "Cannot migrate Quartz using '%s': %s", QUARTZ_LIQUIBASE_XML, e);
            }
        } finally {
            try {
                db.close(); // https://liquibase.jira.com/browse/CORE-2392
            } catch (Exception e) {
                log.debug("Ignoring close database error: " + e);
            }
        }
    }
}
