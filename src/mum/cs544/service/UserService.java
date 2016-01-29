package mum.cs544.service;

import java.util.List;

import mum.cs544.model.User;

public interface UserService {
	User findByUsername(String username);
	
	List<User> findAllUsers(); 
	
	void updateUserProfile(User user);

	/*User findById(int id);
	
	User findByUsername(String username);
	
	void saveUser(User user);
    
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);*/
	
}