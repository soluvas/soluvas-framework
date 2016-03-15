package org.soluvas.security.mongo;

import java.util.List;

import javax.annotation.Nullable;

import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.security.Role2;

/**
 * @author anisa
 *
 */
public interface RolePersonRepository2 {
	
	List<Role2> addAll(List<Role2> upRoleList);
	
	List<Role2> findAll();
	
	Page<Role2> findAll(String searchText, Pageable pageable);
	
	long count(String searchText);
	
	@Nullable Role2 findOne(String id);
	
	Role2 add(Role2 newRole);
	
	Role2 modify(String id, Role2 upRole);
	
	Role2 addDomain(String id, Role2 upRole);
}
