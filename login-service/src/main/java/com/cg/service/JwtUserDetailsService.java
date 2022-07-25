package com.cg.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.cg.model.User> findById = userRepo.findById(username);
		if (findById.isEmpty())
			throw new UsernameNotFoundException("User not found with username: " + username);

		com.cg.model.User foundUser = findById.get();

		return new User(foundUser.getEmail(), foundUser.getPassword(), new ArrayList<>());

	}
}
