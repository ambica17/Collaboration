package com.niit.service;

import java.util.List;

import com.niit.model.User;

public interface UserService {
	public void saveOrUpdate(User user);
	public User getUserById(int userid);
	public  List<User> list();
	public User getUserByname(String username);
}
