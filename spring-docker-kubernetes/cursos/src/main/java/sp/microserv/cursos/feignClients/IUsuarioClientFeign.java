package sp.microserv.cursos.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import sp.microserv.cursos.model.Usuario;

@FeignClient(name="usuarios",url="localhost:8001")
public interface IUsuarioClientFeign {
	
	
	@GetMapping("/detalle/{id}")
	public Usuario detalle (@PathVariable Long id);
	
	@PostMapping("/crear")
	public Usuario crear(@RequestBody Usuario usuario);
	
	@GetMapping("/usuarios-por-curso")
	public List<Usuario>obtenerAlumnosPorCurso(@RequestParam Iterable<Long>ids); //SE USA ITERABLE EN VEZ DE LIST, PARECE Q LIST DA PROBLEMAS EN EL FEIGN.
}
