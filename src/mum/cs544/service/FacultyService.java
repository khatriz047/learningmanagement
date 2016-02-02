package mum.cs544.service;

import java.util.List;

import mum.cs544.model.Faculty;

public interface FacultyService {

	Faculty addFaculty(Faculty faculty);

	List<Faculty> getFaculties();

	void delete(long id);

}
