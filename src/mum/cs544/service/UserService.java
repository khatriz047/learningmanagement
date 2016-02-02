package mum.cs544.service;

import java.util.List;

import mum.cs544.model.User;

public interface UserService {
	User findByUsername(String username);

	List<User> findAllSchoolUsers();

	List<User> findAllAdminUsers();

	List<User> findAllUsers();

	void updateUserProfile(User user);

	void updateProfilePicture(String imageUrl, long id);

	List<User> findByUsernameOrEmail(String username, String email);

	User findById(long id);

	void updateUserPassword(String password, long id);

	User addUser(User user);

	void activateUser(boolean active, long id);

}