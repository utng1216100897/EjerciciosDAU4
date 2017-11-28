package utng.hoteljsf.repository;

import java.util.List;
import javax.persistence.EntityManager;
import utng.hoteljsf.entities.Usuario;


public class UsuarioRepository {
	private EntityManager entityManager;

	public UsuarioRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Usuario usuario) {
		this.entityManager.persist(usuario);
		this.entityManager.flush();
	}
	
	public void update(Usuario usuario) {
		this.entityManager.merge(usuario);
		this.entityManager.flush();
	}

	public void remove(Usuario usuario) {
		this.entityManager.remove(usuario);
	}
	
	public Usuario search(Long ID){
		return this.entityManager.find(Usuario.class, ID);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		return this.entityManager.createNamedQuery("Usuario.findAll")
				.getResultList();
	}

	public Long getCountUsuarios() {
		return (Long) this.entityManager.createNamedQuery("Usuario.count")
				.getSingleResult();
	}

}
