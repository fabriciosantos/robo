package br.com.application.domain;

import java.util.Random;

public class Almoco implements Horario{
	
	/*HORARIO PERFEITO PARA ALMOCO 12:30 - 13:30*/
	private String horarioInicio;
	private String horarioFim;
	private boolean habilitado;
	
	public Almoco(){
		this.setHorarioInicio(getRandomDateInicio());
		this.setHorarioFim(getRandomDateFim());
		this.setHabilitado(true);
	}
	
	public String getRandomDateInicio() {
		
		Random gerador = new Random();
		int minutoAleatorio = gerador.nextInt(10);
		
        String horarioAleatorio = "12:3"+minutoAleatorio+":00";
		return  horarioAleatorio;
	}
	
	public String getRandomDateFim() {
		
		Random gerador = new Random();
		
		int minutoAleatorio = gerador.nextInt(10);
		String horarioAleatorio = "13:3"+minutoAleatorio+":00";
		 
		return horarioAleatorio;
	}


	public boolean isHabilitado() {
		return habilitado;
	}


	@Override
	public void setHabilitado(boolean habilitado) {
		this.habilitado =habilitado;
		
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	


}
