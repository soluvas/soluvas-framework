package org.soluvas.security.couchdb;

import java.net.URI;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.http.conn.ClientConnectionManager;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.ektorp.ViewResult.Row;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.couchdb.CouchDbPersonRepository;
import org.soluvas.couchdb.CouchDbRepositoryException;
import org.soluvas.couchdb.SoluvasObjectMapperFactory;
import org.soluvas.data.repository.AssocRepositoryBase;
import org.soluvas.security.Role;
import org.soluvas.security.RolePersonRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;

/**
 * Associates {@link Role} ID with CouchDB {@link Person} IDs, this is implemented by
 * storing the tenant-scoped {@link Role} IDs inside {@link Person#getSecurityRoleIds()}.
 * 
 * <p>Note: While the implementation is decoupled from {@link CouchDbPersonRepository} for flexibility,
 * it still depends on the views created by {@link CouchDbPersonRepository}. Otherwise,
 * this implementation won't work. Also, it requires the latest schema version of {@link Person}.
 * 
 * @author ceefour
 * @todo App-scoped role/person assignments?
 */
public class CouchDbRolePersonRepository extends AssocRepositoryBase<String, String>
	implements RolePersonRepository {

	private final String couchDbUri;
	private final String dbName;
	private final Logger log;
	private StdCouchDbConnector dbConn;
	/**
	 * @see CouchDbPersonRepository
	 */
	public static final String COLL_NAME = "person";
	/**
	 * @see CouchDbPersonRepository
	 */
	public static final String DESIGN_DOC_ID = "_design/Person";
	
	public CouchDbRolePersonRepository(ClientConnectionManager connMgr, String couchDbUri, String dbName) {
		super();
		this.couchDbUri = couchDbUri;
		this.dbName = dbName;
		
		// WARNING: couchDbUri may contain password!
		final URI realCouchDbUri = URI.create(couchDbUri);
		this.log = LoggerFactory.getLogger(getClass().getName() + "/" + dbName + "/" + COLL_NAME);
		final String username = realCouchDbUri.getUserInfo() != null ? realCouchDbUri.getUserInfo().split(":")[0] : null;
		log.info("Creating CouchDB connector {}:{}{} database {} as {} for {}",
				realCouchDbUri.getHost(), realCouchDbUri.getPort(), realCouchDbUri.getPath(), dbName, username, COLL_NAME);
		try {
			final HttpClient client = new StdHttpClient.Builder().connectionManager(connMgr).url(couchDbUri).build();
			final StdCouchDbInstance dbInstance = new StdCouchDbInstance(client, SoluvasObjectMapperFactory.INSTANCE);
			dbConn = new StdCouchDbConnector(dbName, dbInstance, SoluvasObjectMapperFactory.INSTANCE);
		} catch (Exception e) {
			throw new CouchDbRepositoryException(e, "Cannot connect to CouchDB %s:%s%s database %s as %s for %s repository",
					realCouchDbUri.getHost(), realCouchDbUri.getPort(), realCouchDbUri.getPath(), dbName, username, COLL_NAME);
		}
	}
	
	public String getCouchDbUri() {
		return couchDbUri;
	}
	
	public String getDbName() {
		return dbName;
	}

	@Override
	public boolean put(String roleId, String personId) {
		final ObjectNode personNode = (ObjectNode) dbConn.get(JsonNode.class, "Person_" + personId);
		final LinkedHashSet<String> tenantRoleIds;
		if (personNode.get("securityRoleIds") instanceof ArrayNode) {
			tenantRoleIds = new LinkedHashSet<>(FluentIterable.from(personNode.get("securityRoleIds")).transform(new Function<JsonNode, String>() {
				@Override @Nullable
				public String apply(@Nullable JsonNode input) {
					return input.asText();
				}
			}).toSet());
		} else {
			tenantRoleIds = new LinkedHashSet<>();
		}
		final boolean added = tenantRoleIds.add(roleId);
		personNode.set("securityRoleIds", SoluvasObjectMapperFactory.INSTANCE.createObjectMapper().valueToTree(tenantRoleIds));
		dbConn.update(personNode);
		if (added) {
			log.info("Assigned tenant role {} to person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		} else {
			log.debug("Tenant role {} not added to person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		}
		return added;
	}

	@Override
	public boolean delete(String roleId, String personId) {
		final ObjectNode personNode = (ObjectNode) dbConn.get(JsonNode.class, "Person_" + personId);
		final LinkedHashSet<String> tenantRoleIds;
		if (personNode.get("securityRoleIds") instanceof ArrayNode) {
			tenantRoleIds = new LinkedHashSet<>(FluentIterable.from(personNode.get("securityRoleIds")).transform(new Function<JsonNode, String>() {
				@Override @Nullable
				public String apply(@Nullable JsonNode input) {
					return input.asText();
				}
			}).toSet());
		} else {
			tenantRoleIds = new LinkedHashSet<>();
		}
		final boolean removed = tenantRoleIds.remove(roleId);
		personNode.set("securityRoleIds", SoluvasObjectMapperFactory.INSTANCE.createObjectMapper().valueToTree(tenantRoleIds));
		dbConn.update(personNode);
		if (removed) {
			log.info("Unassigned tenant role {} from person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		} else {
			log.debug("Tenant role didn't exist {} in person {}. Current tenant roles: {}", roleId, personId, tenantRoleIds);
		}
		return removed;
	}

	@Override
	public Multimap<String, String> findAll() {
		final ViewQuery viewQuery = new ViewQuery().designDocId(DESIGN_DOC_ID).viewName(CouchDbPersonRepository.VIEW_SECURITY_ROLE_IDS)
				.reduce(false);
		final ViewResult viewResult = dbConn.queryView(viewQuery);
		final ImmutableMultimap.Builder<String, String> rolePeopleb = ImmutableMultimap.builder();
		for (final Row row : viewResult) {
			rolePeopleb.put(row.getValue(), row.getKey());
		}
		final ImmutableMultimap<String, String> rolePeople = rolePeopleb.build();
		log.debug("findAll returned {} assocs: {}", rolePeople.size(), Iterables.limit(rolePeople.entries(), 10));
		return rolePeople;
	}

	@Override
	public List<String> getLeft(String roleId) {
		final ViewQuery viewQuery = new ViewQuery().designDocId(DESIGN_DOC_ID).viewName(CouchDbPersonRepository.VIEW_SECURITY_ROLE_MEMBERS)
				.key(roleId).reduce(false);
		final ViewResult viewResult = dbConn.queryView(viewQuery);
		final ImmutableList<String> roleIds = FluentIterable.from(viewResult).transform(new Function<Row, String>() {
			@Override @Nullable
			public String apply(@Nullable Row input) {
				return input.getValue();
			}
		}).toList();
		log.debug("getMembers for role '{}' returned {}: {}", roleId, roleIds.size(), Iterables.limit(roleIds, 10));
		return roleIds;
	}

	@Override
	public List<String> getRight(String personId) {
		final ViewQuery viewQuery = new ViewQuery().designDocId(DESIGN_DOC_ID).viewName(CouchDbPersonRepository.VIEW_SECURITY_ROLE_IDS)
				.key(personId).reduce(false);
		final ViewResult viewResult = dbConn.queryView(viewQuery);
		final ImmutableList<String> roleIds = FluentIterable.from(viewResult).transform(new Function<Row, String>() {
			@Override @Nullable
			public String apply(@Nullable Row input) {
				return input.getValue();
			}
		}).toList();
		log.debug("getRoles for person '{}' returned {}: {}", personId, roleIds.size(), Iterables.limit(roleIds, 10));
		return roleIds;
	}
	
}
