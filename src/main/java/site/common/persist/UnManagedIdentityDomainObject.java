package site.common.persist;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class UnManagedIdentityDomainObject<T extends UnManagedIdentityDomainObject<T>> extends DomainObject<T> {

	private static final long serialVersionUID = 6160839886203552214L;

	@Override
	public void setId(Long id){
		super.id = id;
	}
	
	@Override
	@Id
	@Column(nullable = false)
	public Long getId() {
		return super.id;
	}

}
