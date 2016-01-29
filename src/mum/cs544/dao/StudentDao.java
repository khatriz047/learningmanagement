package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.User;

public interface StudentDao extends JpaRepository<User, Integer> {

}
