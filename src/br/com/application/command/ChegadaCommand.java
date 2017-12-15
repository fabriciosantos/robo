package br.com.application.command;

import br.com.application.factory.HorariosDePontoFactory;
import br.com.application.infra.AbstractCommand;

public class ChegadaCommand extends AbstractCommand{

	@Override
	public void run(boolean selected) {
		if(selected){
			HorariosDePontoFactory.habilitaHorario("Chegada");
			System.out.print(HorariosDePontoFactory.pegaHorario("Chegada").isHabilitado());

		}else{
			HorariosDePontoFactory.desabilitaHorario("Chegada");
			System.out.print(HorariosDePontoFactory.pegaHorario("Chegada").isHabilitado());
			
		}
	}

}
