package com.hades.scaffold.service;

import org.springframework.stereotype.Service;

import com.hades.scaffold.entity.AbstractUser;
import com.hades.scaffold.utils.Md5Utils;

@Service
public class PasswordService {

	public <T extends AbstractUser<?>> void validate(T user, String password) {
//		String username = user.getUsername();
//		int retryCount = 0;
//		// TODO 验证
//		if (!matches(user, password)) {
//			
//		} else {
//			
//		}
	}
	
	public <T extends AbstractUser<?>> boolean matches(T user, String newPassword) {
		return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
	}
	
	public String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }
}
