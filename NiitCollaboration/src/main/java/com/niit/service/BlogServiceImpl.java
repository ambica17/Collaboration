package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BlogDaoInterface;
import com.niit.model.Blog;

@Service
public class BlogServiceImpl implements BlogService{
	@Autowired
	BlogDaoInterface blogdao;
	
	public void createNewBlog(Blog blog) {
		blogdao.createNewBlog(blog);
		
	}

	public List<Blog> getBlogList(String bUserName) {
		return blogdao.getBlogList(bUserName);
	}

	public Blog getBlogById(int bid) {
		return new Blog();
	}

	public Blog getBlogByName(String bname) {
		return new Blog();
	}

	public List<Blog> getBlog() {
		System.out.println("i am in blog serivce");
		return blogdao.getBlog();
	}

}
