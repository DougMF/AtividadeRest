package com.dmf.AtividadeRest.Models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Professor extends Pessoa{	
	//Dados específicos do professor a serem modelados em projetos futuros
}