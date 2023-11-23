package com.fatec.backofficeapi.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity(name="Carrinho")
@Table(name="carrinho")
public class Carrinho {
	
	
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="idCarrinho")
	private long idCarrinho;
	
	@NotNull
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
	private List<ItemCarrinho> item = new ArrayList<>();
	
	private double valorTotal;
	

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<ItemCarrinho> getItem() {
		return item;
	}


	public void setItem(List<ItemCarrinho> item) {
		this.item = item;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public void setIdCarrinho(long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}


	public long getIdCarrinho() {
		return idCarrinho;
	}

}
