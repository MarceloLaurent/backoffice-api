package com.fatec.backofficeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.backofficeapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{
}
