package br.com.sadock.ecommerce.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;
	
	@Column(name = "nome_produto", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "descricao_produto", columnDefinition = "TEXT")
	private String descricao;
	
	@Column(name = "preco_produto")
	private Double preco;
	
	@Column(name = "destaque")
	private int destaque;
	
	@Column(name = "disponivel")
	private int disponivel;
	
	@ManyToMany
	@JoinTable(name = "tbl_categoria_produto", 
			   joinColumns = @JoinColumn(name = "id_produto"),
				inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List<Variante> variantes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public int getDestaque() {
		return destaque;
	}
	public void setDestaque(int destaque) {
		this.destaque = destaque;
	}
	public int getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public List<Variante> getVariantes() {
		return variantes;
	}
	public void setVariantes(List<Variante> variantes) {
		this.variantes = variantes;
	}
	
	
	
	
	
	

}
