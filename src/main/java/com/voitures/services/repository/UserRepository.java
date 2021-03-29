package com.voitures.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voitures.data.entity.User;

/**
 *
 * @author e.livaniaina
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
