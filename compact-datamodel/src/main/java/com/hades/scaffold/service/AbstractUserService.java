package com.hades.scaffold.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.hades.scaffold.dao.AbstractUserDao;
import com.hades.scaffold.entity.AbstractUser;

public abstract class AbstractUserService<T extends AbstractUser<ID>, ID extends Serializable> {
	
	public T findByUsername(String username) {
		if(StringUtils.isEmpty(username)) {
			return null;
		}
		return abstractUserDao.findByUsername(username);
	}
	
	public T login(String username, String password) {
		T user = null;
		user = findByUsername(username);
		passwordService.validate(user, password);
		return user;
	}

	protected AbstractUserDao<T, ID> abstractUserDao;
	@Autowired
	public void setAbstractUserDao(AbstractUserDao<T, ID> abstractUserDao) {
		this.abstractUserDao = abstractUserDao;
	}
	@Autowired
	private PasswordService passwordService;
}
