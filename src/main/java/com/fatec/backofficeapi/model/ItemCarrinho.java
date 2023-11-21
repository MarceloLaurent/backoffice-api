package com.fatec.backofficeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ItemCarrinho { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "codigoProduto")
	private Produto produto;

	private int quantidadeProduto;

	@ManyToOne
	@JoinColumn(name = "idCarrinho")
	private Carrinho carrinho;

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public ItemCarrinho(Produto produto, int quantidadeProduto, Carrinho carrinho) {
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.carrinho = carrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
