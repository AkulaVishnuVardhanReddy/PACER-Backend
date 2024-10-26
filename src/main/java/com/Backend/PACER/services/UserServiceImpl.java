package com.Backend.PACER.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.PACER.entities.User;
import com.Backend.PACER.repositories.UserRepository;
import com.Backend.PACER.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}
	
	@Override
	public User updateUser(Long id , User user) {
		if(userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		}
		return null;
	}
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
