package com.niit.dao;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDaoInterface {
	public void createNewBlog(Blog blog);
	public List<Blog> getBlogList(String bUserName);
	public Blog getBlogById(int bid);
	public Blog getBlogByName(String bname);
	public void delete(int bid);
	public List<Blog> getBlog();
}
