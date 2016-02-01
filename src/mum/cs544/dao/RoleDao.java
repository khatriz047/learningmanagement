package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

	Role save(Role role);
	
}
