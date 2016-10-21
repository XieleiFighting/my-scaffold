package com.hades.scaffold.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>抽象service层基类 提供一些通用的方法
 * <p/>
 * <p>泛型：T 表示实体类型；ID 表示主键类型
 * <p>User: XieLei
 * <p>Date: 2016年10月19日 下午12:55:34
 * <p>Version: 1.0
 */
public abstract class BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
	
	protected BaseDao<T, ID> baseDao;
	
	@Autowired
	public void setBaseDao(BaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	
}
