package sp.microserv.usuarios.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cursos", url="localhost:8002")   //PARA CONECTAR DIRECTAMENTE CON EL MICROSERVICIO.
public interface ICursoFeignClient {
	
	@DeleteMapping("/eliminar-curso-usuario/{id}")
	public void eliminarCursoUsuario(@PathVariable Long id);
}
