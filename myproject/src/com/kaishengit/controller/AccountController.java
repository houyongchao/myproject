package com.kaishengit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getAccount(@PathVariable String id) {
		Account a  = accountService.findById(id);
		System.out.println(a.getUsername());
		System.out.println(a.getPassword());
		return "redirect:/user";
	}
}
