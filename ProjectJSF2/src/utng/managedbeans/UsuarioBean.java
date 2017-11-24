package utng.managedbeans;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import utng.entities.RolSeguridad;
import utng.entities.Usuario;
import utng.repository.RolSeguridadRepository;
import utng.repository.UsuarioRepository;

@ManagedBean
public class UsuarioBean {
	
	@ManagedProperty(value="#{entityManager}")
	private EntityManager entityManager;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	private Long rolSeguridadID;
	
	public void save() {
		RolSeguridadRepository rolSeguridadRepository = new RolSeguridadRepository(this.entityManager);
		RolSeguridad rolSeguridad = rolSeguridadRepository.search(rolSeguridadID);
		this.usuario.setRolSeguridad(rolSeguridad);
		UsuarioRepository usuarioRepository = new UsuarioRepository(this.entityManager);
		if(this.usuario.getId()!=null) {
			usuarioRepository.update(this.usuario);
		}else {
			usuarioRepository.save(this.usuario);
		}
		
		this.usuario = new Usuario();
		this.usuarios = null;
		this.setRolSeguridadID(null);;
	}
	
	public void remove(Usuario usuario) {
		UsuarioRepository repository =  new UsuarioRepository(this.entityManager);
		repository.remove(usuario);
		this.usuarios= null;
	}
	
	public void search(Usuario usuario) {
		UsuarioRepository repository = new UsuarioRepository(this.entityManager);
		usuario = repository.search(usuario.getId());
		this.usuario= usuario;
		setRolSeguridadID(this.usuario.getRolSeguridad().getId());
	}
	
	public List<Usuario> getUsuarios(){
		if(this.usuarios== null) {
			UsuarioRepository repository = new UsuarioRepository(this.entityManager);
			this.usuarios = repository.getUsuarios();
		}
		return this.usuarios;
	}
	
	public Long getCount() {
		UsuarioRepository repository = new UsuarioRepository(this.entityManager);
		return repository.getCountUsuarios();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario= usuario;
	}
	
	public Long getRolSeguridadID() {
		return rolSeguridadID;
	}
	
	public void setRolSeguridadID(Long rolSeguridadID) {
		this.rolSeguridadID = rolSeguridadID;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	
	@SuppressWarnings("unused")
	private EntityManager getManager() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return (EntityManager) request.getAttribute("EntityManager");
	}
		
	

}
