package com.hades.scaffold.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hades.scaffold.dao.UserDao;
import com.hades.scaffold.entity.User;

@Service
public class UserService extends AbstractUserService<User, Long> {
	
	@Autowired
	public UserDao getUserDao() {
		return (UserDao) abstractUserDao;
	}
}
