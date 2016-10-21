package com.hades.scaffold.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.hades.scaffold.entity.enums.UserStatus;

@Entity
@Table(name = "sys_user")
public class User extends AbstractUser<Long> {

	private static final long serialVersionUID = 5589278917727195358L;

	@Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.normal;
	
	private Boolean admin = false;
	
	private Boolean deleted = Boolean.FALSE;
	
	public User() {
    }

    public User(Long id) {
        setId(id);
    }

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
    
}
