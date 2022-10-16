package sp.microserv.usuarios.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//1.-FEIGN ORIGINAL
//CLASE53
//2.-SE CAMBIA FEIGN PARA CONECTAR LA IMAGEN DE DOCKER DE USUARIOS CON EL MICROSERVICIO CURSOS EN LOCAL.  

//1
//@FeignClient(name="cursos", url="localhost:8002")   //PARA CONECTAR DIRECTAMENTE CON EL MICROSERVICIO.
//2
@FeignClient(name="cursos", url="host.docker.internal:8002")
public interface ICursoFeignClient {
	
	@DeleteMapping("/eliminar-curso-usuario/{id}")
	public void eliminarCursoUsuario(@PathVariable Long id);
}
