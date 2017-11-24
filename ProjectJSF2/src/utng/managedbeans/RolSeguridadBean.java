package utng.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import utng.entities.RolSeguridad;
import utng.repository.RolSeguridadRepository;

@ManagedBean
public class RolSeguridadBean {
	
	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	
	private List<RolSeguridad> rolesSeguridad = null;
	
	public List<RolSeguridad> getRolesSeguridad(){
		if(this.rolesSeguridad==null) {
			RolSeguridadRepository repository = new RolSeguridadRepository(entityManager);
			this.rolesSeguridad = repository.getRolesSeguridad();
		}
		
		return this.rolesSeguridad;		
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
}
