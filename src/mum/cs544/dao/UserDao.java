package mum.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.cs544.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	User findById(long id);

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

}
