package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.cs544.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findById(long id);

	@Modifying
	@Query("select s from mum.cs544.model.School s")
	List<User> findAllSchoolUsers();

	@Modifying
	@Query("select p from mum.cs544.model.Professor p")
	List<User> findAllProfessorUsers();

	@Modifying
	@Query("select a from mum.cs544.model.Admin a")
	List<User> findAllAdminUsers();

	@Modifying
	@Query("select s from mum.cs544.model.Student s")
	List<User> findAllStudentUsers();

	@Modifying
	@Query("update mum.cs544.model.User set prefix=:prefix,firstname=:firstname,lastname=:lastname,email=:email,contactNumber=:contactNumber,country=:country,city=:city,state=:state,zip=:zip,address=:address where id=:id")
	void updateUserProfile(@Param("prefix") String prefix, @Param("firstname") String firstname,
			@Param("lastname") String lastname, @Param("email") String email,
			@Param("contactNumber") String contactNumber, @Param("country") String country, @Param("city") String city,
			@Param("state") String state, @Param("zip") String zip, @Param("address") String address,
			@Param("id") long id);

	List<User> findByUsernameOrEmail(String username, String email);

	@Modifying
	@Query("update mum.cs544.model.User set password=:password where id=:id")
	void updateUserPassword(@Param("password") String password, @Param("id") long id);

	@Modifying
	@Query("update mum.cs544.model.User set imageUrl=:imageUrl where id=:id")
	void updateProfilePicture(@Param("imageUrl") String imageUrl, @Param("id") long id);

	@Modifying
	@Query("update mum.cs544.model.User set active=:active where id=:id")
	void activateUser(@Param("active") boolean active, @Param("id") long id);

}
