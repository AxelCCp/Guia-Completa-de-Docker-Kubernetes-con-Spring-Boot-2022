package sp.microserv.usuarios.model.service;

import java.util.List;
import java.util.Optional;

import sp.microserv.usuarios.model.entity.Usuario;

//CLASE13
//1.-METODO Q BUSCA POR ID QUE DEVUELVE UN OBJ USUARIO,  PERO SE VA A MANEJAR CON UN OPTIONAL.
	//OPTIONAL ES UN WRAPPER. UNA CLASE QUE ENVUELVE AL OBJETO PARA SABEER SI ESTÁ PRESENTE EN LA CONSULTA. ES UNA FORMA PULENTA DE EVITAR QUE EL OBJ SEA NULO  Y DE ERROR.
//2.-GUARDAR PARA EDITAR E INSERTAR...DEVUELVE UN USUARIO PARA MOSTRARLO.
//CLASE29
//3.-MÉTODO PREPARADO... ESTE ESTÁ EN EL DAO.

public interface IUsuarioService {

	
	List<Usuario>listar();
	//1
	Optional<Usuario>porId(Long id);
	//2
	Usuario guardar(Usuario usuario);
	
	void eliminar(Long id);
	//3
	Optional<Usuario>porEmail(String email);
	
	boolean existePorEmail(String email);
	
	
}
