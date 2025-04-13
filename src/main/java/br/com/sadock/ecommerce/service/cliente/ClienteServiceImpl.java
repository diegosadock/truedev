package br.com.sadock.ecommerce.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.ClienteDAO;
import br.com.sadock.ecommerce.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDAO cliDao;

	@Override
	public Cliente cadastrarNovoCliente(Cliente novo) {
		return cliDao.save(novo);
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return cliDao.save(cliente);
	}

	@Override
	public Cliente recuperarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return cliDao.findById(id).orElse(null);
	}

	@Override
	public Cliente recuperarClientePeloTelefone(String telefone) {
		// TODO Auto-generated method stub
		return cliDao.findByTelefone(telefone);
	}

	@Override
	public List<Cliente> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Cliente>) cliDao.findAll();
	}

}
