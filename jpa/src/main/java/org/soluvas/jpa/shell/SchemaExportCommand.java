package org.soluvas.jpa.shell;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Type;
import org.hibernate.tool.hbm2ddl.Target;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Export the SQL schema for the current tenant via Hibernate {@link SchemaExport}. 
 * @see https://hibernate.atlassian.net/browse/HHH-7389?focusedCommentId=47618&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-47618
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="jpa", name="schemaexport", description="Export the SQL schema for the current tenant via Hibernate SchemaExport.")
public class SchemaExportCommand extends ExtCommandSupport {
	
	@Inject
	private DataSource dataSource;
	
	@Option(name="-g", description="Target: SCRIPT (file) | EXPORT (database) | BOTH.")
	private transient Target target = Target.SCRIPT;
	@Option(name="-t", description="Type: CREATE | DROP | BOTH.")
	private transient Type type = Type.CREATE;
	@Option(name="-s", description="Show SQL, i.e. print the SQL to standard out.")
	private transient boolean showSql = true;
	@Option(name="-d", description="Delete the script file after execution")
	private transient boolean deleteAfter = false;
	@Nullable
	@Argument(name="file", required=false, description="Target script file to export. If not supplied, will use a temporary file name.")
	private String file;
	
	@Override
	protected File doExecute() throws Exception {
		final String tenantId = getTenant().getTenantId();
		final File outputFile = file != null ? new File(file) : File.createTempFile(tenantId + "_", ".schema.sql");
		try (Connection conn = dataSource.getConnection()) {
			try (Statement st = conn.createStatement()) {
				try {
					st.executeUpdate("SET SCHEMA '" + tenantId + "'");
					
					final Configuration configuration = new Configuration()
						.addAnnotatedClass(Class.forName("com.quikdo.schema.core.jpa._1.Place"))
						.setProperty("hibernate.dialect", PostgreSQL82Dialect.class.getName())
						.setProperty("hibernate.show_sql", String.valueOf(showSql));
					final SchemaExport export = new SchemaExport(configuration, conn);
					export.setFormat(true);
					export.setOutputFile(outputFile.getPath());
					export.setDelimiter(";");
					export.execute(target, type);
		//			export.execute(true, true, false, true);
				} finally {
					st.executeUpdate("SET SCHEMA 'public'");
				}
			}
		}
		return outputFile;
	}

}