package com.Backend.PACER.services.interfaces;

import com.Backend.PACER.entities.User;

public interface UserService {
	User getUserById(Long id);
	User createUser(User user);
	User updateUser(Long id , User user);
	void deleteUser(Long id);
}
