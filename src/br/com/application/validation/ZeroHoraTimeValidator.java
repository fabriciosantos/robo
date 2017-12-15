package br.com.application.validation;

import br.com.application.factory.HorariosDePontoFactory;
import br.com.application.service.GeradorDeNovosHorariosService;

public class ZeroHoraTimeValidator implements TimeValidator {

	private TimeValidator proximo;
	private final static String  KEY_HORARIO = "zeroHora";
	
	@Override
	public boolean valida(String horario) {
		
		if(HorariosDePontoFactory.pegaHorario(KEY_HORARIO).getHorarioInicio().equals(horario) &&
				HorariosDePontoFactory.pegaHorario(KEY_HORARIO).isHabilitado()){
		
			//Gera novos Horarios Aleatórios
			GeradorDeNovosHorariosService.gera();
			
			return true;

		}else{
			
			if(proximo!=null){
				return proximo.valida(horario);
			}
			return false;
		}
	}

	@Override
	public void setProximo(TimeValidator proximo) {
		this.proximo = proximo;
		
	}


	
}
