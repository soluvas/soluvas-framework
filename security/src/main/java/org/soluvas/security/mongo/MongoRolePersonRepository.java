package org.soluvas.security.mongo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.data.repository.AssocRepositoryBase;
import org.soluvas.security.Role;

import com.google.common.collect.Multimap;

/**
 * Associates {@link Role} ID with MongoDB {@link Person} IDs, this is implemented by
 * storing the tenant-scoped {@link Role} IDs inside {@link Person#getSecurityRoleIds()}.
 * @author ceefour
 * @todo App-scoped role/person assignments?
 */
public class MongoRolePersonRepository extends AssocRepositoryBase<String, String> {

	private static final Logger log = LoggerFactory
			.getLogger(MongoRolePersonRepository.class);

	@Override
	public boolean put(String left, String right) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(String left, String right) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Multimap<String, String> findAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> getLeft(String left) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> getRight(String right) {
		throw new UnsupportedOperationException();
	}
	
}
