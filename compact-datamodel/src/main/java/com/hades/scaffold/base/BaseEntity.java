package com.hades.scaffold.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.domain.Persistable;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Persistable<ID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
	
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	
	@Column(name = "update_time", nullable = false)
	private Date updateTime;
	
	@PrePersist
	public void prePersist() {
		createTime = updateTime = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateTime = new Date();
	}
	
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass())
			return false;
		return this.getId().equals(((BaseEntity<?>) other).getId());
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	
	/*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Persistable#isNew()
     */
	public boolean isNew() {
        return null == getId();
    }

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
