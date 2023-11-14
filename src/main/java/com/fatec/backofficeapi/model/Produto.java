package com.fatec.backofficeapi.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "Produto")
@Table(name = "produto")
public class Produto {

    @Id
    @NotNull
    @Column(name = "codigoProduto")
    private long codigoProduto;
    @NotNull
    @ManyToOne
    private TipoProduto tipoProduto;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidadeEstoque")
    private int quantidadeEstoque;

    public Produto() {

    }

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

}
