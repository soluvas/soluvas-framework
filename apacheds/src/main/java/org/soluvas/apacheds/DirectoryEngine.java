package org.soluvas.apacheds;

import java.io.File;
import java.util.HashSet;

import javax.annotation.PreDestroy;

import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.server.constants.ServerDNConstants;
import org.apache.directory.server.core.DefaultDirectoryService;
import org.apache.directory.server.core.api.DirectoryService;
import org.apache.directory.server.core.api.InstanceLayout;
import org.apache.directory.server.core.api.LdapCoreSessionConnection;
import org.apache.directory.server.core.api.partition.Partition;
import org.apache.directory.server.core.api.schema.SchemaPartition;
import org.apache.directory.server.core.partition.impl.btree.jdbm.JdbmIndex;
import org.apache.directory.server.core.partition.impl.btree.jdbm.JdbmPartition;
import org.apache.directory.server.core.partition.ldif.LdifPartition;
import org.apache.directory.server.ldap.LdapServer;
import org.apache.directory.server.protocol.shared.transport.TcpTransport;
import org.apache.directory.server.xdbm.Index;
import org.apache.directory.shared.ldap.model.entry.DefaultEntry;
import org.apache.directory.shared.ldap.model.entry.Entry;
import org.apache.directory.shared.ldap.model.name.Dn;
import org.apache.directory.shared.ldap.model.schema.SchemaManager;
import org.apache.directory.shared.ldap.schemaextractor.SchemaLdifExtractor;
import org.apache.directory.shared.ldap.schemaextractor.impl.DefaultSchemaLdifExtractor;
import org.apache.directory.shared.ldap.schemaloader.LdifSchemaLoader;
import org.apache.directory.shared.ldap.schemamanager.impl.DefaultSchemaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ceefour
 *
 */
public class DirectoryEngine {

	private transient Logger log = LoggerFactory.getLogger(DirectoryEngine.class);
	
    /** The directory service */
    private DirectoryService service;

    /** The LDAP server */
    private LdapServer server;
	private File workDir;
	private boolean serverEnabled;

	private String mainDn;
	private String mainName;

    /**
     * Add a new partition to the server
     *
     * @param partitionId The partition Id
     * @param partitionDn The partition DN
     * @return The newly added partition
     * @throws Exception If the partition can't be added
     */
    private Partition addPartition( String partitionId, String partitionDn ) throws Exception
    {
        // Create a new partition named 'foo'.
        JdbmPartition partition = new JdbmPartition(service.getSchemaManager());
        partition.setId( partitionId );
        partition.setPartitionPath( new File( getWorkDir(), partitionId ).toURI() );
        partition.setSuffixDn( new Dn(partitionDn) );
        service.addPartition( partition );

        return partition;
    }

    /**
     * Add a new partition to the server
     *
     * @param partitionId The partition Id
     * @param partitionDn The partition DN
     * @return The newly added partition
     * @throws Exception If the partition can't be added
     */
    private Partition addSystemPartition( String partitionId, String partitionDn ) throws Exception
    {
        // Create a new partition named 'foo'.
        JdbmPartition partition = new JdbmPartition(service.getSchemaManager());
        partition.setId( partitionId );
        partition.setPartitionPath( new File( getWorkDir(), partitionId ).toURI() );
        partition.setSuffixDn( new Dn(partitionDn) );

        return partition;
    }


