package com.dmf.AtividadeRest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Temperatura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para conversão de temperatura")
@RestController
@RequestMapping("/temperatura")
public class TemperaturaController{
	private Temperatura temperatura;
	
	public TemperaturaController() {
		temperatura = new Temperatura();
	}
	
	@ApiOperation(value = "Converte Celsius para Fahrenheit", response = Iterable.class, tags = "converterCparaF")
	@GetMapping("/cparaf{celsius}")
	public String converterCparaF(@PathVariable float celsius){
		return String.valueOf(temperatura.converterCparaF(celsius));
	}
	
	@ApiOperation(value = "Converte Fahrenheit para Celsius", response = Iterable.class, tags = "converterFparaC")
	@GetMapping("/fparac{fahrenheit}")
	public String converterFaraC(@PathVariable float fahrenheit){
		return String.valueOf(temperatura.converterFparaC(fahrenheit));
	}
}
