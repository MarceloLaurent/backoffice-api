package com.fatec.backofficeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente {

    @Id
    @NotNull
    @Column(name = "cpf")
    private Long cpf;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero")
    private int numero;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Column(name = "contato")
    private String contato;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "senha")
    private String senha;
    
    @OneToOne
    private CarrinhoDTO carrinhoDTO;


	public Cliente() {

    }

    public CarrinhoDTO getCarrinhoDTO() {
		return carrinhoDTO;
	}

	public void setCarrinhoDTO(CarrinhoDTO carrinhoDTO) {
		this.carrinhoDTO = carrinhoDTO;
	}

	public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
