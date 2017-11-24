package utng.repository;

import java.util.List;

import javax.persistence.EntityManager;

import utng.entities.RolSeguridad;

public class RolSeguridadRepository {
	
	private EntityManager entityManager;
	
	public RolSeguridadRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public RolSeguridad search(Long ID) {
		return this.entityManager.find(RolSeguridad.class, ID);
	}
	
	@SuppressWarnings("unchecked")
	public List<RolSeguridad> getRolesSeguridad(){
		return this.entityManager.createNamedQuery("SolSeguridad.findAll").getResultList();
	}
	
}
