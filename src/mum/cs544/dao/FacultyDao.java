package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mum.cs544.model.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Long> {
	
}
