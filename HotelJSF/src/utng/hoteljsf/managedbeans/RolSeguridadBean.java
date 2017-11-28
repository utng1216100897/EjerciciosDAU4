package utng.hoteljsf.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import utng.hoteljsf.entities.RolSeguridad;

import utng.hoteljsf.repository.RolSeguridadRepository;


@ManagedBean
public class RolSeguridadBean {

	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	private RolSeguridad rolSeguridad= new RolSeguridad();

	private List<RolSeguridad> rolesSeguridad = null;
	
	public void save() {
		
		RolSeguridadRepository rolSeguridadRepository = new RolSeguridadRepository(this.entityManager);
		if(this.rolSeguridad.getId()!=null){
			rolSeguridadRepository.update(this.rolSeguridad);
		}else{
			rolSeguridadRepository.save(this.rolSeguridad);
		}
		this.rolSeguridad = new RolSeguridad();
		this.rolesSeguridad = null;
		
	}
	public void remove(RolSeguridad rolSeguridad) {
		RolSeguridadRepository repository = new RolSeguridadRepository(this.entityManager);
		repository.remove(rolSeguridad);
		this.rolesSeguridad = null;
	}
	public void search(RolSeguridad rolSeguridad) {
		RolSeguridadRepository repository = new RolSeguridadRepository(this.entityManager);
		rolSeguridad = repository.search(rolSeguridad.getId());
		this.rolSeguridad = rolSeguridad;

	}
	
	
	public List<RolSeguridad> getRolesSeguridad() {
		if(this.rolesSeguridad == null){
			RolSeguridadRepository repository = new RolSeguridadRepository(entityManager);
			this.rolesSeguridad = repository.getRolesSeguridad();
		}
		
		return this.rolesSeguridad;
	}
	
	public Long getCount() {
		RolSeguridadRepository repository = new RolSeguridadRepository(this.entityManager);
		return repository.getCountRolesSeguridad();
		
	}
	
	public RolSeguridad getRolSeguridad() {
		return rolSeguridad;
	}
	public void setRolSeguridad(RolSeguridad rolSeguridad) {
		this.rolSeguridad = rolSeguridad;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute(" EntityManager ");
	}
}
