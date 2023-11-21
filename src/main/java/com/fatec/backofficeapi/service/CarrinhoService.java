package com.fatec.backofficeapi.service;

import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.backofficeapi.model.Carrinho;
import com.fatec.backofficeapi.model.ItemCarrinho;
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
	
	public Carrinho addItem(Carrinho carrinho, Produto produto, int quantidade) {
		List<ItemCarrinho> itens = carrinho.getItem();
		ItemCarrinho item = new ItemCarrinho(produto, quantidade, carrinho);
		itens.add(item);
		carrinho.setItem(itens);
		
		return carrinhoRepository.save(carrinho);
	}
	
	//Remove o item totalmente do carrinho
	public void removeItem(Carrinho carrinho, Produto produto) {
		List<ItemCarrinho> itens = carrinho.getItem();
		int posicao = 0;
	
		for (ItemCarrinho itemCarrinho : itens) {
			posicao++;
			if (itemCarrinho.getProduto().equals(produto)) {
				itens.remove(posicao);
				break;
			}
		}
	}
	
	//TODO: Fazer um método para remover quantidade de um produto do carrinho
	
	public Stack<ItemCarrinho> viewCarrinho() {
		return null;
	}
	
	
	
}
