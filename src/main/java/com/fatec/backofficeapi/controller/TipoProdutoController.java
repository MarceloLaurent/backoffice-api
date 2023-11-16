package com.fatec.backofficeapi.controller;

import java.util.List;
import java.util.Objects;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Adiciona um tipo de produto", method = "POST")
    @PostMapping("/tipoProduto")
    public TipoProduto createTipoProduto(@RequestBody TipoProduto tipoProduto) throws Exception {
        if (tipoProduto.getCodigo() <= 0) {
            throw new Exception("Código do tipo de produto inválido.");
        }
        return tipoProdutoService.saveTipoProduto(tipoProduto);
    }

    @Operation(summary = "Retorna uma lista com todos os tipos de produtos", method = "GET")
    @GetMapping("/tiposProdutos")
    public List<TipoProduto> getTipoProdutoList() {
        return tipoProdutoService.findAll();
    }

    @Operation(summary = "Retorna um tipo de produto específico", method = "GET")
    @GetMapping("/tipoProduto/{codigo}")
    public ResponseEntity<TipoProduto> getTipoProdutoById(@PathVariable("codigo") Long id) throws Exception {
        return ResponseEntity.ok(tipoProdutoService.getById(id).orElseThrow(() -> new Exception("Tipo de Produto não encontrado")));
    }

    @Operation(summary = "Atualiza um tipo de produto", method = "PUT")
    @PutMapping("/tipoProduto")
    public TipoProduto updateTipoProduto(@RequestBody TipoProduto tipoProduto) throws Exception {
        if (tipoProduto.getCodigo() <= 0) {
            throw new Exception("Código do tipo de produto inválido.");
        }
        return tipoProdutoService.updateTipoProduto(tipoProduto);
    }

    @Operation(summary = "Deleta um tipo de produto específico", method = "DELETE")
    @DeleteMapping("/tipoProduto/{codigo}")
    public void deleteById(@PathVariable("codigo") Long id) {
        try {
            tipoProdutoService.deleteTipoProduto(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Objects.requireNonNull(HttpStatus.NOT_FOUND);
        }
    }
}
