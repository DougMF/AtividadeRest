package com.dmf.AtividadeRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Candidato {
	@ApiModelProperty(notes = "ID do candidato", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ApiModelProperty(notes = "Número do candidato", name="numero", required=true)
	@Column(unique = true)
	private int numero;
	
	@ApiModelProperty(notes = "Nome do candidato", name="nome", required=true)
	@Column(nullable = false)
	private String nome;
	
	@ApiModelProperty(notes = "Quantidade de votos que o candidato recebeu", name="votos")
	@Column
	private long votos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getVotos() {
		return votos;
	}
	public void setVotos(long votos) {
		this.votos = votos;
	}
}
