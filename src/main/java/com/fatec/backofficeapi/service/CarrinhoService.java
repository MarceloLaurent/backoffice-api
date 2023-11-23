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
	/**
	 * Varifica o preco de cada produto do carrinho para atribuir o valor total do dos produtos para o carrinho
	 * @param carrinho
	 * @return Retrona carrinho com valorTotal da compra
	 */
	public Carrinho checkout(Carrinho carrinho) {
		List<ItemCarrinho> itens = carrinho.getItem();
		double valorTotal = 0d;
		
		for (ItemCarrinho itemCarrinho : itens) {
			int quantidade = itemCarrinho.getQuantidadeProduto();
			double valorProduto = itemCarrinho.getProduto().getValor();
			valorTotal = valorTotal + (valorProduto * quantidade);
		}
		
		carrinho.setValorTotal(valorTotal);
		
		return carrinho;
	}
	
	public Carrinho addItem(Carrinho carrinho, Produto produto, int quantidade) {
		List<ItemCarrinho> itens = carrinho.getItem();
		ItemCarrinho item = new ItemCarrinho(produto, quantidade, carrinho);
		itens.add(item);
		carrinho.setItem(itens);
		
		return carrinhoRepository.save(carrinho);
	}
	
	/**
	 * Remove o produto totalmente do carrinho 
	 * @param carrinho
	 * @param produto que sera removido
	 */
	public void removeItem(Carrinho carrinho, Produto produto) {
		List<ItemCarrinho> itens = carrinho.getItem();
		int posicao = getPosicaoProduto(carrinho, produto);
		itens.remove(posicao);
		carrinho.setItem(itens);
		
	}
	/**
	 * Remove um item de um produto por vez <i>item--</i> e verifica se ainda há itens desse produto no carrinho<br>
	 * Caso não haja mais itens, é chamado o método para remover o produto da lista
	 * @param carrinho
	 * @param produto que tera a quantidade subtraida
	 */
	public void removeQuantidadeProduto(Carrinho carrinho, Produto produto) {
		List<ItemCarrinho> itens = carrinho.getItem();
		int posicao = getPosicaoProduto(carrinho, produto);
		int quantidade = itens.get(posicao).getQuantidadeProduto();
		itens.get(posicao).setQuantidadeProduto(quantidade-1);
		
		if (quantidade-1 == 0) {
			removeItem(carrinho, produto);
		}
	}
	/**
	 * Procura a posicao onde esta localizado o produto
	 * @param carrinho
	 * @param produto
	 * @return Retorna a posicao do produto na lista 
	 */
	private int getPosicaoProduto(Carrinho carrinho, Produto produto) {
		List<ItemCarrinho> itens = carrinho.getItem();
		int posicao = 0;
	
		for (ItemCarrinho itemCarrinho : itens) {
			if (itemCarrinho.getProduto().equals(produto)) {
				break;
			}
			posicao++;
		}
		return posicao;
	}
	/**
	 * Passa os itens que estao na lista do carrinho para uma pilha
	 * @param carrinho
	 * @return Uma pilha com os itens do carrinho
	 */
	public Stack<ItemCarrinho> viewCarrinho(Carrinho carrinho) {
		List<ItemCarrinho> itens = carrinho.getItem();
		Stack<ItemCarrinho> itensPilha = new Stack<>();
		for (ItemCarrinho itemCarrinho : itens) {
			itensPilha.add(itemCarrinho);
		}
		return itensPilha;
	}
	
	
	
}
