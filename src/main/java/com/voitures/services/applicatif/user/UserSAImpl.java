package com.voitures.services.applicatif.user;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.voitures.data.entity.User;
import com.voitures.services.repository.UserRepository;

/**
 *
 * @author e.livaniaina
 */
@Service
public class UserSAImpl implements UserDetailsService, UserSA {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	String username = "userdefault";
	String password = "PassUserDef";
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
		}
		throw new UsernameNotFoundException("Username not found.");
	}
	
	
	@PostConstruct
	public void init() {
		importDefaultUser();
	}

	public void importDefaultUser() {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			user = new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			userRepository.save(user);
		}
	}

}
