package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDaoInterface {
	public void saveOrUpdate(User user);
	public User getUserById(int userid);
	public  List<User> list();
	public User getUserByname(String username);
}
