package br.com.application.validation;

import br.com.application.factory.HorariosDePontoFactory;

public class FimAlmocoTimeValidator implements TimeValidator{

	private TimeValidator proximo;
	private final static String  KEY_HORARIO = "almoco";
	
	@Override
	public boolean valida(String horario) {
		
		if(HorariosDePontoFactory.pegaHorario(KEY_HORARIO).getHorarioFim().equals(horario) &&
				HorariosDePontoFactory.pegaHorario(KEY_HORARIO).isHabilitado()){
		
			return true;

		}else{
			
			return proximo.valida(horario);
		}
	}

	@Override
	public void setProximo(TimeValidator proximo) {
		this.proximo = proximo;
		
	}

}
