package com.example.rest.service;

import com.example.rest.model.User;
import java.util.List;

public interface UserService {

	List<User> getAllUsers();

	User getUserById(Integer id);

	User saveUser(User user);

	void deleteUser(Integer id);

}
