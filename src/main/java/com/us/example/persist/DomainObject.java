package com.us.example.persist;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;


@MappedSuperclass
public abstract class DomainObject<T extends DomainObject<T>> implements
		Serializable {

	private static final long serialVersionUID = -3348024008311939854L;
	protected String id;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	private Date createTime = new Date();


	public void setId(String id) {
		this.id = id;
	}

	@Transient
	// @Id
	// FIXME: When execute GAS3 task, @Id comment must be removed
	public String getId() {
		return id;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof DomainObject))
			return false;
		else {
			DomainObject<?> domainObject = (DomainObject<?>) obj;
			if (this.getId() == null)
				return false;
			return this.getId().equals(domainObject.getId());
		}
	}

	private transient int hashCode = Integer.MIN_VALUE;

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {		
			String hashStr = this.getClass().getName() + ":"
					+ this.getId();//.hashCode();
			this.hashCode = hashStr.hashCode();
		}
		return this.hashCode;
	}

	public String toString() {
		return this.getClass().getName() + "#" + getId();
	}

}
