package br.com.sadock.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.ecommerce.model.Produto;
import br.com.sadock.ecommerce.model.Variante;
import br.com.sadock.ecommerce.service.variante.IVarianteService;

@RestController
public class VarianteController {
	
	@Autowired
	private IVarianteService service;
	
	@PostMapping("/variantes")
	public ResponseEntity<Variante> adicionar(@RequestBody Variante nova) {
		Variante v = service.adicionarNova(nova);
		
		if (v != null) {
			return ResponseEntity.status(201).body(v);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/variantes/{id}")
	public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable Integer id) {
		variante.setId(id);
		Variante result = service.alterarDados(variante);
		
		if (result != null) {
			ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/variantes/{id}")
	public ResponseEntity<Variante> recuperarPeloId(@PathVariable Integer id) {
		Variante result = service.recuperarPeloId(id);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/variantes")
	public ResponseEntity<List<Variante>> recuperarPeloProduto(@RequestParam(name = "idproduto") Integer idProduto) {
		Produto produto = new Produto();
		produto.setId(idProduto);
		return ResponseEntity.ok(service.recuperarPorProduto(produto));
		
	}
}
