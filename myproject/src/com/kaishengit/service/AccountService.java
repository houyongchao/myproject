package com.kaishengit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaishengit.mapper.AccountMapper;
import com.kaishengit.pojo.Account;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	public Account findById(String id) {
		return accountMapper.findById(id);
	}
	
}
