package mum.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Long> {

}
