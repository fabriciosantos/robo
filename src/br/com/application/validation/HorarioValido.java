package br.com.application.validation;

public class HorarioValido {

	public boolean isHorarioValido(String horario){
		
		TimeValidator r1 = new ChegadaTimeValidator();
		TimeValidator r2 = new InicioAlmocoTimeValidator();
		TimeValidator r3 = new FimAlmocoTimeValidator();
		TimeValidator r4 = new SaidaTimeValidator();
		
		r1.setProximo(r2);
		r2.setProximo(r3);
		r3.setProximo(r4);
		
		return r1.valida(horario);
	}
}
