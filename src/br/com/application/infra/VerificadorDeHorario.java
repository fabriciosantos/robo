package br.com.application.infra;

import br.com.application.validation.ChegadaTimeValidator;
import br.com.application.validation.FimAlmocoTimeValidator;
import br.com.application.validation.InicioAlmocoTimeValidator;
import br.com.application.validation.SaidaTimeValidator;
import br.com.application.validation.TimeValidator;
import br.com.application.validation.ZeroHoraTimeValidator;

public class VerificadorDeHorario {

	public boolean isHorarioValido(String horario){
		
		TimeValidator r1 = new ChegadaTimeValidator();
		TimeValidator r2 = new InicioAlmocoTimeValidator();
		TimeValidator r3 = new FimAlmocoTimeValidator();
		TimeValidator r4 = new SaidaTimeValidator();
		TimeValidator r5 = new ZeroHoraTimeValidator();

		r1.setProximo(r2);
		r2.setProximo(r3);
		r3.setProximo(r4);
		r4.setProximo(r5);
		
		return r1.valida(horario);
	}
}
