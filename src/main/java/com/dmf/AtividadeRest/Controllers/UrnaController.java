package com.dmf.AtividadeRest.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Candidato;
import com.dmf.AtividadeRest.Repositories.CandidatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerenciar os dados de uma urna eletrônica")
@RestController
@RequestMapping("/urna")
public class UrnaController{
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@ApiOperation(value = "Contabiliza o voto recebido", response = Iterable.class, tags = "votar")
	@GetMapping("/votar{numCandidato}")
	public Candidato votar(@PathVariable int numCandidato){		
		Candidato candidato = new Candidato();
		
		candidato.setNumero(numCandidato);
		
		//Filtro para buscar o candidato com o número igual ao do objeto "candidato"
		ExampleMatcher matcher = ExampleMatcher.matching()     
		  .withIgnorePaths("id")                         
		  .withIgnorePaths("nome")                       
		  .withIgnorePaths("votos");                          

		Example<Candidato> example = Example.of(candidato, matcher);
		
		candidato = candidatoRepository.findOne(example).get();
		candidato.setVotos(candidato.getVotos() + 1);
		
		return candidatoRepository.save(candidato);
	}
	
	@ApiOperation(value = "Retorna a quantidade parcial dos votos do candidato com o id recebido", response = Iterable.class, tags = "get")
	@GetMapping("{id}")
	public long getResultadoId(@PathVariable int id){
		Candidato candidato = candidatoRepository.getOne(id);
		
		return candidato.getVotos();
	}
	
	@ApiOperation(value = "Retorna o resultado parcial da votação", response = Iterable.class, tags = "get")
	@GetMapping()
	public HashMap<String, Long> getResultadoParcial(){
		List<Candidato> candidatos = candidatoRepository.findAll();
		HashMap<String, Long> candidatosVotos = new HashMap<>();
		
		for (Candidato candidato : candidatos) {
			candidatosVotos.put(candidato.getNome(), candidato.getVotos());
		}
		
		return candidatosVotos;
	}
}
