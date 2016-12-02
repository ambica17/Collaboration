package com.niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.niit.model.Blog;
import com.niit.service.BlogService;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogservice;
	
	@RequestMapping("/newblog")
	public String createBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("blog");
		model.addAttribute("name",name);
		System.out.println("In Blog controller");
		return "BlogPage";
	}
	
	@ModelAttribute("blog")
	public Blog returnObject()
	{
		return new Blog();
	}
	
	@RequestMapping("/postb")
	public String postblog(@ModelAttribute("blog") Blog blog,Model model)throws IOException
	{
		System.out.println("I am in blogpost");
		blog.setbUserName("hai");
		blog.setCreationdatetime(new java.util.Date());
		blogservice.createNewBlog(blog);
		return "BlogPage";
	}
	
	String setName;
	
	List<Blog> blist;
	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception
	{
		String result="";
		blist=blogservice.getBlog();
		Gson gson=new Gson();
		result=gson.toJson(blist);
		return result;
	}
}
