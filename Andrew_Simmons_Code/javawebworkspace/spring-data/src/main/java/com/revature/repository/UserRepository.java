package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;




/*
 * Spring data takes very opinonated approach to basic data persistence functionality
 * 
 * What does that mean?
 * Well, we don't actually need to write methods
 * 
 * By creating an interface the extends JPA interface in spring data api,  we inherit its functionality and based on the class and id, we automatically have basic crud functionality
 * 
 * all other functionality is done via the parsing of method names
 * 
 * however, you can, of course, still write HQL
 * 
 * 
 * 
 */

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	User findByUsernameLikeIgnoreCase(String username);

	
//	User findbyPasswordLikeIgnoreCase(String password);
	
	
	
	
	@Query("SELECT u FROM User u WHERE length(u.username)>10")
	public List<User> lengthQuery();
	
	

}
