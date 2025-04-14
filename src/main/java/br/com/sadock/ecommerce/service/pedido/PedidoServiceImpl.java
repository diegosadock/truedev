package br.com.sadock.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sadock.ecommerce.dao.PedidoDAO;
import br.com.sadock.ecommerce.model.ItemPedido;
import br.com.sadock.ecommerce.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido criarNovoPedido(Pedido novo) {
		novo.setStatus(1);
		for(ItemPedido item : novo.getItens()) {
			item.setPedido(novo);
		}
		
		double total = 0, desconto = 0.0;
		for (ItemPedido item : novo.getItens()) {
			total += item.getValorTotal();
		}
		novo.setValorBruto(total);
		
		if (total >= 30.0) {
			desconto = total * 0.10;
		}
		total = total - desconto;
		
		novo.setDesconto(desconto);
		novo.setValorTotal(total);
		
		return dao.save(novo);
	}

	@Override
	public Pedido alterarDados(Pedido pedido) {
		// TODO Auto-generated method stub
		return dao.save(pedido);
	}

	@Override
	public List<Pedido> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Pedido>) dao.findAll();
	}

	@Override
	public Pedido recuperarPeloNumero(Integer numPedido) {
		// TODO Auto-generated method stub
		return dao.findById(numPedido).orElse(null);
	}

	@Override
	public List<Pedido> recuperarPorStatus(Integer status) {
		// TODO Auto-generated method stub
		return dao.findAllByStatus(status);
	}
	
	

}
