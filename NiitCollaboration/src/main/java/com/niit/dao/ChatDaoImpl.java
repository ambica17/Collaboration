package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.Chat;
import com.niit.model.Message;
@Repository
@Transactional
public class ChatDaoImpl implements ChatDaoInterface{
	@Autowired 
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Chat chat) {
		Session session=sessionFactory.getCurrentSession();
		Transaction t=session.beginTransaction();
		System.out.println(chat);
		session.saveOrUpdate(chat);
		t.commit();
	}

	List<Chat> messages;
	@SuppressWarnings("unchecked")

	public List<Chat> getMessages() {
		System.out.println("DAO Implementation");
		Session ss1 = sessionFactory.openSession();
		Query qry = ss1.createQuery("from Chat");
		System.out.println(qry.toString());
		messages = (List<Chat>)qry.list();
		return messages;
		
		
	}

}
