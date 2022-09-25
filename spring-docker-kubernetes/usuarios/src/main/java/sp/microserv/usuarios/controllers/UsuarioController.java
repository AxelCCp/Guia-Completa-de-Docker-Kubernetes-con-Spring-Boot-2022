package sp.microserv.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sp.microserv.usuarios.model.entity.Usuario;
import sp.microserv.usuarios.model.service.IUsuarioService;

@RestController
public class UsuarioController {

	@GetMapping("/listar")
	public List<Usuario>listar(){
		return usuarioService.listar();
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<?> detalle (@PathVariable Long id) {
		Optional<Usuario>usuarioOptional = usuarioService.porId(id);
		if(usuarioOptional.isPresent()) {
			//return ResponseEntity.ok(usuarioOptional.get());
			return ResponseEntity.ok().body(usuarioOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?>editar(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> o = usuarioService.porId(id); 
		if(o.isPresent()){
			Usuario usuarioDb = o.get();
			usuarioDb.setNombre(usuario.getNombre());
			usuarioDb.setEmail(usuario.getEmail());
			usuarioDb.setPassword(usuario.getPassword());
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioDb));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?>eliminar(Long id){
		Optional<Usuario> o = usuarioService.porId(id); 
		if(o.isPresent()){
			usuarioService.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@Autowired
	private IUsuarioService usuarioService;
}
