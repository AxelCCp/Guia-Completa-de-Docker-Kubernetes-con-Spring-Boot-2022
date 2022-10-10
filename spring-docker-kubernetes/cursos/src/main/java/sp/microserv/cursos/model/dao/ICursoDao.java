package sp.microserv.cursos.model.dao;

import org.springframework.data.repository.CrudRepository;

import sp.microserv.cursos.model.entity.Curso;

public interface ICursoDao extends CrudRepository<Curso,Long> {

}
