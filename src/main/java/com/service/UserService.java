package com.service;

import com.entity.User;

public interface UserService {
	void insert(User user);
	User queryByUsernameAndPassword(String username,String password);
}
