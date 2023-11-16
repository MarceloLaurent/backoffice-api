package com.fatec.backofficeapi.model;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

public class CarrinhoDTO { //Data Transfer Object

	@NotNull
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
	private Produto produto;
	
	private int quantidadeProduto;

	public Cliente getCliente() {
		return cliente;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
