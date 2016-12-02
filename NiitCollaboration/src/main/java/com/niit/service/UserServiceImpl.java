package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDaoInterface;
import com.niit.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoInterface userdao;
	
	@Transactional
	public void setUserDao(UserDaoInterface userdao)
	{
		this.userdao=userdao;
	}
	@Transactional
	public void saveOrUpdate(User user) {
		userdao.saveOrUpdate(user);
		
	}
	@Transactional
	public User getUserById(int userid) {
		return userdao.getUserById(userid);
	}
	@Transactional
	public List<User> list() {
		
		return userdao.list();
	}
@Transactional
	public User getUserByname(String username) {
	
		return userdao.getUserByname(username);
	}

}
