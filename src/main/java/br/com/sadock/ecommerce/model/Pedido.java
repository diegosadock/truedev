package br.com.sadock.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_pedido")
	private Integer numeroPedido;
	
	@Column(name = "data")
	private LocalDate data;
	
	@Column(name = "valor_bruto")
	private Double valorBruto;
	
	@Column(name = "desconto")
	private Double desconto;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "tbl_cliente_id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens;
	
	public Integer getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
	
	
	

}
