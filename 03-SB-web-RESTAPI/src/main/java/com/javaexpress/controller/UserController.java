package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entities.User;
import com.javaexpress.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;

	// json
	@PostMapping
	public void createUser(@RequestBody User user) {
		log.info("UserController :: createUser {} ",user);
		userService.createUser(user);
	}
	
	// http://localhost:8080/api/v1/user/67
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Long userId) {
		log.info("UserController :: getUserById {} ",userId);
		return userService.findUserById(userId);
	}
	
	@GetMapping("username/{username}")
	public void fetchUserInformatioByUsername(@PathVariable String userId) {
		log.info("UserController :: getUserById {} ",userId);
		//return userService.findUserById(userId);
	}
	
	@PutMapping("{userId}")
	public void updateUser(@PathVariable Long userId,@RequestBody User user) {
		userService.updateUser(userId, user);
	}
	
	// http://localhost:8080/api/v1/user/changepwd/{45}
	@PatchMapping("changepwd/{userId}")
	public void updatePassword(@PathVariable Long userId,@RequestBody User user) {
		userService.updatePassword(userId, user);
	}
	
	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	
}
