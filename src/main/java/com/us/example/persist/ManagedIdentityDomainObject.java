package com.us.example.persist;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@MappedSuperclass
public abstract class ManagedIdentityDomainObject<T extends ManagedIdentityDomainObject<T>>
		extends DomainObject<T> {

	private static final long serialVersionUID = 7325809706312057006L;

	@Override
	@Id
	@GeneratedValue(generator="hibseq")
	@GenericGenerator(name="hibseq", strategy = "uuid")
	@Column(nullable = false, insertable = false, updatable = false)
	public String getId() {
		return super.id;
	}
}
