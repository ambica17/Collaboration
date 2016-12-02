package com.niit.service;

import java.util.List;

import com.niit.model.Chat;
import com.niit.model.Message;

public interface ChaatService {
public void save(Chat chat);
public List<Chat> getMessages();
}
