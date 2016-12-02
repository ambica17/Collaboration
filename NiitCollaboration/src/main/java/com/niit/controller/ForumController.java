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
import com.niit.model.Forum;
import com.niit.service.ForumService;

@Controller
public class ForumController {
	
@Autowired
private ForumService fservice;

@RequestMapping("/newforum")
public String createBlog(HttpServletRequest request,Model model)
{
	String name=request.getParameter("forum");
	model.addAttribute("name",name);
	System.out.println("In Forum Controller");
	return "Forum";
}


@ModelAttribute("forum")
public Forum returnObject()
{
	return new Forum();
	}
@RequestMapping("/postF")
public String postblog(@ModelAttribute("forum") Forum forum,Model model)throws IOException
{
	System.out.println("I am in Forum");
	forum.setForumUserName("forum hai");
	forum.setCreationdatetime(new java.util.Date());
	fservice.createNewForum(forum);
	return "Forum";
	
	}
@SuppressWarnings("unchecked")
@RequestMapping("/GsonCon1")
public @ResponseBody String getValues() throws Exception
{
	List<Forum> flist;
	String result="";
	flist=fservice.getForum();
	Gson gson=new Gson();
	result=gson.toJson(flist);
	System.out.println("before flist");
	System.out.println(flist);
	return result;
	}
}
