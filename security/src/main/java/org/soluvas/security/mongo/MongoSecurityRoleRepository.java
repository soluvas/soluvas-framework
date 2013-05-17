package org.soluvas.security.mongo;

import org.joda.time.DateTime;
import org.soluvas.data.repository.PagingAndSortingRepository;
import org.soluvas.data.repository.Repository;
import org.soluvas.mongo.MongoRepositoryBase;
import org.soluvas.security.Role;
import org.soluvas.security.impl.RoleImpl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Security {@link Role} {@link Repository} stored in MongoDB.
 * @author ceefour
 */
public class MongoSecurityRoleRepository extends MongoRepositoryBase<Role>
		implements PagingAndSortingRepository<Role, String> {

	public MongoSecurityRoleRepository(String mongoUri) {
		super(Role.class, RoleImpl.class, RoleImpl.CURRENT_SCHEMA_VERSION, mongoUri, "securityRole",
				ImmutableList.<String>of(), ImmutableMap.of(
						"creationTime", -1,
						"modificationTime", -1));
	}
	
	@Override
	protected void beforeSave(Role entity) {
		super.beforeSave(entity);
		if (entity.getCreationTime() == null) {
			entity.setCreationTime(new DateTime());
		}
		entity.setModificationTime(new DateTime());
	}

}
