package com.example.rest.service;

import com.example.rest.model.User;
import com.example.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public User getUserById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	public User saveUser(User user) {
		return repo.save(user);
	}

	public void deleteUser(Integer id) {
		repo.deleteById(id);
	}

}
