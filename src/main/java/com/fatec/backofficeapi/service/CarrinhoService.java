package com.fatec.backofficeapi.service;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.backofficeapi.model.Carrinho;
import com.fatec.backofficeapi.model.CarrinhoDTO;
import com.fatec.backofficeapi.model.Produto;
import com.fatec.backofficeapi.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

	
	CarrinhoRepository carrinhoRepository;
	
	@Autowired
	public CarrinhoService(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}
	
	public void checkout() {
		
	}
	
	//TODO: Usar Lista para armazenar ao inves de Pilha
	public Optional<Stack<CarrinhoDTO>> addItem(CarrinhoDTO carrinhoDTO, Long idCarrinho) {
		Optional<Carrinho> carrinho = carrinhoRepository.findById(idCarrinho);
		
		Optional<Stack<CarrinhoDTO>> pilhaItens = Optional.of(carrinho.get().getCarrinhoDTO());
		pilhaItens.get().add(carrinhoDTO);
		return pilhaItens;
	}
	
	public void removeItem() {
		
	}
	
	public List<Produto> viewCarrinho() {
		return null;
	}
	
	
	
}
