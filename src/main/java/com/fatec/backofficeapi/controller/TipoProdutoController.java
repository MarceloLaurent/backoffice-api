package com.fatec.backofficeapi.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.backofficeapi.model.TipoProduto;
import com.fatec.backofficeapi.service.TipoProdutoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "", produces = {"application/json"})
@Tag(name = "backoffice")
@CrossOrigin(origins = "*")
public class TipoProdutoController {

	@Autowired
	TipoProdutoService tipoProdutoService;
	
	@PostMapping("/tipoProduto")
	public TipoProduto createTipoProduto(@RequestBody TipoProduto tipoProduto) {
		 return tipoProdutoService.saveTipoProduto(tipoProduto);
	}
	
	@GetMapping("/tiposProdutos")
	 public List<TipoProduto> getTipoProdutoList(){
		return tipoProdutoService.findAll();
	}
	 
	 @GetMapping("/tipoProduto/{id}")
	 public ResponseEntity<TipoProduto> getTipoProdutoById(@PathVariable ("id")Long id) throws Exception{
		 return ResponseEntity.ok(tipoProdutoService.getById(id).orElseThrow(() -> new Exception("Tipo de Produto não encontrado")));
	 }
	 
	 @PutMapping("/tipoProduto")
	 public TipoProduto updateTipoProduto(@RequestBody TipoProduto tipoProduto) {
		 return tipoProdutoService.updateTipoProduto(tipoProduto);
	 }
	  
	 @DeleteMapping("/tipoProduto/{id}")
	 public void deleteById(@PathVariable("id") Long id) {
		 try {
			 tipoProdutoService.deleteTipoProduto(id);
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
			 Objects.requireNonNull(HttpStatus.NOT_FOUND);
		 }
	 }
}
