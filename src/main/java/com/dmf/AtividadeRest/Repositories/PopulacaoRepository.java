package com.dmf.AtividadeRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest.Models.Populacao;

@Repository
public interface PopulacaoRepository extends JpaRepository<Populacao, Integer>{
	
}
