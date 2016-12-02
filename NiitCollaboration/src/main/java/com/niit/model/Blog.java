package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int bid;
@NotEmpty(message = "title cannot be blank")
private String btitle;
@NotEmpty(message="content cannot be blank")
private String bcontent;
@NotEmpty(message="user name cannot be blank")
private String bUserName;
private Date creationdatetime;
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBtitle() {
	return btitle;
}
public void setBtitle(String btitle) {
	this.btitle = btitle;
}
public String getBcontent() {
	return bcontent;
}
public void setBcontent(String bcontent) {
	this.bcontent = bcontent;
}
public String getbUserName() {
	return bUserName;
}
public void setbUserName(String bUserName) {
	this.bUserName = bUserName;
}
public Date getCreationdatetime() {
	return creationdatetime;
}
public void setCreationdatetime(Date creationdatetime) {
	this.creationdatetime = creationdatetime;
}

}
