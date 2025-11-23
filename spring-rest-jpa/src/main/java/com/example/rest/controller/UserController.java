package com.example.rest.controller;

import com.example.rest.model.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		user.setId(id);
		return userService.saveUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

}
