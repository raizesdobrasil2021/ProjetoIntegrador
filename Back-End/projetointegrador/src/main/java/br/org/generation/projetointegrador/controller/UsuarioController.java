package br.org.generation.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.projetointegrador.model.Usuario;
import br.org.generation.projetointegrador.model.UsuarioLogin;
import br.org.generation.projetointegrador.repository.UsuarioRepository;
import br.org.generation.projetointegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>>getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario>getById(@PathVariable long id){
		
		return usuarioRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin>Autentication(@RequestBody Optional<UsuarioLogin> usuario){
		
		return usuarioService.loginUsuario(usuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
						
		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity <Usuario>cadastrarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.cadastrarUsuario(usuario);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario){
		
		Optional<Usuario> updateUsuario = usuarioService.atualizarUsuario(usuario);
		try{
			return ResponseEntity.ok(updateUsuario.get());
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
	
	

