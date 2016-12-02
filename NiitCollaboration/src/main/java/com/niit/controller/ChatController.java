package com.niit.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.niit.model.Blog;
import com.niit.model.Chat;
import com.niit.model.Message;
import com.niit.model.OutputMessage;
import com.niit.service.ChaatService;

@Controller
@RequestMapping("/")

public class ChatController {
	@Autowired
	private ChaatService chatservice;
	
	  @RequestMapping(method = RequestMethod.GET)
	  public String viewApplication() {
	    return "ChatPage";
	  }

	@MessageMapping("/chat")
	@SendTo("/topic/message")
public OutputMessage sendMessage(Message message)
{
	return new OutputMessage(message,new Date());
	}
	
	@RequestMapping("/newchat")
	public String createBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("chat");
		model.addAttribute("name",name);
		System.out.println("In Chat controller");
		return "Chaat";
	}
	@ModelAttribute("chat")
	public Chat returnObject()
	{
		return new Chat();
	}
	
	@RequestMapping("/postC")
	public String postblog(@ModelAttribute("chat") Chat chat,Model model)throws IOException
	{
		System.out.println("I am in chatpost");
		chat.setDateandtime(new java.util.Date());
		//blog.setbUserName("hai");
		//blog.setCreationdatetime(new java.util.Date());
		chatservice.save(chat);
		//blogservice.createNewBlog(blog);
		return "Chaat";
	}
	List<Chat> clist;
	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon3")
	public @ResponseBody String getValues() throws Exception
	{
		String result="";
		clist=chatservice.getMessages();
		//blist=blogservice.getBlog();
		Gson gson=new Gson();
		result=gson.toJson(clist);
		return result;
	}

}
