package utng.hoteljsf.repository;

import java.util.List;

import javax.persistence.EntityManager;

import utng.hoteljsf.entities.RolSeguridad;


public class RolSeguridadRepository {

	private EntityManager entityManager;

	public RolSeguridadRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public void save(RolSeguridad rolSeguridad) {
		this.entityManager.persist(rolSeguridad);
		this.entityManager.flush();
	}
	
	public void update(RolSeguridad rolSeguridad) {
		this.entityManager.merge(rolSeguridad);
		this.entityManager.flush();
	}

	public void remove(RolSeguridad rolSeguridad) {
		this.entityManager.remove(rolSeguridad);
	}
	
	public Long getCountRolesSeguridad() {
		return (Long) this.entityManager.createNamedQuery("RolSeguridad.count")
				.getSingleResult();
	}
	
	
	

	public RolSeguridad search(Long ID){
		return this.entityManager.find(RolSeguridad.class, ID);
	}
	
	@SuppressWarnings("unchecked")
	public List<RolSeguridad> getRolesSeguridad() {
		return this.entityManager.createNamedQuery("RolSeguridad.findAll")
				.getResultList();
	}
}
