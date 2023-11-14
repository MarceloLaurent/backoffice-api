package com.fatec.backofficeapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="TipoProduto")
@Table(name="tipoProduto")
public class TipoProduto {
		
		@Id
		//TODO: mudar o nome da coluna
		@Column(name="id") 
		private long id;
		
		@Column(name="descricao")
		private String descricao;
	
	public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

	public TipoProduto() {
		
	}

}
