package mum.cs544.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.dao.RoleDao;
import mum.cs544.dao.UserDao;
import mum.cs544.model.Admin;
import mum.cs544.model.Professor;
import mum.cs544.model.Role;
import mum.cs544.model.School;
import mum.cs544.model.Student;
import mum.cs544.model.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userdao;

	@Resource
	private RoleDao roledao;

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
				user.getContactNumber(), user.getCountry(), user.getCity(), user.getState(), user.getZip(),
				user.getAddress(), user.getId());

	}

	@Override
	public List<User> findByUsernameOrEmail(String username, String email) {
		return userdao.findByUsernameOrEmail(username, email);
	}

	@Override
	public User findById(long id) {
		return userdao.findById(id);
	}

	@Override
	public void updateUserPassword(String password, long id) {
		userdao.updateUserPassword(password, id);

	}

	@Override
	public void activateUser(boolean active, long id) {
		userdao.activateUser(active, id);

	}

	@Override
	public List<User> findAllSchoolUsers() {
		return userdao.findAllSchoolUsers();
	}

	@Override
	public List<User> findAllAdminUsers() {
		return userdao.findAllAdminUsers();
	}

	@Override
	public List<User> findAllProfessorUsers() {
		return userdao.findAllProfessorUsers();
	}

	@Override
	public User addUser(User user) {

		Role role = null;
		if (user instanceof School) {
			role = roledao.findByType("SCHOOL");
			user = (School) user;
		} else if (user instanceof Admin) {
			role = roledao.findByType("ADMIN");
			user = (Admin) user;
		} else if (user instanceof Professor) {
			role = roledao.findByType("PROFESSOR");
			user = (Professor) user;
		} else if (user instanceof Student) {
			role = roledao.findByType("STUDENT");
			user = (Student) user;
		}

		user.addRole(role);
		user.setActive(true);

		return userdao.save(user);
	}

	@Override
	public void updateProfilePicture(String imageUrl, long id) {
		userdao.updateProfilePicture(imageUrl, id);

	}

}
