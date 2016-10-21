package com.hades.scaffold.dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import com.hades.scaffold.base.BaseDao;
import com.hades.scaffold.entity.AbstractUser;

@NoRepositoryBean
public interface AbstractUserDao<T extends AbstractUser<ID>, ID extends Serializable> extends BaseDao<T, ID> {

	T findByUsername(String username);
}
