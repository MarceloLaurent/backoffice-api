package com.fatec.backofficeapi.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Produto")
@Table(name="produto")
public class Produto {
	
	@Id
	@Column(name="codigo")
	private long codigo;
	@OneToMany
	private List<TipoProduto> tipoProduto;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="quantidadeEstoque")
	private int quantidadeEstoque;
	
	public Produto() {
		
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<TipoProduto> getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(List<TipoProduto> tipoProduto) {
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
