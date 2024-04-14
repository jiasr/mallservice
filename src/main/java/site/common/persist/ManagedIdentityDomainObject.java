package site.common.persist;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@MappedSuperclass
public abstract class ManagedIdentityDomainObject<T extends ManagedIdentityDomainObject<T>>
		extends DomainObject<T> {

	private static final long serialVersionUID = 7325809706312057006L;

	@Override
	@Id
	@GeneratedValue(generator="hibseq")
	@GenericGenerator(name="hibseq", strategy = "hilo",
	    parameters = {
	        @Parameter(name="max_lo", value = "100")
	    }
	)

	@Column(nullable = false, insertable = false, updatable = false)
	public Long getId() {
		return super.id;
	}
}
