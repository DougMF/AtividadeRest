package com.dmf.AtividadeRest.Models;

public class Temperatura {
	public float converterCparaF(float celsius) {
		return (celsius * 9/5) + 32;
	}
	
	public float converterFparaC(float fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
}
