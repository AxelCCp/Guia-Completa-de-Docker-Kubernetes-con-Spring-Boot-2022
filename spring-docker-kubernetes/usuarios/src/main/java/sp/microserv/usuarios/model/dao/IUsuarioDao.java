package sp.microserv.usuarios.model.dao;

import org.springframework.data.repository.CrudRepository;

import sp.microserv.usuarios.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository <Usuario, Long>{

}
