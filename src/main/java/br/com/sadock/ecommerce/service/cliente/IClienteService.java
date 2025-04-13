package br.com.sadock.ecommerce.service.cliente;

import java.util.List;

import br.com.sadock.ecommerce.model.Cliente;

public interface IClienteService {
	
	public Cliente cadastrarNovoCliente(Cliente novo);
	public Cliente alterarCliente(Cliente cliente);
	public Cliente recuperarPeloId(Integer id);
	public Cliente recuperarClientePeloTelefone(String telefone);
	public List<Cliente> recuperarTodos();

}
