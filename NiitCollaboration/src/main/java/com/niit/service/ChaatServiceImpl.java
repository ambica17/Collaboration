package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ChatDaoInterface;
import com.niit.model.Chat;
import com.niit.model.Message;

@Service
public class ChaatServiceImpl implements ChaatService {

@Autowired
ChatDaoInterface chatdao;
	public void save(Chat chat) {
		chatdao.save(chat);
		
	}

	
	public List<Chat> getMessages() {
		System.out.println("I am in chat service");
		return chatdao.getMessages();
	}


	
}
