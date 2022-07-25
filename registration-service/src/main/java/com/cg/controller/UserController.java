package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserAlreadyExistException;
import com.cg.model.User;
import com.cg.model.UserWithConfirmPassword;
import com.cg.service.UserService;

@RestController
@RequestMapping("/registration/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public User addUser(@RequestBody @Valid UserWithConfirmPassword user)  throws UserAlreadyExistException  {
		return userService.addUser(user);
	}
}
