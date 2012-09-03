package com.kaishengit.mapper;

import java.util.List;

import com.kaishengit.pojo.User;

public interface UserMapper {

	public User findById(User user);
	
	public List<User> find(User user);
	
	public void save(User user);
	
	public void delete(int id);
	
	public void update(User user);
}
