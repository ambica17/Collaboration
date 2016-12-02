package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
private String message;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

public Message() {

}

public Message(int id, String message) {
	
	this.message = message;
	this.id = id;
}

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
