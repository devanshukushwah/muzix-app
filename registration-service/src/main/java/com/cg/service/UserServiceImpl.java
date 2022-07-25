package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.exception.UserAlreadyExistException;
import com.cg.model.User;
import com.cg.model.UserWithConfirmPassword;
import com.cg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User addUser(UserWithConfirmPassword user) throws UserAlreadyExistException {
		if(userRepository.existsById(user.getEmail())) throw new UserAlreadyExistException();
		
		String encryptPassword = bCryptPasswordEncoder.encode(user.getPassword());
		User save = userRepository.save(new User(user.getEmail(), encryptPassword)); 
		return save;
	}

}
