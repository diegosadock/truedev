package br.com.sadock.ecommerce.service.pedido;

import java.util.List;

import br.com.sadock.ecommerce.dto.FaturamentoMensal;
import br.com.sadock.ecommerce.model.Pedido;

public interface IPedidoService {
	
	public Pedido criarNovoPedido(Pedido novo);
	public Pedido alterarDados(Pedido pedido);
	public List<Pedido> recuperarTodos();
	public Pedido recuperarPeloNumero(Integer numPedido);
	public List<Pedido> recuperarPorStatus(Integer status);
	public List<FaturamentoMensal> recuperarFaturamento(Integer ano);
	

}
