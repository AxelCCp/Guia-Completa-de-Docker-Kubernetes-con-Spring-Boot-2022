package sp.microserv.cursos.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import sp.microserv.cursos.model.Usuario;


@Entity
@Table(name="cursos")
public class Curso {
	
	public Curso() {
		cursoUsuarios = new ArrayList<>();
		usuarios = new ArrayList<>();
	}
	
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
	public List<CursoUsuario> getCursoUsuarios() {
		return cursoUsuarios;
	}
	public void setCursoUsuarios(List<CursoUsuario> cursoUsuarios) {
		this.cursoUsuarios = cursoUsuarios;
	}

	public void addCursoUsuario(CursoUsuario cursoUsuario) {
		cursoUsuarios.add(cursoUsuario);
	}
	public void removeCursoUsuario(CursoUsuario cursoUsuario) {
		cursoUsuarios.remove(cursoUsuario);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotEmpty
	@NotBlank
	private String nombre;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="curso_id")
	private List<CursoUsuario> cursoUsuarios;
	
	@Transient  //ESTE ATRIBUTO NO ESTÁ MAPEADO A TABLAS. SE VA USAR PARA OBTENER LOS DATOS COMPLETOS DEL USUARIO DESDE EL OTRO MICROSERVICIO.
	private List<Usuario>usuarios;
	
}
