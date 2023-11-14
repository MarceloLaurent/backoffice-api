package com.fatec.backofficeapi.service;

import com.fatec.backofficeapi.model.TipoProduto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.backofficeapi.repository.TipoProdutoRepository;

@Service
public class TipoProdutoService {

    TipoProdutoRepository tipoRepository;

    @Autowired
    public TipoProdutoService(TipoProdutoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public TipoProduto saveTipoProduto(TipoProduto tipoProduto) {
        return tipoRepository.save(tipoProduto);
    }

    public List<TipoProduto> findAll() {
        return tipoRepository.findAll();
    }

    public Optional<TipoProduto> getById(Long id) {
        return tipoRepository.findById(id);
    }

    public TipoProduto updateTipoProduto(TipoProduto tipoProduto) {
        return tipoRepository.save(tipoProduto);
    }

    public void deleteTipoProduto(Long id) {
        tipoRepository.deleteById(id);
    }
}
