package com.dmf.AtividadeRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest.Models.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
}
