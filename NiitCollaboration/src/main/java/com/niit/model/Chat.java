package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity


public class Chat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String message;
private Date dateandtime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getDateandtime() {
	return dateandtime;
}
public void setDateandtime(Date dateandtime) {
	this.dateandtime = dateandtime;
}

}
