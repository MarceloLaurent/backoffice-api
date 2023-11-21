package com.fatec.backofficeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.backofficeapi.model.Carrinho;
import com.fatec.backofficeapi.model.ItemCarrinho;
import com.fatec.backofficeapi.model.Produto;
import com.fatec.backofficeapi.service.CarrinhoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "", produces = {"application/json"})
@Tag(name = "backoffice")
@CrossOrigin(origins = "*")
public class CarrinhoController {

	@Autowired
	private CarrinhoService carrinhoService;
		
	@PatchMapping("/cliente/carrinho")
	public Carrinho addItem(@RequestBody Carrinho carrinho, Produto produto, int quantidade) {
		
		return carrinhoService.addItem(carrinho, produto, quantidade);
	}
	
	@PutMapping("/cliente/carrinho")
	public String removeItem(Carrinho carrinho, Produto produto) throws Exception {
		List<ItemCarrinho> itens = carrinho.getItem();
		if (itens.isEmpty()) {
			throw new Exception("Produto não encontrado");
		}
		carrinhoService.removeItem(carrinho, produto);

		return "/cliente/carrinho"; 
		
		
	}
	
}
