package com.rudev.hr_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rudev.hr_user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//@Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.email = :email")
    //User findByEmail(@Param("email") String email);

	User findByEmail(String email);
	
}
