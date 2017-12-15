package br.com.application.domain;

public interface Horario {
	 String getRandomDateInicio();
	 String getRandomDateFim();
	 String getHorarioFim();
	 String getHorarioInicio();
	 boolean isHabilitado();
	 void setHabilitado(boolean habilitado);
}
