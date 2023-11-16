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

import com.fatec.backofficeapi.model.Produto;
import com.fatec.backofficeapi.service.ProdutoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "", produces = {"application/json"})
@Tag(name = "backoffice")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/produto")
    public Produto createProduto(@RequestBody Produto produto) throws Exception {
        if (produto.getCodigoProduto() <= 0) {
            throw new Exception("Código do produto inválido");
        }
        return produtoService.saveProduto(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> getProdutoList(Produto produto) {
        return produtoService.findAll();
    }

    @GetMapping("/produto/{codigoProduto}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("codigoProduto") Long codigo) throws Exception {
        return ResponseEntity
                .ok(produtoService.getById(codigo).orElseThrow(() -> new Exception("Produto não encontrado")));
    }

    @PutMapping("/produto")
    public Produto updateProduto(@RequestBody Produto produto) throws Exception {
        if (produto.getCodigoProduto() <= 0) {
            throw new Exception("Código do produto inválido");
        }
        return produtoService.updateProduto(produto);
    }

    @DeleteMapping("/produto/{codigoProduto}")
    public void deleteById(@PathVariable("codigoProduto") Long codigo) {
        try {
            produtoService.deleteProduto(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Objects.requireNonNull(HttpStatus.NOT_FOUND);
        }
    }

}
