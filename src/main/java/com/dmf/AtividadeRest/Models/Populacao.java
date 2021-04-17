package com.dmf.AtividadeRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Populacao {
	@ApiModelProperty(notes = "ID do registro", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ApiModelProperty(notes = "Ano do registro, não pode ser repetido", name="ano", required=true)
	@Column(unique = true)
	private int ano;
	
	@ApiModelProperty(notes = "Quantidade de pessoas residindo na cidade no ano definido", name="quantidade", required=true)
	@Column
	private long quantidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}	
}
