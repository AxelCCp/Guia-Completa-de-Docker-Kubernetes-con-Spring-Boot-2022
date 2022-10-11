package sp.microserv.cursos.model.service;

import java.util.List;
import java.util.Optional;

import sp.microserv.cursos.model.Usuario;
import sp.microserv.cursos.model.entity.Curso;


public interface ICursoService {

	List<Curso>listar();
	Optional<Curso>porId(Long id);
	Curso guardar(Curso curso);
	void eliminar(Long id);
	Optional<Usuario>asinarUsuario(Usuario usuario, Long cursoId);  //ASIGNA UN USUARIO EXISTENTE EN LA BBDD MYSQL DEL MICRO USUARIOS. 
	Optional<Usuario>crearUsuario(Usuario usuario, Long cursoId);   //PARA USUARIOS Q TODAVÍA ON EXISTEN EN LA BBDD.
	Optional<Usuario>eliminarUsuario(Usuario usuario, Long cursoId); //ELIMINA A UN USUARIO DE UN CURSO.
	//CLASE40
	Optional<Curso>porIdConUsuarios(Long id);
	
}
