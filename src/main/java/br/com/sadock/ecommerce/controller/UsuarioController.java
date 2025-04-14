package br.com.sadock.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.ecommerce.model.Usuario;
import br.com.sadock.ecommerce.security.ECToken;
import br.com.sadock.ecommerce.service.usuario.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario novo) {
		Usuario result = service.cadastrarNovo(novo);
		
		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> alterarDados(@RequestBody Usuario usuario, @PathVariable Integer id) {
		usuario.setIdUsuario(id);
		Usuario result = service.alterarDados(usuario);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<ECToken> realizarLogin(@RequestBody Usuario usuario) {
		ECToken token = service.fazerLogin(usuario.getLogin(), usuario.getSenha());
		
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		
		return ResponseEntity.status(403).build();
	}

}
