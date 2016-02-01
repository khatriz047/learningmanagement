package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Role;

public interface RoleService {

	Role addRole(Role role);

	List<Role> getRoles();

	void delete(long id);
	
}
