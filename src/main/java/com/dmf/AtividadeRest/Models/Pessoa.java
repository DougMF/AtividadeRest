package com.dmf.AtividadeRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
	@ApiModelProperty(notes = "ID da Pessoa", name="id", required=true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(notes = "Nome da Pessoa", name="nome", required=true)
	@Column
	private String nome;

	@ApiModelProperty(notes = "CPF da Pessoa", name="cpf", required=true)
	@Column(unique = true)
	private String cpf;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
