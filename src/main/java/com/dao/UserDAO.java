package com.dao;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserDAO {
	void insert(User user);
	User queryByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
