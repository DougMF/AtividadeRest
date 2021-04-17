package com.dmf.AtividadeRest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import io.swagger.annotations.ApiModelProperty;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Aluno extends Pessoa{	
	@ApiModelProperty(notes = "Número da matrícula do aluno", name = "matricula", required = true)
	@Column(unique = true)
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}