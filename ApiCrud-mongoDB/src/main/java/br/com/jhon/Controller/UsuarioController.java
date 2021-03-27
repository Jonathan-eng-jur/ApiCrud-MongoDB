package br.com.jhon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhon.Model.Usuario;
import br.com.jhon.Repository.UsuarioRepository;

@RestController
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@GetMapping (value = "/usuarios")
	public List<Usuario> getAllUsuario(){
		
		return usuarioRepository.findAll();
	}
		
	@PostMapping (value= "/cadastrar")
	public String createUsuario(@RequestBody Usuario usuario) {
		
		Usuario cadastroUsuario = usuarioRepository.insert(usuario);
		
	
	return "Usuario Cadastrado: " + cadastroUsuario.getNome();
	}
		
	@PutMapping (value= "/alterar")
	public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	@DeleteMapping (value= "/deletar")
	public  void deletarUsuario(@RequestBody Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}*/

	
	
	
}
