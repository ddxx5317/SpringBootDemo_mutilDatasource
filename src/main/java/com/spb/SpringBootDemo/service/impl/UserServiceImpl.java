package com.spb.SpringBootDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spb.SpringBootDemo.dao.master.UserDao;
import com.spb.SpringBootDemo.service.IUserService;
import com.spb.SpringBootDemo.vo.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
