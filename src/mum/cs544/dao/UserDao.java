package mum.cs544.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.cs544.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	@Modifying
	@Query("update mum.cs544.model.User set prefix=:prefix,firstname=:firstname,lastname=:lastname,email=:email,contactNumber=:contactNumber,country=:country,city=:city,state=:state,zip=:zip where id=:id")
	void updateUserProfile(@Param("prefix") String prefix, @Param("firstname") String firstname,
			@Param("lastname") String lastname, @Param("email") String email,
			@Param("contactNumber") String contactNumber, @Param("country") String country, @Param("city") String city,
			@Param("state") String state, @Param("zip") String zip, @Param("id") long id);

}
