package com.dmf.AtividadeRest.Models;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendario {
	private SimpleDateFormat sdf;
	
	public String getHora() {		
		sdf = new SimpleDateFormat("HH:mm");
		
		return String.valueOf(sdf.format(Calendar.getInstance().getTime()));
	}
	
	public String getData() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return String.valueOf(sdf.format(Calendar.getInstance().getTime()));
	}
	
	public String getDataHora() {
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return String.valueOf(sdf.format(Calendar.getInstance().getTime()));
	}
}
