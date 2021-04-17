package com.dmf.AtividadeRest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmf.AtividadeRest.Models.Calendario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", 
	description = "REST API para operações com data/hora")
@RestController
@RequestMapping("/calendario")
public class CalendarioController{
	private Calendario calendario;
	
	public CalendarioController() {
		calendario = new Calendario();
	}
	
	@ApiOperation(value = "Retorna a data atual", response = Iterable.class, tags = "get")
	@GetMapping("/data")
	public String getData(){
		return calendario.getData();
	}
	
	@ApiOperation(value = "Retorna a hora atual", response = Iterable.class, tags = "get")
	@GetMapping("/hora")
	public String getHora(){
		return calendario.getHora();
	}
	
	@ApiOperation(value = "Retorna a data e hora atuais", response = Iterable.class, tags = "get")
	@GetMapping
	public String getDataHora(){
		return calendario.getDataHora();
	}
}
