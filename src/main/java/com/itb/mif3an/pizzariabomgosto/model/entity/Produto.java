package com.itb.mif3an.pizzariabomgosto.model.entity;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,length = 100)
	private String nome;
	@Column(nullable = true,length = 250)
	private String descricao;
	@Column(nullable = true,length = 45)
	private String tipo;
	@Column(nullable = true)
	private int quantidadeEstoque;
	@Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
	private double precoVenda;
	@Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
	private double precoCompra;
	private boolean codStatus;
	
    // @ManyToOne: Muitos para Um ex: Muitos produtos para uma categoria
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name= "categoria_id", referencedColumnName = "id", nullable = true)
	private Categoria categoria;
	
	// atributos de apoio
	
	// @Transient : Anotação para os atributos que não reprentam colunas no banco de dados
	
	@Transient 
	private String mensagemErro = "";
	@Transient
	private boolean isValid = true;
	
	// Set e Get
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public boolean isCodStatus() {
		return codStatus;
	}
	public void setCodStatus(boolean codStatus) {
		this.codStatus = codStatus;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	public boolean validarProduto() {
		if(nome == null || nome.isEmpty()) {
			mensagemErro += "O nome do produto é obrigatório:";
			isValid = false;
		}
		if(precoCompra < 0) {
			precoCompra = 0;
			mensagemErro += "O preço de compra do produto deve ser maior que zero:";
			isValid = false;
		}
		if(precoVenda < 0) {
			precoVenda = 0;
			mensagemErro += "O preço de venda do produto deve ser maior que zero:";
			isValid = false;
		}
		
		return isValid;
	}
	
	

	

	
}
