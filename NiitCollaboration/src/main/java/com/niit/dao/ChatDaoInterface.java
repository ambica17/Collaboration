package com.niit.dao;

import java.util.List;

import com.niit.model.Chat;
import com.niit.model.Message;

public interface ChatDaoInterface {
public void save(Chat chat);
public List<Chat> getMessages();
}
