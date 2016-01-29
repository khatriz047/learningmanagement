package mum.cs544.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.UserDao;
import mum.cs544.model.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userdao;

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userdao.findAll();
	}

	@Override
	public void updateUserProfile(User user) {
		userdao.updateUserProfile(user.getPrefix(), user.getFirstname(), user.getLastname(), user.getEmail(),
				user.getContactNumber(), user.getCountry(), user.getCity(), user.getState(),user.getZip(),
				user.getId());

	}

	/*
	 * public User findById(int id) { return dao.findById(id); }
	 * 
	 * public User findByUsername(String username) { return
	 * dao.findByUsername(username); }
	 * 
	 * @Override public void saveUser(User user) { dao.persist(user);
	 * 
	 * }
	 * 
	 * @Override public void updateUser(User user) { dao.merge(user);
	 * 
	 * }
	 * 
	 * @Override public void deleteUserById(long id) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public List<User> findAllUsers() { return dao.findAll(); }
	 * 
	 * @Override public void deleteAllUsers() { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public boolean isUserExist(User user) { // TODO Auto-generated
	 * method stub return false; }
	 */

}
