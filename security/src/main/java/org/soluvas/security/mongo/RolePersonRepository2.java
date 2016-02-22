package org.soluvas.security.mongo;

import java.util.List;

import org.soluvas.security.Role2;

/**
 * @author anisa
 *
 */
public interface RolePersonRepository2 {
	
	List<Role2> addAll(List<Role2> upRoleList);
	
	List<Role2> findAll();

}
