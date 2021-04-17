package com.dmf.AtividadeRest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dmf.AtividadeRest.Models.Aluno;
import com.dmf.AtividadeRest.Models.Pessoa;
import com.dmf.AtividadeRest.Models.Professor;
import com.dmf.AtividadeRest.Repositories.AlunoRepository;
import com.dmf.AtividadeRest.Repositories.PessoaRepository;
import com.dmf.AtividadeRest.Repositories.ProfessorRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para gerência de pessoas")
@RestController
@RequestMapping("/pessoas")
public class PessoaController{
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@ApiOperation(value = "Cadastra um aluno e recebe-o como retorno", response = Iterable.class, tags = "adicionar")
	@PostMapping("/aluno")
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionarAluno(@RequestBody Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	@ApiOperation(value = "Cadastra um professor e recebe-o como retorno", response = Iterable.class, tags = "adicionar")
	@PostMapping("/professor")
	@ResponseStatus(HttpStatus.CREATED)
	public Professor adicionarProfessor(@RequestBody Professor professor){
		return professorRepository.save(professor);
	}
	
	@ApiOperation(value = "Lista todas as pessoas cadastradas", response = Iterable.class, tags = "get")
	@GetMapping
	public List<Pessoa> getPessoas(){
		return pessoaRepository.findAll();
	}
	
	@ApiOperation(value = "Lista todos os alunos cadastrados", response = Iterable.class, tags = "get")
	@GetMapping("/alunos")
	public List<Aluno> getAlunos(){
		return alunoRepository.findAll();
	}
	
	@ApiOperation(value = "Lista todos os professor cadastrados", response = Iterable.class, tags = "get")
	@GetMapping("/professores")
	public List<Professor> getProfessores(){
		return professorRepository.findAll();
	}
	
	@ApiOperation(value = "Busca uma pessoa por seu id", response = Iterable.class, tags = "get")
	@GetMapping("/{id}")
	Pessoa getPessoa(@PathVariable long id){
		return pessoaRepository.findById(id).get();
	}
	
	@ApiOperation(value = "Altera um aluno, recebendo um aluno e seu ID por parâmetro. Retorna o novo aluno.", response = Iterable.class, tags = "alterar")
	@PutMapping("/aluno/{id}")
	Aluno updateAluno(@RequestBody Aluno novoAluno, @PathVariable Long id){
	    novoAluno.setId(id);
		
	    return alunoRepository.save(novoAluno);
	}
	
	@ApiOperation(value = "Altera um professor, recebendo um professor e seu ID por parâmetro. Retorna o novo professor.", response = Iterable.class, tags = "alterar")
	@PutMapping("/professor/{id}")
	Professor updateProfessor(@RequestBody Professor novoProfessor, @PathVariable Long id){
		novoProfessor.setId(id);
		
	    return professorRepository.save(novoProfessor);
	}
	
	@ApiOperation(value = "Exclui a pessoa com o ID informado", response = Iterable.class, tags = "deletar")
	@DeleteMapping("/{id}")
	void deletePessoa(@PathVariable Long id){
		pessoaRepository.deleteById(id);
	}
}
