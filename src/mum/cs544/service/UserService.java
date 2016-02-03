package mum.cs544.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import mum.cs544.model.User;

public interface UserService {
	User findByUsername(String username);

	List<User> findAllSchoolUsers();

	List<User> findAllAdminUsers();

	List<User> findAllUsers();

	List<User> findAllProfessorUsers();

	List<User> findAllStudentUsers();

	void updateUserProfile(User user);

	void updateProfilePicture(String imageUrl, long id);

	List<User> findByUsernameOrEmail(String username, String email);

	User findById(long id);

	void updateUserPassword(String password, long id);

	User addUser(User user);

	void activateUser(boolean active, long id);

	public Map<Long, String> getProfessorsMap();

	Page<User> getProfessorUsers(Integer pageNumber);
}