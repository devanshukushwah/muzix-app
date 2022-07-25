package com.cg.service;

import com.cg.exception.UserAlreadyExistException;
import com.cg.model.User;
import com.cg.model.UserWithConfirmPassword;

public interface UserService {
	public User addUser(UserWithConfirmPassword user)  throws UserAlreadyExistException ;
}
