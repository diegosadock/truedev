package br.com.sadock.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sadock.ecommerce.dto.FaturamentoMensal;
import br.com.sadock.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
	
	public List<Pedido> findAllByStatus(Integer status);
	
	@Query("SELECT new "
			+ "br.com.sadock.ecommerce.dto.FaturamentoMensal(month(p.data), sum(p.valorTotal)) "
			+ " FROM Pedido p "
			+ " WHERE year(p.data) = :ano "
			+ " GROUP BY month(p.data) ")
	public List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);

}
