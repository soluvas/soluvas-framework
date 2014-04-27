package org.soluvas.jpa.shell;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.Nullable;
import javax.sql.DataSource;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.DefaultComponentSafeNamingStrategy;
import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Type;
import org.hibernate.tool.hbm2ddl.Target;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

/**
 * Export the SQL schema for the current tenant via Hibernate {@link SchemaExport}. 
 * @see https://hibernate.atlassian.net/browse/HHH-7389?focusedCommentId=47618&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-47618
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="jpa", name="schemaexport", description="Export the SQL schema for the current tenant via Hibernate SchemaExport.")
public class SchemaExportCommand extends ExtCommandSupport {
	
	@Autowired(required=false)
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
		Preconditions.checkNotNull(dataSource, "dataSource bean is required");
		final String tenantId = getTenant().getTenantId();
		final File outputFile = file != null ? new File(file) : File.createTempFile(tenantId + "_", ".schema.sql");
		try (Connection conn = dataSource.getConnection()) {
			try (Statement st = conn.createStatement()) {
				try {
					st.executeUpdate("SET SCHEMA '" + tenantId + "'");
					
					final Configuration configuration = new Configuration()
						.addAnnotatedClass(Class.forName("com.quikdo.schema.core.jpa._1.Place"))
						.setProperty(org.hibernate.cfg.Environment.DIALECT, PostgreSQL82Dialect.class.getName())
						.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, String.valueOf(showSql))
						.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, "true")
						// https://hibernate.atlassian.net/browse/ANN-99?focusedCommentId=22432&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-22432
						// note: setting org.hibernate.ejb.HibernatePersistence.NAMING_STRATEGY won't work in this case
						.setNamingStrategy(new DefaultComponentSafeNamingStrategy());
//						.setProperty(org.hibernate.ejb.HibernatePersistence.NAMING_STRATEGY, DefaultComponentSafeNamingStrategy.class.getName());
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
