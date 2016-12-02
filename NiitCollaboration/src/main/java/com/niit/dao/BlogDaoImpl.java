package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
@Repository
@Transactional
public class BlogDaoImpl implements BlogDaoInterface {
	@Autowired 
private SessionFactory sessionFactory;
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
	public void createNewBlog(Blog blog) {
		Session session= sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		System.out.println(blog);
		session.saveOrUpdate(blog);
		t.commit();
	
	}

	public List<Blog> getBlogList(String bUserName) {
		@SuppressWarnings("unchecked")
		Session session=this.sessionFactory.getCurrentSession();
		 @SuppressWarnings("unchecked")
		List<Blog> blog = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		 return blog;
	}

	public Blog getBlogById(int bid) {
		Session session=this.sessionFactory.getCurrentSession();
		Blog b=(Blog) session.load(Blog.class,bid);
		System.out.println("data of blog by id="+b);
		return b;	
	}

	public Blog getBlogByName(String bname) {
		System.out.println("getting data in dao based on name");
		Session session=this.sessionFactory.getCurrentSession();
		Blog blog = (Blog) session.get(Blog.class, bname);
		return blog;
		}
@Transactional
	public void delete(int bid) {
		Blog blog = new Blog();
		sessionFactory.getCurrentSession().delete(blog);
		System.out.println("deleted success");
		
	}
List<Blog> blogs;
@SuppressWarnings("unchecked")

	public List<Blog> getBlog() {
	System.out.println("DAO Implementation");
	Session ss1 = sessionFactory.openSession();
	Query qry = ss1.createQuery("from Blog");
	System.out.println(qry.toString());
	blogs = (List<Blog>)qry.list();
	return blogs;
	}

}
