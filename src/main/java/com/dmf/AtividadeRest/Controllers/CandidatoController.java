package com.dmf.AtividadeRest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Candidato;
import com.dmf.AtividadeRest.Repositories.CandidatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerenciar candidatos para testar a urna")
@RestController
@RequestMapping("/candidatos")
public class CandidatoController 
{
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@ApiOperation(value = "Retorna os candidatos cadatrados", response = Iterable.class, tags = "get")
	@GetMapping
	public List<Candidato> getCandidatos()
	{
		return candidatoRepository.findAll();
	}

	@ApiOperation(value = "Cadastra um candidato e o retorna", response = Iterable.class, tags = "adicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Candidato adicionar(@RequestBody Candidato candidato)
	{
		return candidatoRepository.save(candidato);
	}
	
	@ApiOperation(value = "Exclui o candidato com ID informado", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{id}")
	void deleteCandidato(@PathVariable int id) 
	{
		candidatoRepository.deleteById(id);
	}
}
