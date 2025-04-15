package br.com.sadock.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sadock.ecommerce.dto.FaturamentoMensal;
import br.com.sadock.ecommerce.model.Pedido;
import br.com.sadock.ecommerce.service.pedido.IPedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido novo) {
		Pedido result = service.criarNovoPedido(novo);
		
		if (result != null) {
			return ResponseEntity.status(201).body(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> recuperarTodos() {
		List<Pedido> result = service.recuperarTodos();
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> recuperarPeloId(@PathVariable Integer numPedido) {
		Pedido result = service.recuperarPeloNumero(numPedido);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pedidos/faturamento/{ano}")
	public ResponseEntity<List<FaturamentoMensal>> recuperarFaturamento(@PathVariable Integer ano) {
		List<FaturamentoMensal> result = service.recuperarFaturamento(ano);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().build();
	}

}
