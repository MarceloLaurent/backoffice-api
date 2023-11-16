package com.fatec.backofficeapi.model;

import java.util.Stack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@OneToOne
	private Stack<CarrinhoDTO> carrinhoDTO;

	public Carrinho() {
		carrinhoDTO = new Stack<>();
	}

	public Stack<CarrinhoDTO> getCarrinhoDTO() {
		return carrinhoDTO;
	}

	public void setCarrinhoDTO(Stack<CarrinhoDTO> carrinhoDTO) {
		this.carrinhoDTO = carrinhoDTO;
	}

	public long getIdCarrinho() {
		return idCarrinho;
	}

}
