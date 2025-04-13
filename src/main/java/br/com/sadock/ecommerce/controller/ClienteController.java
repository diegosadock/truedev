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

import br.com.sadock.ecommerce.model.Cliente;
import br.com.sadock.ecommerce.service.cliente.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService cliServ;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(cliServ.recuperarTodos());
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
		Cliente result = cliServ.recuperarPeloId(id);

		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo) {
		try {
			Cliente result = cliServ.cadastrarNovoCliente(novo);

			if (result != null) {
				return ResponseEntity.status(201).body(result);
			}
		} 
		catch (Exception ex) {
			System.out.println("LOG - Erro ao cadastrar novo Cliente " + ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/clientes/busca")
	public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone") String telefone) {
		Cliente result = cliServ.recuperarClientePeloTelefone(telefone);
		
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		try {
			Cliente result = cliServ.alterarCliente(cliente);
			
			if (result != null) {
				return ResponseEntity.ok(result);
			}
		}
		catch (Exception ex) {
			System.out.println("LOG - Erro ao atualizar Cliente " + ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	
}
