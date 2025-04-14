package br.com.sadock.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.ecommerce.model.Categoria;
import br.com.sadock.ecommerce.model.Produto;
import br.com.sadock.ecommerce.service.produto.IProdutoService;

@RestController
public class ProdutoController {
	
	@Autowired
	private IProdutoService service;
	
	@GetMapping("/produtos")
	public ResponseEntity<Page<Produto>> recuperarTodos(@RequestParam(name = "p", defaultValue = "1") int p) {
		return ResponseEntity.ok(service.recuperarTodos(p));
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id) {
		Produto result = service.buscarPeloId(id);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> incluirNovo(@RequestBody Produto novo) {
		Produto result = service.cadastrarNovo(novo);
		
		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Integer id) {
		produto.setId(id);
		Produto result = service.alterarProduto(produto);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name="key") String key) {
		List<Produto> lista = service.recuperarPorPalavraChave(key);
		
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/produtos/categoria/{id}")
	public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id) {
		
		Categoria categoria = new Categoria();
		categoria.setId(id);
		
		return ResponseEntity.ok(service.buscarPorCategoria(categoria));
	}

}
