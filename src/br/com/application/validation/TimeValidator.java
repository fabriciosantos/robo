package br.com.application.validation;

public interface TimeValidator {

	 boolean valida(String horario);
	 void setProximo(TimeValidator proximo);
}
