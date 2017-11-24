package utng.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.sun.faces.spi.SerializationProvider;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name="tbl_rol_seguridad")
@NamedQueries({
		@NamedQuery(name="RolSeguridad.findAll", query="SELECT r FROM tbl_rol_seguridad r"),
		@NamedQuery(name="RolSeguridad.count", query="SELECT COUNT(r) FROM tbl_rol_seguridad r")
})

public class RolSeguridad implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
