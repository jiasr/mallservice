package site.common.persist;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@MappedSuperclass
public class SelfGrowingdDomainObject<T extends SelfGrowingdDomainObject<T>> extends
		DomainObject<T> {
	private static final long serialVersionUID = 6160839886203552214L;

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@Override
	@Id  
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud" ,strategy = "increment")
	public Long getId() {
		return super.id;
	}
}
