package br.com.sadock.ecommerce.controller;

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

import br.com.sadock.ecommerce.model.Categoria;
import br.com.sadock.ecommerce.service.categoria.ICategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private ICategoriaService service;

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> recuperarTodas() {
		List<Categoria> result = service.listarTudo();

		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/categorias")
	public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria nova) {
		Categoria result = service.criarNova(nova);

		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/categorias/{id}")
	public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria categoria, @PathVariable Integer id) {
		categoria.setId(id);
		try {
			Categoria result = service.alterar(categoria);

			if (result != null) {
				return ResponseEntity.ok(result);
			}
		} 
		catch (Exception ex) {
			System.out.println("LOG - Erro ao atualizar Cliente " + ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> removerCategoria(@PathVariable Integer id) {
		service.apagarCategoria(id);
		return ResponseEntity.ok("Removed");
		
		
	}
	
}
