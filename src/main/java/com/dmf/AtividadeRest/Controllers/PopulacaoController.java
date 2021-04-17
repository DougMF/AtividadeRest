package com.dmf.AtividadeRest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Populacao;
import com.dmf.AtividadeRest.Repositories.PopulacaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerenciar a população de uma cidade ao longo dos anos")
@RestController
@RequestMapping("/populacao")
public class PopulacaoController{
	@Autowired
	private PopulacaoRepository populacaoRepository;

	@ApiOperation(value = "Cadastra um novo registro com a população de um determinado ano", response = Iterable.class, tags = "adicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Populacao adicionar(@RequestBody Populacao populacao){
		return populacaoRepository.save(populacao);
	}	
	
	@ApiOperation(value = "Retorna os registros da população da cidade ao longo dos anos", response = Iterable.class, tags = "get")
	@GetMapping
	public List<Populacao> getPopulacao(){
		return populacaoRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna a quantidade populacional em um ano recebido por parâmetro", response = Iterable.class, tags = "get")
	@GetMapping("/{ano}")
	Populacao getPopulacao(@PathVariable int ano){
		Populacao populacao = new Populacao();
		
		populacao.setAno(ano);
		
		//Filtro para buscar populações com o ano igual ao do objeto "populacao"
		ExampleMatcher matcher = ExampleMatcher.matching()     
		  .withIgnorePaths("id")                         
		  .withIgnorePaths("quantidade");                          

		Example<Populacao> example = Example.of(populacao, matcher);
		
		return populacaoRepository.findOne(example).get();
	}
	
	@ApiOperation(value = "Exclui a população com ID informado", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{id}")
	void deletePessoa(@PathVariable int id){
		populacaoRepository.deleteById(id);
	}
	
	@ApiOperation(value = "Altera os dados de uma população, recebendo uma população e o ID por parâmetro. Retorna a nova população.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	Populacao updatePopulacao(@RequestBody Populacao novaPopulacao, @PathVariable int id) {
	    novaPopulacao.setId(id);
		
	    return populacaoRepository.save(novaPopulacao);
	 }
}
