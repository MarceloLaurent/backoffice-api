package com.fatec.backofficeapi.controller;

import java.util.Optional;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.backofficeapi.model.Carrinho;
import com.fatec.backofficeapi.model.CarrinhoDTO;
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
	private Carrinho carrinho;
	
	@PatchMapping("/carrinho")
	public Optional<Stack<CarrinhoDTO>> addItem(@RequestBody CarrinhoDTO carrinhoDto) {
		return carrinhoService.addItem(carrinhoDto, carrinho.getIdCarrinho());
	}
	
	
}
