package com.kaishengit.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kaishengit.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.addObject("username", "Rose");
		return mav;
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String create() {
		return "new-user";
	}
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public String save(User user) {
		System.out.println(user.getUsername() + " : " + user.getPassword());
		return "redirect:/user";
	}
	
	@RequestMapping("/del/{id:\\d+}")
	public String del(@PathVariable("id")int myid,RedirectAttributes redirectAttributes) {
		System.out.println("id: " + myid);
		
		redirectAttributes.addFlashAttribute("message", "删除成功");
		
		return "redirect:/user";
	}
	
	@RequestMapping(value="/text",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getText() {
		return "Hello,SpringMVC,这里是中文";
	}
	
	@RequestMapping(value="/data.json",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setId(1001);
		user.setPassword("123123");
		user.setUsername("张三丰");
		return user;
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(String name,@RequestParam MultipartFile myfile,RedirectAttributes redirectAttributes) {
		System.out.println("File Desc :" + name);
		
		System.out.println("Content-Type:" + myfile.getContentType());
		System.out.println("Size : " + myfile.getSize());
		System.out.println("OriginalFilename:" + myfile.getOriginalFilename());
		System.out.println("Name : " + myfile.getName());
		 try {
			myfile.transferTo(new File("c:/",myfile.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("message", "上传成功");
		return "redirect:/user";
	}
	
	
	
	
	
	
	
	
	
	
	
}