    /**
     * Add a new set of index on the given attributes
     *
     * @param partition The partition on which we want to add index
     * @param attrs The list of attributes to index
     */
    private void addIndex( Partition partition, String... attrs )
    {
        // Index some attributes on the apache partition
        HashSet<Index<?, Entry, Long>> indexedAttributes = new HashSet<Index<?, Entry, Long>>();

        for ( String attribute : attrs )
        {
            indexedAttributes.add( new JdbmIndex<String, Entry>( attribute ) );
        }

        ( ( JdbmPartition ) partition ).setIndexedAttributes( indexedAttributes );
    }

    
    /**
     * initialize the schema manager and add the schema partition to diectory service
     *
     * @throws Exception if the schema LDIF files are not found on the classpath
     */
    private void initSchemaPartition() throws Exception
    {
    	SchemaManager schemaManager = service.getSchemaManager();
    	
    	
    	SchemaPartition schemaPartition = new SchemaPartition(schemaManager);
    	service.setSchemaPartition(schemaPartition);

        // Init the LdifPartition
        LdifPartition ldifPartition = new LdifPartition(schemaManager);
        File schemaDir = new File(getWorkDir(), "schema");
        log.info("Schema directory: {}", schemaDir);
		ldifPartition.setPartitionPath( schemaDir.toURI() );

        // Extract the schema on disk (a brand new one) and load the registries
		if (!schemaDir.exists()) {
	        SchemaLdifExtractor extractor = new DefaultSchemaLdifExtractor( getWorkDir() );
	        extractor.extractOrCopy( true );
		}

        schemaPartition.setWrappedPartition( ldifPartition );

//        SchemaLoader loader = new LdifSchemaLoader( schemaDir );
//        SchemaManager schemaManager = new DefaultSchemaManager( loader );
//        service.setSchemaManager( schemaManager );
        schemaManager.setSchemaLoader(new LdifSchemaLoader(schemaDir));

        // We have to load the schema now, otherwise we won't be able
        // to initialize the Partitions, as we won't be able to parse 
        // and normalize their suffix DN
        schemaManager.loadAllEnabled();
//
//        schemaPartition.setSchemaManager( schemaManager );
//
//        List<Throwable> errors = schemaManager.getErrors();
//
//        if ( errors.size() != 0 )
//        {
//            throw new Exception( "Schema load failed : " + errors );
//        }
    }
    
    
    /**
     * Initialize the server. It creates the partition, adds the index, and
     * injects the context entries for the created partitions.
     *
     * @param workDir the directory to be used for storing the data
     * @throws Exception if there were some problems while initializing the system
     */
    private void initDirectoryService( File workDir ) throws Exception
    {
        // Initialize the LDAP service
        service = new DefaultDirectoryService();
        service.setSchemaManager(new DefaultSchemaManager());
//      service.setWorkingDirectory( workDir );
        service.setInstanceLayout(new InstanceLayout(workDir));
        
        // first load the schema
        initSchemaPartition();
        
        // then the system partition
        // this is a MANDATORY partition
        Partition systemPartition = addSystemPartition( "system", ServerDNConstants.SYSTEM_DN );
        service.setSystemPartition( systemPartition );
        
        // Disable the ChangeLog system
        service.getChangeLog().setEnabled( false );
        service.setDenormalizeOpAttrsEnabled( true );

        // Now we can create as many partitions as we need
        log.info("Main DN: {} CN: {}", mainDn, mainName);
        Partition mainPartition = addPartition( "main", getMainDn() );

        // Index some attributes on the main partition
        // TODO: fbId should be indexed too. Make this configurable
        addIndex( mainPartition, "objectClass", "ou", "uid", "cn", "mail" );

        // And start the service
        service.startup();

        // Inject the root entry
        LdapConnection conn = new LdapCoreSessionConnection(service);
        if ( !conn.exists(mainPartition.getSuffixDn() ) )
        {
        	log.info("Creating root entry {} with cn=", mainDn, mainName);
            Dn dnMain = new Dn( getMainDn() );
            Entry entryMain = new DefaultEntry( dnMain );
            entryMain.add( "objectClass", "top", "domain", "extensibleObject" );
            entryMain.add( "cn", getMainName() );
            conn.add(entryMain);
        }

        // We are all done !
    }


    /**
     * starts the LdapServer
     *
     * @throws Exception
     */
    public void startServer() throws Exception
    {
        server = new LdapServer();
        int serverPort = 10389;
		log.info("Listening to LDAP connections at port {}", serverPort);

        server.setTransports( new TcpTransport( serverPort ) );
        server.setDirectoryService( service );
        
        server.start();
    }

	public void start() throws Exception {
		// Sanity checks
		if (workDir == null)
			throw new RuntimeException("ApacheDS workDir must be configured");
		if (mainDn == null || mainDn.isEmpty())
			throw new RuntimeException("ApacheDS mainDn must be configured");
		if (mainName == null || mainName.isEmpty())
			throw new RuntimeException("ApacheDS mainName must be configured");
		
		log.info("Starting embedded ApacheDS at {}", workDir);
		
//    	String tmpDir = System.getProperty( "java.io.tmpdir" );
//    	if (System.getenv("OPENSHIFT_DATA_DIR") != null)
//    		tmpDir = System.getenv("OPENSHIFT_DATA_DIR"); 
//        workDir = new File(tmpDir, "server-work" );
        
        getWorkDir().mkdirs();
        
        // Create the server
        initDirectoryService( getWorkDir() );

////        CoreSession session = service.getAdminSession();
//        LdapConnection ldap = new LdapCoreSessionConnection(service);
//        
//        // Read an entry
//        Entry result = ldap.lookup( new Dn( "dc=apache,dc=org" ) );

        // And print it if available
//        System.out.println( "Found entry : " + result );
        
        // optionally we can start a server too
        if (isServerEnabled())
        	startServer();
	}
	
	public LdapConnection createConnection() {
		return new LdapCoreSessionConnection(service);
	}
	
	@PreDestroy public void destroy() throws Exception {
		log.info("Shutting down ApacheDS...");
		if (server != null)
			server.stop();
		if (service != null)
			service.shutdown();
	}
	
	public boolean isServerEnabled() {
		return serverEnabled;
	}

	public void setServerEnabled(boolean serverEnabled) {
		this.serverEnabled = serverEnabled;
	}

	public File getWorkDir() {
		return workDir;
	}

	public void setWorkDir(File workDir) {
		this.workDir = workDir;
	}

	public String getMainDn() {
		return mainDn;
	}

	/**
	 * Set the DN of the main partition.
	 * @param mainDn
	 */
	public void setMainDn(String mainDn) {
		this.mainDn = mainDn;
	}

	public String getMainName() {
		return mainName;
	}
	
	/**
	 * Set the CN (Common Name) of the main partition.
	 * @param mainName
	 */
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	
}
