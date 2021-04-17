package com.dmf.AtividadeRest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmf.AtividadeRest.Models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
}
