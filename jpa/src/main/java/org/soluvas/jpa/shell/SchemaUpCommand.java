package org.soluvas.jpa.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.sql.Connection;

import javax.annotation.Nullable;
import javax.sql.DataSource;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.change.Change;
import liquibase.change.ColumnConfig;
import liquibase.change.core.CreateIndexChange;
import liquibase.change.core.CreateTableChange;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.ChangeSet.ExecType;
import liquibase.changelog.ChangeSet.RunStatus;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.changelog.visitor.ChangeExecListener;
import liquibase.database.Database;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.PreconditionErrorException;
import liquibase.exception.PreconditionFailedException;
import liquibase.precondition.core.PreconditionContainer.ErrorOption;
import liquibase.precondition.core.PreconditionContainer.FailOption;
import liquibase.resource.ClassLoaderResourceAccessor;

/**
 * Runs {@link Liquibase#update(liquibase.Contexts)}. 
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="jpa", name="schemaup", description="Updates SQL schema for the current tenant using Liquibase.")
public class SchemaUpCommand extends ExtCommandSupport {
	
	@Autowired(required=false)
	private DataSource dataSource;
	
	@Option(name="-s", aliases="--schema", description="Default schema name. (defaults to current tenantId)")
	private String defaultSchemaName;
	@Argument(name="schemaFile", required=true,
		description="Liquibase schema file, loaded from the classpath, e.g. \"com/quikdo/guardian/core/guardian-analytics\". The \".liquibase.xml\" suffix is implied.")
	private String schemaFile;
	
	public static String getChangeDescription(Change change) {
		if (change instanceof CreateTableChange) {
			final CreateTableChange createTable = (CreateTableChange) change;
			return "CREATE TABLE " + createTable.getTableName() + " " +
					FluentIterable.from(createTable.getColumns()).transform(new Function<ColumnConfig, String>() {
						@Override @Nullable
						public String apply(@Nullable ColumnConfig input) {
							return input.getName() + " " + input.getType();
						}
					});
		} else if (change instanceof CreateIndexChange) {
			final CreateIndexChange createIndex = (CreateIndexChange) change;
			return "CREATE INDEX " + createIndex.getIndexName() + " ON " + createIndex.getTableName();
		} else {
			return change.getClass().getSimpleName();
		}
	}
	
	@Override
	protected Void doExecute() throws Exception {
		Preconditions.checkNotNull(dataSource, "dataSource bean is required");
		if (Strings.isNullOrEmpty(defaultSchemaName)) {
			final String tenantId = getTenant().getTenantId();
			defaultSchemaName = tenantId;
		}
		if (!schemaFile.endsWith(".xml")) {
			schemaFile += ".liquibase.xml";
		}
		System.out.println(ansi().render("Updating schema @|bold %s|@ using @|bold %s|@", defaultSchemaName, schemaFile));
		
		final Contexts contexts = new Contexts();
		final ClassLoaderResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(SchemaUpCommand.class.getClassLoader());
		try (Connection conn = dataSource.getConnection()) {
			final JdbcConnection jdbc = new JdbcConnection(conn);
			final PostgresDatabase db = new PostgresDatabase();
			try {
				db.setConnection(jdbc);
				db.setDefaultSchemaName(defaultSchemaName);
				final Liquibase liquibase = new Liquibase(schemaFile, resourceAccessor, db);
				System.out.println(ansi().render("Database: @|bold %s|@", db));
				liquibase.setChangeExecListener(new ChangeExecListener() {
					
					@Override
					public void willRun(Change change, ChangeSet changeSet,
							DatabaseChangeLog changeLog, Database database) {
						System.err.println(ansi().render("@|blue %s|@ > @|bold %s|@",
								changeSet, getChangeDescription(change)));
					}
					
					@Override
					public void willRun(ChangeSet changeSet,
							DatabaseChangeLog databaseChangeLog, Database database,
							RunStatus runStatus) {
						System.err.println(ansi().render("@|bold %s|@ @|blue %s|@",
								runStatus, changeSet));
					}
					
					@Override
					public void rolledBack(ChangeSet changeSet,
							DatabaseChangeLog databaseChangeLog, Database database) {
						System.err.println(ansi().render("Rolled back: @|bold %s|@",
								changeSet));
					}
					
					@Override
					public void ran(Change change, ChangeSet changeSet,
							DatabaseChangeLog changeLog, Database database) {
						System.err.println(ansi().render("Ran @|blue %s|@ > @|bold %s|@",
								changeSet, getChangeDescription(change)));
					}
					
					@Override
					public void ran(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog,
							Database database, ExecType execType) {
						System.err.println(ansi().render("@|bold %s|@ @|blue %s|@",
								execType, changeSet));
					}
					
					@Override
					public void preconditionFailed(PreconditionFailedException error,
							FailOption onFail) {
						System.err.println(ansi().render("Precondition failed: @|bold %s|@ @|bold %s|@",
								error, onFail));
					}
					
					@Override
					public void preconditionErrored(PreconditionErrorException error,
							ErrorOption onError) {
						System.err.println(ansi().render("Precondition errored: @|bold %s|@ @|bold %s|@",
								error, onError));
					}

					@Override
					public void runFailed(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database,
							Exception exception) {
						System.err.println(ansi().render("Run failed: @|bold %s|@ @|blue %s|@",
								changeSet, exception));
					}
				});
				liquibase.update(contexts);
			} finally {
				db.close();
			}
		}
		
		return null;
	}

}
