package com.dmf.AtividadeRest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Calculadora;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para operações matemáticas")
@RestController
@RequestMapping("/calculadora")
public class CalculadoraController{
	private Calculadora calculadora;
	
	public CalculadoraController() {
		calculadora = new Calculadora();
	}
	
	@ApiOperation(value = "Verifica se o número informado é par ou ímpar", response = Iterable.class, tags = "verificarParouImpar")
	@GetMapping("/parouimpar{numero}")
	public String verificarParouImpar(@PathVariable float numero){
		return calculadora.verificarParouImpar(numero);
	}
}
