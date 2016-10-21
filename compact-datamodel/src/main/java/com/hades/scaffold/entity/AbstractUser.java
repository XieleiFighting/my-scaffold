package com.hades.scaffold.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.RandomStringUtils;

import com.hades.scaffold.base.BaseEntity;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractUser<ID extends Serializable> extends BaseEntity<ID> {

	private String username;
	
	private String email;
	
	@Column(name = "mobile_phone_number")
	private String mobilePhoneNumber;
	
	private String password;
	
	private String salt;
	
	public void randomSalt() {
        setSalt(RandomStringUtils.randomAlphanumeric(10));
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
