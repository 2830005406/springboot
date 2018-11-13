package com.service;

import com.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDAO.insert(user);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public User queryByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.queryByUsernameAndPassword(username, password);
	}

}
