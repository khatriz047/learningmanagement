package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Resource;

public interface ResourceDao extends JpaRepository<Resource, Long> {

}
