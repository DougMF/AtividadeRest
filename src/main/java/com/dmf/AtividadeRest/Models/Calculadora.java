package com.dmf.AtividadeRest.Models;

public class Calculadora {
	public String verificarParouImpar(float numero) {
		if(numero % 2 == 0)
			return "Par";
		
		return "Ímpar";
	}
}
